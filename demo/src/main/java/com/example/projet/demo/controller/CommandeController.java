package com.example.projet.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.projet.demo.Repo.CommandeRepository;
import com.example.projet.demo.entity.Commande;

import java.util.List;

@RestController

public class CommandeController {
    @Autowired
    private CommandeRepository commandeRepository;
    
    @GetMapping
    
    @RequestMapping("/comd")
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeRepository.findById(id).orElse(null);
    }
    @PutMapping("/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande updatedCommande) {
        Commande existingCommande = commandeRepository.findById(id).orElse(null);
        if (existingCommande != null) {
            existingCommande.setDesc(updatedCommande.getDesc());
            existingCommande.setQte(updatedCommande.getQte());
            existingCommande.setDate(updatedCommande.getDate());
            existingCommande.setMontant(updatedCommande.getMontant());
            return commandeRepository.save(existingCommande);
        }
        return null;
    }
    
    @PostMapping
    public Commande createCommande(@RequestBody Commande commande) {
        return commandeRepository.save(commande);
    }


    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeRepository.deleteById(id);
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        if (commandeRepository.count() > 0) {
            return ResponseEntity.ok("Up");
        } else {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Down");
        }
    }
    
}
