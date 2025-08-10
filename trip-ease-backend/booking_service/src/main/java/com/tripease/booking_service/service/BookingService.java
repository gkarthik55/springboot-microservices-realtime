package com.tripease.booking_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.tripease.booking_service.entity.Passenger;
import com.tripease.booking_service.entity.Ticket;

@Service
public class BookingService
{
	@Value("${irctc.endpoint.book_ticket}")
	private String IRCTC_BOOK_TRAIN_TICKET_URL;
	
	@Value("${irctc.endpoint.get_ticket}")
	private String IRCTC_GET_TRAIN_TICKET_URL;

	public ResponseEntity<Ticket> processTicketBooking(Passenger passenger)
	{
		//		RestTemplate rt = new RestTemplate();
		//		
		//		ResponseEntity<Ticket> responseEntity = 
		//				rt.postForEntity(IRCTC_BOOK_TRAIN_TICKET_URL, passenger, Ticket.class);

		WebClient webclient = WebClient.create();
		
		Ticket ticket = 	webclient.post() // Perform the POST Operation
								 .uri(IRCTC_BOOK_TRAIN_TICKET_URL) // URI
								 .body(BodyInserters.fromValue(passenger)) // Insert the Passenger data as Request Body 
								 .header("Content-Type", "application/json") // Mention its Content Type
								 .accept(MediaType.APPLICATION_JSON) // Mention the Mediatype expect
								 .retrieve() // Get the values
								 .bodyToMono(Ticket.class) // Bind the values to Ticket class
								 .block(); // Perform Synchronous Call
		
		ResponseEntity<Ticket> responseEntity = new ResponseEntity<Ticket	>(ticket, HttpStatus.OK);
		
		return responseEntity;
	}

	public ResponseEntity<Ticket> fetchTicketInformationSync(Integer ticketId)
	{
		// Using RestTemplate 
		//		RestTemplate rt = new RestTemplate();
		//		
		//		ResponseEntity<Ticket> responseEntity = 
		//				rt.getForEntity(IRCTC_GET_TRAIN_TICKET_URL, Ticket.class, ticketId);
		
		System.out.println("Synchronous Method Started..");
		
		WebClient webclient = WebClient.create();
		
		Ticket ticket = webclient.get() // Represents GET Operation
								 .uri(IRCTC_GET_TRAIN_TICKET_URL, ticketId) // URI
								 .accept(MediaType.APPLICATION_JSON) // To mention what Mediatype expect
								 .retrieve() // Retrieve from Response Body
								 .bodyToMono(Ticket.class) // Bind Response Body to Java Object
								 .block(); // Blocking Thread - Synchronous
		
		System.out.println("Synchronous Method Ended..");
		
		ResponseEntity<Ticket> responseEntity = new ResponseEntity<Ticket	>(ticket, HttpStatus.OK);
		return responseEntity;
	}
	
	public void fetchTicketInformationAsync(Integer ticketId)
	{
		System.out.println("Asynchronous Method Started..");
		
		WebClient webclient = WebClient.create();
		
		webclient.get() // Represents GET Operation
				 .uri(IRCTC_GET_TRAIN_TICKET_URL, ticketId) // URI
				 .accept(MediaType.APPLICATION_JSON) // To mention what Mediatype expect
				 .retrieve() // Retrieve from Response Body
				 .bodyToMono(String.class) // Bind Response Body to Java Object
				 .subscribe( response -> handleResponse(response));
		
		System.out.println("Asynchronous Method Ended..");
	}
	
	public void handleResponse(String response)
	{
		System.out.println(response);
	}
}
