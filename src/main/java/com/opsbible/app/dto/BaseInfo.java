package com.opsbible.app.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
@ApiModel(value = "员工")
public class BaseInfo implements Serializable {

    @ApiModelProperty(value = "出生日期",example = "2020-05-01")
    private String birthDate;

    @ApiModelProperty(value = "第一名字")
    private String firstName;

    @ApiModelProperty(value = "第二名字")
    private String lastName;

    @ApiModelProperty(value = "性别",example = "M")
    private String gender;
}
