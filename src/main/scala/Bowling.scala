object Bowling {

  def main(args: Array[String]): Unit = {
    //points = scala.io.StdIn.readInt()
    var score1 = new Score()

    var stPrevFrame1 = "normal"
    var stPrevFrame2 = "normal"
    for (x <- 1 to 3) {

      var frame1 = new Frame(stPrevFrame1, stPrevFrame2)
      while (frame1.status < 2) {
        println("Enter a number, your scoreType is "+stPrevFrame1)
        var points = scala.io.StdIn.readInt()

        frame1.getPoints(points)

        frame1.getScoreType(points)
        stPrevFrame2 = stPrevFrame1

        stPrevFrame1 = frame1.scoreType
        println(frame1.pointsTotal)
      }
      score1.updateTotal(frame1.pointsTotal)
      println(score1.scoreTotal)
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
      pointsFrame = pointsFrame +point
      pointsTotal = pointsTotal + (point * 3)
    } else if (statusPF1 =="strike" ) {
      pointsFrame = pointsFrame +point
      pointsTotal = pointsTotal + (point * 2)
    }else if (statusPF1 == "spare" & status == 0){
      pointsFrame = pointsFrame +point
      pointsTotal = pointsTotal + (point * 2)
    }else{
      pointsFrame = pointsFrame + point
      pointsTotal = pointsTotal + point
    }
    status = status + 1

  }

  def getScoreType(point: Int): Any = {
    val points = point
    if (points == 10) {
      scoreType = "strike"
      status = 2
      //println("first")
    } else if (pointsFrame == 10 && status == 2) {
      scoreType = "spare"
      //println("second")
    } else {
      scoreType = "normal"
      //println("third")
    }
    scoreType

  }
}