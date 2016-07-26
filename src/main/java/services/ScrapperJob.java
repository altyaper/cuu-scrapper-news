package services;

import hibernate.SessionFactorySingleton;
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
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ScrapCover scrapCover = new ScrapCover();
        try {
            try {
                scrapCover.scrappAllCovers();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } finally {
            SessionFactorySingleton.getInstance().close();
        }
    }
}
