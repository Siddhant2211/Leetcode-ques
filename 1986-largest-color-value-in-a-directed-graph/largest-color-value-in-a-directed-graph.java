class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int numVertices = colors.length();
        List<Integer>[] adjacencyList = new List[numVertices];
      
       
        Arrays.setAll(adjacencyList, element -> new ArrayList<>());
      
       
        int[] indegree = new int[numVertices];

        
        for (int[] edge : edges) {
            int fromVertex = edge[0], toVertex = edge[1];
            adjacencyList[fromVertex].add(toVertex);
            ++indegree[toVertex];
        }
      
        
        Deque<Integer> queue = new ArrayDeque<>();
      
        
        int[][] maxColorCountAtVertex = new int[numVertices][26];
      
       
        for (int vertex = 0; vertex < numVertices; ++vertex) {
            if (indegree[vertex] == 0) {
                queue.offer(vertex);
                int colorIndex = colors.charAt(vertex) - 'a';
                ++maxColorCountAtVertex[vertex][colorIndex];
            }
        }
      
       
        int processedVerticesCount = 0;
      
        
        int answer = 1;

        
        while (!queue.isEmpty()) {
            int currentVertex = queue.pollFirst();
            ++processedVerticesCount;
          
            
            for (int adjacentVertex : adjacencyList[currentVertex]) {
              
                
                if (--indegree[adjacentVertex] == 0) {
                    queue.offer(adjacentVertex);
                }
              
                
                int colorIndex = colors.charAt(adjacentVertex) - 'a';
                for (int color = 0; color < 26; ++color) {
                    int currentMax = maxColorCountAtVertex[currentVertex][color] +
                                     (colorIndex == color ? 1 : 0);
                    maxColorCountAtVertex[adjacentVertex][color] = 
                        Math.max(maxColorCountAtVertex[adjacentVertex][color], currentMax);
                  
                    
                    answer = Math.max(answer, maxColorCountAtVertex[adjacentVertex][color]);
                }
            }
        }
      
        
        return processedVerticesCount == numVertices ? answer : -1;
    }
}