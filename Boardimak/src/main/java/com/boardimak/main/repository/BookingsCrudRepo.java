package com.boardimak.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.boardimak.main.model.Bookings;

public interface BookingsCrudRepo extends CrudRepository<Bookings, Integer> {
	Bookings findAllById(int id);
}
