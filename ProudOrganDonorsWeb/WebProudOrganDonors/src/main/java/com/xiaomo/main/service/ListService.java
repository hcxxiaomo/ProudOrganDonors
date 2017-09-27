package com.xiaomo.main.service;

import java.util.Date;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.xiaomo.main.bean.Data;
import com.xiaomo.main.bean.Email;

@IocBean
public class ListService {

	@Inject // 注入同名的一个ioc对象
    protected Dao dao;
	
	public Integer connectUrlCount(String name) {
		Data data = dao.fetch(Data.class, Cnd.where("name", "=", name));
		if (data == null || data.getCount() == null) {
			return 0;
		}else {
			return  data.getCount(); 
		}
    }
	
	public void updateUrlCount(String name){
		Sql sql = Sqls.create("update t_data set count = count + 1");//TODO String name 需要写进去
	    dao.execute(sql);
	}
	
	public List<Email> email(){
		List<Email>  list = dao.query(Email.class, Cnd.orderBy().desc("id"));
		return list;
	}
	
	public boolean saveEmail(String email){
		Email e = dao.fetch(Email.class, Cnd.where("email", "=", email));
		if (e == null) {
			e = new Email();
			e.setEmail(email);
			e.setCreateTime(new Date());
			dao.insert(e);
			return true;
		}
		return false;
	}
}
