package com.boardimak.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.boardimak.main.model.Proposal;

public interface ProposalRepo extends JpaRepository<Proposal, Integer>{

}
