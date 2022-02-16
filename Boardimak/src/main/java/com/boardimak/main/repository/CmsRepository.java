package com.boardimak.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.boardimak.main.model.Blogs;




public interface CmsRepository extends CrudRepository<Blogs, Integer> {

	Blogs findAllById(int id);
	
	//public Ticket findByUsernameAndPassword(String username,String password);

	



}
