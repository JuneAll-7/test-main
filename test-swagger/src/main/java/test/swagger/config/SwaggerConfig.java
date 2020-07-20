package test.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置swagger2 bean 实例
      @Bean
    public Docket docket(){
     return  new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo2())
             .select()
             //扫描接口的方式
             .apis(RequestHandlerSelectors.basePackage("test.swagger.controller")).build();

    }
    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo()
    {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title("标题：Ins导航系统_接口文档")
                // 描述
                .description("描述：用于管理集团旗下公司的人员信息,具体包括XXX,XXX模块...")
                // 作者信息
                .contact(new Contact("测试项目", "http://47.96.151.94:8080/login.html", "15959008715"))
                // 版本
                .version("版本号:" + "X.1.5")
                .build();
    }
    private ApiInfo apiInfo2()
    {
        //配置作者信息
        Contact contact=new Contact("小铭","http://www.baidu.com","805066042@qq.com");
        // 用ApiInfoBuilder进行定制
        return new ApiInfo("个人测试Swagger项目",
                "描述：仅限于测试其他不要多想。。。",
                "AY.1.3",
                "http://47.96.151.94:8080/login.html",
                contact,
                "CRUD 2.0",
                "http://47.96.151.94:8080/login.html",
                 new ArrayList());
    }

}
