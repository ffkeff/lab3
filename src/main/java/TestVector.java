public class TestVector {

    public static void main(String[] args){
        var v = new myVector<String>(32);
        v.PushDataAt("string", 1);
        for(int x = 0; x < 32; x++)
            v.PushDataAt(String.valueOf(x), x);
    }
}
