import java.util.Stack;
class maxRecHistArea
{
	static int larRecArea(int[] hist)
	{
		int n = hist.length;
		Stack<Integer> stk = new Stack<>();
		int max_area = 0;
		int curr_max_area = 0; 
        int i=0;
        int top = 0;
        while(i < n)
        {
        	if(stk.isEmpty() || hist[stk.peek()] <= hist[i])
        	{
        		stk.push(i++); // storing the index
        	}
        	else
        	{
        		top = stk.pop();
        		curr_max_area = hist[top]*(stk.isEmpty() ? i : i - stk.peek() -1);
        		if(curr_max_area > max_area)
        			max_area = curr_max_area;
        	}
        }
        // if element are remaining in stack perform upper else area
        while(!stk.isEmpty())
        {
        		top = stk.pop();
        		curr_max_area = hist[top]*(stk.isEmpty() ? i : i - stk.peek() -1);
        		if(curr_max_area > max_area)
        			max_area = curr_max_area;
        }
        return max_area;
	}
	public static void main(String[] arg)
	{
		int hist[] =  {6, 2, 5, 4, 5, 1, 6}; // {1,2,3,4,5}
		System.out.println("Largest rectangular area under histogram : "+larRecArea(hist));
	}
}
