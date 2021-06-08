package priv.ljh.utils.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
/**
 * 编写过滤器
 * @author lijinghai
 */
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessHandler())
                //添加需要进⾏拦截的链接
                .addPathPatterns("/**")
                //排除不需要拦截的链接，多个链接直接⽤逗号隔开
                .excludePathPatterns("/person/login");
        System.out.println("=========== 拦截器注册完毕 ===========");
    }
}