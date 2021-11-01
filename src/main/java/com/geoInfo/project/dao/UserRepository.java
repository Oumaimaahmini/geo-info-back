package com.geoInfo.project.dao;

import com.geoInfo.project.model.Intermediaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Intermediaire,Long> {
    Optional<Intermediaire> findByUsername(String username);

}
