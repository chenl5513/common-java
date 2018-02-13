package com.simple.dynamic.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {
  
    @Test
	public void testProxy() throws Throwable {
        // 实例化目标对象  
        UserService userService = new UserServiceImpl();  
          
        // 实例化InvocationHandler  
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);  
          
        // 根据目标对象生成代理对象  
       //UserService proxy = (UserService) invocationHandler.getProxy();

        UserService proxy  = (UserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                userService.getClass().getInterfaces(), invocationHandler);
          
        // 调用代理对象的方法  
        proxy.add();
        System.out.println(proxy.toString());
          
    }

    @Test
    public void testGenerateProxyClass() {
        //ProxyGeneratorUtils.writeProxyClassToHardDisk("F:/$Proxy11.class");
    }
} 