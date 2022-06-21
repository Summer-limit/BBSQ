package com.electronicticket.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @author Niubaiquan
 * @desc 这是一个用来模拟配置属性自动绑定的类
 * @date 2022年05月09日 2022/5/9
 */
@Setter
@Getter
//以下两个注解用来绑定配置文件的配置属性
@Component
@ConfigurationProperties(prefix = "mycat")
//用来进行条件配置,是按需开启自动配置项的必要注解
//@Conditional({})
public class Cat {
    private String name;
    private int age;
}
