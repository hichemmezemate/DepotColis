package com.example.depotcolis.controllers;

import com.example.depotcolis.models.Depot;
import com.example.depotcolis.repositories.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("depot")
public class DepotController {
   
    @Autowired
    private DepotRepository repository;

    @GetMapping("")
    public List<Depot> index(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Depot show(@PathVariable String id){
        int depotId = Integer.parseInt(id);
        return repository.findById(depotId).get();
    }

    @PostMapping("/search")
    public List<Depot> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return repository.findByNomContaining(searchTerm);
    }

    @PostMapping("/depot")
    public Depot create(@RequestBody Map<String, String> body){
        String nom = body.get("nom");
        String adresse = body.get("adresse");
        int capacite = Integer.parseInt(body.get("capacite"));
        return repository.save(new Depot(nom, adresse, capacite));
    }

    @PutMapping("/update/{id}")
    public Depot update(@PathVariable String id, @RequestBody Map<String, String> body){
        int depotId = Integer.parseInt(id);
        // getting blog
        Depot depot = repository.findById(depotId).get();
        depot.setNom(body.get("nom"));
        depot.setAdresse(body.get("adresse"));
        depot.setCapacite(Integer.parseInt(body.get("capacite")));
        return repository.save(depot);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        int depotId = Integer.parseInt(id);
        repository.deleteById(depotId);
        return true;
    }

}
