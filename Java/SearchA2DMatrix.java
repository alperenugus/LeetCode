/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = binarySearchRow(matrix, target, 0, matrix.length - 1);
                
        if(row == -1) return false;
        
        return binarySearchColumn(matrix[row], target, 0, matrix[row].length - 1);
        
    }
    
    public int binarySearchRow(int[][] matrix, int target, int down, int up){
        
        if(down <= up){
            int mid = (down + up) / 2;

            if(matrix[mid][0] <=  target && matrix[mid][matrix[mid].length - 1] >= target) 
                return mid;

            if(matrix[mid][0] > target) return binarySearchRow(matrix, target, down, mid - 1);

            return binarySearchRow(matrix, target, mid + 1, up);
        }
        
        return -1;   
    }
    
    public boolean binarySearchColumn(int[] row, int target, int left, int right){
        
        int mid = (left + right) / 2;
        
        if(left <= right){
            
            if(row[mid] == target) return true;
            
            if(row[mid] > target) return binarySearchColumn(row, target, left, mid - 1);
            
            return binarySearchColumn(row, target, mid + 1, right);
        }
        
        return false;
    }    
}