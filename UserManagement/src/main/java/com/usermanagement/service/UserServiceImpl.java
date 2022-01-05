package com.usermanagement.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.usermanagement.Exception.CustomException;
import com.usermanagement.dao.UserRepository;
import com.usermanagement.model.DatabaseSequence;
import com.usermanagement.model.SignUp;
@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserRepository repo;

	@Override
	public void save1(SignUp signup) {
		// TODO Auto-generated method stub
		repo.save(signup);
	}

	@Override
	public List<SignUp> findAll() {
	List<SignUp> s=repo.findAll();
	if(s.isEmpty())
	{
		throw new CustomException("empty records");
	}
		return s;
	}
	
	
	@Override
	public void updateuserdetails(int id, SignUp signup) {
		SignUp s=repo.findById(id);
		if(s==null)
		{
			throw new NoSuchElementException();
		}
		 repo.save(signup);
	}

	
	

	@Override
	public void deleteuser(int id) {
	SignUp s=repo.findById(id);
	if(s==null)
	{
		throw new NoSuchElementException();
	}
		repo.deleteById(id);
	}
	
	
	
	
	
	@Autowired
	private MongoOperations mongoOperations;



	public Long getSequenceNumber(String sequenceName) {
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

	

	

	
	
	
}
