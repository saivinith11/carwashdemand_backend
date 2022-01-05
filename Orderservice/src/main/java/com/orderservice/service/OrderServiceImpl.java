
package com.orderservice.service;

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

import com.orderservice.dao.OrderRepository;
import com.orderservice.exception.CustomException;
import com.orderservice.model.DatabaseSequence;
import com.orderservice.model.Orderdetails;

@Service
public class OrderServiceImpl implements Orderservice {
	
    @Autowired
    private OrderRepository repo;
    
    
	@Override
	public void save(Orderdetails orderdetails) {
		repo.save(orderdetails);
	}

	@Override
	public List<Orderdetails> findAll() {
		List<Orderdetails> s=repo.findAll();
		if(s.isEmpty()) {
			throw new CustomException("empty records");
		}
		return s;
	}

	@Override
	public void updateDetails(int id,Orderdetails order) {
		Orderdetails o=repo.findById(id).get();
		if(o==null)
		{
			throw new NoSuchElementException();
		}
		repo.save(order);
	}

	@Override
	public void deleteorder(int id) {
		Orderdetails o=repo.findById(id).get();
		if(o==null)
		{
			throw new NoSuchElementException();
		}
		repo.deleteById(id);
	}

	@Override
	public Optional<Orderdetails> getorderdetailbyid(int id) {
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

}
