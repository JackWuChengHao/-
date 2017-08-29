package scheduler_L1;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {
		public static void main(String[] args) throws SchedulerException {

			//jb立即吃腥，
			Trigger tr = TriggerBuilder.newTrigger()
					.withIdentity("mytriiger","group1")
					.startNow()
					.usingJobData("message", "HeeloWorld11111111") 
					.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
								.withIntervalInSeconds(2).repeatForever()).build();
			
			
			//name groups
			JobDetail jd = JobBuilder.newJob(Hob.class).withIdentity("myjob","group1").usingJobData("message", "HeeloWorld") .build();
			System.out.println(jd.getKey().getName());
			System.out.println(jd.getKey().getGroup());
			System.out.println(jd.getJobClass());
			
			//创建sc
			SchedulerFactory  sl = new StdSchedulerFactory();
			Scheduler sd = sl.getScheduler();
			sd.start();
			sd.scheduleJob(jd, tr);
		}
}
