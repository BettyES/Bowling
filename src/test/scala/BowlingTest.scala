import org.scalatest.FunSuite

class BowlingTest extends FunSuite {
//  test("one frame resulting in a spare") {
//    var stPrevFrame1 = "normal"
//    var stPrevFrame2 = "normal"
//    var frame1 = new Frame(stPrevFrame1, stPrevFrame2)
//    frame1.getPoints(8)
//    assert(frame1.pointsTotal === 8)
//    assert(frame1.scoreType === "normal")
//    frame1.getPoints(2)
//    frame1.getScoreType(2)
//    assert(frame1.pointsTotal === 10)
//    assert(frame1.scoreType === "spare")
//    assert(frame1.status === 2)
//  }
//
//  test("one frame, only normal shots") {
//    var stPrevFrame1 = "normal"
//    var stPrevFrame2 = "normal"
//    var frame1 = new Frame(stPrevFrame1, stPrevFrame2)
//    frame1.getPoints(4)
//    assert(frame1.pointsTotal === 4)
//    assert(frame1.scoreType === "normal")
//    frame1.getPoints(2)
//    frame1.getScoreType(2)
//    assert(frame1.pointsTotal === 6)
//    assert(frame1.scoreType === "normal")
//    assert(frame1.status === 2)
//  }

  test("extreme case of all strikes"){
    var score1 = new Score()
    var points = 10
    var stPrevFrame1 = "normal"
    var stPrevFrame2 = "normal"
    for (x <- 1 to 10) {

      var frame1 = new Frame(stPrevFrame1, stPrevFrame2)
      while (frame1.status < 2) {

        frame1.getPoints(points)

        frame1.getScoreType(points)
        stPrevFrame2 = stPrevFrame1

        stPrevFrame1 = frame1.scoreType


      }
      score1.updateTotal(frame1.pointsTotal)
    }

    assert(score1.scoreTotal===270)

  }

  test("extreme case of all 3s"){
    var score1 = new Score()
    var points = 3
    var stPrevFrame1 = "normal"
    var stPrevFrame2 = "normal"
    for (x <- 1 to 10) {

      var frame1 = new Frame(stPrevFrame1, stPrevFrame2)
      while (frame1.status < 2) {

        frame1.getPoints(points)

        frame1.getScoreType(points)
        stPrevFrame2 = stPrevFrame1

        stPrevFrame1 = frame1.scoreType

      }
      score1.updateTotal(frame1.pointsTotal)
    }

    assert(score1.scoreTotal===60)

  }

  test("spare"){
    var score1 = new Score()
    var points = new Array[Int](6)
    points = Array(8,2,3,7,5,5)
    var stPrevFrame1 = "normal"
    var stPrevFrame2 = "normal"
    var i = 0
    for (x <- 1 to 3) {

      var frame1 = new Frame(stPrevFrame1, stPrevFrame2)

      while (frame1.status < 2) {

        frame1.getPoints(points(i))

        frame1.getScoreType(points(i))
        stPrevFrame2 = stPrevFrame1

        stPrevFrame1 = frame1.scoreType
        i = i+1
      }
      score1.updateTotal(frame1.pointsTotal)
    }

    assert(score1.scoreTotal===38)

  }

}
