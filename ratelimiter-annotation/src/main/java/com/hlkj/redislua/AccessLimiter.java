package com.hlkj.redislua;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Lixiangping
 * @createTime 2022年04月13日 21:49
 * @decription:
 */
@Service
@Slf4j
public class AccessLimiter {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisScript<Boolean> rateLimitLua;//redis lua脚本调用

    public void limitAccess(String key, Integer limit, Integer period) {
        //1、request Lua script
        boolean acquired = stringRedisTemplate.execute(
                rateLimitLua,//Lua script脚本
                Lists.newArrayList(key),//lua脚本中的Key列表
                limit.toString(),
                period.toString());
        if (!acquired) {
            log.error("your access is blocked. key={}", key);
            throw new RuntimeException("Your access is blocked");
        }
        //2、
        //3、
    }

}
