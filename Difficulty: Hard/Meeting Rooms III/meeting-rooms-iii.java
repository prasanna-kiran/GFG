//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Jaimport java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        long[] roomAvailableAt = new long[n];
        int[] meetingCount = new int[n];

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) ->
            a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));

        for (int i = 0; i < n; i++) freeRooms.offer(i);

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            int duration = end - start;

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                roomAvailableAt[room] = start + duration;
                meetingCount[room]++;
                busyRooms.offer(new long[]{roomAvailableAt[room], room});
            } else {
                long[] earliest = busyRooms.poll();
                long newStart = earliest[0];
                int room = (int) earliest[1];
                roomAvailableAt[room] = newStart + duration;
                meetingCount[room]++;
                busyRooms.offer(new long[]{roomAvailableAt[room], room});
            }
        }

        int maxCount = 0, resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxCount || (meetingCount[i] == maxCount && i < resultRoom)) {
                maxCount = meetingCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}



//{ Driver Code Starts.
// } Driver Code Ends