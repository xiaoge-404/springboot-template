package com.opsbible.app.dto;

import com.opsbible.app.utils.GenderEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

/**
 * EmployeeInfo 员工信息,在基础数据结构上添加了离职日期和总薪资
 */

@Data
@Builder
@ApiModel(value = "员工基本信息")
public class EmployeeInfo {

    @ApiModelProperty(value = "员工编号")
    private Integer empNo;

    private BaseInfo userInfo;

    @ApiModelProperty(value = "职位名称")
    private String title;

    @ApiModelProperty(value = "所属部门")
    private String departMent;

    @ApiModelProperty(value = "入职日期")
    private Date hireDate;

    @ApiModelProperty(value = "离职日期")
    private Date departureDate;

    @ApiModelProperty(value = "在职总收入")
    private Integer totalSalaries;
}
