package com.opsbible.app.dto;

import com.opsbible.app.utils.GenderEnum;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

/**
 * EmployeeInfo 员工信息,在基础数据结构上添加了离职日期和总薪资
 */

@Data
@Builder
public class EmployeeInfo {

    private Integer empNo;
    private BaseInfo userInfo;
    private Date hireDate;
    private Date DepartureDate;
    private Integer totalSalaries;
}
