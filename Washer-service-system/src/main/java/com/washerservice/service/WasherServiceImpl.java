package com.washerservice.service;

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

import com.washerservice.Model.DatabaseSequence;
import com.washerservice.Model.Washerdetails;
import com.washerservice.Repository.WasherRepo;
import com.washerservice.exception.CustomException;

@Service
public class WasherServiceImpl implements WasherService {

	@Autowired
	private WasherRepo repo;

	@Override
	public void save(Washerdetails washerdetails) {
		repo.save(washerdetails);
	}

	@Override
	public List<Washerdetails> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Washerdetails> getwasherdetailsbylocation(String location) {
		List<Washerdetails> w=repo.findBylocation(location);
		if(w.isEmpty())	
		{
			throw new CustomException("location not found ");
		}
		return w;
	}


	@Override
	public void deletewasher(int id) {
		Washerdetails w=repo.findById(id).get();
		if(w==null)
		{
			throw new NoSuchElementException();
		}
		repo.deleteById(id);
		
	}

	@Override
	public Optional<Washerdetails> getwasherbyid(int id) {
		return repo.findById(id);
	}

	
	
	@Autowired
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



	}

	public void deletewasher(Washerdetails washer) {
		// TODO Auto-generated method stub
		
	}

	
	
}
