package Utils;

import org.junit.Test;
import utils.UtilFunctions;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by echavez on 7/18/16.
 */
public class UtilFunctionsTest {

    @Test
    public void itShouldReturnAStringAsAString() {
        HashSet<String> tags = new HashSet<>();
        tags.add("Tag 1");
        tags.add("Tag 2");
        tags.add("Tag 3");
        tags.add("Tag 4");
        String expected = "Tag 3, Tag 2, Tag 4, Tag 1";
        assertEquals(UtilFunctions.convertCollectionToString(tags), expected);
    }

    @Test
    public void itShouldReturnASlug(){
        String title = "Hola esto es el mundo de Java 2034 /#$ como estamos";
        String slug = UtilFunctions.makeSlug(title);
        assertEquals("hola-esto-es-el-mundo-de-java-2034--como-estamos", slug);
    }
}
