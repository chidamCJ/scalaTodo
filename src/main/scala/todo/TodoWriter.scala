package todo

import scala.io.Source
import java.util.Scanner
import java.io.FileWriter

object TodoWriter {
  val sc       = new Scanner(System.in)
  val location = "/home/chims/Desktop/scala.txt"

  def begin() {
    try {
      println("Welcome...")
      println("Press 1 for Write a Proverb")
      println("Press 2 for retrive previous all proverbs")

      var input = sc.nextInt()

      input match {
        case 1 =>
          TodoWriter.WritingData()
        case 2 =>
          TodoWriter.ReadingData()
        case _ =>
          println("please choose 1 or 2...")
          return begin()
      }

    } catch {
      case x: Exception =>
        println("please give 1 or 2...")
        return begin()

    }
  }
  def WritingData() {
    print("Write your Proverb here...")
    var prb = readLine()

    val wrt = new FileWriter(location, true)
    wrt.append(prb)
    println("sucessfully written on file.")
    wrt.flush()
    wrt.close()

  }

  def ReadingData() {
    println("Fetching from File...")
    val rd = Source.fromFile(location)

    for (line <- rd.getLines())
      println(line)
    rd.close()
  }

  def main(args: Array[String]) {
    begin()
  }
}
