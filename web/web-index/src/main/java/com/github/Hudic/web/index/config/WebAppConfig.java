package com.github.Hudic.web.index.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 应用服务配置
 */
@EnableWebMvc //该行注解不能删除，否则影响文件上传
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Autowired
    private InterceptorConfig interceptor;

    /**
     * 登录拦截策略
     * addInterceptor 拦截登录
     * excludePathPatterns 不拦截登录验证
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("进来了222addInterceptors");
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**").excludePathPatterns("/swagger-resources/**") //swagger 资源不拦截登录
                .excludePathPatterns("/swagger-ui.html"); //swagger 资源不拦截登录
//                .excludePathPatterns("/hystrix/**") //hystrix 不拦截登录
//                .excludePathPatterns("/sysAttach/ns/fileDownload")  //文件下载不拦截登录
//                .excludePathPatterns("/webjars/**") //swagger 资源不拦截登录
//                .excludePathPatterns("/swagger-resources/**") //swagger 资源不拦截登录
//                .excludePathPatterns("/swagger-ui.html") //swagger 资源不拦截登录
//                .excludePathPatterns("/auth/getRandCode") //获取验证码不拦截登录
//                .excludePathPatterns("/auth/login") //登录接口不拦截登录
//                .excludePathPatterns("/oauth/**")  //统一认证登录不拦截登录
//                .excludePathPatterns("/home/page/**")  //首页观看资料 不需要token
//                .excludePathPatterns("/home/search/**")  //首页全局搜索不需要token
//                .excludePathPatterns("/home/other/**")  //首页全局搜索不需要token
//                .excludePathPatterns("/onlineFile/**")//在线阅览
//                .excludePathPatterns("/pub/**") //访问路径pub不拦截
//                .excludePathPatterns("/call/**");
    }

    /**
     * 加载静态资源
     * 一般的资源在classpath:/META-INF/resources/、classpath:/static/
     * 对于JAR包里的资源，如果访问不了，可以用压缩工具打开，看下具体资源的位置，然后添加进来
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);
    }

}
