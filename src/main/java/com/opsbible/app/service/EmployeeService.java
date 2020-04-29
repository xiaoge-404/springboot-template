package com.opsbible.app.service;

import com.opsbible.app.dto.BaseInfo;
import com.opsbible.app.dto.EmployeeInfo;


public interface EmployeeService {

    //通过雇员基本信息获取雇员薪资和状态
    EmployeeInfo queryEmployeeInfo(BaseInfo baseInfo);

}
