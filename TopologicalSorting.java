import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSorting {
    public static void addEdge(ArrayList<ArrayList<Integer>> list, int source, int destination) {
        list.get(source).add(destination);
    }

    public static void main(String[] args) {
        int vertex = 6;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Boolean visited[] = new Boolean[vertex];
        Arrays.fill(visited, Boolean.FALSE);
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < vertex; i++) {
            list.add(new ArrayList<>());
        }

        addEdge(list, 5, 2);
        addEdge(list, 5, 0);
        addEdge(list, 4, 0);
        addEdge(list, 4, 1);
        addEdge(list, 2, 3);
        addEdge(list, 3, 1);

        for (int i = 0; i < vertex; i++) {
            if (list.get(i).size() == 0 && visited[i] == false) {
                stack.push(i);
                visited[i] = true;
            } else {
                for (int j = 0; j < list.get(i).size(); j++) {
                    if (!visited[list.get(i).get(j)]) {
                        stack.push(list.get(i).get(j));
                        visited[list.get(i).get(j)] = true;
                    }
                }
            }

            if(!visited[i]) {
                stack.push(i);
                visited[i] = true;
            }
        }

        System.out.print("Topological order :");
        while(!stack.empty()) {
            System.out.print(" " + stack.pop());
        }
    }
}
