import java.util.List;
import java.util.stream.Collectors;

public interface JavaLambdas {

    default List<KotlinPerson> findByFirstName(List<KotlinPerson> people, String fistName) {
        return people.stream().filter(person -> person.getFirstName() == fistName).collect(Collectors.toList());
    }

    default List<String> collectFirstNames(List<KotlinPerson> people) {
        return people.stream().map(KotlinPerson::getFirstName).collect(Collectors.toList());
    }

    default int sumReduce(List<Integer> values) {
        return values.stream().reduce((x, y) -> x + y).get();
    }

    default void print(List<?> values) {
        values.forEach(value -> System.out.println(value));
    }

}
