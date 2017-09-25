package com.xiaomo.main.service;

import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.xiaoleilu.hutool.crypto.SecureUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import com.xiaomo.main.bean.Data;
import com.xiaomo.main.bean.User;

@IocBean
public class ListService {

	@Inject // 注入同名的一个ioc对象
    protected Dao dao;
	
	public Integer connectUrlCount(String name) {
		Data data = dao.fetch(Data.class, Cnd.where("name", "=", name));
        return data.getCount() == null ? 0 : data.getCount();
    }
}
