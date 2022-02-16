package com.boardimak.main.services;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.boardimak.main.model.Property;
import com.boardimak.main.model.Proposal;
import com.boardimak.main.repository.PropertyRepository;
import com.boardimak.main.repository.ProposalRepo;

@Service
public class PropertyService {

	PropertyRepository propertyRepo;
	ProposalRepo proposalRepo;
	Property property;
	
	@Autowired
	public PropertyService(PropertyRepository pRepo,ProposalRepo propRepo) {
		this.propertyRepo = pRepo;
		this.proposalRepo = propRepo;
	}

	public List<Property> showAll() {
		List<Property> properties = new ArrayList<>();
			for(Property propertyObject : propertyRepo.findAll()) {
				properties.add(propertyObject);
			}
		return properties;
	}

	public void saveProperty(Property newProperty,MultipartFile file) throws Exception {
		// Normalize file name
    	//String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    	String fileName = file.getOriginalFilename();
    	System.out.println(fileName);
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }
            //testImages dbFile = new testImages(0,fileName,fileName, file.getContentType(), file.getBytes());
            newProperty.setImageName(fileName);
            newProperty.setFileType(file.getContentType());
            newProperty.setData(file.getBytes());
            propertyRepo.save(newProperty);
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
	}
	
	public void updateProperty(Property property) {
		propertyRepo.save(property);
	}
	
	public Property getAProperty(int id) {
		Property property = propertyRepo.findAllById(id);
		return 	property;
	}
	
	public void deleteProperty(int id) {
		propertyRepo.deleteById(id);	
	}
	
	
	//proposal ----------------------------------------------------------------------
	
	public List<Proposal> showProposals() {
		List<Proposal> proposals = new ArrayList<>();
			for(Proposal Object : proposalRepo.findAll()) {
				proposals.add(Object);
			}
			System.out.println("test two");
		return proposals;
	}
	
	/*
	public Proposal getAProposal(int id) {
		Proposal proposal = proposalRepo.findById(id);
		return 	proposal;
	}
	
	public void saveProposal(Proposal newProposal) {
		proposalRepo.save(newProposal);
	}
	*/
	
	public void deleteProposal(int id) {
		proposalRepo.deleteById(id);	
	}

	
	//---------------
	/*
	public List<Property> showPageByPage() {
		int page = 0;
		int limit = 5;
	    Pageable pageable = (Pageable) new PageRequest(page, limit);
	    Page<Property> modelPage = propertyRepo.findAll(pageable);
	    
	    while (true) {
	        for (Property model : modelPage.getContents()) {
	            processAwesomeModel(model);
	        }
	        if (!modelPage.hasNext()) {
	            break;
	        }
	        pageable = modelPage.nextPageable();
	        modelPage = propertyRepo.findAll(pageable);
	    }  
	}
	*/
	
	
	
	
	
	
	
	
}
