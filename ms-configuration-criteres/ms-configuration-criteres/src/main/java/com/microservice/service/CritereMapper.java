package com.microservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.microservice.dto.CritereDto;
import com.microservice.entity.Critere;

@Service
public class CritereMapper {

	public CritereDto ConvertirEnDto(Critere critere) {
		
		CritereDto critereDto = new CritereDto();
		
		critereDto.setCompteurInitial(critere.getCompteurInitial());
		critereDto.setDateFormat(critere.getDateFormat());
		critereDto.setLongueur(critere.getLongueur());
		critereDto.setOrdre(critere.getOrdre());
		critereDto.setPrefixe(critere.getPrefixe());
		critereDto.setSuffixe(critere.getSuffixe());
		critereDto.setType(critere.getType());
		critereDto.setId(critere.getId());
		return critereDto;
	}
	
	public Critere ConvertirEnEntite(CritereDto critereDto) {
		
		Critere critere = new Critere();
		
		critere.setCompteurInitial(critereDto.getCompteurInitial());
		critere.setDateFormat(critereDto.getDateFormat());
		critere.setLongueur(critereDto.getLongueur());
		critere.setOrdre(critereDto.getOrdre());
		critere.setPrefixe(critereDto.getPrefixe());
		critere.setSuffixe(critereDto.getSuffixe());
		critere.setType(critereDto.getType());
		critere.setId(critereDto.getId());
		
		return critere;
	}

    public List<CritereDto> ConvertirEnDtoList(List<Critere> criteres) {
    	List<CritereDto> critereDtos = criteres.stream()
    		    .map(critere -> {
    		    	
    				CritereDto critereDto = new CritereDto();
    				
    				critereDto.setCompteurInitial(critere.getCompteurInitial());
    				critereDto.setDateFormat(critere.getDateFormat());
    				critereDto.setLongueur(critere.getLongueur());
    				critereDto.setOrdre(critere.getOrdre());
    				critereDto.setPrefixe(critere.getPrefixe());
    				critereDto.setSuffixe(critere.getSuffixe());
    				critereDto.setType(critere.getType());
    				critereDto.setId(critere.getId());
    		        return critereDto;
    		        
    		    })
    		    .collect(Collectors.toList());
    	
    	return critereDtos;
    }
    
}
