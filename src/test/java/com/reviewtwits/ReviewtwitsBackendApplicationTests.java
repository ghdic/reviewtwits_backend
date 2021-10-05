package com.reviewtwits;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReviewtwitsBackendApplicationTests {

    @Value("${GOOGLE_APPLICATION_CREDENTIALS}")
    public String path;

    @Test
    void contextLoads() {
        System.out.println(path);
    }

}
