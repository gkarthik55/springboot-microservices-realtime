package com.tripease.train_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripease.train_service.request.Passenger;
import com.tripease.train_service.response.Ticket;
import com.tripease.train_service.service.TrainService;

@RestController
public class TrainController
{
	private final TrainService trainService;
	
	@Autowired
	TrainController(TrainService trainService)
	{
		this.trainService = trainService;
	}
	
	@PostMapping(value = "/ticket")
	public ResponseEntity<Ticket> bookTrainTicket(@RequestBody Passenger passenger)
	{
		System.out.println("Welcome to Train Ticket Booking..");
		
		return trainService.bookTicket(passenger);
	}
	
	@GetMapping(value="/ticket/{ticketId}")
	public ResponseEntity<Ticket> getTicketDetails(@PathVariable Integer ticketId)
	{
	    Ticket ticket = trainService.getTicket(ticketId);

	    return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
}
