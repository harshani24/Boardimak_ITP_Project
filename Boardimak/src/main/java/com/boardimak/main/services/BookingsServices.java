package com.boardimak.main.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.boardimak.main.model.Bookings;
import com.boardimak.main.repository.BookingsCrudRepo;



@Service
@Transactional
public class BookingsServices {

	private final BookingsCrudRepo repoBookings;

	public BookingsServices(BookingsCrudRepo repo) {
		super();
		this.repoBookings = repo;
	}
	
	public void saveCmsOther(Bookings book) {

		repoBookings.save(book);
	}

	public List<Bookings> findAllBookings() {
		List<Bookings> book = new ArrayList<Bookings>();
		for (Bookings other : repoBookings.findAll()) {
			book.add(other);
		}

		return book;
	}

	public void deleteBookigs(int id) {
		repoBookings.deleteById(id);
	}

	public void saveBookings(Bookings book) {

		repoBookings.save(book);
	}

	public Bookings findOneBookings(int id) {

		return repoBookings.findAllById(id);
	}
}
