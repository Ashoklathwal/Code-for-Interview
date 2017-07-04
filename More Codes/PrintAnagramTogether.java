import java.util.*; 
class PrintAnagramTogether
{
	private static void printAnagramsTogether_util(String[] strs) 
	{
      /* Arrays.sort(str, new Comparator<String>(){
       @Override
       public int compare(String o1, String o2) 
       {
             char [] arr1 = o1.toCharArray();
             char [] arr2 = o2.toCharArray();
             Arrays.sort(arr1);
             Arrays.sort(arr2);
             o1 = String.valueOf(arr1);
             o2 = String.valueOf(arr2);

         return o1.compareTo(o2);
        }
       });
       */
       if (strs == null || strs.length == 0) 
       	       //return new ArrayList<List<String>>();
       	        return;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) 
        {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) 
            	map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
       for(Map.Entry<String, List<String>> e : map.entrySet())
       {
          for(String e1 : e.getValue())
               System.out.println(e1);
       }
    }
	public static void main(String[] args) 
	{
		String[] arr = {"cat", "dog", "tac", "god", "act"};
		printAnagramsTogether_util(arr);
		
	}
}