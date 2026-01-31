public class findTheIndexOfTheFirstOccurrencyInAString {

    /*
    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
     */

    public int strStr(String haystack, String needle) {

        char[] arrayHay = haystack.toCharArray();
        char[] arrayNeedle = needle.toCharArray();
        int targetSize = needle.length() ;
        char targetStart = needle.charAt(0);



        for (int i = 0; i < haystack.length(); i++) {

            if (arrayHay[i] == targetStart) {

                int counter = 0;

                for (int j = i; j < haystack.length(); j++) {

                    if (arrayHay[j] == arrayNeedle[counter]) {
                        counter++;
                        if (counter == targetSize) {
                            return i;
                        }
                    } else {

                        break;

                    }

                }

            }

        }

        return -1;

    }

    /// solution 2
    public int strStr2(String haystack, String needle) {

        int windowStart = 0;
        int windowEnd = needle.length();

        while (windowEnd <= haystack.length()) {

            String sub = haystack.substring(windowStart, windowEnd);
            if (sub.equals(needle)) {
                return windowStart;
            }

            windowStart++;
            windowEnd++;

        }

        return -1;


    }



}
