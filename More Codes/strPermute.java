import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Date 05/23/2017
 * @author Ashok Lathwal
 *
 * Generate all permutations of string in lexicographically sorted order where repetitions of
 * character is possible in string.
 */
public class strPermute 
{

    public List<String> permute(char input[]) 
    {
        // for sorting char in increasing order
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) 
                {
                    return 1;
                } else 
                {
                    return val + 1;
                }
            });
        }
        //System.out.println(countMap);
        char str[] = new char[countMap.size()]; // contain char fo str in increasing order
        int count[] = new int[countMap.size()]; // corresponding count of char 
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet())
         {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        // contain final all string 
        List<String> resultList = new ArrayList<>();
        // contain particular string 
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0, resultList);
        return resultList;
    }

    public void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) 
    {
        // when all char count = 0
        if (level == result.length)
         {
            resultList.add(new String(result));
            return;
        }

        for(int i = 0; i < str.length; i++) 
        {
            if(count[i] == 0) 
            {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            count[i]++;
        }
    }

   /* private void printArray(char input[]) 
    {
        for(char ch : input) {
            System.out.print(ch);
        }
        System.out.println();
    }
*/
    public static void main(String args[]) 
    {
        strPermute sp = new strPermute();
        sp.permute("BBCA".toCharArray()).forEach(s -> System.out.println(s));
    }
}