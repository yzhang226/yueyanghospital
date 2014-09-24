package org.omega.yueyanghospital.service;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.omega.yueyanghospital.entity.Doctor;

@IocBean(fields = {"dao"})
public class DoctorService extends _BaseService<Doctor>{

	public DoctorService() {
		super();	
	}
	
	public DoctorService(Dao dao) {
		super(dao);
	}
	
}
