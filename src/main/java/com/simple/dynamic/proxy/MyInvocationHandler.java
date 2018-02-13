package com.simple.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Title: MyInvocationHandler
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/9/13
 * @version 1.0
 * @since 1.0
 */
public class MyInvocationHandler implements InvocationHandler {

	private Object target;

	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				target.getClass().getInterfaces(), this);
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println(proxy.getClass().getName());
		System.out.println(method.getName());
		System.out.println(Arrays.toString(args));

		System.out.println("------------------before------------------");

		// 执行目标对象的方法
		Object result = method.invoke(target, args);

		// 在目标对象的方法执行之后简单的打印一下
		System.out.println("-------------------after------------------");

		return result;
	}
}
