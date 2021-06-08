package priv.ljh.utils.redis;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//开启注解缓存
@EnableCaching
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)//session过期时间(秒)
@Configuration
public class RedisSessionConfig {
}