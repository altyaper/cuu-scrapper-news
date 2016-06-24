package scrappers.CoverTest;

import java.io.IOException;

/**
 * Created by echavez on 6/20/16.
 */
public interface CommonCoverTest {

    void itShouldMatchWithRegexPattern();
    void itShouldGetAtLeastOneNew();
    void setup() throws IOException;

}
