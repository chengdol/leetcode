// medium

/*
There are N gas stations along a circular route, where the amount of gas at
 station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
 from station i to its next station (i+1). You begin the journey with an empty
  tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit
 once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/


/*
TLE了， 我是先收集所有可能的starting point，再一个一个试.

greedy 2 个条件:
1. 总gas >= 总cost，否则返回-1
2. 若A 不能到达B，则A,B之间任意一个都不能到达B，所以只能选B的下一个当起点

*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int start = 0;
        int tank = 0;
        
        int totalGas = 0;
        int totalCost = 0;
        
        
        // solution is guaranteed to be unique
        for (int i = 0; i < gas.length; i++)
        {
            tank += gas[i] - cost[i];
            // update start
            if (tank < 0)
            {
                start = i + 1;
                tank = 0;
            }
            
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        return totalGas >= totalCost? start: -1;
        
    }
}