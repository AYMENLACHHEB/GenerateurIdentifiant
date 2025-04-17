package com.microservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.microservice.dto.CritereDto;

@FeignClient(name = "ms-configuration-criteres")
public interface InterfaceFeignClient {
	@GetMapping("/api/criteria/getAllDto")
	List<CritereDto> fournirToutlesCriteres();
}