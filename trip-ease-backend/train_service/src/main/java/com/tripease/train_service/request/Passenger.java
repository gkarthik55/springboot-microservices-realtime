package com.tripease.train_service.request;

public class Passenger
{
	private String firstName;
	private String lastName;
	private String gender;
	private String source;
	private String destination;
	private String journeyDate;
	private String trainNumber;
	
	public Passenger()
	{}
	
	public Passenger(String firstName, String lastName, String gender, String source,
			String destination, String journeyDate, String trainNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.source = source;
		this.destination = destination;
		this.journeyDate = journeyDate;
		this.trainNumber = trainNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", source=" + source + ", destination=" + destination + ", journeyDate="
				+ journeyDate + ", trainNumber=" + trainNumber + "]";
	}
}
