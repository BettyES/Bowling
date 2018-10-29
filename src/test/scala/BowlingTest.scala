import org.scalatest.FunSuite

class BowlingTest extends FunSuite {
  test("one frame resulting in a spare") {
    var stPrevFrame1 = "normal"
    var stPrevFrame2 = "normal"
    var frame1 = new Frame(stPrevFrame1, stPrevFrame2)
    frame1.getPoints(8)
    assert(frame1.pointsTotal === 8)
    assert(frame1.scoreType === "normal")
    frame1.getPoints(2)
    frame1.getScoreType(2)
    assert(frame1.pointsTotal === 10)
    assert(frame1.scoreType === "spare")
    assert(frame1.status === 2)
  }

  test("one frame, only normal shots") {
    var stPrevFrame1 = "normal"
    var stPrevFrame2 = "normal"
    var frame1 = new Frame(stPrevFrame1, stPrevFrame2)
    frame1.getPoints(4)
    assert(frame1.pointsTotal === 4)
    assert(frame1.scoreType === "normal")
    frame1.getPoints(2)
    frame1.getScoreType(2)
    assert(frame1.pointsTotal === 6)
    assert(frame1.scoreType === "normal")
    assert(frame1.status === 2)
  }

}
