class Solution:
    def activitySelection(self, start, finish):
        activities=sorted(zip(finish,start))
        count,last_end=0, -1;
        for end, begin in activities:
            if begin>last_end:
                count+=1
                last_end=end
        return count


#{ 
 # Driver Code Starts
def main():
    t = int(input().strip())  # Number of test cases

    for _ in range(t):
        # Read the start times
        start = list(map(int, input().strip().split()))

        # Read the finish times
        finish = list(map(int, input().strip().split()))

        # Create solution object and call activitySelection
        obj = Solution()
        print(obj.activitySelection(start, finish))
        print("~")


if __name__ == "__main__":
    main()

# } Driver Code Ends