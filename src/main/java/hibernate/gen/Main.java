package hibernate.gen;

import hibernate.bean.UUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;

/**
 * Title: Main
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/11/28
 * @version 1.0
 * @since 1.0
 */
public class Main {

	public static void main(String[] args) {
		//
		Configuration configuration = new Configuration().configure(Main.class.getResource("hibernate.cfg.xml"));
		SessionFactory sessionFactory =  configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		UUser u = new UUser();
		u.setNickname("小王");
		u.setEmail("123@126.com");
		u.setPswd("123456");
		u.setCreateTime(new Timestamp(System.currentTimeMillis()));
		u.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
		u.setStatus(10L);
		Long l  = (Long) session.save(u);
		session.close();
		System.out.println(l);

	}
}
