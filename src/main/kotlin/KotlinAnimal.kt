abstract class KotlinAnimal {
    abstract fun speak()
}

interface KotlinFourLeggedAnimal {
    fun walk()
    fun run()
}

interface KotlinWaggingTail {
    val tailLength: Int

    fun startTail() {println("tail started")}
    fun stopTail() {println("tail stopped")}
}

class KotlinDog : KotlinAnimal(), KotlinWaggingTail, KotlinFourLeggedAnimal {
    override val tailLength: Int = 5

    override fun speak() = println("Dog says 'woof'")
    override fun walk() = println("Dog is walking")
    override fun run() = println("Dog is running")
}
