/**
  * Created by sdavids on 3/19/16.
  */
object ScalaOption {

  def toInt(in: String): Option[Int] = {
    try {
      Some(Integer.parseInt(in.trim))
    } catch {
      case ex: NumberFormatException => None
    }
  }

  def printInt(someString: Option[Int]) = someString match {
    case Some(i) => println(i)
    case None => println("That didn't work.")
  }

  def getAddressLine2(customer: Option[ScalaCustomer]) = customer.map(customer => customer.shippingAddress.map(address => address.addressLine2)).getOrElse("")

  def nullManipulation() {
    var foo: String = "Foo"
    //Note: No compile error of next line - will be a string of "null"
    //foo = null

    foo += " Bar"
    println(foo.toLowerCase())

    //Note: Null pointer possibility...
    //var bar: Option[String] = null
    var bar: Option[String] = Option.apply("Baz")
    bar = bar.map(_ + " Foo")
    println(bar.getOrElse("Default Value").toLowerCase)

    bar = Option.empty
    bar = bar.map(_ + " Foo")
    println(bar.getOrElse("Default Value").toLowerCase)
  }

}

case class ScalaCustomer(var shippingAddress: Option[ScalaAddress])
case class ScalaAddress(name: String, addressLine1: String, var addressLine2: Option[String])