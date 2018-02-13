package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Title: QuartzDemo
 * Description: 请更改这里的描述
 * <p>
 * Copyright: Copyright (c) 悦升信息
 * Company: 济南悦升信息技术有限公司
 *
 * @author create 陈雷 2017/11/22
 * @version 1.0
 * @since 1.0
 */
public class QuartzDemo {


	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory schedulerFactory =  new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();

		//任务
		JobDetail jobDetail = JobBuilder.newJob(CustomJob.class).
				withIdentity("job_name_1","job_group_1").build();


		SimpleScheduleBuilder scheduleBuilder =
				SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
		//触发器
		Trigger trigger = TriggerBuilder.newTrigger().
				withIdentity("trigger_name_1","trigger_group_1")
				.startAt(new Date()).withSchedule(scheduleBuilder).build();


		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();

	}
}
