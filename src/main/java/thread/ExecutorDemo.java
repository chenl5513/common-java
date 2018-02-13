package thread;

import java.util.Iterator;
import java.util.Queue;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Title: ExecutorDemo
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/11/10
 * @version 1.0
 * @since 1.0
 */
public class ExecutorDemo {




	public static void main(String[] args) {
		MyExecutor executor = new MyExecutor();

		Random r= new Random();
		System.out.println("1234567890".charAt(20));


	}
}
class  MyExecutor implements Executor{

	final Queue<Runnable> tasks = new LinkedBlockingQueue<Runnable>();


	@Override
	public void execute(Runnable command) {

	}
}