package org.omega.yueyanghospital.test;

import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.xml.XmlIocLoader;
import org.omega.yueyanghospital.entity.Doctor;

import com.jolbox.bonecp.BoneCPDataSource;

public class Test01 {

	public static void main(String[] args) {
		Ioc ioc = new NutIoc(new XmlIocLoader("nutz-dao.xml"));
		BoneCPDataSource ds = ioc.get(BoneCPDataSource.class, "dataSource");
		Dao dao = new NutDao(ds); //如果已经定义了dao,那么改成dao = ioc.get(Dao.class);

		try {
			Doctor doct = new Doctor();
			doct.setName("test");
			dao.insert(doct);
			List<Doctor> docts = dao.query(Doctor.class, null);
			
			for (Doctor d : docts) {
				System.out.println(d.getId() + ", " + d.getName());
			}

			ioc.depose(); //关闭Ioc容器
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
