package com.opsbible.app.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 *  DeptEmp 员工 部门 关系对应表
 */

@Data
@Builder
public class DeptEmp implements Serializable {

    private Integer empNo;
    private String deptNo;
    private Date fromDate;
    private Date toDate;
}
