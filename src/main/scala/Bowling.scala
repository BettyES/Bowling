object Bowling{

  def main(args: Array[String]): Unit = {


  }

}

class Score(){
  var pointsTotal:Int = 0
  var typeScore = "normal"

  def updateScore(points: Int): Int ={
    pointsTotal = pointsTotal + points
    pointsTotal
  }

  //    def updateScopreType(points: Int): String ={
  //
  //    }

}