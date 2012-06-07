package com.maasdianto.ws.service.impl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.maasdianto.certification.FarmCertification;
import com.maasdianto.ws.domain.FarmCertificationException;
import com.maasdianto.ws.domain.InvalidFarmCertificationStatusException;
import com.maasdianto.ws.service.FarmCertificationService;

public class FarmCertificationServiceImpl implements FarmCertificationService {

	@Override
	public List<FarmCertification> getFarmCertificationByStatus(String status)
			throws FarmCertificationException,
			InvalidFarmCertificationStatusException {
		if (!"valid".equals(status) && !"invalid".equals(status)) {
			throw new InvalidFarmCertificationStatusException("Status invalid");
		}

		List<FarmCertification> certifications = new ArrayList<FarmCertification>();
		for (int i = 1; i <= 5; i++) {
			FarmCertification farmCertification = new FarmCertification();
			farmCertification.setId(i);
			GregorianCalendar calendar = new GregorianCalendar();
			XMLGregorianCalendar startDate;
			XMLGregorianCalendar endDate;
			try {
				startDate = DatatypeFactory.newInstance()
						.newXMLGregorianCalendar(calendar);
				farmCertification.setStartDate(startDate);
				calendar.add(GregorianCalendar.MONTH, 3 + i);
				endDate = DatatypeFactory.newInstance()
						.newXMLGregorianCalendar(calendar);
				farmCertification.setEndDate(endDate);
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
			farmCertification.setStatus(status);
			certifications.add(farmCertification);
		}
		return certifications;
	}

	@Override
	public List<FarmCertification> getFarmCertification()
			throws FarmCertificationException {
		List<FarmCertification> certifications = new ArrayList<FarmCertification>();
		for (int i = 1; i <= 5; i++) {
			FarmCertification farmCertification = new FarmCertification();
			farmCertification.setId(1);
			GregorianCalendar calendar = new GregorianCalendar();
			XMLGregorianCalendar startDate;
			XMLGregorianCalendar endDate;
			try {
				startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
				farmCertification.setStartDate(startDate);
				calendar.add(GregorianCalendar.MONTH, 3);
				endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
				farmCertification.setEndDate(endDate);
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
			farmCertification.setStatus("valid");
			certifications.add(farmCertification);
		}
		return certifications;
	}

}
