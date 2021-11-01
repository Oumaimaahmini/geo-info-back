package com.geoInfo.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.geoInfo.project.model.Intermediaire;


@Repository
public interface IntermediaireRepository  extends JpaRepository<Intermediaire, Long> {

}
