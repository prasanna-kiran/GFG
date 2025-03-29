//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n=deadline.length;
        Job[] jobs=new Job[n];
        for(int i=0; i<n; i++){
            jobs[i]=new Job(deadline[i], profit[i]);
        }
        Arrays.sort(jobs,(a, b) -> b.profit-a.profit);
        int maxDeadline =0;
        for(int d: deadline){
            maxDeadline= Math.max(maxDeadline, d);
        }
        boolean[] slot=new boolean[maxDeadline +1];
        int countJobs=0, totalProfit=0;
        for(Job job: jobs){
            for(int j=Math.min(job.deadline, maxDeadline); j>0; j--){
                if(!slot[j]){
                    slot[j]=true;
                    countJobs++;
                    totalProfit+= job.profit;
                    break;
                }
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
        result.add(countJobs);
        result.add(totalProfit);
        return result;
    }
    static class Job{
        int deadline, profit;
        Job(int deadline, int profit){
            this.deadline=deadline;
            this.profit=profit;
        }
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends