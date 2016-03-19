public class JavaInterop {

    public static int scalaListSumLessThan10(){
        //Scala doesn't produce Java Bean getter signature, nor does it infer the generic type
        scala.collection.immutable.List<Object> scalaList = ScalaImmutableDataStructures.list();
        //We are using Scala built-in functions (using Java 8 anonymous method to implement Scala Function2 interface), not Java 8 streams -- hopefully casting is correct...
        //TODO: Can't seem to get this to work....
        //return scalaList.filter(val -> ((Integer) val) < 10).reduce((x, y) -> x + y);
        return -1;
    }

    public static int scalaListSumLessThan10ViaStreams(){
        scala.collection.immutable.List<Object> scalaList = ScalaImmutableDataStructures.list();
        //asJava() == "Object" - hopefully this is right w/r/t casting ;), not to mention copy performance impact
        java.util.List<Object> javaList = (java.util.List<Object>) scala.collection.JavaConverters.seqAsJavaListConverter(scalaList).asJava();
        return javaList.stream().map(val -> (Integer) val).filter(val -> val < 10).reduce((x, y) -> x + y).get();
    }

    public static int kotlinListSumLessThan10(){
        //Kotlin produces Java Bean happy getList for val list + we can use native Java structures!
        java.util.List<Integer> list = KotlinImmutableDataStructures.INSTANCE.getList();
        return list.stream().filter(val -> val < 10).reduce((x, y) -> x + y).get();
    }

}
