package com.opsbible.app.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 *  Salaries 为员工薪资表
 */

@Data
@Builder
public class Salaries implements Serializable {
    private Integer empNo;
    private Integer salary;
    private Date fromDate;
    private Date toDate;
}
