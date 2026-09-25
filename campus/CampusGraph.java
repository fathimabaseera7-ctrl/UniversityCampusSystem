package campus;

import java.util.*;

@SuppressWarnings({"java:S106", "java:S1192", "java:S2864"})
public class CampusGraph {

    // Adjacency List
    private Map<String, List<String>> graph;

    // Constructor
    public CampusGraph() {
        graph = new HashMap<>();
    }

    // =========================
    // ADD LOCATION
    // =========================
    public void addLocation(String location) {

        if (location == null || location.trim().isEmpty()) {
            System.out.println("Invalid location.");
            return;
        }

        if (graph.containsKey(location)) {
            System.out.println("Location already exists: " + location);
            return;
        }

        graph.put(location, new ArrayList<>());

        System.out.println("Location added successfully: " + location);
    }

    // =========================
    // REMOVE LOCATION
    // =========================
    public void removeLocation(String location) {

        if (!graph.containsKey(location)) {
            System.out.println("Location not found: " + location);
            return;
        }

        // Remove this location from other locations
        for (List<String> connections : graph.values()) {
            connections.remove(location);
        }

        graph.remove(location);

        System.out.println("Location removed successfully: " + location);
    }

    // =========================
    // ADD CONNECTION
    // =========================
    public void addConnection(String location1, String location2) {

        if (!graph.containsKey(location1)
                || !graph.containsKey(location2)) {

            System.out.println("One or both locations do not exist.");
            return;
        }

        if (location1.equals(location2)) {
            System.out.println("A location cannot connect to itself.");
            return;
        }

        if (graph.get(location1).contains(location2)) {
            System.out.println("Connection already exists.");
            return;
        }

        // Undirected graph
        graph.get(location1).add(location2);
        graph.get(location2).add(location1);

        System.out.println(
                "Connection added: "
                + location1 + " <-> " + location2
        );
    }

    // =========================
    // REMOVE CONNECTION
    // =========================
    public void removeConnection(String location1, String location2) {

        if (!graph.containsKey(location1)
                || !graph.containsKey(location2)) {

            System.out.println("One or both locations do not exist.");
            return;
        }

        if (!graph.get(location1).contains(location2)) {
            System.out.println("Connection does not exist.");
            return;
        }

        graph.get(location1).remove(location2);
        graph.get(location2).remove(location1);

        System.out.println(
                "Connection removed: "
                + location1 + " <-> " + location2
        );
    }

    // =========================
    // DISPLAY CONNECTIONS
    // =========================
    public void displayConnections() {

        if (graph.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        System.out.println("================================");
        System.out.println("       CAMPUS CONNECTIONS");
        System.out.println("================================");

        for (String location : graph.keySet()) {

            System.out.print(location + " -> ");

            List<String> connections = graph.get(location);

            if (connections.isEmpty()) {
                System.out.println("No connections");
            } else {
                System.out.println(String.join(", ", connections));
            }
        }

        System.out.println("--------------------------------");
    }

    // =========================
    // BFS
    // =========================
    public void bfs(String startLocation) {

        if (!graph.containsKey(startLocation)) {
            System.out.println(
                    "Starting location not found: "
                    + startLocation
            );
            return;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startLocation);
        visited.add(startLocation);

        System.out.println("================================");
        System.out.println("       BFS TRAVERSAL");
        System.out.println("================================");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.println("Visited: " + current);

            for (String neighbour : graph.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }

        System.out.println("--------------------------------");
    }
}
