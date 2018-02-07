package com.common.test.demo20;

/**
 * @author jinx
 * @date 2018/02/05 23:15
 * Desc:hashMap
 */
public class Country {
    private String name;
    //人口
    private long population;

    public Country(String name, Long population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    // If length of name in country object is even(偶数) then return 31(any random number) and if odd(奇数) then return 95(any random number).
    // This is not a good practice to generate hashcode as below method but I am doing so to give better and easy understanding of hashmap.
    @Override
    public int hashCode() {
        if (this.name.length() % 2 == 0)
            return 31;
        else
            return 95;
    }

    @Override
    public boolean equals(Object obj) {
        Country other = (Country) obj;
        if (name.equalsIgnoreCase((other.name)))
            return true;
        return false;
    }
}
