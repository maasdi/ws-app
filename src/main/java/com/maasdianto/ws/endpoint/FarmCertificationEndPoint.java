package com.maasdianto.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.maasdianto.certification.GetFarmCertificationByStatusRequest;
import com.maasdianto.certification.GetFarmCertificationByStatusResponse;
import com.maasdianto.certification.GetFarmCertificationRequest;
import com.maasdianto.certification.GetFarmCertificationResponse;
import com.maasdianto.ws.domain.FarmCertificationException;
import com.maasdianto.ws.service.FarmCertificationService;
import com.maasdianto.ws.service.impl.FarmCertificationServiceImpl;

@Endpoint
public class FarmCertificationEndPoint {

	FarmCertificationService farmService = new FarmCertificationServiceImpl();

	@PayloadRoot(localPart = "getFarmCertificationByStatusRequest", namespace = "http://www.maasdianto.com/certification")
	@ResponsePayload
	public GetFarmCertificationByStatusResponse getFarmCertificationByStatus(
			@RequestPayload GetFarmCertificationByStatusRequest request) {
		String status = request.getStatus();
		if (status.equals(null)) {
			throw new FarmCertificationException("Status can't be bull");
		}
		GetFarmCertificationByStatusResponse response = new GetFarmCertificationByStatusResponse();
		response.getFarmCertification().addAll(farmService.getFarmCertificationByStatus(status));
		return response;
	}

	@PayloadRoot(localPart = "getFarmCertificationRequest", namespace = "http://www.maasdianto.com/certification")
	@ResponsePayload
	public GetFarmCertificationResponse getFarmCertification(
			@RequestPayload GetFarmCertificationRequest request) {
		GetFarmCertificationResponse response = new GetFarmCertificationResponse();
		response.getFarmCertification().addAll(
				farmService.getFarmCertification());
		return response;
	}
}
