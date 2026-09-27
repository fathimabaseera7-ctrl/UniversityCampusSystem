package campus;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceQueue {

    private Queue<String> serviceRequests;

    public ServiceQueue() {
        serviceRequests = new LinkedList<>();
    }

    public void addRequest(String request) {
        serviceRequests.offer(request);
        System.out.println("Service request added: " + request);
    }

    public void processNextRequest() {
        if (serviceRequests.isEmpty()) {
            System.out.println("No service requests available.");
            return;
        }

        String request = serviceRequests.poll();

        System.out.println("Processing request: " + request);
    }

    public void displayRequests() {
        if (serviceRequests.isEmpty()) {
            System.out.println("No service requests available.");
            return;
        }

        System.out.println("================================");
        System.out.println("       SERVICE REQUEST QUEUE");
        System.out.println("================================");

        int number = 1;

        for (String request : serviceRequests) {
            System.out.println(number + ". " + request);
            number++;
        }

        System.out.println("--------------------------------");
    }

    public boolean isEmpty() {
        return serviceRequests.isEmpty();
    }
}
