package campus;

import java.util.Stack;

public class ActionStack {

    private Stack<String> actions;

    public ActionStack() {
        actions = new Stack<>();
    }

    public void pushAction(String action) {
        actions.push(action);
        System.out.println("Action recorded: " + action);
    }

    public void viewLastAction() {
        if (actions.isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }

        System.out.println("Last Action: " + actions.peek());
    }

    public void popAction() {
        if (actions.isEmpty()) {
            System.out.println("No actions to remove.");
            return;
        }

        String action = actions.pop();
        System.out.println("Removed Action: " + action);
    }

    public void displayActions() {
        if (actions.isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }

        System.out.println("================================");
        System.out.println("       RECENT ACTIONS");
        System.out.println("================================");

        int number = 1;

        for (int i = actions.size() - 1; i >= 0; i--) {
            System.out.println(number + ". " + actions.get(i));
            number++;
        }

        System.out.println("--------------------------------");
    }

    public boolean isEmpty() {
        return actions.isEmpty();
    }
}