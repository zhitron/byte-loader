package com.github.zhitron.byte_loader;

import org.junit.Test;

import java.io.CharArrayReader;
import java.io.Reader;

import static org.junit.Assert.*;

public class ByteLoaderByReaderTest {
    @Test
    public void testHasNextByteValueAndNextByteValue() throws Exception {
        Reader data = new CharArrayReader("Hello".toCharArray());
        byte[] expected = new byte[]{0x00, 'H', 0x00, 'e', 0x00, 'l', 0x00, 'l', 0x00, 'o'};
        try (ByteLoader loader = ByteLoaderFactory.of(data, 3)) {
            for (byte b : expected) {
                assertTrue(loader.hasNextByteValue());
                assertEquals(b, loader.nextByteValue());
            }
            assertFalse(loader.hasNextByteValue());
        }
    }
}
