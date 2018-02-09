package todo
import java.util.Scanner
import java.io.{File, FileReader, FileWriter,RandomAccessFile}
import scala.io.Source
import scala.io.StdIn
object ReadAndWrite
{
    val sc = new Scanner(System.in)
    val location = "ToDo.json"
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
//            writingData()
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
    def writingData(pos:String,data:String)
    {
//      print("Write your Proverb here...")
//      var prb=StdIn.readLine()
//      val wt = new FileWriter(location, true)
//      val sz=new File(location)
//      wt.append(data)
//      wt.flush()
//      wt.close()

      val cv:Int=Integer.parseInt(pos)
//      getting size of file and printing

      val ra=new RandomAccessFile(location,"rw")
      val size=ra.length()
      println("size of file before writing "+size+" bytes")
      ra.seek(cv)
      ra.writeBytes(data)
      println("Successfully written on file.")

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
        val a=args(0)
      val position=args(1)
      val todo=args(2)

      if(a.equalsIgnoreCase("add"))
        writingData(position,todo)

//      begin()
    }

  }

