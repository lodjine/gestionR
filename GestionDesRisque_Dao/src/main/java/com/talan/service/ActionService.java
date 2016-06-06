package com.talan.service;

import java.rmi.activation.ActivationGroupDesc;
import java.util.List;

import com.talan.entities.Action;

public interface ActionService {
	
	public List<Action> getAll();
	public Action getById(int id);
	public void persist(Action action);
	public void update(Action action);
	public void delete(Action action);
	public void save(Action action);
	public List<Action> getAllNonTermine();
	public List<Action> getAllTermine();

}
