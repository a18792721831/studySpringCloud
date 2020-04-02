package com.study.servicedomain.beans;

import com.study.servicedomain.convert.SexConvert;
import com.study.servicedomain.convert.StatusConvert;
import com.study.servicedomain.neum.Sex;
import com.study.servicedomain.neum.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author jiayq
 * @Date 2020-03-28
 */
@Data
@Entity
@ApiModel(description = "People实体")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(required = false, value = "People id", notes = "由oracle序列生成", dataType = "Long")
    private Long id;

    @Column(nullable = false,length = 1024)
    @ApiModelProperty(required = true, value = "People编码", notes = "People编码不能为空", dataType = "String")
    private String code;

    @Column(length = 1024)
    @ApiModelProperty(required = false, value = "People名字", notes = "People姓名", dataType = "String")
    private String name;

    @Convert(converter = SexConvert.class)
    @Column(nullable = false, name = "SEX")
    @ApiModelProperty(required = true, value = "People性别", notes = "People性别，枚举", dataType = "int", allowableValues = "0:女,1:男")
    private Sex sex;

    @Column
    @ApiModelProperty(required = true, value = "People年龄", notes = "People年龄，数字", dataType = "int", allowableValues = "int")
    private int age;

    @Column(length = 1024)
    @ApiModelProperty(required = false, value = "People爱好", notes = "People爱好,最大1024", dataType = "String")
    private String hobby;

    @Convert(converter = StatusConvert.class)
    @Column(nullable = false, name = "STATUS")
    @ApiModelProperty(required = true, value = "People状态", notes = "是否有效，枚举", dataType = "int", allowableValues = "0:无效,1:有效")
    private Status status;
}
