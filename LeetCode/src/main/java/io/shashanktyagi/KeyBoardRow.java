package io.shashanktyagi;

import java.util.*;
import java.util.stream.Collectors;

public class KeyBoardRow {
    static public class Solution {
        private static ArrayList<Set<Character>> rows = new ArrayList<>();

        static {
            Set<Character> row = new HashSet<>();
            row.add('Q');
            row.add('W');
            row.add('E');
            row.add('R');
            row.add('T');
            row.add('Y');
            rows.add(row);
            row = new HashSet<>();
            row.add('A');
            row.add('S');
            row.add('D');
            row.add('F');
            row.add('G');
            row.add('H');
            row.add('J');
            row.add('K');
            row.add('L');
            rows.add(row);
            row = new HashSet<>();
            row.add('Z');
            row.add('X');
            row.add('C');
            row.add('V');
            row.add('B');
            row.add('N');
            row.add('M');
            rows.add(row);
        }

        public String[] findWords(String[] words) {
            ArrayList<String> res = new ArrayList<>(words.length);
            for (String word :
                    words) {
                List<Character> chrs = word.toUpperCase().chars()
                        .mapToObj((i) -> (char) i)
                        .collect(Collectors.toList());
                for (Set<Character> crow : rows) {
                    if (crow.containsAll(chrs)) {
                        System.out.println(word);
                        res.add(word);
                    }
                }
            }
            return res.stream().toArray(String[]::new);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}
