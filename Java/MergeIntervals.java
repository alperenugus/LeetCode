/*

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

*/

class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> resultList = new ArrayList<>();
        
        int[] first = intervals[0];
        
        resultList.add(first);
        
        int resultIndex = 0;
        
        for(int i = 1; i < intervals.length; i++){
              
            if(resultList.get(resultIndex)[1] >= intervals[i][0])
                resultList.get(resultIndex)[1] = 
                Math.max(resultList.get(resultIndex)[1], intervals[i][1]);
            
            else{
                resultList.add(intervals[i]);
                resultIndex++;
            }
        }
        
        int[][] resultArray = new int[resultList.size()][2];
        
        for(int i = 0; i < resultList.size(); i++){
            
            resultArray[i] = resultList.get(i);
            
        }
        
        return resultArray;
    }
}