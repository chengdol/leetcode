// easy

/*
Given an integer array with even length, where different numbers in 
this array represent different kinds of candies. Each number means 
one candy of the corresponding kind. You need to distribute these 
candies equally in number to brother and sister. Return the maximum 
number of kinds of candies the sister could gain.

Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
The sister has two different kinds of candies, the brother has only one kind of candies. 

*/

class Solution {
    public int distributeCandies(int[] candies) 
    {
        Set<Integer> set = new HashSet<>();
        
        for (int candy : candies)
        {
            set.add(candy);
        }
        
        int half = candies.length / 2;
        return set.size() > half? half : set.size(); 
    }
}