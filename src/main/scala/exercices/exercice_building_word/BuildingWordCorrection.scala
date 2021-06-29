package exercices.exercice_building_word

object BuildingWordCorrection {
  def main(args: Array[String]): Unit = {
    assert(can_build(Seq("art","cart","carte")))
    assert(can_build(Seq("art","arte","carte")))
    assert(!can_build(Seq("art","carte","carte")))
    assert(can_build(Seq("art","part","parti")))
    assert(can_build(List("a", "at", "ate", "late", "plate", "plates")))
    assert(!can_build(List("a", "at", "ate", "late", "plate", "plater", "platter")))
    assert(!can_build(List("it", "bit", "bite", "biters")))
    assert(can_build(List("mean", "meany")))
  }
  def can_build(words:Seq[String]):Boolean={
    val couples = words zip words.tail
    couples.forall {
      couple =>
        (couple._2 contains couple._1) && couple._2.length-couple._1.length==1
    }
  }
}
