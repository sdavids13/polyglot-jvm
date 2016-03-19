object KotlinPatternMatch {

    fun parseArgument(arg : String, value: String) = when(arg) {
        "-h", "--help" -> displayHelp()
        "-l" -> setLanguageTo(value)
        "-o", "--optim" -> {
            val n = value.toInt()
            if ((0 < n) && (n <= 5)) {
                setOptimizationLevelTo(n)
            } else {
                badOptimizationLevel(n)
            }
        }
        else -> badArgument(arg)
    }

    fun displayHelp() = println("Help")
    fun setLanguageTo(lang: String) = println("Saved language: $lang")
    fun setOptimizationLevelTo(n: Int) = println("Saved optimization level: $n")
    fun badOptimizationLevel(n: Int) = println("Bad optimization level: $n")
    fun badArgument(arg: String) = println("Bad argument: $arg")
}
