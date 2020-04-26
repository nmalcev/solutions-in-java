package sorts;
import utils.*;

public class QuickSort
{
    public static boolean isDebug = false;
    public static int[] sort(int[] array) {
        qsort(array, 0, array.length - 1);
        return array;
    }
    
    private static void qsort(int[] array, int left, int right) {
      if (isDebug) System.out.printf("Before: %s\n", Print.list(array, left, right));
      int[] res = reorder(array, left, right);
      if (isDebug) System.out.printf("After: %s\n", Print.list(array, left, right));
      if (res[1] - res[0] > 0) qsort(array, res[0], res[1]);
      if (res[3] - res[2] > 0) qsort(array, res[2], res[3]);
    }
    
    public static int[] reorder(int[] array, int start, int end) {
      int base = array[start];
      int left = start + 1;
      int right = end;
      int[] out = new int[4];
      int more, less;
      boolean isLeftActive = true;
      boolean isRightActive = true;
      int nextBaseIndex;
      
      while(right - left >= 0) {
        if (isDebug) System.out.printf("#%s %s %s\n", right-left, array[left], array[right]);
        if (isLeftActive && array[left] > base) {
          more = array[left];
          isLeftActive = false;
        }
        
        if (isRightActive && array[right] < base) {
          less = array[right];
          isRightActive = false;
        }
        
        if (!isRightActive && !isLeftActive) {
          less = array[right];
          more = array[left];
          if (isDebug) System.out.printf("%s <> %s\n", less, more);
          array[left] = less;
          array[right] = more;
          isLeftActive = true;
          isRightActive = true;
        }
        
        if (isLeftActive) left++;
        if (isRightActive) right--;
      }
      
      if (!isRightActive) {
        nextBaseIndex = right;
      } else if (!isLeftActive || (isLeftActive && isRightActive)) {
        nextBaseIndex = left - 1;
      } else {
        return out;
      }
      if (isDebug) System.out.printf("nextBaseIndex: [%s]=%s\n", nextBaseIndex, array[nextBaseIndex]);
      array[start] = array[nextBaseIndex];
      array[nextBaseIndex] = base;
      out[0] = start;
      out[1] = nextBaseIndex - 1;
      out[2] = nextBaseIndex + 1;
      out[3] = end;

      return out;
    }
}
