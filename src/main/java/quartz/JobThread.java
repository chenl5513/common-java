package quartz;

/**
 * Title: JobThread
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/11/22
 * @version 1.0
 * @since 1.0
 */
public class JobThread extends Thread {

	@Override
	public void run() {
		for (int i = 0;;i++){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			CustomJob.add(i+"");
		}
	}

	public static void main(String[] args) {
		JobThread t= new JobThread();
		t.start();
	}
}
