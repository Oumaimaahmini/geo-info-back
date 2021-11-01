package com.geoInfo.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.geoInfo.project.model.Intermediaire;
import com.geoInfo.project.dao.IntermediaireRepository;

import lombok.Data;

@Data
@Service
public class IntermediaireService {
	
	@Autowired
    private IntermediaireRepository intermediaireRepository;

    public Optional<Intermediaire> getIntermediaire(final Long id) {
        return intermediaireRepository.findById(id);
    }

    public Iterable<Intermediaire> getIntermediaires() {
        return intermediaireRepository.findAll();
    }

    public void deleteIntermediaire(final Long id) {
    	intermediaireRepository.deleteById(id);
    }

    public Intermediaire saveIntermediaire(Intermediaire intermediaire) {
    	Intermediaire savedIntermediaire = intermediaireRepository.save(intermediaire);
        return savedIntermediaire;
    }

}