package com.maasdianto.ws.service;

import java.util.List;

import com.maasdianto.certification.FarmCertification;
import com.maasdianto.ws.domain.FarmCertificationException;
import com.maasdianto.ws.domain.InvalidFarmCertificationStatusException;

public interface FarmCertificationService {
	
	List<FarmCertification> getFarmCertificationByStatus(String status) throws FarmCertificationException, InvalidFarmCertificationStatusException;
	
	List<FarmCertification> getFarmCertification() throws FarmCertificationException;

}
