package part3.largestAscending;

public class LargestAscending {
    public static String findString(String orgStr){
        int[] asciiArr = new int[orgStr.length()];
        for (int i = 0; i < orgStr.length(); i++){
            asciiArr[i] = (int) orgStr.charAt(i);
        }

        StringBuilder resStr = new StringBuilder();
        int curAscii = 0;
        for (int i = 0; i < asciiArr.length; i++){
            if (asciiArr[i] > curAscii){
                resStr.append((char) asciiArr[i]);
                curAscii = asciiArr[i];
            }
        }
        return resStr.toString();
    }

    public static void main(String[] args) {
        String str = "Welcome";
        System.out.println(findString(str));
    }
}
