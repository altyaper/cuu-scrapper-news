package scrappers.PageTest;

import java.io.IOException;

/**
 * Created by echavez on 6/20/16.
 */
public interface CommonTest {

    void itShouldGetTheTitle();
    void itShouldGetTheContent();
    void setup() throws IOException;
}
