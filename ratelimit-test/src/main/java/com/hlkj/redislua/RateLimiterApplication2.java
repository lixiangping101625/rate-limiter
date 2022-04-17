package com.hlkj.redislua;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Lixiangping
 * @createTime 2022年04月13日 22:18
 * @decription:
 */
@SpringBootApplication
public class RateLimiterApplication2 {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RateLimiterApplication2.class).run(args);
    }
}
