package com.app.infraestructure.adapter.database.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
public class UserData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name ="user_name")
    private String name;
    @Column(name= "user_create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

}
