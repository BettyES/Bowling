object Bowling{

  def main(args: Array[String]): Unit = {
    //points = scala.io.StdIn.readInt()

    var points = 10

  }

}


class Score(){
  var scoreTotal:Int = 0

  def updateTotal(pointsFrame: Int){
  scoreTotal = scoreTotal + pointsFrame
    scoreTotal
  }

}

class Frame() {
  var pointsTotal: Int = 0
  var scoreType = "normal"
  var points = 0
  var status = 0

  def getPoints(points: Int): Unit = {
    status = status + 1
    pointsTotal = pointsTotal + points
  }

  def getScoreType(): Any = {
    if (points == 10) {
      scoreType = "strike"
    } else if (pointsTotal == 10 & status == 2) {
      scoreType = "spare"
    } else {
      scoreType = "normal"
    }

  }
}