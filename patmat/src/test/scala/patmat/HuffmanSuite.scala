package patmat

import org.junit._
import org.junit.Assert.{assertEquals, assertFalse}

class HuffmanSuite {
  import Huffman._

  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }


  @Test def `weight of a larger tree (10pts)`: Unit =
    new TestTrees {
      assertEquals(5, weight(t1))
    }


  @Test def `chars of a larger tree (10pts)`: Unit =
    new TestTrees {
      assertEquals(List('a','b','d'), chars(t2))
    }

  @Test def `string2chars hello world`: Unit =
    assertEquals(List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'), string2Chars("hello, world"))

  @Test def `times hello`: Unit = {
    val result = times(List('h', 'e', 'l', 'l', 'o'))
    print(result)
    assertEquals(List(('e',1), ('h',1), ('l',2), ('o',1)), result.sortWith((a,b) => a._1 < b._1))
  }

  @Test def `make ordered leaf list for some frequency table (15pts)`: Unit =
    assertEquals(List(Leaf('e',1), Leaf('t',2), Leaf('x',3)), makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))))


  @Test def `combine of some leaf list (15pts)`: Unit = {
    val leaflist = List(Leaf('t', 3), Leaf('e', 2), Leaf('x', 4))
    assertEquals(List(Leaf('x',4), Fork(Leaf('e',2),Leaf('t',3),List('e', 't'),5)), combine(leaflist))
  }


  @Test def `singleton true test`: Unit = {
    assert(singleton(List(Leaf('a',1))))
  }


  @Test def `singleton false test`: Unit = {
    assertFalse(singleton(List(Leaf('a',1), Leaf('b', 2))))
  }


  @Test def `decode and encode a very short text should be identity (10pts)`: Unit =
    new TestTrees {
      assertEquals("ab".toList, decode(t1, encode(t1)("ab".toList)))
    }


  @Test def `decode and quickEncode a very short text should be identity (10pts)`: Unit =
    new TestTrees {
      assertEquals("ab".toList, decode(t1, quickEncode(t1)("ab".toList)))
    }


  @Rule def individualTestTimeout = new org.junit.rules.Timeout(10 * 1000)
}
