package com.study.servicecustomer.controller;

import com.study.servicecustomer.service.ICustomerService;
import com.study.servicecustomer.service.feign.PeopleFeignService;
import com.study.servicedomain.beans.dto.CustomerDto;
import com.study.servicedomain.beans.dto.PeopleDto;
import com.study.servicedomain.neum.Status;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-03-30
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private int port;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private PeopleFeignService peopleFeignService;

    @PostMapping("/{code}/{name}/{address}")
    @ApiOperation(value = "增加Customer", notes = "post 方法增加一个客户")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "Customer 编码", required = true, dataType = "String",
            example = "xiaomei", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回异常信息"),
            @ApiResponse(code = 200, message = " add customer success, from ${applicationName}:${port} !")})
    public String addCustomer(@PathVariable("code") String code,
                              @PathVariable("name") String name,
                              @PathVariable("address") String address) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCode(code);
        customerDto.setName(name);
        customerDto.setAddress(address);
        customerDto.setStatus(Status.VALID);
        customerService.addCustomer(customerDto);
        return " add customer success, from " + applicationName + ":" + port + " !";
    }

    @GetMapping("/code/{code}")
    @ApiOperation(value = "根据code查询Custoemr", notes = "get 方法根据编码查询客户")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "Customer 编码", required = true, dataType = "String",
            example = "xiaomei", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回字符串"),
            @ApiResponse(code = 200, message = " return List<CustomerDto> for {code}")})
    public List<CustomerDto> queryCustomerByCode(@PathVariable("code") String code) {
        return customerService.findCustomerByCode(code);
    }

    @GetMapping("/name/{name}")
    @ApiOperation(value = "根据name查询Customer", notes = "get 方法根据姓名查询客户")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "Customer 姓名", required = true, dataType = "String",
            example = "小美", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回字符串信息"),
            @ApiResponse(code = 200, message = "return List<CustomerDto> for {name}")})
    public List<CustomerDto> queryCustomerByName(String name) {
        return customerService.findCustomerByName(name);
    }

    @DeleteMapping("/name/{name}")
    @ApiOperation(value = "根据name删除Customer", notes = "delete 方法根据姓名删除客户")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "Customer 姓名", required = true, dataType = "String",
            example = "测试", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回异常字符串信息"),
            @ApiResponse(code = 200, message = " delete success by name , from ${applicationName}:{port} !")})
    public String deleteCustomerByName(@PathVariable("name") String name) {
        customerService.deleteCustomerByName(name);
        return " delete success by name , from " + applicationName + ":" + port + " !";
    }

    @DeleteMapping("/code/{code}")
    @ApiOperation(value = "根据code删除Customer", notes = "delete 方法根据编码删除客户")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "Customer 编码", required = true, dataType = "String",
            example = "ceshi", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回异常字符串"),
            @ApiResponse(code = 200, message = " delete success by code, from ${applicationName}:${port} !")})
    public String deleteCustomerByCode(@PathVariable("code") String code) {
        customerService.deleteCustomerByCode(code);
        return " delete success by code, from " + applicationName + ":" + port + " !";
    }


    @GetMapping("/")
    @ApiOperation(value = "查询所有的Customer", notes = "get 方法获取全部的客户")
    @ApiResponses({@ApiResponse(code = 404, message = "返回字符串"),
            @ApiResponse(code = 200, message = " return List<CustomerDto> for all")})
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/{code}/{name}")
    @ApiOperation(value = "根据code设置name", notes = "put 方法根据编码更新姓名")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "Customer 编码", required = true, dataType = "String",
            example = "ceshi", paramType = "path"),
            @ApiImplicitParam(name = "name", value = "Customer 姓名", required = true, dataType = "String",
                    example = "小美", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回字符串信息"),
            @ApiResponse(code = 200, message = " modify success ,from {$applicationName}:${port} !")})
    public String modifyCustomer(@PathVariable("code") String code, @PathVariable("name") String name) {
        customerService.modifyCustomerNameByCode(code, name);
        return " modify success ,from " + applicationName + ":" + port + " !";
    }

    @PostMapping("/people/{code}/{name}/{age}/{sex}/{hobby}")
    @ApiOperation(value = "远程调用增加People", notes = "post 提交远程调用增加People")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "People 编码", required = true, dataType = "String",
            example = "xiaomei", paramType = "path"),
            @ApiImplicitParam(name = "name", value = "People 姓名", required = true, dataType = "String",
                    example = "小美", paramType = "path"),
            @ApiImplicitParam(name = "age", value = "People 年龄", required = true, dataType = "int",
                    example = "22", paramType = "path"),
            @ApiImplicitParam(name = "sex", value = "People 性别(0:男,1:女)", required = true, dataType = "int",
                    example = "1", paramType = "path"),
            @ApiImplicitParam(name = "hobby", value = "People 爱好", required = false, dataType = "String",
                    example = "洗衣服", paramType = "path")})
    @ApiResponses(value = {@ApiResponse(message = "返回字符串", code = 404)
            , @ApiResponse(code = 200, message = " add success , from ${applicationName}:${port} !")})
    public String addPeople(@PathVariable("code") String code, @PathVariable("name") String name,
                            @PathVariable("age") int age, @PathVariable("sex") int sex,
                            @PathVariable("hobby") String hobby) {
        peopleFeignService.addPeople(code, name, age, sex, hobby);
        return " add people success ,from " + applicationName + ":" + port + " !";
    }

    @PutMapping("/people/{code}/{name}")
    @ApiOperation(value = "远程调用根据编码修改名字", notes = " put 远程调用修改People")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "People 编码", required = true, dataType = "String",
            example = "xiaomei", paramType = "path"),
            @ApiImplicitParam(name = "name", value = "People 姓名", required = true, dataType = "String",
                    example = "小美01", paramType = "path")})
    @ApiResponses(value = {@ApiResponse(message = "返回字符串", code = 404)
            , @ApiResponse(code = 200, message = " modify people success ,from ${applicationName}:${port} !")})
    public String modifyPeople(String code, String name) {
        peopleFeignService.modifyPeople(code, name);
        return " modify people success ,from " + applicationName + ":" + port + " !";
    }

    @GetMapping("/people/code/{code}")
    @ApiOperation(value = "远程调用根据编码查询People", notes = "get 方法远程调用根据编码查询People")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "People 编码", required = false, dataType = "String",
            example = "xiaomei", paramType = "path")})
    @ApiResponses(value = {@ApiResponse(message = "返回字符串", code = 404)
            , @ApiResponse(code = 200, message = " return List<PeopleDto> for query people by code !")})
    public List<PeopleDto> queryPeopleByCode(@PathVariable("code") String code) {
        return peopleFeignService.queryPeopleByCode(code);
    }

    @GetMapping("/people/name/{name}")
    @ApiOperation(value = "远程调用根据姓名查询People", notes = "get 方法远程调用根据姓名查询People")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "People 姓名", required = false, dataType = "String",
            example = "小美", paramType = "path")})
    @ApiResponses(value = {@ApiResponse(message = "返回字符串", code = 404)
            , @ApiResponse(code = 200, message = " return List<PeopleDto> for query people by name !")})
    public List<PeopleDto> queryPeopleByName(@PathVariable("name") String name) {
        return peopleFeignService.queryPeopleByName(name);
    }

    @GetMapping("/people")
    @ApiOperation(value = "远程调用获取所有的People", notes = "get 方法远程调用获取所有有效的People")
    @ApiResponses(value = {@ApiResponse(message = "返回字符串", code = 404)
            , @ApiResponse(code = 200, message = " return List<PeopleDto> for query people for all !")})
    public List<PeopleDto> getAllPeoples() {
        return peopleFeignService.getAllPeoples();
    }

    @DeleteMapping("/people/code/{code}")
    @ApiOperation(value = "远程调用根据编码删除People", notes = "delete 方法远程调用根据编码删除People")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "People 编码", required = true, dataType = "String",
            example = "String", paramType = "path")})
    @ApiResponses(value = {@ApiResponse(message = "返回字符串", code = 404)
            , @ApiResponse(code = 200, message = " delete people by code success ,from ${applicationName}:${port} !")})
    public String deletePeopleByCode(@PathVariable("code") String code) {
        peopleFeignService.deletePeopleByCode(code);
        return " delete people by code success ,from " + applicationName + ":" + port + " !";
    }

    @DeleteMapping("/people/name/{name}")
    @ApiOperation(value = "远程调用根据People姓名删除", notes = "delete 方法远程调用根据姓名删除People")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "People 姓名", required = true, dataType = "String",
            example = "测试", paramType = "path")})
    @ApiResponses(value = {@ApiResponse(message = "返回字符串", code = 404)
            , @ApiResponse(code = 200, message = " delete people by name success ,from ${applicationName}:${port} !")})
    public String deletePeopleByName(@PathVariable("name") String name) {
        peopleFeignService.deletePeopleByName(name);
        return " delete people by name success ,from " + applicationName + ":" + port + " !";
    }
}
