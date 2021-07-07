package ia.tuto



/*


### Exercice 1

Essayer de comppléter les ??? pour pouvoir exécuter le programme.


Voici un exemple de résultat attendu (les premières lignes peuvent changer comme les données sont triés aléatoirement):

Data: DataLine(4.8,3.0,1.4,0.1,Iris-setosa); confidence: 0.98; Annotated: 1; Predicted: 1
Data: DataLine(6.2,2.9,4.3,1.3,Iris-versicolor); confidence: 0.010638297872340425; Annotated: 0; Predicted: 0
Data: DataLine(6.7,3.3,5.7,2.1,Iris-virginica); confidence: 0.010638297872340425; Annotated: 0; Predicted: 0
Data: DataLine(6.4,2.8,5.6,2.1,Iris-virginica); confidence: 0.010638297872340425; Annotated: 0; Predicted: 0
Data: DataLine(6.3,2.7,4.9,1.8,Iris-virginica); confidence: 0.010638297872340425; Annotated: 0; Predicted: 0
Data: DataLine(5.8,2.8,5.1,2.4,Iris-virginica); confidence: 0.010638297872340425; Annotated: 0; Predicted: 0
Data: DataLine(6.1,3.0,4.6,1.4,Iris-versicolor); confidence: 0.010638297872340425; Annotated: 0; Predicted: 0
Data: DataLine(5.2,2.7,3.9,1.4,Iris-versicolor); confidence: 0.010638297872340425; Annotated: 0; Predicted: 0
Data: DataLine(4.4,3.2,1.3,0.2,Iris-setosa); confidence: 0.98; Annotated: 1; Predicted: 1
Data: DataLine(7.7,3.0,6.1,2.3,Iris-virginica); confidence: 0.010638297872340425; Annotated: 0; Predicted: 0


Precision: 1.0;   Rappel: 1.0




### Exercice 2

Essayer de faire la même chose avec le jeu de données suivant:

https://github.com/bnjmn/weka/blob/master/wekadocs/data/segment-test.arff

 */


case class DataLine(

                     // Utiliser les données de IrisData.
                     // Ca correspond à une ligne de données.
                     // Exemple: 5.1,3.5,1.4,0.2,Iris-setosa
                     raw_data:String
                   ) {



  // Pour chaque type de fleurs (Iris-setosa,Iris-versicolor,Iris-virginica)
  // On choisit un type qui est associé à la valeur 1 et les autres à 0
  lazy val label : Int = {
    raw_data.split(",").last match {
      case "Iris-setosa" => 1
      case _ => 0
    }
  }


  // On parse les données et on les mets dans une array
  //  5.1,3.5,1.4,0.2
  lazy val features : Array[Double] = {
    ???
  }
}
object IATuto {



  def main(args: Array[String]): Unit = {


    val parsed_data = {
      splitIrisData()
        .map{l=> DataLine(l) }
    }


    val random_parsed_data = {
      scala.util.Random.shuffle(parsed_data.toSeq).toArray
    }

    val train_data = {
      random_parsed_data
        .slice(
          0,
          random_parsed_data.length-10
        )
    }

    val test_data = {
      random_parsed_data
        .slice(
          random_parsed_data.length-10,
          random_parsed_data.length
        )
    }



    val cart_model = {

      val x = train_data.map(_.features)
      val y = train_data.map(_.label)

      smile.classification.cart(
        x,
        y,
        100
      )
    }


    val threshold = 0.5

    var tp = 0
    var fn = 0
    var fp = 0
    var tn = 0
    test_data.foreach{data=>

      val confidences = Array.ofDim[Double](2)

      cart_model.predict(data.features,confidences)

      val annotated_class = data.label


      val class_confidence = {
        confidences.last
      }

      val predicted_class = {
        if(class_confidence>threshold) {
          1
        } else {
          0
        }
      }

      println(s"Data: ${data}; confidence: ${class_confidence}; Annotated: ${annotated_class}; Predicted: ${predicted_class}")


      (annotated_class, predicted_class) match {
        case (0,0) => {
          tn+=1
          "TN"
        }
        case (1,0) => {
          fn+=1
          "FN"
        }
        case (0,1) => {
          fp+=1
          "FP"
        }
        case (1,1) => {
          tp+=1
          "TP"
        }
      }

    }



    // https://en.wikipedia.org/wiki/Precision_and_recall

    val precision = {
      ???
    }
    val rappel = {
      ???
    }

    println(s"Precision: ${precision};   Rappel: ${rappel}")



  }





  def splitIrisData() : Array[String] = {
    ???
  }



}