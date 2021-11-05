package com.geoInfo.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;
    @Column(unique = true)
    private String username ;

    private String password;

    private String roles ;
}
