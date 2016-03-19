class ScalaPatternMatch {

  def parseArgument(arg : String, value: Any) = (arg, value) match {
    case ("-h" | "--help", null) => displayHelp()
    case ("-l", lang: String) => setLanguageTo(lang)
    case ("-o" | "--optim", n : Int) if ((0 < n) && (n <= 5)) => setOptimizationLevelTo(n)
    case ("-o" | "--optim", badLevel: Int) => badOptimizationLevel(badLevel)
    case (bad, null) => badArgument(bad)
  }

  def displayHelp() = println("Help")
  def setLanguageTo(lang: String) = println(s"Saved language: $lang")
  def setOptimizationLevelTo(n: Int) = println(s"Saved optimization level: $n")
  def badOptimizationLevel(n: Int) = println(s"Bad optimization level: $n")
  def badArgument(arg: String) = println(s"Bad argument: $arg")

}
