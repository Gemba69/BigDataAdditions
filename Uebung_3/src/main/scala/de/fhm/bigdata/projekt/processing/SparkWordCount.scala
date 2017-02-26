import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SparkWordCount {
  def main(args: Array[String]) {
	  //Setting up the AppName and SparkContext
      val sc = new SparkContext(new SparkConf().setAppName("SparkWordCount"))
	
	//Parsing the args
	  val inputFile = args(0)
      val outputFile = args(1)
	  val filterValue = args(2)
	  val outputFileFilter = "Filtered" + outputFile
	  
      val input =  sc.textFile(inputFile)
      // Split up into words.
      val words = input.flatMap(line => line.split(" "))
      // Transformation into word and there counter.
	  val wordCounts = words.map((_, 1)).reduceByKey(_ + _)
      // Save the word count back out to a text file
      wordCounts.saveAsTextFile(outputFile)
    
	  //filter top Words
      val filtered = wordCounts.filter(_._2 >= 3)
	  
	  outputFileFilter.saveAsTextFile(outputFileFilter)

  }
}