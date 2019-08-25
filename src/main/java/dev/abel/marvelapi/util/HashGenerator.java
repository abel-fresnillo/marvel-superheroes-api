package dev.abel.marvelapi.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HashGenerator {
    @Value("${marvel.api.publickey}")
    public String publicKey;

    @Value("${marvel.api.privatekey}")
    public String privateKey;

    public String generate(long ts) {
        return generate(ts, privateKey, publicKey);
    }

    private String generate(long ts, String privateKey, String publicKey) {
        String password = ts + privateKey + publicKey;
        return DigestUtils.md5Hex(password);
    }
}
