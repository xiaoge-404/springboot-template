package com.opsbible.app.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * Titles 员工职位 关系表
 */

@Data
@Builder
public class Titles implements Serializable {

    private Integer empNo;
    private String title;
    private Date fromDate;
    private Date toDate;
}
