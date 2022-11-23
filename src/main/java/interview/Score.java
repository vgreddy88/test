package interview;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Score {
   private Map<String, Points> pointsMap;
   private Map<String, String> defaultMap;
   public Score() {
      pointsMap = new HashMap<>();
      pointsMap.put("Server", new Points("0", "0"));
      pointsMap.put("Receiver", new Points("0", "0"));

      defaultMap = new HashMap<>();
      defaultMap.put("1", "15");
      defaultMap.put("2", "15");
      defaultMap.put("3", "10");
      defaultMap.put("A", "A");
      defaultMap.put("W", "Win");
   }

   public void addPointsForServer(String points) {
      pointsMap.put("Server", addPoints(pointsMap.get("Server"), defaultMap.get(points)));
   }

   public void addPointsForReceiver(String points) {
      pointsMap.put("Receiver", addPoints(pointsMap.get("Receiver"), defaultMap.get(points)));
   }

   private Points addPoints(Points existingPoints, String pointTobeAdded) {
      if (pointTobeAdded.equals("A") && StringUtils.isNumeric(existingPoints.currentPoints)) {
         return new Points(pointTobeAdded, existingPoints.getExistingPoints());
      } else if (pointTobeAdded.equals("A") && !StringUtils.isNumeric(existingPoints.currentPoints)) {
         return new Points(defaultMap.get("W"), existingPoints.getExistingPoints());
      } else {
         return new Points(String.valueOf(
                 Integer.parseInt(existingPoints.getCurrentPoints())+Integer.parseInt(pointTobeAdded)),
                 existingPoints.getExistingPoints());
      }
   }

}
