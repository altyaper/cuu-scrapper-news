package main;

import java.util.ArrayList;
import java.util.List;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import services.ScrapperJob;
import utils.Scrapper;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {

    private final List<Class> AClass = new ArrayList<Class>();

    public static void main(String... strings) throws Exception {

        String link = "http://www.omnia.com.mx/article/cae-lluvia-en-la-capital-deja-encharcamientos";
        Scrapper s = new Scrapper(link);
        System.out.println(s);
//        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//
//        // and start it off
//        scheduler.start();
//
//        // define the job and tie it to our ScrapperJob class
//        JobDetail job = newJob(ScrapperJob.class)
//                .withIdentity("job1", "group1")
//                .build();
//
//        // Trigger the job to run now, and then repeat every hour
//        Trigger trigger = newTrigger()
//                .withIdentity("trigger1", "group1")
//                .startNow()
//                .withSchedule(simpleSchedule()
//                        .withIntervalInSeconds(3600)
//                        .repeatForever())
//                .build();
//
//        // Tell quartz to schedule the job using our trigger
//        scheduler.scheduleJob(job, trigger);


    }



}
