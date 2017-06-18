class reArrange 
{
 
    static void reArrange_util(int arr[], int n) 
    {


        for (int i = 0; i < n; i++)
            arr[arr[i] % n] = arr[arr[i] % n] + n*i;
 
        for (int i = 0; i < n; i++)
            System.out.println(arr[i] / n);
    }
 
    // Driver program to test above functions
    public static void main(String[] args) 
    {
        int arr[] = {2, 3, 3, 2, 5};
        int n = arr.length;
        reArrange_util(arr, n);
    }
}