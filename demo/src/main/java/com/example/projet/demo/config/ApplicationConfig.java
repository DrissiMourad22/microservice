package com.example.projet.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${mes-config-ms.commandes-last:10}")
    private int comdLast;

    public int getCommandesLast() {
        return comdLast;
    }
}
