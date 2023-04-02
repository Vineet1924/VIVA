import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    public static void addEdge(ArrayList<ArrayList<Integer>> list, int source, int destination) {
        list.get(source).add(destination);
        list.get(destination).add(source);
    }
    public static void main(String[] args) {
        int vertex = 5;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Boolean visited[] = new Boolean[vertex];
        Arrays.fill(visited, Boolean.FALSE);
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < vertex; i++) {
            list.add(new ArrayList<>());
        }

        addEdge(list, 0, 1);
        addEdge(list, 0, 3);
        addEdge(list, 0, 2);
        addEdge(list, 1, 2);
        addEdge(list, 2, 3);
        addEdge(list, 2, 4);

        System.out.println("--------------------- Adjacency List --------------------");
        for(int i = 0; i < vertex; i++) {
            System.out.print(i + " --> ");

            for(int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " --> ");
            }

            System.out.print("Null");
            System.out.println();
        }

        System.out.println("--------------------- BFS --------------------");

        int source = 4;
        queue.add(source);
        stack.push(source);
        visited[source] = true;

        System.out.print("Traversal : " + source);
        while(!queue.isEmpty()) {
            int currentVertex = queue.remove();
            for(int i = 0; i < list.get(currentVertex).size(); i++) {
                if(visited[list.get(currentVertex).get(i)] == false) {
                    queue.add(list.get(currentVertex).get(i));
                    visited[list.get(currentVertex).get(i)] = true;
                    System.out.print(" " + list.get(currentVertex).get(i));
                }
            }
        }

        Arrays.fill(visited, Boolean.FALSE);
        System.out.println();
        System.out.println("--------------------- DFS --------------------");

        visited[source] = true;

        System.out.print("Traversal :");
        while(!stack.empty()) {
            int currentVertex = stack.pop();
            System.out.print(" " + currentVertex);

            for(int i = 0; i < list.get(currentVertex).size(); i++) {
                if(visited[list.get(currentVertex).get(i)] == false) {
                    stack.push(list.get(currentVertex).get(i));
                    visited[list.get(currentVertex).get(i)] = true;
                }
            }
        }
    }
}
