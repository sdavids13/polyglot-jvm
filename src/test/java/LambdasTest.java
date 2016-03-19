import org.junit.Test;
import scala.collection.JavaConversions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class LambdasTest {

    List<ScalaPerson> scalaPersons = Arrays.asList(new ScalaPerson("Mr.", "Jim", "", "Bob", ""), new ScalaPerson("Mr.", "John", "", "Jones", ""));
    List<KotlinPerson> kotlinPersons = Arrays.asList(new KotlinPerson("Mr.", "Jim", "", "Bob", ""), new KotlinPerson("Mr.", "John", "", "Jones", ""));

    @Test
    public void scalaFindByFirstName() {
        scala.collection.immutable.List<ScalaPerson> people = ScalaLambdas.findByFirstName(JavaConversions.asScalaBuffer(scalaPersons).toList(), "John");
        List<ScalaPerson> javaPeople = JavaConversions.seqAsJavaList(people);
        assertThat(javaPeople.size(), is(1));
        assertThat(javaPeople.get(0).firstName(), is("John"));
    }

    @Test
    public void kotlinFindByFirstName() {
        List<KotlinPerson> people = KotlinLambdas.INSTANCE.findByFirstName(kotlinPersons, "John");
        assertThat(people.size(), is(1));
        assertThat(people.get(0).getFirstName(), is("John"));
    }

    @Test
    public void scalaCollectFirstNames() {
        scala.collection.immutable.List<String> firstNames = ScalaLambdas.collectFirstNames(JavaConversions.asScalaBuffer(scalaPersons).toList());
        assertThat(JavaConversions.seqAsJavaList(firstNames), contains("Jim", "John"));
    }

    @Test
    public void kotlinCollectFirstNames() {
        List<String> firstNames = KotlinLambdas.INSTANCE.collectFirstNames(kotlinPersons);
        assertThat(firstNames, contains("Jim", "John"));
    }

    @Test
    public void scalaSumReduce() {
        //Need to actually remove types to make this work...
        scala.collection.immutable.List<Object> toSum = JavaConversions.asScalaBuffer(Arrays.asList((Object) 1, 2, 3)).toList();
        assertThat(ScalaLambdas.sumReduce(toSum), is(6));
    }

    @Test
    public void kotlinSumReduce() {
        assertThat(KotlinLambdas.INSTANCE.sumReduce(Arrays.asList(1, 2, 3)), is(6));
    }

}
