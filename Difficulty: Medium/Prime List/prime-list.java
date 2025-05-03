//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution 
{
    static final int MAX = 100010;
    static boolean[] isPrime = new boolean[MAX];
    static 
    {
        for (int i = 2; i < MAX; i++) isPrime[i] = true;
        for (int i = 2; i * i < MAX; i++) 
        {
            if (isPrime[i]) 
            {
                for (int j = i * i; j < MAX; j += i) 
                {
                    isPrime[j] = false;
                }
            }
        }
    }

    Node primeList(Node head) 
    {
        Node current = head;
        while (current != null) 
        {
            current.val = nearestPrime(current.val);
            current = current.next;
        }
        return head;
    }

    int nearestPrime(int n) 
    {
        if (isPrime[n]) return n;
        int lower = n - 1;
        int upper = n + 1;
        while (true) 
        {
            if (lower >= 2 && isPrime[lower]) return lower;
            if (isPrime[upper]) return upper;
            lower--;
            upper++;
        }
    }
}
