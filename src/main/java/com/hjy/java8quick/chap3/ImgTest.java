package com.hjy.java8quick.chap3;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;


/**
 * Created by hjy on 18-1-9.
 */
public class ImgTest {

    public static void main(String[] args) {
        Image image = new Image("love2.jpg");

        Image brightenedImage = transform(image, javafx.scene.paint.Color::brighter);
    }

    public static Image transform(Image in, UnaryOperator<Color> f){
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();

        WritableImage out = new WritableImage(width,height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x,y,f.apply(in.getPixelReader().getColor(x,y)));
            }
        }
        return out;
    }

    public static Color[][] parallelTransform(Color[][] in,UnaryOperator<Color> f){
        int n = Runtime.getRuntime().availableProcessors();
        int height = in.length;
        int width = in[0].length;

        Color[][] out = new Color[height][width];
        try{
            ExecutorService pool = Executors.newCachedThreadPool();
            for (int i = 0; i < n; i++) {
                int fromY = i*height/n;
                int toY = (i+1) * height /n;
                pool.submit(()->{
                    for (int x = 0; x < width; x++) {
                        for (int y = fromY; y < toY; y++) {
                            out[y][x] = f.apply(in[y][x]);
                        }
                    }
                });
            }
            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return out;
    }


}
