package com.xiaomo.main.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.xiaoleilu.hutool.crypto.SecureUtil;
import com.xiaoleilu.hutool.util.RandomUtil;
import com.xiaomo.main.bean.User;

@RunWith(MyNutTestRunner.class)
@IocBean // 必须有
public class TestUser {

private static final Log log = Logs.get();
	
	// 跟通常的@Inject完全一样.
//    @Inject("refer:$ioc")
//    protected Ioc ioc;
    
    @Inject
    protected Dao dao;
    
    @Test
    public void testInserUser(){
    	User user = new User();
    	user.setName("admin");
    	user.setPassword("admin@hk");
    	user.setCreateTime(new Date());
    	user.setUpdateTime(new Date());
    	 String salt = RandomUtil.randomString(6);
         user.setSalt(salt);
         user.setPassword(SecureUtil.md5(user.getPassword().trim().concat(salt)));
         user = dao.insert(user);
    }
}
