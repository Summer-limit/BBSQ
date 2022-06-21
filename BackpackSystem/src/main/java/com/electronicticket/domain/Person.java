package com.electronicticket.domain;

import lombok.Data;

/**
 * @author Niubaiquan
 * @desc
 * @date 2022年05月12日 2022/5/12
 */
@Data
public class Person {
    private String name;
    private Integer age;
    private Person lover;
}
