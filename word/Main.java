import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader dicBr = new BufferedReader(new FileReader("dic.txt"));
        BufferedReader inputBr = new BufferedReader(new FileReader(args[0]));

        Map<Character, Integer> mapT = new HashMap<>();
        String nextLine = "";
        while ((nextLine = inputBr.readLine()) != null) {
            nextLine = nextLine.toLowerCase();
            for (int i = 0; i < nextLine.length(); i++) {
                if (mapT.containsKey(nextLine.charAt(i))) {
                    mapT.put(nextLine.charAt(i), mapT.get(nextLine.charAt(i)) + 1);
                } else {
                    mapT.put(nextLine.charAt(i), 1);
                }
            }
        }

        while ((nextLine = dicBr.readLine()) != null) {
            boolean anagram = isAnagram(nextLine, mapT);
            if (anagram) {
                System.out.println(nextLine);
            }
        }

    }


    static boolean isAnagram(String s, Map<Character, Integer> mapT) {
        s = s.toLowerCase();
        Map<Character, Integer> mapS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (mapS.containsKey(s.charAt(i))) {
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1);
            } else {
                mapS.put(s.charAt(i), 1);
            }
        }

        if (mapS.equals(mapT))
            return true;
        for (Character key1 : mapS.keySet()) {
            if (!mapT.containsKey(key1) || mapS.get(key1) > mapT.get(key1))
                return false;
        }

        return true;
    }
}
