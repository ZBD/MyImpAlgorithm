import java.util.*;


public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        
        //path[i][j] means until row i, arrived collum j, the minsumpathtotal
        //path[i][j] = min(path[i-1][j], path[i-1][j-1]) + value[i][j]
        //boarder: path[0][0] = value[0][0]
        
        if (triangle == null || triangle.size() < 1 || triangle.get(0) == null) {
            return 0;
        }
        
        int[] sum = new int[triangle.get(triangle.size()-1).size()];
        int[] preSum = new int[triangle.get(triangle.size()-1).size()];
        
        for (int i=0; i<sum.length; i++) {
            sum[i] = Integer.MAX_VALUE;
            preSum[i] = sum[i];
        }
        
        for (int i=0; i<triangle.get(0).size(); i++) {
            sum[i] = triangle.get(0).get(i);
            preSum[i] = sum[i];
        }
        
        for (int i=1; i<triangle.size(); i++) {
            ArrayList<Integer> row = triangle.get(i);
            if (row == null) {
                continue;
            }
            
            sum[0] = preSum[0] + row.get(0);
            for (int j=1; j<row.size(); j++) {
                sum[j] = Math.min(preSum[j], preSum[j-1]) + row.get(j);
            }
            
            for (int j=0; j<sum.length; j++) {
                preSum[j] = sum[j];
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i=0; i<sum.length; i++) {
            answer = Math.min(answer, sum[i]);
        }
        return answer;
    }
}
