package priv.ljh.config;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * swagger
 * @author lijinghai
 * @Date 2021-1-19
 */

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class MySwagger {

    /**
     * https://localhost:8080/swagger-ui.html
     * https://localhost:8080/doc.html
     * 配置了Swagger的Docket的Bean实例
     * @return
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //配置分组 一个Docket 一个组
                .groupName("李京海")
                //Swagger配置扫描接口
                .select()
                .apis(RequestHandlerSelectors.basePackage("priv.ljh.controller"))
                .build();
    }

    /**
     * 配置Swagger信息=apiInfo
     * @return
     */
    public ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("李京海", "http://github.com/Dorian1015", "1503676492@qq.com");
        return new ApiInfo(
                "李京海的SwaggerAPI文档",
                "月光还是少年的月光，九州一色还是李白的霜。",
                "v1.0",
                "http://github.com/Dorian1015",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }


    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("default");
    }
}
