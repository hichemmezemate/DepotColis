package com.example.depotcolis.controllers;

import com.example.depotcolis.models.Colis;
import com.example.depotcolis.repositories.ColisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("colis")
public class ColisController {
   
    @Autowired
    private ColisRepository repository;

    @GetMapping("")
    public List<Colis> index(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Colis show(@PathVariable String id){
        int depotId = Integer.parseInt(id);
        return repository.findById(depotId).get();
    }

    @PostMapping("/search")
    public List<Colis> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return repository.findByNumeroContaining(searchTerm);
    }

    @PostMapping("/colis")
    public Colis create(@RequestBody Map<String, String> body){
        String numero = body.get("numero");
        String adresselivraison = body.get("adresse_livraison");
        String nom_destinataire = body.get("nom_destinataire");
        String prenom_destinataire = body.get("prenom_destinataire");
        String tel_destinataire = body.get("tel_destinataire");
        int id_depot = Integer.parseInt(body.get("id_depot"));
        return repository.save(new Colis(numero, adresselivraison, nom_destinataire, prenom_destinataire, tel_destinataire, id_depot));
    }

    @PutMapping("/update/{id}")
    public Colis update(@PathVariable String id, @RequestBody Map<String, String> body){
        int colisId = Integer.parseInt(id);
        // getting blog
        Colis colis = repository.findById(colisId).get();
        colis.setNumero(body.get("numero"));
        colis.setAdresse_livraison(body.get("adresse_livraison"));
        colis.setNom_destinataire(body.get("nom_destinataire"));
        colis.setPrenom_destinataire(body.get("prenom_destinataire"));
        colis.setTel_destinataire(body.get("tel_destinataire"));
        colis.setId_depot(Integer.parseInt(body.get("id_depot")));
        return repository.save(colis);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        int colisId = Integer.parseInt(id);
        repository.deleteById(colisId);
        return true;
    }

}
