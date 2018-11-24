package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cg.dao.ITraineeDao;
import com.cg.entity.Trainee;

@Service
public class TraineeService implements ITraineeService {


	@Autowired
	private ITraineeDao traineeDao;
		
	public int save(Trainee trainee) {
		return traineeDao.save(trainee);
	}
		
	public List<Trainee> loadAll() {
		return traineeDao.loadAll();
	}

	public Trainee fetch(int traineeId) {
		return traineeDao.fetch(traineeId);
		  
	}
	
	public void delete(int traineeid)
	{
		traineeDao.delete(traineeid);
	}

	public Trainee updateTrainee(Trainee trainee) {
		return traineeDao.updateTrainee(trainee);
	}
	
}
