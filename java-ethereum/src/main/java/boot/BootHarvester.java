package boot;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import jobscheduler.MyJob;

public class BootHarvester {

	public static void main(String[] args) throws Exception{
		BootHarvester harvester=new BootHarvester();
		harvester.fireJob();
	}
	
	
	public void fireJob() throws SchedulerException, InterruptedException {
		//creiamo la factory per instanziare lo scheduler
		SchedulerFactory schedFact=new StdSchedulerFactory();
		//instanziamo lo scheduler
		Scheduler scheduler=schedFact.getScheduler();
		//ora avviamo lo scheduler
		scheduler.start();
		
		//facciamo la build per lanciare il job dello scheduler
		JobBuilder jobBuilder=JobBuilder.newJob(MyJob.class);
		//usato per instanziare dei dati nel job
		JobDataMap data = new JobDataMap();
		data.put("example", this.getClass().getName());
		
		//settiamo le proprietà
		JobDetail jobDetail=jobBuilder
					.usingJobData(data)
					.withIdentity("myJob","group1")
					.build();
		
		//definiamo trigger che definisce lo schedule time dell'esecuzione
		Trigger trigger=TriggerBuilder.newTrigger()
					.withIdentity("myTrigger","group1")
					.startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(4).withIntervalInSeconds(3)).build();
		
		//lanciamo il nostro job per schedularlo
		scheduler.scheduleJob(jobDetail,trigger);
		//qui mettiamo lo sleep fin quando lo scheduler non termina il lavoro
		Thread.sleep(10000);
		System.out.println("job terminati");
		scheduler.shutdown();
		
	}
	
}