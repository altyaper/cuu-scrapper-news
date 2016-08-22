package services;

import main.ThreadNews;
import org.quartz.JobExecutionContext;

/**
 * Created by echavez on 7/25/16.
 */
public class ScrapperJob implements org.quartz.Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext){
        ThreadNews t = new ThreadNews();
        try {
            t.getCovers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
