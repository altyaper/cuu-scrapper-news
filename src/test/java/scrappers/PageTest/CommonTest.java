package scrappers.PageTest;

import java.io.IOException;

/**
 * Created by echavez on 6/20/16.
 */
public interface CommonTest {

    void setup() throws IOException;
    void itShouldGetTheTitle();
    void itShouldGetTheContent();
}
