abstract class ScalaAnimal {
  def speak
}

trait ScalaFourLeggedAnimal {
  def walk
  def run
}

trait ScalaWaggingTail {
  val tailLength: Int

  def startTail { println("tail started") }
  def stopTail { println("tail stopped") }
}

class ScalaDog extends ScalaAnimal with ScalaWaggingTail with ScalaFourLeggedAnimal {
  val tailLength = 5;

  def speak { println("Dog says 'woof'") }
  def walk { println("Dog is walking") }
  def run { println("Dog is running") }
}
