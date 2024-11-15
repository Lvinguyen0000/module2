package part1.treeMapOp;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapCount {
    public static void main(String[] args) {
        Map<Character, Integer> map = new TreeMap<>();
        String str = randomString(100);

        System.out.println(str);

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 1) + 1);
        }

        System.out.println("TreeMap: " + map);
    }

    public static String randomString(int size){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++){
            sb.append(Character.toString((char)((Math.random() * (122 - 97)) + 97)));
        }
        return sb.toString();
    }
}
