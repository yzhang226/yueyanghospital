package org.omega.yueyanghospital.service;

import java.util.List;
import java.util.Map;

import org.omega.mytools.db.DBService;
import org.omega.yueyanghospital.entity.Test01;

public class TestService extends DBService<Test01> {

	protected String getTableName() {
		return "test_01";
	}

	protected Map<String, String> getColumnToProperty() {
		return columnToProperty;
	}

	public static void main(String[] args) throws Exception {
		TestService ts = new TestService();
		List<Test01> all = ts.findAll();
		for (Test01 t : all) {
			System.out.println(t.getId() + ", " + t.getName() + ", " + t.getDou());
		}
	}
	
}
