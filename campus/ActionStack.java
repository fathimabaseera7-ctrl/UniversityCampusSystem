package campus;

import java.util.Stack;

@SuppressWarnings("java:S106")
public class ActionStack {

    private Stack<String> actions;

    // Constructor
    public ActionStack() {
        actions = new Stack<>();
    }

    // ==========================================
    // ADD ACTION
    // ==========================================
    public void pushAction(String action) {

        actions.push(action);

        System.out.println("Action recorded: " + action);
    }

    // ==========================================
    // VIEW MOST RECENT ACTION
    // ==========================================
    public void viewLastAction() {

        if (actions.isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }

        System.out.println("Last Action: " + actions.peek());
    }

    // ==========================================
    // REMOVE MOST RECENT ACTION
    // ==========================================
    public void popAction() {

        if (actions.isEmpty()) {
            System.out.println("No actions to remove.");
            return;
        }

        String action = actions.pop();

        System.out.println("Removed Action: " + action);
    }

    // ==========================================
    // DISPLAY ALL ACTIONS
    // ==========================================
    public void displayActions() {

        if (actions.isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }

        System.out.println("================================");
        System.out.println("       RECENT ACTIONS");
        System.out.println("================================");

        // Display from latest to oldest
        for (int i = actions.size() - 1; i >= 0; i--) {

            System.out.println(actions.get(i));
        }

        System.out.println("--------------------------------");
    }

    // ==========================================
    // CHECK IF STACK IS EMPTY
    // ==========================================
    public boolean isEmpty() {

        return actions.isEmpty();
    }
}
action still