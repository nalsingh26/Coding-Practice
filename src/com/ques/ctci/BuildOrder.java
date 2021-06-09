package com.ques.ctci;

import java.util.*;

/*
Q4.7
You are given a list of projects and a list of dependencies(pairs of project, second is dependent on first)
All of a project's dependencies must be built before the project is. Find a build order that will allow the
projects to be built.
 */
public class BuildOrder {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value space separated projects: ");
        String projects = sc.nextLine();
        List<String> proj = Arrays.asList(projects.split(" "));
        System.out.print("Enter the number of dependencies: ");
        int N = sc.nextInt();
        sc.nextLine();
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
        System.out.println("Enter dependencies in format [a b] where b is dependent on a");
        for (int i = 0; i < N; i++) {
            System.out.print("Enter the dependency: ");
            String adj[] = sc.nextLine().split(" ");
            first.add(adj[0]);
            second.add(adj[1]);
        }
        HashMap<String, List<String>> graph = new HashMap<>();
        for (String elem : proj) {
            graph.put(elem, new ArrayList<>());
        }
        for (int i = 0; i < first.size(); i++) {
            String elem = first.get(i);
            List<String> curr = graph.get(elem);
            curr.add(second.get(i));
            graph.put(elem, curr);
        }
        printOrderedList(graph, proj);
    }

    private void printOrderedList(HashMap<String, List<String>> graph, List<String> proj) {
        HashSet<String> visited = new HashSet<>();
        Stack<String> dfsS = new Stack<>();
        Stack<String> result = new Stack<>();
        for (String p : proj) {
            if(graph.get(p).isEmpty()){
                result.push(p);
                visited.add(p);
            }
        }
        for (String p : proj) {
            if (visited.contains(p))
                continue;
            dfsS.push(p);
            visited.add(p);
            while (!dfsS.isEmpty()) {
                String elem = dfsS.peek();
                List<String> adj = graph.get(elem);
                int flag = 0;
                if(adj.size()==0){
                    result.push(elem);
                    dfsS.pop();
                    continue;
                }
                for (String e : adj)
                    if (!visited.contains(e)) {
                        flag++;
                        dfsS.push(e);
                        visited.add(e);
                    }
                if (flag == 0) {
                    result.push(dfsS.pop());
                }
            }
        }
        while (!result.isEmpty())
            System.out.print(result.pop() + ", ");
    }


}
