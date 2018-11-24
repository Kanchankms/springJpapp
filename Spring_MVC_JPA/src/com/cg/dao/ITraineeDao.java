package com.cg.dao;

import java.util.List;

import com.cg.entity.Trainee;

public interface ITraineeDao {

	public int save(Trainee trainee);
	public List<Trainee> loadAll();
	public Trainee fetch(int traineeId);
	public void delete(int traineeId);
	public Trainee updateTrainee(Trainee trainee);
}
