import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SymbolsTest {

    @Test
    public void oneNonBmtCharacter() {
        char ch = '现';
        assertThat(+ch, is(0x73b0)); // "+" - что бы поместить char в числовой контекст
        assertThat(Integer.toHexString(ch), is("73b0"));

        String str = new String(new char[]{ch}).intern();
        assertThat(str.length(), is(1));

        byte[] bytes = str.getBytes();
        assertThat(bytes.length, is(3));
        assertThat(bytes[0], is((byte) 0xe7));
        assertThat(bytes[1], is((byte) 0x8e));
        assertThat(bytes[2], is((byte) 0xb0));
    }

    @Test
    public void manyNonBmtCharacters() {
        String str = "现已整合";
        assertThat(str.length(), is(4));
        assertThat(str.getBytes().length, is(12));

        byte[] bytes = str.getBytes(),
                checkBytes = {
                        (byte) 0xe7, (byte) 0x8e, (byte) 0xb0,
                        (byte) 0xe5, (byte) 0xb7, (byte) 0xb2,
                        (byte) 0xe6, (byte) 0x95, (byte) 0xb4,
                        (byte) 0xe5, (byte) 0x90, (byte) 0x88
                };

        for (int index = 0; index < bytes.length; )
            assertThat(bytes[index], is(checkBytes[index++]));
    }
}