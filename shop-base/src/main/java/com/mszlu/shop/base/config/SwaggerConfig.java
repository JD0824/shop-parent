package com.mszlu.shop.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration//加载到springboot配置里面
@EnableSwagger2//开启swagger2
public class SwaggerConfig {
    /**
     * 配置swagger2
     * 注册一个bean属性
     * swagger2其实就是重新写一个构造器，因为他没有get set方法\
     * enable() 是否启用swagger false swagger不能再浏览器中访问
     * groupName()配置api文档的分组  那就注册多个Docket实例 相当于多个分组
     * @return
     */
    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(userApiInfo())
                .groupName("buyApi")//组名称
                .enable(true)
                .select()
                /**
                 * RequestHandlerSelectors配置扫描接口的方式
                 *      basePackage 配置要扫描的包
                 *      any 扫描全部
                 *      none 不扫描
                 *      withClassAnnotation 扫描类上的注解
                 *      withMethodAnnotation 扫描方法上的注解
                 */
                .apis(RequestHandlerSelectors.any())
                /**
                 * paths() 扫描过滤方式
                 *      any过滤全部
                 *      none不过滤
                 *      regex正则过滤
                 *      ant过滤指定路径
                 */
                //                .paths(PathSelectors.ant("/login/**"))
                .build();
    }
    /**
     * 配置swagger2信息 =apiInfo
     * @return
     */
    private ApiInfo userApiInfo(){
        return new ApiInfoBuilder()
                .title("shop-app的API文档")
                .description("本文档描述了shop-parent的各个模块的接口的调用方式")
                .version("1.6")
                .contact(new Contact("Helen", "http://atguigu.com", "admin@atguigu.com"))
                .build();
    }
}
