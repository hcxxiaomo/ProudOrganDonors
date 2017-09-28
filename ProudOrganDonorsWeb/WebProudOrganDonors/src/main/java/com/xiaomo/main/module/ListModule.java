package com.xiaomo.main.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.filter.CheckSession;

import com.xiaomo.main.service.ListService;

@IocBean // 声明为Ioc容器中的一个Bean
@At("/") // 整个模块的路径前缀
@Fail("http:500") // 抛出异常的话,就走500页面
public class ListModule {
	
	@Inject
	private ListService listService;

	   @At("/list")
	    @Ok("jsp:jsp.manager.list")
	   @Filters(@By(type=CheckSession.class, args={"me", "/index"})) // 检查当前Session是否带me这个属性
	    public Object listIndex(){
		  return new NutMap().addv("connectUrlCount", listService.connectUrlCount("connectUrlCount"))
		   .addv("email", listService.email());
//	    	return listService.connectUrlCount("connectUrlCount");
	    }
	
   @At("/saveEmail")
   @Ok("json")
   @Filters
	public NutMap saveEmail(String email){
		listService.saveEmail(email);
		return new NutMap().addv("save", "ok");
	}
   
   @At("/updateConnectUrlCount")
   @Ok("json")
   @Filters
   public NutMap updateConnectUrlCount(){
	   listService.updateUrlCount("connectUrlCount");
	   return new NutMap().addv("save", "ok");
   }
}
