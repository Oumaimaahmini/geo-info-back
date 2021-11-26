package com.geoInfo.project.model;

<<<<<<< HEAD
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
=======
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Entity
>>>>>>> e1157a649a8af1fd4aeeec57091d925895fb77ce

public class Intermediaire {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private String Email;
<<<<<<< HEAD
    
    private String Login;
=======

    @Column(unique = true)
    private String username;
>>>>>>> e1157a649a8af1fd4aeeec57091d925895fb77ce

    private String password;
    
    private String Telephone;
    
    private String Adresse;
    
    private String N_RC;
    
    private String ville;
    
    private String gerant_Name;
    
    private String Commune1;
    
    private String Commune2;
    
    private String Commune3;

<<<<<<< HEAD
=======
    private String roles ;

>>>>>>> e1157a649a8af1fd4aeeec57091d925895fb77ce
}
