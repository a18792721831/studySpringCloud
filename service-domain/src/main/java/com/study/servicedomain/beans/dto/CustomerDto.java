package com.study.servicedomain.beans.dto;

import com.study.servicedomain.neum.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jiayq
 * @Date 2020-03-29
 */
@Data
@ApiModel(description = "CustomerDto实体")
public class CustomerDto {

    @ApiModelProperty(required = false, value = "Customer id", notes = "由oracle序列生成", dataType = "Long")
    private Long id;

    @ApiModelProperty(required = true, value = "Customer 编码", notes = "客户编码", dataType = "String")
    private String code;

    @ApiModelProperty(required = false, value = "Customer 姓名", notes = "客户姓名", dataType = "String")
    private String name;

    @ApiModelProperty(required = false, value = "Customer 状态", notes = "客户状态", dataType = "Status")
    private Status status;

    @ApiModelProperty(required = false, value = "Customer 地址", notes = "客户地址", dataType = "String")
    private String address;

}
