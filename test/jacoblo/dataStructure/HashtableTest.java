package jacoblo.dataStructure;

import org.junit.jupiter.api.Test;

public class HashtableTest {

  @Test
  void testSample(String[] args) {
    Hashtable<Integer,Integer> hashs = new Hashtable<>();
//		hashs.put(1, 1);
//		hashs.put(3, 3);
//		hashs.put(6, 6);
//		hashs.put(17, 17);
//		hashs.put(18, 18);
//		hashs.remove(6);
    for (int i = 0 ; i < 100 ; i++) {
      hashs.put(i,i);
    }
    for (int i = 0 ; i < 99 ; i++) {
      hashs.remove(i);
    }
    System.out.println(hashs);
  }
}
