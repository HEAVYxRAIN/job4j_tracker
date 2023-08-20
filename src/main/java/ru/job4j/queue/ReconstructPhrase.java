package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder builder = new StringBuilder();
        String result = null;
        int size = evenElements.size();
            for (char i = 0; size != 0; i++) {
                if (i % 2 == 0) {
                    result = String.valueOf(builder.append(evenElements.peek()));
                }
                evenElements.poll();
                size--;
            }
        return result;
    }

    private String getDescendingElements() {
        StringBuilder builder = new StringBuilder();
        String result = null;
        int size = descendingElements.size();
        while (size != 0) {
                result = String.valueOf(builder.append(descendingElements.pollLast()));
                size--;
        }
        return result;
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
