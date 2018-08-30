package com.common.test.demo20;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author jinx
 * @date 2018/02/05 23:21
 * Desc:
 */
public class HashMapStructure {
    public static void main(String[] args) {
        Country india = new Country("india", (long) 1000);
        Country japan = new Country("japan", (long) 10000);
        Country france = new Country("france", (long) 2000);
        Country russa = new Country("russa", (long) 20000);

        Map<Country, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put(india, "Delhi");
        countryCapitalMap.put(japan, "Tokyo");
        countryCapitalMap.put(france, "Paris");
        countryCapitalMap.put(russa, "Moscow");

        Iterator<Country> iterator = countryCapitalMap.keySet().iterator();
        while (iterator.hasNext()) {
            Country country = iterator.next();
            String captial = countryCapitalMap.get(country);
            System.out.println(captial);
        }

    }
}
