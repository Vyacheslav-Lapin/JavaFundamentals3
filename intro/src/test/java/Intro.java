import com.epam.courses.jf.se01.*;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Intro {

    private static final int TOO_MANY = -1;

    /**
     * Убедиться, что языков программирования - более 200
     */
    @Test
    public void tooManyProgrammingLanguages() throws Exception {
        List<ProgrammingLanguage> programmingLanguages =
                ProgrammingLanguage.getAll();
        assertTrue(programmingLanguages.size() > 200);
    }

    /**
     * Существует огромное кол-во:
     *  - Типовых задач
     *  - Протоколов
     *  - Форматов
     *  - Стандартов
     */
    @Test
    public void tooManyThings() {
        assertTooMany(Task.getEqualInstances());
        assertTooMany(Protocol.getInstances());
        assertTooMany(DataFormat.getInstances());
        assertTooMany(Standart.getInstances());
        //...
    }

    private static void assertTooMany(Collection<?> things) {
        if (things.size() < TOO_MANY)
            fail();
    }
}