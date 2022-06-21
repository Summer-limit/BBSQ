package com.electronicticket.domain;


import lombok.Getter;
import lombok.Setter;

/**
 * @author Niubaiquan
 * @desc
 * @date 2022年02月19日 2022/2/19
 */
@Setter
@Getter
public class ResultData {
    private int code;
    private String msg;
    private Object data;
}
