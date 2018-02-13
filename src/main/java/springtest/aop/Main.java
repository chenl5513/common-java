package springtest.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: Main
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/10/17
 * @version 1.0
 * @since 1.0
 */
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		IMath math = context.getBean(IMath.class);

		math.add(1,2);

		/*math.div(1,0);

		math.mut(1,2);

		math.sub(1,2);

		math.abs(-1);*/



	}

}
