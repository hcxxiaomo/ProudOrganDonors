package com.xiaomo.main;

import java.util.Date;

import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import com.xiaomo.main.bean.User;

public class MainSetup implements Setup {

	public void init(NutConfig conf) {
		 Ioc ioc = conf.getIoc();
	        Dao dao = ioc.get(Dao.class);
	        // 如果没有createTablesInPackage,请检查nutz版本
//	        Daos.createTablesInPackage(dao, "com.xiaomo.main", false);
	        dao.create(User.class, false);
	        // 初始化默认根用户
	        if (dao.count(User.class) == 0) {
	            User user = new User();
	            user.setName("admin");
	            user.setPassword("a272670be8960ec9f7d1d2ba02a977b9");//admin@hk
	            user.setSalt("apbb3v");
	            user.setCreateTime(new Date());
	            user.setUpdateTime(new Date());
	            dao.insert(user);
	        }
//	        dao.create(CarNumberInfo.class, false);
//	        dao.create(PoliceInfo.class, false);
//	        dao.create(NoticeInfo.class, false);
//	        dao.create(PunishInfo.class, false);
//	        dao.create(PunishTemplate.class, false);
//	        dao.create(AreaInfo.class, false);
//	        Daos.migration(dao,PunishTemplate.class, true, false);
//	        Daos.migration(dao,PunishInfo.class, true, false);
	}

	public void destroy(NutConfig nc) {
		// TODO Auto-generated method stub
		
	}

}
