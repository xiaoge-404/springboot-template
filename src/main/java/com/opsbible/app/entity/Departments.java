package com.opsbible.app.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Departments 部门表
 */

@Data
@Builder
public class Departments implements Serializable {
    private String deptNo;
    private String deptName;
}
