package interview;

import lombok.Getter;

@Getter
public class Points {

   String currentPoints;
   String existingPoints;
   public Points(String currentPoints, String existingPoints) {
       this.currentPoints = currentPoints;
       this.existingPoints = existingPoints;
   }
}
