package campus;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("java:S106")
public class ServiceQueue {

    private Queue<String> serviceRequests;

    // Constructor
    public ServiceQueue() {
        serviceRequests = new LinkedList<>();
    }

    // ==========================================
    // ADD SERVICE REQUEST
    // ==========================================
    public void addRequest(String request) {

        serviceRequests.offer(request);

        System.out.println("Service request added: " + request);
    }

    // ==========================================
    // PROCESS NEXT REQUEST
    // ==========================================
    public void processNextRequest() {

        if (serviceRequests.isEmpty()) {
            System.out.println("No service requests available.");
            return;
        }

        String request = serviceRequests.poll();

        System.out.println("Processing request: " + request);
    }

    // ==========================================
    // DISPLAY ALL REQUESTS
    // ==========================================
    public void displayRequests() {

        if (serviceRequests.isEmpty()) {
            System.out.println("No service requests available.");
            return;
        }

        System.out.println("================================");
        System.out.println("       SERVICE REQUEST QUEUE");
        System.out.println("================================");

        for (String request : serviceRequests) {
            System.out.println(request);
        }

        System.out.println("--------------------------------");
    }

    // ==========================================
    // CHECK IF QUEUE IS EMPTY
    // ==========================================
    public boolean isEmpty() {

        return serviceRequests.isEmpty();
    }
}
