package dev.abel.marvelapi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MarvelUrlGenerator {
    @Value("${marvel.api.url}")
    public String marvelApiUrl;

    @Value("${marvel.api.publickey}")
    public String publicKey;

    @Autowired
    private HashGenerator hashGenerator = new HashGenerator();

    public String generateCharacterUrl(long ts) {
        return marvelApiUrl + "characters?ts=" + ts + "&apikey=" + publicKey + "&hash=" + hashGenerator.generate(ts);
    }
}
