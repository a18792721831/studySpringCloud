package com.study.servicesubscriber.controller;

import com.study.servicedomain.beans.dto.CustomerDto;
import com.study.servicedomain.beans.dto.PeopleDto;
import com.study.servicedomain.neum.Sex;
import com.study.servicedomain.neum.Status;
import com.study.servicesubscriber.service.PeopleService;
import com.study.servicesubscriber.service.feign.CustomerFeignService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiayq
 * @Date 2020-03-28
 */
@RestController
@RequestMapping("/people")
@Api
public class PeopleController {

    @Value("${server.port}")
    private int port;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private CustomerFeignService customerFeignService;

    @PostMapping("/{code}/{name}/{age}/{sex}/{hobby}")
    @ApiOperation(value = "增加People", notes = "post 提交增加People")
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
    public String addPeople(@PathVariable("code") String code,
                            @PathVariable("name") String name,
                            @PathVariable("age") int age,
                            @PathVariable("sex") int sex,
                            @PathVariable("hobby") String hobby) {
        PeopleDto peopleDto = new PeopleDto();
        peopleDto.setCode(code);
        peopleDto.setName(name);
        peopleDto.setAge(age);
        peopleDto.setStatus(Status.VALID);
        peopleDto.setSex(Sex.getSexByValue(sex));
        peopleDto.setHobby(hobby);
        peopleService.addPeople(peopleDto);
        return " add success , from " + applicationName + ":" + port + " !";
    }

