import java.util.*;
class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        //find n
        int n = candyType.length;
        //sort array
        Arrays.sort(candyType);
        //eaten set
        Set<Integer> set = new HashSet<>();
        //iterate over candy types
        for(int i = 0; i < n; i++)
        {
            if(set.size() < n/2 && !set.contains(candyType[i]))
            {
                set.add(candyType[i]);
            }
        }
        return set.size();
                    
        
    }
}