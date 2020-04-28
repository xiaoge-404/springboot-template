package com.opsbible.app.entity;


import com.opsbible.app.utils.GenderEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * Employees 为员工信息表,数据来源:https://github.com/datacharmer/test_db
 */

@Data
@Builder
public class Employees implements Serializable {
    private Integer empNo;
    private String birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;
}
