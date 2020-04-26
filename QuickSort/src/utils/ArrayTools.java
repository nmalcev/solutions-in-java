package utils;
import java.util.Random;

public class ArrayTools
{
    public static int[] generate(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        
        for(int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100);
        }
        return array;
    }
    
    public static boolean equals(int[] list1, int[] list2) {
      if (list1.length != list2.length) return false;
      for(int i = 0; i < list1.length; i++) {
        if (list1[i] != list2[i]) return false;
      }
      return true;
    }
    
    public static boolean isSorted(int[] list) {
      int i = list.length -1;
      
      while(i-- > 0) {
        if (list[i + 1] - list[i] < 0) return false;
      }
      return true;
    }
    
}
