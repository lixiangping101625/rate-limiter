//package com.hlkj.ratelimiter.api;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author Lixiangping
// * @createTime 2022年04月12日 20:22
// * @decription: 基于Nginx的IP限流
// */
//@RestController
//@Slf4j
//public class NginxRateLimitController {
//
//    @GetMapping("/nginx")
//    public String nginx() {
//      log.info("nginx success");
//      return "success";
//    }
//
//    @GetMapping("/nginx-conn")
//    public String nginxConn(@RequestParam(defaultValue = "0") Integer secs) throws InterruptedException {
//      Thread.sleep(secs * 1000);
//      return "success";
//    }
//
//}
