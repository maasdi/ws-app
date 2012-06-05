package com.maasdianto.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.maasdianto.person.GetAllPersonRequest;
import com.maasdianto.person.GetAllPersonResponse;
import com.maasdianto.person.GetPersonRequest;
import com.maasdianto.person.GetPersonResponse;
import com.maasdianto.person.Person;
import com.maasdianto.ws.service.PersonService;

@Endpoint
public class PersonEndPoint {
	
	private PersonService personService = new PersonService();
	
	@PayloadRoot(localPart="getPersonRequest", namespace="http://www.maasdianto.com/person")
	@ResponsePayload
	public GetPersonResponse getPerson(@RequestPayload GetPersonRequest personRequest){
		int id = personRequest.getId();
		GetPersonResponse response = new GetPersonResponse();
		response.setPerson(personService.getPerson(id));
		return response;
	}
	
	@PayloadRoot(localPart="getAllPersonRequest", namespace="http://www.maasdianto.com/person")
	@ResponsePayload
	public GetAllPersonResponse getAllPerson(@RequestPayload GetAllPersonRequest allPersonRequest){
		GetAllPersonResponse response = new GetAllPersonResponse();
		for (int i = 1; i <= 5; i++) {
			Person person = new Person();
			person.setId(i);
			person.setFirstName("FirstName"+i);
			person.setLastName("LastName"+i);
			response.getPerson().add(person);
		}
		return response;
	}

}
