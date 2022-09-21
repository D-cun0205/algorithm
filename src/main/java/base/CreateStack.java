package base;

import java.util.Arrays;

public class CreateStack {
    int top, bottom;
    int[] buf;

    public CreateStack() {
        this.top = 0;
        this.bottom = 0;
        this.buf = new int[10];
    }

    public void push(int num) {
        grow();
        this.buf[top] = num;
    }

    public int pop() {
        int bufData = peek();
        // srcPos: 배열에 몇 번째 요소를
        // destPos: 몇 번째 요소에 넣을지
        // length: srcPos ~ 몇개 까지
        System.arraycopy(buf, 1, buf, 0, top);
        buf[buf.length - 1] = 0;
        return bufData;
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
        return buf[bottom++];
    }

    public static void main(String[] args) {

    }
}