package base;

import java.util.Arrays;

public class CreateStack {
    private int top;
    private int[] buf;

    private CreateStack() {
        this.top = 0;
        this.buf = new int[10];
    }

    public void push(int num) {
        grow();
        this.buf[this.top++] = num;
    }

    public int pop() {
        int bufData = peek();
        removeCapacity();
        return bufData;
    }

    private void removeCapacity() {
        int len = size();
        //System.arraycopy(buf, top + 1, buf, top, len);
        this.buf = Arrays.copyOf(this.buf, this.top);
    }

    public int peek() {
        return this.buf[--this.top];
    }

    public int size() {
        return this.buf.length;
    }

    private void grow() {
        if (this.top == size()) {
            this.buf = Arrays.copyOf(this.buf, this.top + 1);
        }
    }

    public static void main(String[] args) {

    }
}