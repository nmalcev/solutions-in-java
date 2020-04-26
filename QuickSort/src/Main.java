import java.util.*;
import utils.*;
import sorts.*;
/**
 * @author N.Maltsev
 * @version 24/04/2020
 */
public class Main
{
    public static void main(String[] args) {
        testSorting();
    }
    
    public static void testSorting() {
      testSorting(new int[]{84,71,15,74,29,7,1,81,6,63});
      testSorting(new int[]{47,31,6,89,63,30,77,36,3,64});
      for (int i = 2; i < 10; i++) {
          testSorting(ArrayTools.generate(i));
      }
    }
    
    public static void testReordering() {
        testReordering(new int[]{84,71,15,74,29,7,1,81,6,63});
        testReordering(new int[]{71,81,1});
        testReordering(new int[]{3,9,4,5,4,7,1,2, 0,0});
        testReordering(new int[]{1,1,1,1,1,1,1,1,1});
        testReordering(new int[]{100,99,101,102});
        testReordering(new int[]{3,2});
        testReordering(new int[]{3,9,2});
        testReordering(new int[]{30,31,6,3,36});
    } 
    
    public static void testReordering(int[] array) {
      System.out.printf("Before: %s\n", Print.list(array));
      int[] res = QuickSort.reorder(array, 0, array.length - 1);
      System.out.printf("After: %s RES: %s\n", Print.list(array), Print.list(res));
    }
    
    public static void testSorting(int[] array) {
      System.out.printf("Before: %s\n", Print.list(array));
      QuickSort.sort(array);
      System.out.printf("After: %s\n", Print.list(array));
      System.out.printf("\t%s\n\n", ArrayTools.isSorted(array) ? "matched" : "FAIL");
    }
}
