package notes.cafe24;

import java.io.IOException;

public class ThrowableFake {

    public static void main(String[] args) {

    }

    void exception() throws IOException {
        throw new IOException();
    }
}
