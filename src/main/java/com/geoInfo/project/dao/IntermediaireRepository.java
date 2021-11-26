package com.geoInfo.project.dao;

<<<<<<< HEAD
=======
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> e1157a649a8af1fd4aeeec57091d925895fb77ce
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.geoInfo.project.model.Intermediaire;


@Repository
<<<<<<< HEAD
public interface IntermediaireRepository  extends CrudRepository<Intermediaire, Long>{
=======
public interface IntermediaireRepository  extends JpaRepository<Intermediaire, Long> {
>>>>>>> e1157a649a8af1fd4aeeec57091d925895fb77ce

}
