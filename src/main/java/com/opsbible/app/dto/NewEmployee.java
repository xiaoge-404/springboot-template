package com.opsbible.app.dto;


import com.opsbible.app.entity.Employees;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@ApiModel(value = "新建员工")
public class NewEmployee implements Serializable {

    @ApiModelProperty(value = "出生日期",example = "1992-11-19")
    private String birthDate;

    @ApiModelProperty(value = "第一名字")
    private String firstName;

    @ApiModelProperty(value = "第二名字")
    private String lastName;

    @ApiModelProperty(value = "性别",example = "M")
    private String gender;

    @ApiModelProperty(value = "入职日期",example = "2008-10-10")
    private Date hireDate;

    @ApiModelProperty(value = "薪资")
    private Integer salary;

    @ApiModelProperty(value = "职位")
    private String title;

    @ApiModelProperty(value = "部门编号")
    private String deptNo;

    @ApiModelProperty(value = "起始时间")
    private Date fromDate;

    @ApiModelProperty(value = "截至时间")
    private Date toDate;

}
