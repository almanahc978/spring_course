package org.kamil.beans;

import java.util.List;

import org.kamil.config.DatabaseDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NameRepository {

	private DatabaseDatasource ds;

	@Autowired
	public NameRepository(DatabaseDatasource ds) {
		this.ds = ds;
	}

	public List<String> getAll() {
		return ds.getDatabase();
	}
}
