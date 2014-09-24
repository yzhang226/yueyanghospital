package org.omega.yueyanghospital;

import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.xml.XmlIocLoader;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.ioc.provider.ComboIocProvider;
import org.omega.yueyanghospital.entity.Doctor;


@Modules(scanPackage = true)
@IocBy(type=ComboIocProvider.class, args={"*org.nutz.ioc.loader.xml.XmlIocLoader", "nutz-dao.xml", "*org.nutz.ioc.loader.annotation.AnnotationIocLoader", "org.omega.yueyanghospital"})
@Encoding(input="UTF-8", output="UTF-8")
public class MainModule {

	@At("/index")
	@Ok("jsp:/index")
	public String hello() {
		Ioc ioc = new NutIoc(new XmlIocLoader("nutz-dao.xml"));
		Dao dao = ioc.get(Dao.class);
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
