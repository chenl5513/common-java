package hibernate.gen;

import hibernate.bean.UPermission;
import hibernate.bean.URole;
import hibernate.bean.URolePermission;
import hibernate.bean.UUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Title: MainTest
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/11/29
 * @version 1.0
 * @since 1.0
 */


public class MainTest {

	private  static Session session;

	private static Transaction transaction;

	@Test
	public  void testInsert(){
		UUser u = new UUser();
		u.setNickname("小王");
		u.setEmail("123@126.com");
		u.setPswd("123456");
		u.setCreateTime(new Timestamp(System.currentTimeMillis()));
		u.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
		u.setStatus(10L);
		Long l  = (Long) session.save(u);

	}
	@Test
	public  void testInsertRolePermission(){
		UPermission permission = new UPermission("123","456");
		URole role = new URole("asd","fgg");
		URolePermission rolePermission = new URolePermission();
		rolePermission.setPermission(permission);
		rolePermission.setRole(role);
		//session.save(role);
		//session.save(permission);
		session.save(rolePermission);
	}









	@BeforeClass
	public static void init(){
		Configuration configuration = new Configuration().configure(Main.class.getResource("hibernate.cfg.xml"));
		SessionFactory sessionFactory =  configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	@AfterClass
	public static void destory(){
		if(transaction != null && transaction.isActive()){
			transaction.commit();
		}
		if(session != null && session.isOpen()){
			session.close();
		}
	}
}
