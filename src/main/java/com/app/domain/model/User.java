package com.app.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class User  {


    private Long id;
    private String name;
    private Date createAt;

}
