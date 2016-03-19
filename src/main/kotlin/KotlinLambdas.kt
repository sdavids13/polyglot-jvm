object KotlinLambdas {

    //OR: people.filter { person -> person.firstName == fistName }
    fun findByFirstName(people: List<KotlinPerson>, fistName: String) = people.filter { it.firstName == fistName }

    fun collectFirstNames(people: List<KotlinPerson>): List<String> = people.map { it.firstName }

    fun sumReduce(values: List<Int>) = values.reduce { x, y -> x + y }

    fun print(values: List<Any>) = values.forEach { println(it) }

}
