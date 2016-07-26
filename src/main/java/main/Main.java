package main;

import hibernate.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import services.ScrapperJob;
import utils.ScrapCover;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by echavez on 5/20/16.
 */
public class Main {

    public static void main(String... strings) throws SQLException, URISyntaxException, IOException, SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // and start it off
        scheduler.start();

        // define the job and tie it to our ScrapperJob class
        JobDetail job = newJob(ScrapperJob.class)
                .withIdentity("job1", "group1")
                .build();

        // Trigger the job to run now, and then repeat every hour
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(3600)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);


    }



}
