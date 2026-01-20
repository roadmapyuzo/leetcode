import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordPattern {

    /*
    Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.


Example 1:

Input: pattern = "abba", s = "dog cat cat dog"

Output: true

Explanation:

The bijection can be established as:

'a' maps to "dog".
'b' maps to "cat".
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"

Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"

Output: false



Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
     */

    // first solution

        public boolean wordPattern(String pattern, String s) {

            char[] patternarray = pattern.toCharArray();
            String[] wordsarray = s.split(" ");

            if (wordsarray.length != patternarray.length) {
                return false;
            }

            HashMap<Character, Integer> patternmap = new HashMap<>();
            HashMap<String, Integer> wordsmap = new HashMap<>();

            int aux1 = 0;
            int aux2 = 0;

            for (char c : patternarray) {

                if (!patternmap.containsKey(c)) {
                    patternmap.put(c, aux1);
                    aux1++;
                }

            }

            for (String x : wordsarray) {

                if(!wordsmap.containsKey(x)) {

                    wordsmap.put(x, aux2);
                    aux2++;

                }

            }

            if (wordsmap.size() != patternmap.size()) {
                return false;
            }

            int[] resultpattern = new int[patternarray.length];
            int[] resultwords = new int[wordsarray.length];

            int counter = 0;
            for (char c : patternarray) {

                resultpattern[counter] = patternmap.get(c);
                counter++;

            }

            counter = 0;

            for (String z : wordsarray) {

                resultwords[counter] = wordsmap.get(z);
                counter++;

            }

            for (int i = 0; i < wordsarray.length; i++) {
                if (resultpattern[i] != resultwords[i]) {
                    return false;
                }
            }

            return true;





        }


        // second solution

    public boolean wordPattern2(String pattern, String s) {


        char[] patternarray = pattern.toCharArray();
        String[] wordsarray = s.split(" ");

        if (wordsarray.length != patternarray.length) {
            return false;
        }

        HashMap<String, String> map = new HashMap<>();
        List<String> patternlist = new ArrayList<>();
        List<String> wordslist = new ArrayList<>();

        for (char c : patternarray) {


            if (!patternlist.contains(Character.toString(c))) {
                patternlist.add(Character.toString(c));
            }


        }

        for (String x : wordsarray) {

            if(!wordslist.contains(x)) {
                wordslist.add(x);
            }

        }

        if (wordslist.size() != patternlist.size()) {
            return false;
        }



        for (int i = 0; i < wordslist.size(); i++) {
            map.put(patternlist.get(i), wordslist.get(i));
        }

        for (int i = 0; i < patternarray.length; i++) {
            if (!wordsarray[i].equals(map.get(Character.toString(patternarray[i])))) {
                return false;
            }
        }

        return true;

    }

}
