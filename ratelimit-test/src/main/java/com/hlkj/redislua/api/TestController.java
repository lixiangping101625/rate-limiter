package com.hlkj.redislua.api;

import com.hlkj.redislua.AccessLimiter;
import com.hlkj.redislua.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Lixiangping
 * @createTime 2022年04月13日 22:20
 * @decription:
 */
@RestController
@Slf4j
public class TestController {

    @Resource
    private AccessLimiter accessLimiter;

    @RateLimiter(limitKey = "key1", count = 2, period = 1)
    @GetMapping("/test")
    public String test() {
//        accessLimiter.limitAccess("ratelimit-test", 1);
        return "success";
    }

}
