import java.util.*;
class reducesArray
{
	public static  void reduced_util(int[] arr)
	{
		int n = arr.length;
		HashMap<Integer, Integer> hmap = new HashMap<>();
		int val = 0;
		int[] temp = arr.clone();
		Arrays.sort(temp);
		for(int i=0; i<n; i++)
		{
			hmap.put(temp[i], val++);
		}
       //System.out.println(hmap);
		for(int i=0; i<n;i++)
		{
			arr[i] = hmap.get(arr[i]);
		}

		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) 
	{
		int[] arr = {10, 15, 20, 12, 11, 50};
		reduced_util(arr);	
	}
}