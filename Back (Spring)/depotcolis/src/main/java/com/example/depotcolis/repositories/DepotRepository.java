package com.example.depotcolis.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.depotcolis.models.Depot;

@Repository
public interface DepotRepository extends JpaRepository<Depot, Integer> {
   
    // custom query to search in depot
    List<Depot> findByNomContaining(String text);
}
