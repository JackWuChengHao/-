package scheduler_L1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;

public class Hob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
			//便携具体的业务逻辑
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sf.format(date) +" Hello World");

	
			System.out.println(  		arg0.getJobDetail().getJobDataMap().get("message"));
		System.out.println( 	arg0.getTrigger().getJobDataMap().get("message") );
		System.out.println( 	arg0.getMergedJobDataMap().get("message") );
		Trigger tr= arg0.getTrigger();
		tr.getKey().getName();
		tr.getKey().getGroup();
		tr.getKey().getName();
	}
}
