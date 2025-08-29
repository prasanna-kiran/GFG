class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "";
        int[] freqP = new int[256];
        for (char c : p.toCharArray()) freqP[c]++;
        int[] freqS = new int[256];
        int count = 0, minLen = Integer.MAX_VALUE, startIndex = -1, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            freqS[rChar]++;
            if (freqS[rChar] <= freqP[rChar]) count++;
            if (count == p.length()) {
                while (freqS[s.charAt(left)] > freqP[s.charAt(left)] || freqP[s.charAt(left)] == 0) {
                    if (freqS[s.charAt(left)] > freqP[s.charAt(left)]) freqS[s.charAt(left)]--;
                    left++;
                }
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIndex = left;
                }
            }
        }
        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
