package com.geoInfo.project.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Entity

public class Intermediaire {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private String Email;

    @Column(unique = true)
    private String username;

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

}
