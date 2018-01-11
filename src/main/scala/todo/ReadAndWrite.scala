package todo
import java.util.Scanner
import java.io.{File, FileReader, FileWriter,RandomAccessFile}
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
            writingData()
          case 2 =>
            readingData()
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
    def writingData()
    {
      print("Write your Proverb here...")

      var prb=StdIn.readLine()

      val wt = new FileWriter(location, true)
      val sz=new File(location)

//      getting size of file and printing
      val size=sz.length()
      println("size of file before writing "+size+" bytes")

      wt.append(prb)
      println("Successfully written on file.")
      wt.flush()
      wt.close()
    }

    def readingData()
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

