package com.hs.entiry;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-03 11:40
 **/
@Data
@Accessors(chain = true)
public class User implements Serializable {
    private String username;
    private String password;
    private Integer age;

}
