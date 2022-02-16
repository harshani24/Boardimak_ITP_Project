package com.boardimak.main.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.boardimak.main.model.Blogs;
import com.boardimak.main.repository.CmsRepository;


@Service
@Transactional
public class CmsService {

	private final CmsRepository blogRepository;

	public CmsService(CmsRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	public void saveMyUser(Blogs blog) {

		blogRepository.save(blog);
	}

	public List<Blogs> findAllBlogs() {
		List<Blogs> blogs = new ArrayList<Blogs>();
		for (Blogs blog : blogRepository.findAll()) {
			blogs.add(blog);
		}

		return blogs;
	}

	public void deleteBlogs(int id) {
		blogRepository.deleteById(id);
	}

	public void saveBlog(Blogs blog) {

		blogRepository.save(blog);
	}

	public Blogs findOneBlog(int id) {

		return blogRepository.findAllById(id);
	}
}
