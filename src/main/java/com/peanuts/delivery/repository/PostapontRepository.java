package com.peanuts.delivery.repository;

import com.peanuts.delivery.model.Postapont;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostapontRepository extends JpaRepository<Postapont, Long> {

    List<Postapont> findByCityIgnoreCaseContaining(String city);
    List<Postapont> findPostapontsByCityContaining(String city);
    List<Postapont> findPostapontsByCityIgnoreCaseContaining(String city);

}

