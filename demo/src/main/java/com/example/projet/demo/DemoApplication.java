package com.example.projet.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.projet.demo.service.CommandesService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private CommandesService commandesService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Insérer des commandes aléatoires
        commandesService.insererCommandesAleatoires(50);

        // Afficher toutes les commandes
        commandesService.insererCommandesAleatoiresEtAfficher(50);
    }
}
