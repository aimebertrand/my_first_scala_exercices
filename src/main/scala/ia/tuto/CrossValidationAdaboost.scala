package ia.tuto
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}


case class DataCross(raw_data:String) {

  lazy val label : Int = {
    raw_data.split(",").last match {
      case "cement" => 1
      case "grass" => 2
      case "sky" => 3
      case _ => 0
    }
  }
  lazy val features : Array[Double] = raw_data.split(",").init.map(x => x.toDouble)
}

object CrossValidationAdaboost {
    def FoldIndex(n: Int, k: Int, random_parsed_data: Array[DataCross]): IndexedSeq[Array[DataCross]] = {
      val groupe = n / k
      val j = n % k
      val res = Array.tabulate(k) { i =>
        if (i < j) {(i + 1) * (groupe + 1)}
        else (i + 1) * groupe + j
      }
      val to = for (i <- 0 until res.length - 1) yield {
        random_parsed_data.slice(res(i), res(i + 1))
      }
      to
  }

  def main(args: Array[String]): Unit = {

    val parsed_data = splitIrisData().map { l => DataCross(l) }
    val random_parsed_data = scala.util.Random.shuffle(parsed_data.toSeq).toArray
    val res = FoldIndex(random_parsed_data.length, 10, random_parsed_data)
    var cv_score = 0d
    for (i <- res.indices) {
      val train_data = res(i)
      val test_data = res.flatMap(x => x.drop(i))
      val ada_model = {
        val x = train_data.map(_.features)
        val y = train_data.map(_.label)
        smile.classification.adaboost(x, y, null, 400, 4)
      }
      val threshold = 0.55
      var tp = 0
      var fn = 0
      var fp = 0
      var tn = 0
      test_data.foreach { data =>
        val confidences = Array.ofDim[Double](4)
        ada_model.predict(data.features, confidences)
        val annotated_class = data.label
        val class1_confidence = confidences(1)
        val class2_confidence = confidences(2)
        val class3_confidence = confidences.last
        val class0_confidence = confidences.head
        val predicted_class = {
          if (class1_confidence > threshold) 1
          else if (class2_confidence > threshold) 2
          else if (class3_confidence > threshold) 3
          else 0
        }
        (annotated_class, predicted_class) match {
          case (0, 0) => tn += 1
          case (1, 0) => fn += 1
          case (0, 1) => fp += 1
          case (1, 1) => tp += 1
          case (2, 0) => fn += 1
          case (0, 2) => fp += 1
          case (2, 2) => tp += 1
          case (3, 0) => fn += 1
          case (0, 3) => fp += 1
          case (3, 3) => tp += 1
        }
      }
      val precision = tp / (tp + fp).toDouble
      val rappel = tp / (tp + fn).toDouble
      val F_score = 2 * (precision * rappel) / ( precision + rappel)
      println(s"Fscore == $F_score")
      cv_score += F_score
    }
    println("/------------/")
    println(s"cv_score == ${cv_score / res.size}")
  }


  def splitIrisData(): Array[String] = {

    val bufferedSource = io.Source.fromFile("/home/aime_bertrand/Documents/my_first_scala_exercices/src/main/scala/ia/tuto/segment_data.arff")
    val tab = (for (line <- bufferedSource.getLines()) yield line).toArray
    val _map = new ArrayBuffer[String]()
    var i = 1

    while (i < tab.length) {
      breakable {
        if (tab(i) == "")
          break
        else if (tab(i)(0) >= 48 && tab(i)(0) <= 57) {
          _map += tab(i)
        }
      }
      i += 1
    }
    _map.toArray
  }
}