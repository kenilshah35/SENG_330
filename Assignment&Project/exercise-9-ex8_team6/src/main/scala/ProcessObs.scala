import java.io.File
import java.net.URL

import com.github.tototoshi.csv.CSVReader

object ProcessObs extends App {
  val file_url: URL = getClass.getResource("observations.csv")
  val reader = CSVReader.open(new File(file_url.toURI))

  val intList = reader.toStreamWithHeaders.map(x => x.get("est_size")).flatMap(_.toList).map(_.toInt)
  val average_kg = intList.sum/intList.length
  println("The average mass of the whales in kilograms is " + average_kg +"kg.")

  val kgtolb = intList.map(x => x*2.2)
  val average_lb = (kgtolb.sum/intList.length).toInt
  println("The average mass in pounds is " + average_lb + "lbs.")
}
