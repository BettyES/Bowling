object Bowling {

  def main(args: Array[String]): Unit = {
    //points = scala.io.StdIn.readInt()
    var score1 = new Score()
    var points = 10
    var stPrevFrame1 = "normal"
    var stPrevFrame2 = "normal"
    for (x <- 1 to 10) {

      var frame1 = new Frame(stPrevFrame1, stPrevFrame2)
      while (frame1.status < 2) {

        //println(stPrevFrame1 + "  " + stPrevFrame2)
        frame1.getPoints(points)

        frame1.getScoreType(points)
        stPrevFrame2 = stPrevFrame1

        stPrevFrame1 = frame1.scoreType

        score1.updateTotal(frame1.pointsTotal)

      }
    }

    println(score1.scoreTotal)

  }
}


class Score(){
  var scoreTotal:Int = 0

  def updateTotal(pointsFrame: Int){
  scoreTotal = scoreTotal + pointsFrame
    scoreTotal
  }

}

class Frame(statusPrevFrame1: String, statusPrevFrame2: String) {
  var pointsTotal: Int = 0
  var statusPF1 = statusPrevFrame1
  var statusPF2 = statusPrevFrame2
  var scoreType = "normal"
  var pointsFrame: Int = 0
  var status: Int = 0

  def getPoints(point: Int): Unit = {
    if (statusPF1 =="strike" && statusPF2=="strike") {
      pointsFrame = point * 3
    } else if (statusPF1 =="strike" ){
      pointsFrame = point * 2
    }else{
      pointsFrame = point
    }
    status = status + 1
    pointsTotal = pointsTotal + pointsFrame

  }

  def getScoreType(point: Int): Any = {
    val points = point
    if (points == 10) {
      scoreType = "strike"
      status = 2
      //println("first")
    } else if (pointsTotal == 10 && status == 2) {
      scoreType = "spare"
      //println("second")
    } else {
      scoreType = "normal"
      //println("third")
    }
    scoreType

  }
}