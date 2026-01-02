class Solution{
    static int inversionCount(int arr[]){
        return(int)mergeSort(arr, 0, arr.length - 1);
    }
    static long mergeSort(int[] arr, int left, int right){
        long count=0;
        if (left<right){
            int mid=left+(right-left)/2;
            count+=mergeSort(arr, left, mid);
            count+=mergeSort(arr, mid + 1, right);
            count+=mergeAndCount(arr, left, mid, right);
        }
        return count;
    }
    static long mergeAndCount(int[] arr, int left, int mid, int right){
        int n1=mid-left+1;
        int n2=right-mid;
        int[]L=new int[n1];
        int[]R=new int[n2];
        for(int i=0; i<n1; i++)
            L[i]=arr[left+i];
        for(int j=0; j<n2; j++)
            R[j]=arr[mid+1+j];
        int i=0, j=0, k=left;
        long invCount=0;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k++]=L[i++];
            } else {
                arr[k++]=R[j++];
                invCount+=(n1-i);
            }
        }
        while(i<n1)
            arr[k++]=L[i++];
        while(j<n2)
            arr[k++] = R[j++];
        return invCount;
    }
}
