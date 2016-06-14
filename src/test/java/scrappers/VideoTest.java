package scrappers;

import enums.VideoProvidersList;
import models.Video;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by echavez on 5/23/16.
 */
public class VideoTest {

    Video video;

    @Before
    public void setup(){
        video = new Video("http://www.youtube.com/embed/nml8-us2PoA");
    }


    @Test
    public void itShouldRecognizeWhichProviderItsUsed(){

        assertEquals(VideoProvidersList.providers.YOUTUBE, video.getProvider());

    }

    @Test
    public void itShouldGetTheIdOfTheVideoUrl(){

        assertEquals("nml8-us2PoA", video.getVideoId());

    }

}
