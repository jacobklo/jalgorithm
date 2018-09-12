package jacoblo.designPattern;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMain {
   
  public static void main(String[] args) {
    
    IntStream s = generateRandomNumber(10, 0, 1000);
    List<Integer> result = s.filter(cur -> cur > 0).map(e -> e).boxed().collect(Collectors.toList());
    System.out.println(result.toString());
  }
  
  public static IntStream generateRandomNumber ( int numOfIntegers, int min, int max ) {
    
    Random random = new Random();
    return random.ints(numOfIntegers, min, max);
  }
}
