package dev.abel.marvelapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private int total;
    private HeroDTO[] results;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public HeroDTO[] getResults() {
        return results;
    }

    public void setResults(HeroDTO[] results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Data{" +
                "total=" + total +
                '}';
    }
}