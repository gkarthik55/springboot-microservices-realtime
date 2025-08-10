package com.tripease.train_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripease.train_service.response.Ticket;

@Repository
public interface TrainRepository	extends JpaRepository<Ticket, Integer>
{

}
