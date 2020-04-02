package com.study.servicedomain.beans;

import com.study.servicedomain.convert.StatusConvert;
import com.study.servicedomain.neum.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author jiayq
 * @Date 2020-03-29
 */
@Entity
@Data
@ApiModel(description = "Customer实体")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(required = false, value = "Customer id", notes = "由oracle序列生成", dataType = "Long")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty(required = true, value = "Customer 编码", notes = "客户编码", dataType = "String")
    private String code;

    @Column
    @ApiModelProperty(required = false, value = "Customer 姓名", notes = "客户姓名", dataType = "String")
    private String name;

    @Convert(converter = StatusConvert.class)
    @Column(nullable = false)
    @ApiModelProperty(required = false, value = "Customer 状态", notes = "客户状态", dataType = "Status")
    private Status status;

    @Column
    @ApiModelProperty(required = false, value = "Customer 地址", notes = "客户地址", dataType = "String")
    private String address;

}
