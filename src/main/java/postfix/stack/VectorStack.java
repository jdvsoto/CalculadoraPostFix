package postfix.stack;

import java.util.ArrayList;
import java.util.List;

public class VectorStack<T> implements IStack<T> {

    private List<T> data;

    public VectorStack() {
        data = new ArrayList<>();
    }

    @Override
    public void push(T value) {
        data.add(value);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data.remove(data.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data.get(data.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }
}
