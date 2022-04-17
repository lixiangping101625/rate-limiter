//package com.hlkj.ratelimiter.api;
//
//import com.google.common.util.concurrent.RateLimiter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author Lixiangping
// * @createTime 2022年04月11日 22:56
// * @decription: 限流测试
// */
//@RestController
//@Slf4j
//public class RateLimiterController {
//
//    RateLimiter rateLimiter = RateLimiter.create(2.0);//每秒发放2个令牌
//
//    /**
//     * 非阻塞限流:
//     * @param count 获取许可证的数量
//     * @return
//     */
//    @GetMapping("/tryAcquire")
//    public String tryAcquire(@RequestParam Integer count) {
//        if (rateLimiter.tryAcquire(count)){//获取指定数量的请求
//            /**
//             *  tryAcquire(int permits)内部还是调用了tryAcquire(permits, 0, MICROSECONDS)方法
//             *      public boolean tryAcquire(int permits) {
//             *          return tryAcquire(permits, 0, MICROSECONDS);
//             *      }
//             */
//            log.info("success, rate: " + rateLimiter.getRate());
//            return "success";
//        }
//        else {
//            log.info("fail, rate: " + rateLimiter.getRate());
//            return "fail";
//        }
//    }
//
//    /**
//     * 限定时间的非阻塞限流
//     * @param count
//     * @param timeout
//     * @return
//     */
//    @GetMapping("/tryAcquireWithTimeout")
//    public String tryAcquireWithTimeout(@RequestParam Integer count,@RequestParam Integer timeout) {
//        if (rateLimiter.tryAcquire(count, timeout, TimeUnit.SECONDS)){//获取指定数量的请求
//            log.info("success, rate: " + rateLimiter.getRate());
//            return "success";
//        }
//        else {
//            log.info("fail, rate: " + rateLimiter.getRate());
//            return "fail";
//        }
//    }
//
//}
