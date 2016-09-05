import org.junit.Test;

import java.util.Locale;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ResourcePropertyTest {

    private ResourceProperty myBundle;

    @Test
    public void propertiesHandlingUnitedStatesIsRight() throws Exception {
        myBundle = new ResourceProperty(new Locale("en", "US"));
        assertThat(myBundle.getValue("prop.key1"), is("value 01 en US1"));
        assertThat(myBundle.getValue("prop.key2"), is("value 02 en US1"));
    }

    @Test
    public void propertiesHandlingUnitedKingdomIsRight() throws Exception {
        myBundle = new ResourceProperty(new Locale("en", "UK"));
        assertThat(myBundle.getValue("prop.key1"), is("value 01 en1"));
        assertThat(myBundle.getValue("prop.key2"), is("value 02 default1"));
    }

    @Test
    public void propertiesHandlingBelarussiaIsRight() throws Exception {
        myBundle = new ResourceProperty(new Locale("ru", "BY"));
        assertThat(myBundle.getValue("prop.key1"), is("value 01 en US1"));
        assertThat(myBundle.getValue("prop.key2"), is("value 02 en US1"));
    }

    @Test
    public void propertiesHandlingRussiaIsRight() throws Exception {
        myBundle = new ResourceProperty(new Locale("ru", "RU"));
        assertThat(myBundle.getValue("prop.key1"), is("value 01 ru RU1"));
        assertThat(myBundle.getValue("prop.key2"), is("value 02 ru RU1"));
    }
}