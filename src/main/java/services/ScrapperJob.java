package services;

import hibernate.SessionFactorySingleton;
import main.ThreadNews;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import utils.ScrapCover;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

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
