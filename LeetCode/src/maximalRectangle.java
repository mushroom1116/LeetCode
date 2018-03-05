/**
先去掉最下面的一行， 然后就可以发现， 它可以转化成一个直方图， 数据为[2, 2, 2, 0]， 我们认为1就是高度， 如果碰到0， 譬如上面最右列， 则高度为0， 而计算这个直方图最大矩形面积就很容易了， 我们已经在Largest Rectangle in Histogram处理了。所以我们可以首先得到每一行的直方图， 分别求出改直方图的最大区域， 最后就能得到结果了。
*/
import java.util.*;
class maximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        //边角判断
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        //得到原字符矩阵的行列数
        int r = matrix.length;
        int c = matrix[0].length;
        
        //得到每一行的直方图数组
        int[][] heights = new int[r][c];
        for(int i =0 ; i<r; i++)
            for(int j=0; j<c; j++)
            {
                if(matrix[i][j] == '0')
                    heights[i][j] = 0;
                else
                {
                    heights[i][j] = (i==0) ? 1 : heights[i-1][j]+1;
                }
            }
        
        //求最大矩形
        int maxArea = 0;
        for(int i=0; i<r; i++)
        {
            maxArea = Math.max(maxArea, largestRectangleArea(heights[i]));
        }
        
        return maxArea;
    }
    
    public static int largestRectangleArea(int[] heights)
    {
        Stack<Integer> s = new Stack<Integer>();
        int sum = 0;
        int value = 0;
        int top = 0;
        for(int i=0; i<=heights.length; )
        {
            value = i<heights.length ? heights[i] : 0;
            if(s.empty() || value > heights[s.peek()])
            {
                s.push(i);
                i++;
            }
            else
            {
                top = s.pop();
                sum = Math.max(sum, heights[top] * (s.empty()?i:(i-1-s.peek())));
            }
        }
        return sum;
    }

    public static void main(String[] args)
    {
        char[][] input = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.print(maximalRectangle(input));
    }
}