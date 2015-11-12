object SumStringLength {
  def main(args: Array[String]) {
    println(args.foldLeft(0)((sum, str) => sum + str.size))
  }
}
