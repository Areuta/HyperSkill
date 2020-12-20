import java.util.*;

class AsciiCharSequence implements CharSequence {
    private byte[] bytes;
    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes.clone();
    }

    @Override
    public int length() {
        return this.bytes.length;
    }

    @Override
    public char charAt(int i) {
        return (char) this.bytes[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] bytes = Arrays.copyOfRange(this.bytes, i, i1);
        return new AsciiCharSequence(bytes);
    }

    @Override
    public String toString() {
        return new String(bytes);
    }

/*    public static void main(String[] args) {
        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(new byte[]{100, 110, 34, 56, 54});
        System.out.println(asciiCharSequence.toString());
    }*/
}