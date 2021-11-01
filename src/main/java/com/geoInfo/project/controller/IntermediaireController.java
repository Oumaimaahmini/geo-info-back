package com.geoInfo.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geoInfo.project.model.Intermediaire;
import com.geoInfo.project.service.IntermediaireService;

@RestController
public class IntermediaireController {
	
	 @Autowired
	    private IntermediaireService intermediaireService;

	    /**
	    * Read - Get all employees
	    * @return - An Iterable object of Employee full filled
	    */
	    @GetMapping("/intermediaires")
	    public Iterable<Intermediaire> getIntermediaires() {
	        return intermediaireService.getIntermediaires();
	    }

}


