class Solution {
    public int getSecondLargest(int[] arr) {
    int large=Integer.MIN_VALUE;
    int second=Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++){
        if(arr[i]>large){
            second=large;
            large=arr[i];
            
        } else if(arr[i]>second && arr[i]!=large){
            second=arr[i];
            
    
        }
        
    

        
    }
    if(second==Integer.MIN_VALUE){
        return -1;
    
        
    }
    return second;
    
    
        
    
        
    }
}