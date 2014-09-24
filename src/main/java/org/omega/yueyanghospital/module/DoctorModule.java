package org.omega.yueyanghospital.module;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.omega.yueyanghospital.entity.Doctor;
import org.omega.yueyanghospital.service.DoctorService;

@At("/doctor")
@IocBean
public class DoctorModule {

	@Inject
	private DoctorService doctorService;
	
	@At
	@Ok("jsp:/jsp/doctor/doctor_list")
	public List<Doctor> show() {
		return doctorService.findAll();
	}
	
}
