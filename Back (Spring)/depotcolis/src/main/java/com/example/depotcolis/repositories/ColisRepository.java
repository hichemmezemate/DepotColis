package com.example.depotcolis.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.depotcolis.models.Colis;

@Repository
public interface ColisRepository extends JpaRepository<Colis, Integer> {
   
    // custom query to search in depot
    List<Colis> findByNumeroContaining(String text);
}
