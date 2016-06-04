package com.talan.controlleur.Controller;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DeclanchingJob {
	JobDetail job;
	
	@Bean
	public String declanching(){
		String chSun="/1 * * * * ?";
		CronTrigger CronTrigger=null;
		CronTrigger = TriggerBuilder.newTrigger()
		         .withIdentity("Alerte", "Alerte1")
		         .withSchedule(CronScheduleBuilder.cronSchedule(chSun).withMisfireHandlingInstructionDoNothing())
		         .build();
		  job = JobBuilder.newJob(JobAlerte.class).withIdentity("Alerte2", "Alerte3").build();
		  Scheduler scheduler = null;
		  

//			try {
//				scheduler = new StdSchedulerFactory().getScheduler();
//			} catch (SchedulerException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				scheduler.start();
//				
//			} catch (SchedulerException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				
//				scheduler.scheduleJob(job, CronTrigger);
//				
//				
//
//				
//
//			} catch (SchedulerException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//	
//
//		catch(Exception e){
//			
//		}

		  return "";
	}
	
	
}
