class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);

        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[0][0]; // return empty matrix if topological sort failed
        }

        // Map each number to its position in the order lists
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }

        // Create the matrix
        int[][] matrix = new int[k][k];
        for (int i = 1; i <= k; i++) {
            matrix[rowPos[i]][colPos[i]] = i;
        }

        return matrix;
    }

    private List<Integer> topologicalSort(int k, int[][] conditions) {
        List<Integer> order = new ArrayList<>();
        int[] inDegree = new int[k + 1];
        List<Integer>[] graph = new ArrayList[k + 1];

        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph and calculate in-degrees
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph[u].add(v);
            inDegree[v]++;
        }

        // Use a queue to process nodes with 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            for (int neighbor : graph[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (order.size() == k) {
            return order;
        } else {
            return new ArrayList<>();
        }
    }
}
