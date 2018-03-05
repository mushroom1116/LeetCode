/**
 * Author: Wang Zhaorong
 */
/**
 * 对于这个给定的矩阵， 我们如果用brute force解法， 用两个嵌套循环， O(n2)便可以得到答案.但
 是我们需要注意的是这道题已经给定了这个矩阵的两个特性， 这两个特性对于提高我们算法的时间复杂度
 有很大帮助， 首先我们给出一个O(n)的解法， 也就是说我们可以固定住右上角的元素， 根据递增或者递减
 的规律， 我们可以判断这个给定的数值是否存在于这个矩阵当中.
 */
public class searchMatrix
{
    public static boolean searchMatrix(int[][] matrix, int target)
    {
        //边角判断
        if(matrix.length == 0)
            return false;
        if(matrix[0].length == 0)
            return false;

        //设置右上角
        int rowNumber = 0;
        int colNumber = matrix[0].length - 1;

        while(rowNumber < matrix.length && colNumber >= 0)
        {
            if(target > matrix[rowNumber][colNumber])
                rowNumber++;
            else if (target < matrix[rowNumber][colNumber])
                colNumber--;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.print(searchMatrix(matrix, 3));
    }
}
