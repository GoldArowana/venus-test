package cn.com.mx.algorithm.lettcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Company Tags: Pocket Gems, Microsoft, Apple, Facebook
 * Tags: Two Pointers, String
 * Similar Problems: (H) Shortest Palindrome
 */
public class ImplementStrStr {

    /**
     * Two Pointers.
     * For i from 0 to m-n:
     * | For j from 0 to n-1:
     * |   If characters are not the same, break
     * |   If j reaches the end of needle, return i.
     * Return -1.
     * Special case:
     * If needle is empty, no need to check , just return 0.
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m - n; i++) { // Why m-n? From m-n+1 to m-1 the characters are not enough for needle.
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == n - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Test
    public void testExamples() {
        String str1 = "14531234";
        String str2 = "123";
        String str3 = "1123";
        String str4 = "1245";
        String str5 = "12121212123";
        Assert.assertEquals(4, strStr(str1, str2));
        Assert.assertEquals(1, strStr(str3, str2));
        Assert.assertEquals(-1, strStr(str4, str2));
        Assert.assertEquals(8, strStr(str5, str2));
    }
}
