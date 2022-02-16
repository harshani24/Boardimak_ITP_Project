package com.boardimak.main.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.boardimak.main.model.CmsOther;
import com.boardimak.main.repository.CrudRepoCmsOthers;





@Service
@Transactional
public class CmsOtherServices {

	private final CrudRepoCmsOthers cmsOtherRepo;
	
	public CmsOtherServices(CrudRepoCmsOthers cmsOtherRepo) {
		this.cmsOtherRepo = cmsOtherRepo;
	}
	
	public void saveCmsOther(CmsOther blog) {

		cmsOtherRepo.save(blog);
	}

	public List<CmsOther> findAllOthers() {
		List<CmsOther> others = new ArrayList<CmsOther>();
		for (CmsOther other : cmsOtherRepo.findAll()) {
			others.add(other);
		}

		return others;
	}

	public void deleteOthers(int id) {
		cmsOtherRepo.deleteById(id);
	}

	public void saveOthers(CmsOther other) {

		cmsOtherRepo.save(other);
	}

	public CmsOther findOneOthers(int id) {

		return cmsOtherRepo.findAllById(id);
	}
}
