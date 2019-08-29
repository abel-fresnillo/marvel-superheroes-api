package dev.abel.marvelapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.abel.marvelapi.domain.Hero;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private int total;
    private Hero[] results;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Hero[] getResults() {
        return results;
    }

    public void setResults(Hero[] results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Data{" +
                "total=" + total +
                '}';
    }
}