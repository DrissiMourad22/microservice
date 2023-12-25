// CommandeRepository.java
package com.example.projet.demo.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projet.demo.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    

}
