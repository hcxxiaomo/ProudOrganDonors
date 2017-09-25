package com.xiaomo.main.module;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.filter.CheckSession;

import com.xiaomo.main.service.ListService;

@IocBean // 声明为Ioc容器中的一个Bean
@At("/") // 整个模块的路径前缀
@Ok("json:{locked:'password|salt',ignoreNull:true}") // 忽略password和salt属性,忽略空属性的json输出
@Fail("http:500") // 抛出异常的话,就走500页面
@Filters(@By(type=CheckSession.class, args={"me", "/"})) // 检查当前Session是否带me这个属性
public class ListModule {
	
	@Inject
	private ListService listService;

	   @At("/list")
	    @Ok("jsp:jsp.manager.list")
	    @Filters
	    public Object listIndex(){
	    	return listService.connectUrlCount("connectUrlCount");
	    }
	
	
}
