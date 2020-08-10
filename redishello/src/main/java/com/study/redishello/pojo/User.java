package com.study.redishello.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author jiayq
 * @Date 2020/8/6
 */
@Alias("user")
@Data
public class User implements Serializable {

    private Long id;

    private String userName;

    private String note;

}
