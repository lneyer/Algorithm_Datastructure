import java.util.Arrays;

public class FloydWarshall {
    public static void main(String[] args) {
        // distances from one vertex to another in a weighted, directed graph;
        int[][] d= {
                {0,1,2,3},
                {4,0,5,6},
                {7,8,0,9},
                {10,11,12,0}
        };
        int n=d.length;
        assert n==d[0].length;
        for (int i = 0; i < n; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    d[u][v] = Math.min(d[u][v],d[u][i] + d[i][v]);
                }
            }
        }
        System.out.println(Arrays.deepToString(d));
        //Check for negative Cycle
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < u; v++) {
                if(d[u][v] < 0){
                    System.out.println("Negative Cycle");
                }
            }
        }
    }
}