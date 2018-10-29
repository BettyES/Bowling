import org.scalatest.FunSuite

class BowlingTest extends FunSuite{
  test("all normal one score") {
    var score1 = new Score()
    score1.updateScore(8)
    assert(score1.pointsTotal === 8)}
}
