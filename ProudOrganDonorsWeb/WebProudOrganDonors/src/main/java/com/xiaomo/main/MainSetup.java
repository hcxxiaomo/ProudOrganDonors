package com.xiaomo.main;

import java.util.Date;

import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import com.xiaomo.main.bean.Data;
import com.xiaomo.main.bean.Email;
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
	        dao.create(Data.class, false);
	        if (dao.count(Data.class) == 0) {
	        	Data data = new Data();
	        	data.setCount(0);
	        	data.setName("connectUrlCount");
	        	dao.insert(data);
	        }
	        dao.create(Email.class, false);
//	        Daos.migration(dao,PunishInfo.class, true, false);
	}

	public void destroy(NutConfig nc) {
		// TODO Auto-generated method stub
		
	}

}
