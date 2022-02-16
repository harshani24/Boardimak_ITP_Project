package com.boardimak.main.services;

import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.stereotype.Service;

import com.boardimak.main.model.Promotion;
import com.boardimak.main.repository.PromotionRepository;

@Service
@Transactional
public class PromotionServices {

	private final PromotionRepository promotionRepository;
	
	public PromotionServices(PromotionRepository promotionRepository) {
		super();
		this.promotionRepository = promotionRepository;
	}
	
	
	public void savePromotion(Promotion promotion) {
		
		promotionRepository.save(promotion);
	}
	
	public List<Promotion> ShowAllPromotion(){
		List<Promotion> pro = new ArrayList<Promotion>();
		for(Promotion promotion :promotionRepository.findAll()) {
			pro.add(promotion);
		}
		return pro;
	}
	
	public List<Promotion> ShowAllPromotionByUser(int user){
		List<Promotion> pro = new ArrayList<Promotion>();
		for(Promotion promotion :promotionRepository.findAllByUser(user)) {
			pro.add(promotion);
		}
		return pro;
	}
	
	public void deletePromotion(int id) {
		promotionRepository.deleteById(id);
	}
	
	public Promotion editPromotion(int id) {
		return promotionRepository.findAllById(id);
	
	}
	
	
	public Promotion getAPromotion(int id) {
		Promotion promotion = promotionRepository.findAllById(id);
		return 	promotion;
	}

	
	
	/*public Ticket findByUsernameAndPassword(String username,String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}*/
	
	
}











	
	


	



