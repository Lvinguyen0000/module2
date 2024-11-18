package part3.largestAscendingSubArray;

public class LargestSub {
    public static String findSub(String orgStr){
        int[] asciiArr = new int[orgStr.length()];
        for (int i = 0; i < orgStr.length(); i++){
            asciiArr[i] = (int) orgStr.charAt(i);
        }

        int startIndex = 0, endIndex = 0, count = 0;
        int[] subInfo = {0, 0, 0};

        for (int i = 0; i < asciiArr.length - 1; i++){
            if (asciiArr[i] <= asciiArr[i + 1]){
                count++;
                endIndex = i + 1;
                if (count > subInfo[0]){
                    subInfo[0] = count;
                    subInfo[1] = startIndex;
                    subInfo[2] = endIndex;
                }
            }
            else {
                count = 0;
                startIndex = endIndex = i + 1;
            }
        }
        StringBuilder subStr = new StringBuilder();
        for (int  i = subInfo[1]; i <= subInfo[2]; i++){
            subStr.append((char) asciiArr[i]);
        }
        return subStr.toString();
    }

    public static void main(String[] args) {
        String test = "abcabcdgabxy";
        System.out.println(findSub(test));

        test = "abcabcdgabmnsxy";
        System.out.println(findSub(test));
    }
}
