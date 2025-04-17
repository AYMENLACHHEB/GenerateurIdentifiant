package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.entity.Critere;

@Repository
public interface CritereRepository extends JpaRepository<Critere, Long> {
}

