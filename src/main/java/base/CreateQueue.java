package base;

import java.util.Arrays;

public class CreateQueue {
    int top, bottom;
    int[] buf;

    public CreateQueue() {
        this.top = 0;
        this.bottom = 0;
        this.buf = new int[10];
    }

    public void push(int num) {
        grow();
        this.buf[top++] = num;
    }

    public int pop() {
        return peek();
    }

    public int size() {
        return buf.length;
    }

    private void grow() {
        if (this.top == size()) {
            this.buf = Arrays.copyOf(this.buf, this.top + 1);
        }
    }

    private int peek() {
        if (bottom == top) {
            throw new ArrayIndexOutOfBoundsException("더 출력할 값 없음");
        }
        if (bottom == size() && (bottom % size() < top)) {
            bottom = 0;
        }
        return buf[bottom++];
    }

    public static void main(String[] args) {

    }
}