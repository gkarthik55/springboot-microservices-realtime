package com.tripease.train_service.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tripease.train_service.repository.TrainRepository;
import com.tripease.train_service.request.Passenger;
import com.tripease.train_service.response.Ticket;

@Service
public class TrainService
{
	private final TrainRepository trainRepo;
	
	TrainService(TrainRepository trainRepo)
	{
		this.trainRepo = trainRepo;
	}
	
	public ResponseEntity<Ticket> bookTicket(Passenger passenger)
	{
		Ticket ticket = new Ticket();
		
		Random r = new Random();
		
		ticket.setTicketId(r.nextInt(100));
		ticket.setSource(passenger.getSource());
		ticket.setDestination(passenger.getDestination());
		ticket.setTicketStatus(TrainStatus.CONFIRMED.toString());
		ticket.setTicketCost(350);
		ticket.setTrainNumber(passenger.getTrainNumber());
		
		trainRepo.save(ticket);
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}
	
	public Ticket getTicket(Integer ticketId)
	{
		Optional<Ticket> ticket = trainRepo.findById(ticketId);
		
		if(!ticket.isEmpty())
			return ticket.get();
		else 
			return null;
	}
}
