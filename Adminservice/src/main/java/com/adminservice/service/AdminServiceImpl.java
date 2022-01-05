package com.adminservice.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.adminservice.dao.AdminRepository;
import com.adminservice.dao.RatingRepository;
import com.adminservice.dao.WashPackRepository;
import com.adminservice.exception.CustomException;
import com.adminservice.model.Adminlogin;
import com.adminservice.model.DatabaseSequence;
import com.adminservice.model.Ratings;
import com.adminservice.model.Washpacks;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository repo;

	@Autowired
	private WashPackRepository repo1;
	
	@Autowired
	private RatingRepository repo2;

	@Override
	public List<Adminlogin> findAll() {
		List<Adminlogin> s = repo.findAll();
		if (s.isEmpty()) {
			throw new CustomException("no such user");
		}
		return s;
	}

	@Override
	public void save(Adminlogin admindetails) {
		repo.save(admindetails);
	}

	@Override
	public void updateDetails(int id, Adminlogin admin) {
		Adminlogin d = repo.findById(id).get();
		if (d == null) {
			throw new NoSuchElementException();
		}
		repo.save(admin);
	}

	@Override
	public void deleteadmin(int id) {
		Adminlogin d = repo.findById(id).get();
		if (d == null) {
			throw new NoSuchElementException();
		}
		repo.deleteById(id);
	}

	
	
	//packs
	@Override
	public void save(Washpacks washpacks) {
		repo1.save(washpacks);
	}

	@Override
	public List<Washpacks> findAllpacks() {
		List<Washpacks> s=repo1.findAll();
		if(s.isEmpty())
		{
			throw new CustomException("no such user");
		}
		return s;
	}

	
	
	@Override
	public void deletepack(int id) {
		Washpacks d = repo1.findById(id).get();
		if (d == null) 
		{
			throw new NoSuchElementException();
		}
		repo1.deleteById(id);
	}

	@Override
	public void updatepacks(int id, Washpacks wash) {
		Washpacks d = repo1.findById(id).get();
		if (d == null) 
		{
			throw new NoSuchElementException();
		}
		repo1.save(wash);
	}
	
	
	
	
	/*@Autowired
	private MongoOperations mongoOperations;



	public long getSequenceNumber(String sequenceName) {
	//get sequence no
	Query query = new Query(Criteria.where("id").is(sequenceName));
	//update the sequence no
	Update update = new Update().inc("seq", 1);
	//modify in document
	DatabaseSequence counter = mongoOperations.findAndModify(query,
	update, options().returnNew(true).upsert(true),
	DatabaseSequence.class);



	return !Objects.isNull(counter) ? counter.getSeq() : 1;



	}*/

	@Override
	public void save(Ratings ratings) {
		repo2.save(ratings);
		
	}

	@Override
	public List<Ratings> findratings() {
		// TODO Auto-generated method stub
		return repo2.findAll();
	}



}
