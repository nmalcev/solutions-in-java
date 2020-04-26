package utils;


public class Print
{
    public static String list(int[] array, int start, int end) {
        String out = "";
        
        for(int i = start; i <= end; i++) {
            out += (i != start ? "," : "") + String.valueOf(array[i]);
        }
        
        return out;
    }


    public static String list(int[] array) {
        return list(array, 0, array.length - 1);
    }
}
