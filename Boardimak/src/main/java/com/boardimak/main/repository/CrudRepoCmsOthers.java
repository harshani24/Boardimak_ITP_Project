package com.boardimak.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.boardimak.main.model.CmsOther;





public interface CrudRepoCmsOthers extends CrudRepository<CmsOther, Integer>{

	CmsOther findAllById(int id);
}
