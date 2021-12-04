package com.geoInfo.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "intermediaire")

public class Intermediaire extends Admin{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private String Email;
    
    private String Login;

    private String password;
    
    private String Telephone;
    
    private String Adresse;
    
    private String N_RC;
    
    private String ville;
    
    private String gerant_Name;
    
    private String Commune1;
    
    private String Commune2;
    
    private String Commune3;


    private String roles ;


    private boolean isVerified = false ;
    


