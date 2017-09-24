package com.xiaomo.main.test;

import org.junit.runners.model.InitializationError;
import org.nutz.mock.NutTestRunner;

import com.xiaomo.main.MainModule;

public class MyNutTestRunner extends NutTestRunner  {

	public MyNutTestRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	protected Class<?> getMainModule() {
		return MainModule.class;
	}
	
	

}
