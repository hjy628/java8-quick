package com.hjy.java8quick.chap2;

import java.util.*;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

/**
 * Created by hjy on 18-1-8.
 */
public class StreamReduce2Test {


    public static void main(String[] args) {

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());

        Map<String,String> languageNames = locales.collect(
                toMap(l->l.getDisplayLanguage(),
                        l->l.getDisplayLanguage(l),
                        (existingValue,newValue)->existingValue)
        );

        System.out.println(languageNames.toString());

        locales = Stream.of(Locale.getAvailableLocales());

        Map<String,Set<String>> countryLanguageSets = locales.collect(toMap(
                l->l.getDisplayCountry(),
                l-> Collections.singleton(l.getDisplayLanguage()),
                        (a,b)->{    //a和b的组合
                            Set<String> r = new HashSet<String>(a);
                            r.addAll(b);
                            return r;
                        }));

        System.out.println(countryLanguageSets.toString());

        locales = Stream.of(Locale.getAvailableLocales());

        Map<String,List<Locale>> countryToLocales = locales.collect(groupingBy(Locale::getCountry));
        List<Locale> swissLocales = countryToLocales.get("CH");
        //产生结果[it_CH, de_CH,fr_CH]

        System.out.println(swissLocales.toString());

        locales = Stream.of(Locale.getAvailableLocales());
        Map<Boolean,List<Locale>> englishAndOtherLocales = locales.collect(
                partitioningBy(l->l.getLanguage().equals("en"))
        );
        List<Locale> englishLocales = englishAndOtherLocales.get(true);
        System.out.println(englishLocales.toString());

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String,Long> countryToLocaleCounts = locales.collect(groupingBy(Locale::getCountry,counting()));



    }


}
