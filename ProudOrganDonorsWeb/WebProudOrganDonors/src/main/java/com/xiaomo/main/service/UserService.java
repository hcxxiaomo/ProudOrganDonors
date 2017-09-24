package com.xiaomo.main.service;

import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.Param;

import com.xiaoleilu.hutool.crypto.SecureUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import com.xiaomo.main.bean.User;

@IocBean
public class UserService {

	@Inject // 注入同名的一个ioc对象
    protected Dao dao;
	
	public Integer login(String name, String password, HttpSession session) {
        User user = dao.fetch(User.class, Cnd.where("name", "=", name));
        
        if (user == null) {
            return -1;
        }
        boolean equal = StrUtil.equals(SecureUtil.md5(password.trim().concat(user.getSalt())), user.getPassword());
        if (!equal) {
			return -2;
		}
        session.setAttribute("me", user);
        return 0;
    }
}
