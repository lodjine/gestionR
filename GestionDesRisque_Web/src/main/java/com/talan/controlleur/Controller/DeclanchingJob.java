package com.talan.controlleur.Controller;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DeclanchingJob {
	JobDetail job;
	
	@Bean
	public String declanching(){
		String chSun="0 0 * * * ?";
		CronTrigger CronTrigger=null;
		CronTrigger = TriggerBuilder.newTrigger()
		         .withIdentity("Alerte", "Alerte")
		         .withSchedule(CronScheduleBuilder.cronSchedule(chSun).withMisfireHandlingInstructionDoNothing())
		         .build();
		  job = JobBuilder.newJob(JobAlerte.class).withIdentity("Alerte", "Alerte").build();
		  return "";
	}
	
	
}
