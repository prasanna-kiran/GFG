//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxPartitions(String s) {
        int n=s.length();
        int [] last= new int[26];
        for(int i=0; i<n; i++){
            last[s.charAt(i)-'a']=i;
        }
        int count=0;
        int end=-1;
        for(int i=0; i<n; i++){
            end = Math.max(end, last[s.charAt(i)-'a']);
            if(i==end){
                count++;
            }
        }
        return count;
    }
}