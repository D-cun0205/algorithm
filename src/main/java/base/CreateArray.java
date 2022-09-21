package base;

public class CreateArray {
    private int count;
    private int[] assignedBuf;
    private int bufSize;

    private CreateArray() {}

    public CreateArray(int bufSize) {
        this.count = 0;
        this.bufSize = bufSize;
        this.assignedBuf = new int[bufSize];
    }

    public void addElement(int number) {
        indexOutOfBounds();
        assignedBuf[count++] = number;
    }


    public void insertElement(int idx, int number) {
        indexOutOfBounds();
        if (count == bufSize) {
            throw new IndexOutOfBoundsException("요소를 추가하기 위한 버퍼가 남아있지 않습니다.");
        }
        if (idx > count) {
            throw new IndexOutOfBoundsException("해당 인덱스는 앞에 빈 버퍼가 포함되어 있습니다.");
        }
        for (int i = count; i >= idx; i--) {
            assignedBuf[i + 1] = assignedBuf[i];
        }
        assignedBuf[idx] = number;
        ++count;
    }

    public void removeElement(int idx) {
        indexOutOfBounds();
        if (idx > count) {
            throw new IndexOutOfBoundsException("비어있는 버퍼를 다시 초기화할 필요가 없습니다.");
        }
        for (int i = idx; i <= count; i++) {
            if (i == count) {
                assignedBuf[i] = 0;
                break;
            }
            assignedBuf[i] = assignedBuf[i + 1];
        }
        --count;
    }

    private void indexOutOfBounds() {
        if (count < 0 || count > bufSize - 1) {
            throw new IndexOutOfBoundsException("할당되지 않은 메모리의 인덱스를 참조하려고 시도하였습니다.");
        }
    }

    private int size() {
        return count;
    }

    public int[] getAssignedBuf() {
        return assignedBuf;
    }

    public static void main(String[] args) {
        CreateArray array = new CreateArray(5);
        array.addElement(3);
        array.addElement(7);
        array.addElement(5);
        array.insertElement(1, 10);
        array.removeElement(2);
        array.addElement(5);
        array.addElement(9);
        System.out.println("배열 개수 : " + array.size());
        array.addElement(10);
    }
}