    @PutMapping("/{code}/{name}")
    @ApiOperation(value = "根据编码修改名字", notes = " put 修改People")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "People 编码", required = true, dataType = "String",
            example = "xiaomei", paramType = "path"),
            @ApiImplicitParam(name = "name", value = "People 姓名", required = true, dataType = "String",
                    example = "小美01", paramType = "path")})
    @ApiResponses(value = {@ApiResponse(message = "返回字符串", code = 404)
            , @ApiResponse(code = 200, message = " modify success , from ${applicationName}:${port} !")})
    public String modifyPeople(@PathVariable("code") String code, @PathVariable("name") String name) {
        peopleService.modifyPeopleNameByCode(code, name);
        return " modify success , from " + applicationName + ":" + port + " !";
    }

    @GetMapping("/code/{code}")
    @ApiOperation(value = "根据编码查询People", notes = "get 方法根据编码查询People")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "People 编码", required = false, dataType = "String",
            example = "xiaomei", paramType = "path")})
    @ApiResponses(value = {@ApiResponse(message = "返回字符串", code = 404)
            , @ApiResponse(code = 200, message = " return List<PeopleDto> for people by code !")})
    public List<PeopleDto> queryPeopleByCode(@PathVariable("code") String code) {
        return peopleService.findPeopleByCode(code);
    }

    @GetMapping("/name/{name}")
    @ApiOperation(value = "根据姓名查询People", notes = "get 方法根据姓名查询People")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "People 姓名", required = false, dataType = "String",
            example = "小美", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回字符串"),
            @ApiResponse(code = 200, message = " return List<PeopleDto> for people by name !")})
    public List<PeopleDto> queryPeopleByName(@PathVariable("name") String name) {
        return peopleService.findPeopleByName(name);
    }

    @GetMapping("/people")
    @ApiOperation(value = "获取所有的People", notes = "get 方法获取所有有效的People")
    @ApiResponses({@ApiResponse(code = 404, message = "返回字符串"),
            @ApiResponse(code = 200, message = " return List<PeopleDto> for get all peoples !")})
    public List<PeopleDto> getAllPeoples() {
        return peopleService.getAllPeople();
    }

    @DeleteMapping("/code/{code}")
    @ApiOperation(value = "根据编码删除People", notes = "delete 方法根据编码删除People")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "People 编码", required = true, dataType = "String",
            example = "String", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回字符串"),
            @ApiResponse(code = 200, message = " delete success by code, from ${applicationName}:{port} !")})
    public String deletePeopleByCode(@PathVariable("code") String code) {
        peopleService.deletePeopleByCode(code);
        return " delete success by code, from " + applicationName + ":" + port + " !";
    }

    @DeleteMapping("/name/{name}")
    @ApiOperation(value = "根据People姓名删除", notes = "delete 方法根据姓名删除People")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "People 姓名", required = true, dataType = "String",
            example = "测试", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回字符串"),
            @ApiResponse(code = 200, message = " delete success by name, from ${applicationName}:{port} !")})
    public String deletePeopleByName(@PathVariable("name") String name) {
        peopleService.deletePeopleByName(name);
        return " delete success by name, from " + applicationName + ":" + port + " !";
    }

    @GetMapping("/customer")
    @ApiOperation(value = "远程调用查询所有的Customer", notes = "get 方法远程调用获取全部的客户")
    @ApiResponses({@ApiResponse(code = 404, message = "返回字符串"),
            @ApiResponse(code = 200, message = " return List<CustomerDto> for all")})
    public List<CustomerDto> getAllCustomers() {
        return customerFeignService.getAllCustomer();
    }

    @PostMapping("/customer/{code}/{name}/{address}")
    @ApiOperation(value = "远程调用增加Customer", notes = "post 方法远程调用增加客户")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "Customer 编码", required = true, dataType = "String",
            example = "xiaomei", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回字符串"),
            @ApiResponse(code = 200, message = " return List<CustomerDto> for {code}")})
    public String addCustomer(@PathVariable("code") String code, @PathVariable("name") String name, @PathVariable("address") String address) {
        return customerFeignService.addCustomer(code, name, address);
    }

    @GetMapping("/customer/code/{code}")
    @ApiOperation(value = "远程调用根据name查询Customer", notes = "get 方法远程调用根据姓名查询客户")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "Customer 姓名", required = true, dataType = "String",
            example = "小美", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回字符串信息"),
            @ApiResponse(code = 200, message = "return List<CustomerDto> for {name}")})
    public List<CustomerDto> queryCustomerByCode(@PathVariable("code") String code) {
        return customerFeignService.queryCustomerByCode(code);
    }

    @DeleteMapping("/customer/name/{name}")
    @ApiOperation(value = "远程调用根据name删除Customer", notes = "delete 方法远程调用根据姓名删除客户")
    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "Customer 姓名", required = true, dataType = "String",
            example = "测试", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回异常字符串信息"),
            @ApiResponse(code = 200, message = " delete customer by name success by name , from ${applicationName}:{port} !")})
    public String deleteCustomerByName(@PathVariable("name") String name) {
        return customerFeignService.deleteCustomerByName(name);
    }

    @DeleteMapping("/customer/code/{code}")
    @ApiOperation(value = "远程调用根据code删除Customer", notes = "delete 方法远程调用根据编码删除客户")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "Customer 编码", required = true, dataType = "String",
            example = "ceshi", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回异常字符串"),
            @ApiResponse(code = 200, message = " delete customer by code success by code, from ${applicationName}:${port} !")})
    public String deleteCustomerByCode(@PathVariable("code") String code) {
        return customerFeignService.deleteCustomerByCode(code);
    }

    @PutMapping("/customer/{code}/{name}")
    @ApiOperation(value = "远程调用根据code设置name", notes = "put 方法远程调用根据编码更新姓名")
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "Customer 编码", required = true, dataType = "String",
            example = "ceshi", paramType = "path"),
            @ApiImplicitParam(name = "name", value = "Customer 姓名", required = true, dataType = "String",
                    example = "小美", paramType = "path")})
    @ApiResponses({@ApiResponse(code = 404, message = "返回字符串信息"),
            @ApiResponse(code = 200, message = " modify success ,from {$applicationName}:${port} !")})
    public String modifyCustomer(@PathVariable("code") String code, @PathVariable("name") String name) {
        return customerFeignService.modidfyCustomer(code, name);
    }
}
