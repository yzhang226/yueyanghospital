package org.omega.yueyanghospital;

import java.util.List;

import javax.sql.DataSource;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;
import org.nutz.ioc.loader.xml.XmlIocLoader;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.omega.yueyanghospital.entity.Doctor;

import com.jolbox.bonecp.BoneCPDataSource;


@Modules(scanPackage = true)
public class MainModule {

	@At("/index")
	@Ok("jsp:/index")
	public String hello() {
		//将配置信息保存到dao.xml,并存放于src文件夹下

//		Ioc ioc = new NutIoc(new XmlIocLoader("nutz-dao.xml"));
		Ioc ioc = new NutIoc(new JsonLoader("nut-dao.json"));
		BoneCPDataSource ds = ioc.get(BoneCPDataSource.class, "dataSource");
		Dao dao = new NutDao(ds); //如果已经定义了dao,那么改成dao = ioc.get(Dao.class);

//		dao.create(Doctor.class, true);
		try {
			Doctor doct = new Doctor();
			doct.setName("test");
			dao.insert(doct);
			List<Doctor> docts = dao.query(Doctor.class, null);
			
			for (Doctor d : docts) {
				System.out.println(d.getId() + ", " + d.getName());
			}

			ioc.depose(); //关闭Ioc容器
			return docts.get(0).getId() + " ---  " + docts.get(0).getName();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		
		return "okkkk";
	}
	
}
