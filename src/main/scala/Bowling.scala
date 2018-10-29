object Bowling{

  def main(args: Array[String]): Unit = {
    //points = scala.io.StdIn.readInt()
    var score1 = new Score()
    var points = 10
    for(x<-1 to 10){

      var frame1 = new Frame()
      while(frame1.status<2){
      frame1.getPoints(points)
      frame1.getScoreType()}
      score1.updateTotal(frame1.pointsTotal)
  }
    println(score1.scoreTotal)

}}


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

  def getPoints(point: Int): Unit = {
    points = point
    status = status + 1
    pointsTotal = pointsTotal + points

  }

  def getScoreType(): Any = {
    if (points == 10) {
      scoreType = "strike"
      status = 2
    } else if (pointsTotal == 10 && status == 2) {
      scoreType = "spare"
    } else {
      scoreType = "normal"
    }

  }
}