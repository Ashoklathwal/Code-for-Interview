import java.util.Stack;
class queUsingStk
{
    static Stack<Integer> stk = new Stack<>();
    static void eq(int x)
    {
        stk.push(x);
    }
    static void dq()
    {
        if(!stk.isEmpty())
        {
            int top = stk.pop();
            if(stk.isEmpty()){
                return;
            }
            dq();
    
            stk.push(top);
        }
        
    }
    
    public static void main(String[] args)
    {
        eq(5);
        eq(7);
        eq(8);
        eq(9);
        System.out.println(stk);
        dq();
        System.out.println(stk);
        dq();
        System.out.println(stk);
    }
}
