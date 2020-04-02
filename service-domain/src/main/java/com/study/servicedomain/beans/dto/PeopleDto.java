package com.study.servicedomain.beans.dto;

import com.study.servicedomain.neum.Sex;
import com.study.servicedomain.neum.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jiayq
 * @Date 2020-03-28
 */
@Data
@ApiModel(description = "People DTO")
public class PeopleDto {

    @ApiModelProperty(required = false, value = "People id", notes = "由oracle序列生成", dataType = "Long")
    private Long id;

    @ApiModelProperty(required = true, value = "People编码", notes = "People编码不能为空", dataType = "String")
    private String name;

    @ApiModelProperty(required = false, value = "People名字", notes = "People姓名", dataType = "String")
    private String code;

    @ApiModelProperty(required = true, value = "People性别", notes = "People性别，枚举", dataType = "int", allowableValues = "0:女,1:男")
    private Sex sex;

    @ApiModelProperty(required = true, value = "People年龄", notes = "People年龄，数字", dataType = "int", allowableValues = "int")
    private int age;

    @ApiModelProperty(required = false, value = "People爱好", notes = "People爱好,最大1024", dataType = "String")
    private String hobby;

    @ApiModelProperty(required = true, value = "People状态", notes = "是否有效，枚举", dataType = "int", allowableValues = "0:无效,1:有效")
    private Status status;

}
