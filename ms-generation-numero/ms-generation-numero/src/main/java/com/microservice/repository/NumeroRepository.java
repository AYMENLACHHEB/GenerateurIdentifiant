package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.entity.NumeroGenere;

@Repository
public interface NumeroRepository extends JpaRepository<NumeroGenere, Long> {
}
