package com.opsbible.app.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;


@Data
@Builder
@ApiModel(value = "员工薪资")
public class Salary  implements Serializable {

    @ApiModelProperty(value = "员工编号")
    private Integer empNo;

    @ApiModelProperty(value = "薪资")
    private Integer salary;

    @ApiModelProperty(value = "生效日期")
    private Date fromDate;
}
