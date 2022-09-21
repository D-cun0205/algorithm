package base;

import java.util.Arrays;

public class CreateQueue {
    private int top;
    private int[] buf;

    private CreateQueue() {
        this.top = 0;
        this.buf = new int[10];
    }

    public void push(int num) {
        grow();
        buf[this.top++] = num;
    }

    public int pop() {
        int bufData = peek();
        removeCapacity();
        return bufData;
    }

    private void removeCapacity() {
        int len = size();
        System.arraycopy(buf, top + 1, buf, top, len);
    }

    public int peek() {
        return buf[this.top];
    }

    public int size() {
        return buf.length;
    }

    private void grow() {
        if (top == size()) {
            buf = Arrays.copyOf(buf, top + 1);
        }
    }
}