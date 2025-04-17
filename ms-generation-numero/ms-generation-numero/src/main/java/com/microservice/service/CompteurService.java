package com.microservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

// Simule un compteur incrémental par configuration
@Service
class CompteurService {
    private Map<String, Integer> compteurMap = new HashMap<>();

    public int getNextCompteur(String configKey, int initialValue) {
        int next = compteurMap.getOrDefault(configKey, initialValue) + 1;
        compteurMap.put(configKey, next);
        return next;
    }
}