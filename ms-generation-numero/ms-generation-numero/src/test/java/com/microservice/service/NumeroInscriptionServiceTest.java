package com.microservice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservice.dto.CritereDto;
import com.microservice.dto.InscriptionDto;
import com.microservice.entity.NumeroGenere;
import com.microservice.repository.NumeroRepository;


@SpringBootTest
public class NumeroInscriptionServiceTest {
	
    @InjectMocks
    private GenerationNumeroService generationNumeroService;

    @Mock
    private NumeroRepository numeroRepository;

    @Mock
    private CompteurService compteurService;
    
    @Mock
    private InterfaceFeignClient interfaceFeignClient;

    @Test
    void testGenererNumeroOk() throws ParseException {
        InscriptionDto data = new InscriptionDto();
        data.setNom("Dupont");
        data.setPrenom("Jean");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data.setDateNaissance(sdf.parse("15/01/1990"));
        NumeroGenere numeroMock = new NumeroGenere("DUPJE19900005");

        List<CritereDto> criteres = List.of(
            new CritereDto(1L, "nom", 1, 3, "", "", "", 0),
            new CritereDto(1L, "prenom", 2, 2, "", "", "", 0),
            new CritereDto(1L, "dateNaissance", 3, 0, "", "", "yyyy", 0),
            new CritereDto(1L, "compteur", 4, 4, "", "", "", 0)
        );

        Mockito.when(interfaceFeignClient.fournirToutlesCriteres()).thenReturn(criteres);
        Mockito.when(compteurService.getNextCompteur(Mockito.anyString(), Mockito.anyInt())).thenReturn(5);
        Mockito.when(numeroRepository.save(Mockito.any(NumeroGenere.class))).thenReturn(numeroMock);
        String resultat = generationNumeroService.genererNumero(data);

        Assertions.assertEquals(numeroMock, new NumeroGenere(resultat));
    }
    
    @Test
    void testTronquerTextePlusLong() {
        String result = generationNumeroService.tronquer("Bonjour", 3);
        Assertions.assertEquals("Bon", result);
    }

    @Test
    void testTronquerTexteMoinsLong() {
        String result = generationNumeroService.tronquer("Bo", 5);
        Assertions.assertEquals("Bo", result);
    }

    @Test
    void testTronquerMongeurTexteZero() {
        String result = generationNumeroService.tronquer("Bonjour", 0);
        Assertions.assertEquals("Bonjour", result);
    }


}
