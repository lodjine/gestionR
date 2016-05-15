package com.talon.dao;

import java.util.List;

import com.talon.entities.Disponibilit�;
import com.talon.entities.Int�grit�;

public interface IntegriteDao {

	
	public List<Int�grit�> getAll();
	public Int�grit� getById(int id);
	public void persist(Int�grit� integ);
	public void update(Int�grit� integ);
	public void delete(Int�grit� integ);
	public void save(Int�grit� integ);
}
