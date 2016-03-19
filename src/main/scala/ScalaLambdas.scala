
object ScalaLambdas {

  //OR: people.filter(_.firstName == fistName)
  def findByFirstName(people: List[ScalaPerson], fistName: String) = people.filter(person => person.firstName == fistName)

  def collectFirstNames(people: List[ScalaPerson]): List[String] = people.map(person => person.firstName)

  //OR: values.reduce(_ + _)
  def sumReduce(values: List[Int]) = values.reduce((x, y) => x + y)

  def print(values: List[Any]) = values.foreach(println)

}
