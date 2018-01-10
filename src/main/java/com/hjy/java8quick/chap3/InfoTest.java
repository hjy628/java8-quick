package com.hjy.java8quick.chap3;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by hjy on 18-1-9.
 */
public class InfoTest {

    public static void info(Logger logger, Supplier<String> message){
        if (logger.isLoggable(Level.INFO))
            logger.info(message.get());
    }

}
