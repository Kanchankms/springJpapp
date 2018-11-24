package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entity.Trainee;


@Repository
@Transactional
public class TraineeDao implements ITraineeDao{

	@PersistenceContext
	EntityManager entitymanager;
	@Override
	public int save(Trainee trainee) {
		entitymanager.persist(trainee);
		entitymanager.flush();
		return trainee.getTraineeId();
		
	}

	@Override
	public List<Trainee> loadAll() {
		// TODO Auto-generated method stub
		Query queryOne=entitymanager.createQuery("FROM Trainee");
		List<Trainee> myList=queryOne.getResultList();
				return myList;
	}

	@Override
	public void delete(int traineeId) {
		Query q=entitymanager.createQuery("DELETE FROM Trainee WHERE traineeId=:traineeid");
		q.setParameter("traineeid",traineeId);
		q.executeUpdate();
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) {

		Trainee traineeres=entitymanager.merge(trainee);
		return traineeres;

		
	}

	@Override
	public Trainee fetch(int traineeId) {
		
		Trainee trainee = entitymanager.find(Trainee.class, traineeId);
		return trainee;
	
	}
	
}
