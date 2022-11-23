package interview;

import org.junit.Assert;
import org.junit.BeforeClass;

public class Test {

   private static Score score;

   @BeforeClass
   public static void  before() {
      score =  new Score();
   }

   @org.junit.Test
   public void testPoints() {
      score.addPointsForServer("1");
      score.addPointsForReceiver("1");
      score.addPointsForServer("2");
      score.addPointsForReceiver("2");
      score.addPointsForServer("3");
      score.addPointsForReceiver("3");
      Assert.assertEquals("40", score.getPointsMap().get("Server").getCurrentPoints());
      Assert.assertEquals("40", score.getPointsMap().get("Receiver").getCurrentPoints());

      score.addPointsForServer("A");
      Assert.assertEquals("A", score.getPointsMap().get("Server").getCurrentPoints());
      Assert.assertEquals("40", score.getPointsMap().get("Receiver").getCurrentPoints());

      score.addPointsForReceiver("A");
      Assert.assertEquals("A", score.getPointsMap().get("Server").getCurrentPoints());
      Assert.assertEquals("A", score.getPointsMap().get("Receiver").getCurrentPoints());


      score.addPointsForServer("A");
      Assert.assertEquals("Win", score.getPointsMap().get("Server").getCurrentPoints());
      Assert.assertEquals("A", score.getPointsMap().get("Receiver").getCurrentPoints());
   }
}
