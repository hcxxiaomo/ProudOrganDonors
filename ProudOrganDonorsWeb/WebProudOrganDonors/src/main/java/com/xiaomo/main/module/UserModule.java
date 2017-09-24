package com.xiaomo.main.module;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Attr;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;

import com.xiaoleilu.hutool.crypto.SecureUtil;
import com.xiaoleilu.hutool.util.RandomUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import com.xiaomo.main.bean.User;
import com.xiaomo.main.service.UserService;

@IocBean // 声明为Ioc容器中的一个Bean
@At("/") // 整个模块的路径前缀
@Ok("json:{locked:'password|salt',ignoreNull:true}") // 忽略password和salt属性,忽略空属性的json输出
@Fail("http:500") // 抛出异常的话,就走500页面
@Filters(@By(type=CheckSession.class, args={"me", "/"})) // 检查当前Session是否带me这个属性
public class UserModule {

	@Inject // 注入同名的一个ioc对象
    protected Dao dao;
	
	@Inject // 注入同名的一个ioc对象
	protected UserService userService;

    @At
    public int count() { // 统计用户数的方法,算是个测试点
        return dao.count(User.class);
    }
    
    @At("/index")
    @Ok("jsp:jsp.manager.login")
    @Filters
    public void loginIndex(){
    	
    }

    @At
    @Filters // 覆盖UserModule类的@Filter设置,因为登陆可不能要求是个已经登陆的Session
    public Integer login(@Param("username")String name, @Param("password")String password, HttpSession session) {
       return userService.login(name, password, session);
    }

    @At
    @Ok(">>:/") // 跟其他方法不同,这个方法完成后就跳转首页了
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @At
    public Object add(@Param("..")User user) { // 两个点号是按对象属性一一设置
        NutMap re = new NutMap();
        String msg = checkUser(user, true);
        if (msg != null){
            return re.setv("ok", false).setv("msg", msg);
        }
        String salt = RandomUtil.randomString(6);
        user.setSalt(salt);
        user.setPassword(SecureUtil.md5(user.getPassword().trim().concat(salt)));
        user = dao.insert(user);
        return re.setv("ok", true).setv("data", user);
    }

    @At
    public Object update(@Param("..")User user) {
        NutMap re = new NutMap();
        String msg = checkUser(user, false);
        if (msg != null){
            return re.setv("ok", false).setv("msg", msg);
        }
        user.setName(null);// 不允许更新用户名
        user.setCreateTime(null);//也不允许更新创建时间
        user.setUpdateTime(new Date());// 设置正确的更新时间
        dao.updateIgnoreNull(user);// 真正更新的其实只有password和salt
        return re.setv("ok", true);
    }

    @At
    public Object delete(@Param("id")int id, @Attr("me")User user) {
        if (user.getId() == id) {
            return new NutMap().setv("ok", false).setv("msg", "不能删除当前用户!!");
        }
        dao.delete(User.class, id); // 再严谨一些的话,需要判断是否为>0
        return new NutMap().setv("ok", true);
    }

    @At
    public Object query(@Param("name")String name, @Param("..")Pager pager) {
        Cnd cnd = Strings.isBlank(name)? null : Cnd.where("name", "like", "%"+name+"%");
        QueryResult qr = new QueryResult();
        qr.setList(dao.query(User.class, cnd, pager));
        pager.setRecordCount(dao.count(User.class, cnd));
        qr.setPager(pager);
        return qr; //默认分页是第1页,每页20条
    }

    @At("/")
    @Ok("jsp:jsp.manager.userlist") // 真实路径是 /WEB-INF/jsp/manager/userlist.jsp
    public void index() {
    }

    protected String checkUser(User user, boolean create) {
        if (user == null) {
            return "空对象";
        }
        if (create) {
            if (Strings.isBlank(user.getName()) || Strings.isBlank(user.getPassword()))
                return "用户名/密码不能为空";
        } else {
            if (Strings.isBlank(user.getPassword()))
                return "密码不能为空";
        }
        String passwd = user.getPassword().trim();
        if (6 > passwd.length() || passwd.length() > 12) {
            return "密码长度错误";
        }
        user.setPassword(passwd);
        if (create) {
            int count = dao.count(User.class, Cnd.where("name", "=", user.getName()));
            if (count != 0) {
                return "用户名已经存在";
            }
        } else {
            if (user.getId() < 1) {
                return "用户Id非法";
            }
        }
        if (user.getName() != null)
            user.setName(user.getName().trim());
        return null;
    }
	
}