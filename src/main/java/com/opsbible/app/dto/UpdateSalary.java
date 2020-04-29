package com.opsbible.app.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@ApiModel(value = "修改员工薪资")
public class UpdateSalary {

    private BaseInfo baseInfo;

    @ApiModelProperty(value = "薪资")
    private Integer salary;

    @ApiModelProperty(value = "生效日期")
    private Date fromDate;
}
