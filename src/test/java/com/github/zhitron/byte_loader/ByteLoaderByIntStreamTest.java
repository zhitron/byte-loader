package com.github.zhitron.byte_loader;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class ByteLoaderByIntStreamTest {
    @Test
    public void test() throws Exception {
        int[] data = {0x12345678, 0x9ABCDEF0};
        byte[] expected = new byte[]{
                (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78,
                (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0
        };
        try (ByteLoader loader = ByteLoaderFactory.of(IntStream.of(data), 4)) {
            for (byte b : expected) {
                assertTrue(loader.hasNextByteValue());
                assertEquals(b, loader.nextByteValue());
            }
            assertFalse(loader.hasNextByteValue());
        }
    }
}
