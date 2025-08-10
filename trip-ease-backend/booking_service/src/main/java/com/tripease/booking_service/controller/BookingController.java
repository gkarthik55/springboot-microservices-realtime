package com.tripease.booking_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripease.booking_service.entity.Passenger;
import com.tripease.booking_service.entity.Ticket;
import com.tripease.booking_service.service.BookingService;

@RestController
public class BookingController
{
	BookingService bookingService;

	@Autowired
	BookingController(BookingService bookingService)
	{
		this.bookingService = bookingService;
	}
	
	@PostMapping(value = "/ticket")
	public ResponseEntity<Ticket> bookTrainTicket(@RequestBody Passenger passenger)
	{
		return bookingService.processTicketBooking(passenger);
	}
	
	@GetMapping(value="/ticket/{ticketId}")
	public ResponseEntity<Ticket> getTrainTicket(@PathVariable Integer ticketId)
	{
	    return bookingService.fetchTicketInformationSync(ticketId);
	}
	
	@GetMapping(value="/ticketAsync/{ticketId}")
	public void getTrainTicketAsync(@PathVariable Integer ticketId)
	{
	    bookingService.fetchTicketInformationAsync(ticketId);
	}
}
