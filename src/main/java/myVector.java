import java.util.Arrays;

public class myVector<E> {

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] data;

    private int dataSize;

    private int capacityIncrement;

    public myVector(int initialCapacity, int capacityIncrement){
        super();
        if(initialCapacity < 0)
            System.out.println("Illegal capacity: " + initialCapacity);

        this.data = new Object[initialCapacity];
        dataSize = initialCapacity;
    }

    public myVector(int initialCapacity){
        this(initialCapacity, 0);
    }

    public myVector(){
        this(10);
    }

    public void PushDataAt(E data, int index){
        if(index > dataSize)
            System.out.println("qssdfa");

        if(dataSize + 1 - this.data.length > 0){
            if(dataSize + 1 - this.data.length > 0)
                Grow(dataSize + 1);
        }

        System.arraycopy(this.data, index, this.data, index + 1, dataSize - index);
        this.data[index] = data;
        dataSize++;
    }

    public void RemoveElementAt(int index){
        if(index >= dataSize)
            System.out.println("govno is popi");

        if(index < 0)
            System.out.println("polnoe govno");

        int i = dataSize - index - 1;
        if(i > 0)
            System.arraycopy(data, index + 1, data, index, i);

        dataSize--;
        data[dataSize] = null;
        System.gc();
    }

    public void RemoveTail(){
        RemoveElementAt(dataSize);
    }

    public void SetSize(int newSize){
        if(newSize > dataSize) {
            if (dataSize - this.data.length > 0) {
                if (dataSize + 1 - this.data.length > 0)
                    Grow(dataSize + 1);
            }
        } else {
            for(int i = newSize; i < dataSize; i++)
                data[i] = null;

            System.gc();
        }

        dataSize = newSize;
    }

    public void Clear(){
        for(int i = 0; i < dataSize; i++)
            data[i] = null;

        System.gc();
        dataSize = 0;
    }

    private void Grow(int minCapacity){

        int oldCapacity = data.length;
        int newCapacity = oldCapacity + ((capacityIncrement > 0)? capacityIncrement: oldCapacity);

        if(newCapacity - minCapacity < 0)
            newCapacity = minCapacity;

        if(newCapacity - MAX_ARRAY_SIZE > 0){
            if(minCapacity < 0)
                System.out.println("asd");

            newCapacity = ((minCapacity > MAX_ARRAY_SIZE)? Integer.MAX_VALUE: MAX_ARRAY_SIZE);
        }

        data = Arrays.copyOf(data, newCapacity);
    }

}
