package com.boardimak.main.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardimak.main.model.Proposal;
import com.boardimak.main.model.Users;
import com.boardimak.main.repository.ProposalRepo;
import com.boardimak.main.repository.UsersRepo;

@Service
public class UsersService {

	
	@Autowired
	private UsersRepo usersrepo;
	
	@Autowired 
	private ProposalRepo proposalrepo;
	
	// Method to read all users from the database
	public ArrayList<Users> getAllUsers(){
		ArrayList<Users> users = new ArrayList<>();
		usersrepo.findAll().forEach(users::add);
		return users;
	}
	
	public Users getUser(int id){
		return usersrepo.findById(id).get();
	}
	
	public void updateStripeID( Users user ) {
		usersrepo.save(user);
	}

	public Users getIdByEmail(String email) {

		Users id = usersrepo.findAllByEmail(email);
		return id;
	}

	/*Sending a proposal from the Parent or the Student*/
	public void saveProposal(Proposal p) {
		proposalrepo.save(p);
	}
	
	public ArrayList<Proposal> findProposals() {
		ArrayList<Proposal> proposals = new ArrayList<>();
		proposalrepo.findAll().forEach(proposals::add);
		return proposals;
	}

	public void deleteProposal(int id) {
		proposalrepo.deleteById(id);
	}
	
	/*Create account*/
	
	
	public void saveOwner(Users newOwner) {
		usersrepo.save(newOwner);
	}
	
	public Users getUserByStripe(String stripeId) {
		return usersrepo.getUserByStripeId(stripeId);
	}
	
	public Users getUserByAccount(String accountId) {
		return usersrepo.getUserByAccountId(accountId);
	}
}
