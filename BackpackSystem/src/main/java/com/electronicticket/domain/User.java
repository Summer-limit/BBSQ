package com.electronicticket.domain;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @author Niubaiquan
 * @desc
 * @date 2022年02月22日 2022/2/22
 */
@Component
@ConfigurationProperties(prefix = "user")
@Entity
@Table(name = "user")
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String passWord;
    @Column(name = "realname")
    private String realName;
    @Column(name = "dress")
    private String dress;
    @Column(name = "telephone")
    private String telphone;
    @Column(name = "img")
    private String img;
}
