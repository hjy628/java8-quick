package com.hjy.java8quick.chap8;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by hjy on 18-1-8.
 */
public class FileTest {

    public static void main(String[] args) throws Exception{

        Stream<String> lines = Files.lines(Paths.get("eee.txt"));
        Optional<String> passwordEntry = lines.filter(s->s.contains("password")).findFirst();

        Base64.Encoder encoder =Base64.getEncoder();
        String original = "root:root";
        String encoded = encoder.encodeToString(original.getBytes(StandardCharsets.UTF_8));

        Path originalPath = Paths.get("/tmp"), encodedPath = Paths.get("/tmp/encoded"), decodedPath = Paths.get("/tmp/decoded");
        Base64.Encoder mimiEncoder = Base64.getMimeEncoder();
        try (OutputStream output = Files.newOutputStream(encodedPath)){
            Files.copy(originalPath,mimiEncoder.wrap(output));
        }


        Base64.Decoder decoder = Base64.getMimeDecoder();
        try (InputStream input = Files.newInputStream(encodedPath)) {
            Files.copy(decoder.wrap(input),decodedPath);
        }

    }


}
