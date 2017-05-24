import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SentenceDecomposition {
  HashMap<int[], String> lang = new HashMap<>();
  private HashMap<String, Integer> dp = new HashMap<>();

  public int decompose(String sentence, String[] validWords) {
    for (int i = 0; i < validWords.length; i++) {
      String validWord = validWords[i];
      int[] currMap = new int[26];
      for (int j = 0; j < validWord.length(); j++) {
        currMap[validWord.charAt(j) - 'a']++;
      }
      lang.put(currMap, validWord);
    }
    dp.put("", 0);
    return min(sentence);
  }


  private int min(String sentence) {

    return dp.computeIfAbsent(sentence, s -> {
      int w = -1;
      for (Map.Entry<int[], String> e :
          lang.entrySet()) {
        if (e.getValue().length() <= s.length()) {
          String curr = s.substring(0, e.getValue().length());
          int[] currMap = new int[26];
          for (int i = 0; i < curr.length(); i++) {
            currMap[curr.charAt(i) - 'a']++;
          }
          if (Arrays.equals(currMap, e.getKey())) {
            int curW = min(s.substring(e.getValue().length()));
            if (curW != -1) {
              for (int i = 0; i < curr.length(); i++) {
                if (e.getValue().charAt(i) != curr.charAt(i))
                  curW++;
              }
              if (w == -1) {
                w = curW;
              } else {
                w = Math.min(w, curW);
              }
            }

          }
        }
      }
      return w;
    });
  }
}
