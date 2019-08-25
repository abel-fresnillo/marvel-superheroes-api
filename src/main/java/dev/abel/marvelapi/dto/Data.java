package dev.abel.marvelapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.abel.marvelapi.domain.Character;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private int total;
    private Character[] results;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Character[] getResults() {
        return results;
    }

    public void setResults(Character[] results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Data{" +
                "total=" + total +
                '}';
    }
}