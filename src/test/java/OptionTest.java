import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import scala.Option;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class OptionTest {

    private static final String NEW_LINE = System.lineSeparator();
    private static final KotlinOption kotlinOption = KotlinOption.INSTANCE;

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void scalaToInt() {
        Option<Object> option = ScalaOption.toInt("1");
        assertThat(option.get(), is(1));

        option = ScalaOption.toInt("foo");
        assertThat(option.isEmpty(), is(true));
    }

    @Test
    public void kotlinToInt() {
        //Kotlin should tie into Java 8's Optional class...
        Integer option = kotlinOption.toInt("1");
        assertThat(option, is(1));

        option = kotlinOption.toInt("foo");
        assertThat(option, nullValue());
    }

    @Test
    public void scalaPrintInt() {
        //Java method sees Option<Object>, not the appropriate Option<Integer>
        ScalaOption.printInt(Option.apply(1));
        assertThat(log.getLog(), is("1" + NEW_LINE));

        log.clear();
        ScalaOption.printInt(Option.empty());
        assertThat(log.getLog(), is("That didn't work." + NEW_LINE));

        //Get a runtime ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        //ScalaOption.printInt(Option.apply("Foo"));

        //Exception: scala.MatchError: null
        //ScalaOption.printInt(null);
    }

    @Test
    public void kotlinPrintInt() {
        kotlinOption.printInt(1);
        assertThat(log.getLog(), is("1" + NEW_LINE));

        log.clear();
        kotlinOption.printInt(null);
        assertThat(log.getLog(), is("That didn't work." + NEW_LINE));

        //Will not compile (as it should be)
        //KotlinOption.INSTANCE.printInt("1");
    }

    @Test
    public void scalaNullManipulation() {
        ScalaOption.nullManipulation();
        assertThat(log.getLog(), is("foo bar" + NEW_LINE + "baz foo" + NEW_LINE + "default value" + NEW_LINE));
    }

    @Test
    public void kotlinNullManipulation() {
        kotlinOption.nullManipulation();
        assertThat(log.getLog(), is("foo bar" + NEW_LINE + "baz foo" + NEW_LINE + "default value" + NEW_LINE));
    }

    @Test
    public void scalaGetAddressLine2() {
        ScalaAddress address = new ScalaAddress("Name", "Address 1", Option.apply("Address 2"));
        ScalaCustomer customer = new ScalaCustomer(Option.apply(address));
        assertThat(ScalaOption.getAddressLine2(Option.apply(customer)), is("Address 2"));

        //Really? _$eq
        address.addressLine2_$eq(Option.empty());
        assertThat(ScalaOption.getAddressLine2(Option.apply(customer)), is(""));

        customer.shippingAddress_$eq(Option.empty());
        assertThat(ScalaOption.getAddressLine2(Option.apply(customer)), is(""));

        assertThat(ScalaOption.getAddressLine2(Option.empty()), is(""));
    }

    @Test
    public void kotlinGetAddressLine2() {
        KotlinAddress address = new KotlinAddress("Name", "Address 1", "Address 2");
        KotlinCustomer customer = new KotlinCustomer(address);
        assertThat(kotlinOption.getAddressLine2(customer), is("Address 2"));

        address.setAddressLine2(null);
        assertThat(kotlinOption.getAddressLine2(customer), is(""));

        customer.setShippingAddress(null);
        assertThat(kotlinOption.getAddressLine2(customer), is(""));

        assertThat(kotlinOption.getAddressLine2(null), is(""));
    }
}
