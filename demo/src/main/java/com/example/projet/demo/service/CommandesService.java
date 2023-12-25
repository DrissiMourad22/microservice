package com.example.projet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projet.demo.Repo.CommandeRepository;
import com.example.projet.demo.entity.Commande;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class CommandesService {

    @Autowired
    private CommandeRepository commandeRepository;

    public void insererCommandesAleatoires(int nombreDeCommandes) {
        IntStream.rangeClosed(1, nombreDeCommandes)
                .forEach(i -> insererCommandeAleatoire());
    }

    private void insererCommandeAleatoire() {
        Random random = new Random();

        String description = "Description " + (random.nextInt(50) + 1);
        int quantite = random.nextInt(10) + 1;
        LocalDate date = LocalDate.now().minusDays(random.nextInt(30));
        Long montant = (long) (random.nextInt(500) + 100);

        Commande commande = new Commande(null, description, quantite, date, montant);
        commandeRepository.save(commande);
    }

    public List<Commande> getToutesLesCommandes() {
        return commandeRepository.findAll();
    }
    
    public void insererCommandesAleatoiresEtAfficher(int nombreDeCommandes) {
        insererCommandesAleatoires(nombreDeCommandes);

        // Récupérer toutes les commandes après l'insertion
        List<Commande> toutesLesCommandes = getToutesLesCommandes();

        // Afficher le nombre total de commandes
        System.out.println("Nombre total de commandes : " + toutesLesCommandes.size());
    }
}
