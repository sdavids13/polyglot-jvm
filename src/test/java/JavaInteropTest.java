import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JavaInteropTest {

    @Test
    public void scalaListSumLessThan10() {
        assertThat(JavaInterop.scalaListSumLessThan10(), is(6));
    }

    @Test
    public void scalaListSumLessThan10ViaStreams() {
        assertThat(JavaInterop.scalaListSumLessThan10ViaStreams(), is(6));
    }

    @Test
    public void kotlinListSumLessThan10() {
        assertThat(JavaInterop.kotlinListSumLessThan10(), is(6));
    }
}
