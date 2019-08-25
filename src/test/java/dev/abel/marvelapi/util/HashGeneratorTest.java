package dev.abel.marvelapi.util;


import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HashGeneratorTest {
    HashGenerator hashGenerator = new HashGenerator();

    @Test
    public void generate_WithValidInputs_Valid() {
        long ts = 123;

        String hash = hashGenerator.generate(ts);

        assertThat(hash).isEqualTo("e9d7f6c15f9e09bedcc8e64c96b4aa3a");
    }
}
