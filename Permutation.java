import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;

public class Permutation 
{
	public void permute(String str)
	{
		if(str==null || str.length()==0)
		{
			System.out.println("Nic nie poda³eœ");
			return;
		}
		permute("",str);
	}
	
	public void permute(String prefix, String remaining)
	{
		if(remaining.length()==0)
		{
			System.out.println(prefix);
			return;
		}
		for(int i=0;i<remaining.length(); i++)
		{
			permute(prefix+remaining.charAt(i), remaining.substring(0, i)+remaining.substring(i+1, remaining.length()));
		}	
		
	}
	// A utility function to find factorial of n
    public int fact(int n)
    {
        return (n <= 1)? 1 :n * fact(n-1);
    }
  
    // A utility function to count smaller 
    // characters on right of arr[low]
    public int findSmallerInRight(String str, int low, int high)
    {
        int countRight = 0, i;
  
        for (i = low + 1; i <= high; ++i)
            if (str.charAt(i) < str.charAt(low))
                ++countRight;
  
        return countRight;
    }
  
    // A function to find rank of a string in 
    // all permutations of characters
    public int findRank (String str)
    {
        int len = str.length();
        int mul = fact(len);
        int rank = 0;
        int countRight;
  
        for (int i = 0; i < len; ++i)
        {
            mul /= len - i;
  
            // count number of chars smaller 
            // than str[i] from str[i+1] to
            // str[len-1]
            countRight = findSmallerInRight(str, i, len-1);
  
            rank += countRight * mul ;
        }
         
        return rank;
    }
    public  String nextPermutation(String text) {
		// next permutation
		char [] letters = text.toCharArray();
		// find the largest decreasing sequence.
		int startLongestNonInc = text.length() - 1;
		// loop back from the end of the char array, until you find
		// a spot where the preceeding char is greater than the next.
		while (startLongestNonInc > 0 && 
				text.charAt(startLongestNonInc - 1) >= text.charAt(startLongestNonInc)) {
	        startLongestNonInc--;
		}
		if (startLongestNonInc <= 0) {
			// then you must be at the last permutation.
			// e.g. "54321" is the last permutation of that sequence.
			// "cba", "321"
			return null;
		}
		// next we need to find a "pivot point".
		// this is a following element (to the right) that is 
		// greater than the start of the largest decreasing sequence.
		int pivotSwapWith = text.length() - 1;
	    while (text.charAt(pivotSwapWith) <= text.charAt(startLongestNonInc - 1)) {
	        pivotSwapWith--;
	    }
	    // Swap the pivot with the higher element to the right
	    char temp = letters[startLongestNonInc - 1];
	    letters[startLongestNonInc - 1] = letters[pivotSwapWith];
	    letters[pivotSwapWith] = temp;
	    
	    // Reverse the suffix sequence
	    pivotSwapWith = text.length()  - 1;
	    while (startLongestNonInc < pivotSwapWith) {
	    	// another bit of swapping code.
	    	// pull out original
	        temp = letters[startLongestNonInc];
	        // assign the end to the beginning.
	        letters[startLongestNonInc] = letters[pivotSwapWith];
	        // assign the temp back to the other spot.
	        letters[pivotSwapWith] = temp;
	        startLongestNonInc++;
	        pivotSwapWith--;
	    }
	    // remember, strings are immutable, so we need to pass 
	    // back a new string from the char array.
	    return new String(letters);
	}
    
    public  String previousPermutation(String text) {
		char [] letters = text.toCharArray();
		int startLongestNonInc = text.length() - 1;
		while (startLongestNonInc > 0 && 
				text.charAt(startLongestNonInc - 1) <= text.charAt(startLongestNonInc)) {
	        startLongestNonInc--;
		}
		if (startLongestNonInc <= 0) {
			return null;
		}
		int pivotSwapWith = text.length() - 1;
	    while (text.charAt(pivotSwapWith) >= text.charAt(startLongestNonInc - 1)) {
	        pivotSwapWith--;
	    }
	    char temp = letters[startLongestNonInc - 1];
	    letters[startLongestNonInc - 1] = letters[pivotSwapWith];
	    letters[pivotSwapWith] = temp;
	    pivotSwapWith = text.length() -1;
	    while (startLongestNonInc+1 < pivotSwapWith) {
	        temp = letters[startLongestNonInc];
	        letters[startLongestNonInc] = letters[pivotSwapWith];
	        letters[pivotSwapWith] = temp;
	        startLongestNonInc++;
	        pivotSwapWith--;
	    }
	    return new String(letters);
	}

//    public int[] unRank(int n, int rank)
//    {
//    
//      int[] digits = new int[n];
//      for (int digit = 2; digit <= n; digit++)
//      {
//        int divisor = digit;
//        digits[n - digit] = rank%(divisor);
//        if (digit < n)
//          rank = rank/(divisor);
//      }
//      BitSet usedDigits = new BitSet();
//      int[] permutation = new int[n];
//      for (int i = 0; i < n; i++)
//      {
//        int v = usedDigits.nextClearBit(0);
//        for (int j = 0; j < digits[i]; j++)
//          v = usedDigits.nextClearBit(v + 1);
//        permutation[i] = v;
//        usedDigits.set(v);
//      }
//      return permutation;
//    }
//
//    
    public  int factorial(int number) {
        int result = 1;

        for (int factor = 1; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }
    public String unRank(String set, int n)
    {
        String res="";
        while (set.length() > 0)
        {
            int setSize = factorial(set.length()-1);
            int index = n/setSize;
            res+= String.valueOf(set.charAt(index));
            set = index > 0 ? set.substring(0, index) : "" +
                  (index < set.length()-1) != null ? set.substring(index+1) : "";
            n = n % setSize;
        }
        return res;
    }
	
//    public String unRank(String n, int r)
//    {
//        String res="";
//        for(int i=n.length(); i>0; i-- )
//        {           
//            if(r%2==1)
//            {
//            	res=res+i;
//            }
//             r=(int)Math.floor(r/2);
//        }
//        return res;
//    }
    public static void main(String[] args1) 
	{
		Permutation p =new Permutation();
		String str = "123";
		p.permute(str);
		String str2 = "123";
		System.out.println ("Nastêpna permutacja "+str2+": "+p.nextPermutation(str2));
		System.out.println ("Poprzednia permutacja "+str2+": "+p.previousPermutation(str2));
		System.out.println ("Rank permutacji "+str2+": "+p.findRank(str2));
		int per=5;
		System.out.println ("Permutacja "+str2+" dla liczby rankingowej "+per+" wynosi: "+p.unRank(str, per));
	}

}
