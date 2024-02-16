package src.main.java.repository;

import java.util.Stack;

public class CalcRepository {

    private final Stack<String> history = new Stack<>();

    public void addHistory(String historyEntry) {
        history.push(historyEntry);
    }

    public Stack<String> getHistory() {
        return history;
    }
}
