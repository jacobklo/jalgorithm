package jacoblo.dataStructure;

import jacoblo.dataStructure.UnionFind.UnionFind;
import jacoblo.dataStructure.UnionFind.UnionFindVertex;
import org.junit.jupiter.api.Test;

public class UnionFindTest {
  @Test
  void testUnionFind() {
    UnionFindVertex<Integer> au = new UnionFindVertex("a",0,0);
    UnionFindVertex<Integer> bu = new UnionFindVertex("b",0,1);
    UnionFindVertex<Integer> cu = new UnionFindVertex("c",1,1);
    UnionFindVertex<Integer> du = new UnionFindVertex("d",1,0);
    UnionFindVertex<Integer> eu = new UnionFindVertex("e",2,2);

    UnionFind.union(au, bu);
    UnionFind.union(cu, du);
    UnionFind.union(au, eu);
    UnionFind.union(au, cu);

    System.out.println(au.equals(bu));


    System.out.println(au);
    System.out.println(bu);
    System.out.println(cu);
    System.out.println(du);
    System.out.println(eu);
  }

}
