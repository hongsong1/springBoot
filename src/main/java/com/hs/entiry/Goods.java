package com.hs.entiry;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-01 21:54
 **/
@Data
public class Goods implements Serializable {
    private Integer id;
    private String name;
    private Integer number;
    private Double price;
    private Date date;
    private Integer typeid;
    private String typename;
}
