package com.opsbible.app.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
public class BaseInfo implements Serializable {
    private String birthDate;
    private String firstName;
    private String lastName;
    private String gender;
}
