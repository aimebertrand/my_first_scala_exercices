package ia.tuto

import smile.classification.randomForest
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}
import smile._
import smile.classification._
import smile.data.AttributeDataset
import smile.validation._
import smile.{data, read}


case class MyData(raw_data:String) {

  lazy val label : Int = {
    raw_data.split(",").last match {
      case "yes" => 1
      case _ => 0
    }
  }

  lazy val features: Array[Double] = {
    raw_data.split(",").init.map(x => x.toDouble)
  }

 lazy val transform : Array[Double] = {

   raw_data.split(",").init.map {
        case "sunny" =>  1.0d
        case "hot" =>  10.0d
        case "high" =>  100.0d
        case "TRUE" =>  1000.0d
        case "overcast" => 2.0d
        case "cool" =>  20.0d
        case "normal" =>  200.0d
        case "FALSE" => 2000.0d
        case "rainy" =>  3.0d
        case _ =>  -84d
      }
  }
}
  object random_forest {

    def main(args: Array[String]): Unit = {
      val parsed_data = {
        splitIrisData()
          .map { l => MyData(l) }
      }
      val random_parsed_data = scala.util.Random.shuffle(parsed_data.toSeq).toArray
      val train_data = random_parsed_data.slice(0, random_parsed_data.length - 5)
      val test_data = random_parsed_data.slice(random_parsed_data.length - 15, random_parsed_data.length)
      val nTrees = 200
      val maxNodes = 4
      val tab = train_data.map(_.transform)
      val res = train_data.map(_.label)
      println(res.size)
      println(tab.size)
      println(tab.deep.mkString("\n"))
      println(res.mkString("\n"))
      val rf_model = randomForest(tab, res, null, nTrees, maxNodes)
      println(s"OOB error = ${rf_model.error()}")
      var threshold = 0.00
      while (threshold < 1) {
        var tp = 0
        var fn = 0
        var fp = 0
        var tn = 0
        test_data.foreach { data =>
          val confidences = Array.ofDim[Double](2)
          rf_model.predict(data.transform, confidences)
          val annotated_class = data.label
          val class_confidence = {
            confidences.last
          }
          val predicted_class = {
            if (class_confidence > threshold) {
              1
            } else {
              0
            }
          }
          println(s"Data: $data; confidence: $class_confidence; Annotated: $annotated_class; Predicted: $predicted_class")
          (annotated_class, predicted_class) match {
            case (0, 0) => tn += 1;"TN"
            case (1, 0) => fn += 1;"FN"
            case (0, 1) => fp += 1;"FP"
            case (1, 1) => tp += 1;"TP"
          }
        }
        val precision = tp / (tp + fp).toDouble
        val rappel = tp / (tp + fn).toDouble
        val F_score = 2 * (precision * rappel) / ( precision + rappel)

        println(s"tp: $tp, tn: $tn, fn: $fn, fp: $fp")
        println(s"Precision: ${precision * 100 + "%"};   Rappel: ${rappel * 100 + "%"}")
        println(s"Fscore == ${F_score * 100 + "%"}")
        println(s"threshold == $threshold")
        threshold += 0.05
      }
    }

    def splitIrisData(): Array[String] = {

      val bufferedSource = io.Source.fromFile("/home/aime_bertrand/Documents/my_first_scala_exercices/src/main/scala/ia/tuto/test_weather.nominal.arff")
      val tab = (for (line <- bufferedSource.getLines()) yield line).toArray
      val _map = new ArrayBuffer[String]()
      var i = 1

      while (i < tab.length) {
        breakable {
          if (tab(i) == "")
            break
          else if (tab(i)(0) != 64) {
            _map += tab(i)
          }
        }
        i += 1
      }
      _map.toArray
    }
  }
