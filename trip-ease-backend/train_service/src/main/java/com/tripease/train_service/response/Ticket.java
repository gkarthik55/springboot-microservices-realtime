package com.tripease.train_service.response;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_details")
public class Ticket
{
	@Id
	@Column(name = "ticketId")
	private Integer ticketId;
	
	@Column(name = "src")
	private String source;
	
	@Column(name = "dest")
	private String destination;
	
	@Column(name = "trainNumber")
	private String trainNumber;
	
	@Column(name = "ticketCost")
	private Integer ticketCost;
	
	@Column(name = "ticketStatus")
	private String ticketStatus;
	
	public Ticket()
	{
		
	}

	public Ticket(Integer ticketId, String source, String destination, String trainNumber, Integer ticketCost,
			String ticketStatus) {
		this.ticketId = ticketId;
		this.source = source;
		this.destination = destination;
		this.trainNumber = trainNumber;
		this.ticketCost = ticketCost;
		this.ticketStatus = ticketStatus;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public Integer getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(Integer ticketCost) {
		this.ticketCost = ticketCost;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", source=" + source + ", destination=" + destination + ", trainNumber="
				+ trainNumber + ", ticketCost=" + ticketCost + ", ticketStatus=" + ticketStatus + "]";
	}

}
