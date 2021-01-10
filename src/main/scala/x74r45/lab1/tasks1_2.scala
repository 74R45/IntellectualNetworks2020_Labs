package x74r45.lab1

object tasks1_2 extends App {
  val testSample = "abcdexyz ?ńæ½¥".toList
  val encodings = List("ASCII", "UTF-8", "UTF-16BE", "Cp1252")

  def byteRepresentations(c: Char): List[String] =
    encodings.map(c.toString.getBytes(_).map("%02x" format _).mkString("0x", "", ""))

  val testSampleReps = testSample map byteRepresentations

  println(encodings.map(s => f"$s%6s").mkString("   │ ", " │ ", ""))
  println("—".repeat(40))
  (testSample zip testSampleReps).foreach {
    case (c: Char, List(r1, r2, r3, r4)) => println(f" $c │ $r1%6s │ $r2%6s │ $r3%8s │ $r4%6s")
  }
}

