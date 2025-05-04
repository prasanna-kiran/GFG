//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{
    public int findSubString(String str) 
    {
        int n = str.length();
        if (n == 0) return 0;
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : str.toCharArray()) uniqueChars.add(c);
        int required = uniqueChars.size();
        Map<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0;
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < n) 
        {
            char c = str.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            if (windowFreq.get(c) == 1) formed++;
            while (formed == required) 
            
            {
                minLen = Math.min(minLen, right - left + 1);
                char leftChar = str.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (windowFreq.get(leftChar) == 0) formed--;
                left++;
            }
            right++;
        }
        return minLen;
    }
}
