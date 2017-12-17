package todo
import java.util.Scanner
import java.io.FileWriter
import scala.io.Source
import scala.io.StdIn
object ReadAndWrite
{
    val sc = new Scanner(System.in)
    val location = "/home/chims/Desktop/scala.txt"

    def begin()
    {
      try
      {
        println("Welcome...")
        println("Press 1 for Write a Proverb")
        println("Press 2 for retrieve previous all proverbs")

        var input = sc.nextInt()

        input match
        {
          case 1 =>
            WritingData()
          case 2 =>
            ReadingData()
          case _ =>
            println("please choose 1 or 2...")
            begin()
        }

      }
      catch
        {
          case x: Exception =>
            println("please give 1 or 2...")
            begin()

        }
    }
    def WritingData()
    {
      print("Write your Proverb here...")
      val in=Source.fromInputStream(System.in)
      //    val lines=in.getLines().collect()

      var prb=StdIn.readLine()

      val wrt = new FileWriter(location, true)
      wrt.append(prb)
      println("Successfully written on file.")
      wrt.flush()
      wrt.close()

    }

    def ReadingData()
    {
      println("Fetching from File...")
      val rd = Source.fromFile(location)

      for (line <- rd.getLines())
        println(line)
      rd.close()
    }
    def main(args: Array[String])
    {
      begin()
    }

  }

