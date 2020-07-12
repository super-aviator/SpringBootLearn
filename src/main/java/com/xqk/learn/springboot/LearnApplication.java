package com.xqk.learn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Learn application.
 * 排除定时任务的包
 * 排除redis自动配置类
 * 排除spring security配置类
 *
 * @author Aviator
 */
//@EnableScheduling
//@EnableWebSecurity
//@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration.class,
//        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
//@EnableDiscoveryClient
@SpringBootApplication
public class LearnApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //最常规的启动方式，使用静态方法的方式
        SpringApplication.run(LearnApplication.class, args);

        /*
        //以编程的方式激活profile，
        SpringApplication application = new SpringApplication();
        //激活指定的profile
        application.setAdditionalProfiles("kafka");
        //关闭Banner显示
        application.setBannerMode(Banner.Mode.OFF);
        //Source为项目中需要指定包的路径（Source不能为空）
        application.setSources(new HashSet<>(Collections.singletonList("com.springboot.learn")));
        application.run(args);
        */
    }
}