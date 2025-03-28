//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            int[] start = new int[startInput.length];
            for (int i = 0; i < startInput.length; i++) {
                start[i] = Integer.parseInt(startInput[i]);
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            int[] finish = new int[endInput.length];
            for (int i = 0; i < endInput.length; i++) {
                finish[i] = Integer.parseInt(endInput[i]);
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, finish));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n=start.length;
        if(n==0) return 0;
        int[][] activities=new int[n][2];
        for(int i=0; i<n; i++){
            activities[i][0]=finish[i];
            activities[i][1]=start[i];
        }
        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
        int count=0;
        int lastEnd=-1;
        for(int i=0;i<n;i++){
            int end=activities[i][0];
            int begin=activities[i][1];
            if(begin>lastEnd){
                count++;
                lastEnd=end;
            }
        }
        return count;
    }
}
