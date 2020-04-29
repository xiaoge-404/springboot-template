package com.opsbible.app.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * DeptManager 部门管理者
 */

@Data
@Builder
public class DeptManager implements Serializable {

    private Integer empNo;
    private String deptNo;
    private Date fromDate;
    private Date toDate;
}
