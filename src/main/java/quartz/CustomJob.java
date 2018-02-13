package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title: CustomJob
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/11/22
 * @version 1.0
 * @since 1.0
 */
public class CustomJob implements Job {

	private static List<String> tasks;

	public CustomJob(){
		tasks = new ArrayList<String>();
	}

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

		System.out.println(Arrays.toString(tasks.toArray()));
	}

	public static  void add(String e){
		if(tasks == null ){
			tasks = new ArrayList<String>();
		}
		tasks.add(e);
	}


}
