package com.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.dto.CritereDto;
import com.microservice.entity.Critere;
import com.microservice.repository.CritereRepository;

@Service
public class CritereService {

    @Autowired
    private CritereRepository critereRepository;
    
    @Autowired
    private CritereMapper critereMapper;

    public Critere EnregistrerCritere(CritereDto criteredto) {
        return critereRepository.save(critereMapper.ConvertirEnEntite(criteredto));
    }
    
    public Critere majCritere(Long id, CritereDto criteredto) {
    	Critere critere = critereRepository.findById(id).get();
    	if (criteredto.getCompteurInitial() != 0) critere.setCompteurInitial(criteredto.getCompteurInitial());
    	if (criteredto.getDateFormat() != null) critere.setDateFormat(criteredto.getDateFormat());
    	if (criteredto.getLongueur() != 0) critere.setLongueur(criteredto.getLongueur());
    	if (criteredto.getOrdre() != 0) critere.setOrdre(criteredto.getOrdre());
    	if (!criteredto.getPrefixe().equals("")) critere.setPrefixe(criteredto.getPrefixe());
    	if (!criteredto.getSuffixe().equals("")) critere.setSuffixe(criteredto.getSuffixe());
    	if (!criteredto.getType().equals("")) critere.setType(criteredto.getType());
        return critereRepository.save(critere);
    }
    
    public void supprimerCritere(Long id) {
    	critereRepository.deleteById(id);
    }

    public Critere recupererCritere(Long id) {
        return critereRepository.findById(id).get();
    }
    
    public List<Critere> recupererToutCriteres() {
        return critereRepository.findAll();
    }
    
    public List<CritereDto> recupererToutCriteresDto() {
        return critereMapper.ConvertirEnDtoList(critereRepository.findAll());
    }
}

