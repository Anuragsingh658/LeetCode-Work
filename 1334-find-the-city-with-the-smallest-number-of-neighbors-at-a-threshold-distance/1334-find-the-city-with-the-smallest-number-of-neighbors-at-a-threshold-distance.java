class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize the distance matrix
        int[][] dist = new int[n][n];
        
        // Fill the matrix with a large value representing infinity
        for (int[] row : dist) {
            Arrays.fill(row, 10000000); // Use a large value instead of Integer.MAX_VALUE to prevent overflow
        }
        
        // Distance from a node to itself is zero
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        
        // Populate initial distances based on edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight; // Since the graph is undirected
        }
        
        // Floyd-Warshall algorithm to compute shortest paths between all pairs of nodes
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int minReachableCities = Integer.MAX_VALUE;
        int cityWithMinReachable = -1;
        
        // Find the city with the smallest number of reachable cities within the threshold
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            
            if (reachableCities <= minReachableCities) {
                if (reachableCities == minReachableCities) {
                    cityWithMinReachable = Math.max(cityWithMinReachable, i);
                } else {
                    minReachableCities = reachableCities;
                    cityWithMinReachable = i;
                }
            }
        }
        
        return cityWithMinReachable;
    }
}