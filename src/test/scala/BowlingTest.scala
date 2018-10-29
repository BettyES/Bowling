import org.scalatest.FunSuite

class BowlingTest extends FunSuite{
  test("all normal one score") {
    var frame1 = new Frame()
    frame1.getPoints(8)
    assert(frame1.pointsTotal === 8)}
}
