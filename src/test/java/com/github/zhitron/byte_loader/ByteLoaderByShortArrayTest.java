package com.github.zhitron.byte_loader;

import org.junit.Test;

import static org.junit.Assert.*;

public class ByteLoaderByShortArrayTest {
    @Test
    public void testHasNextByteValueAndNextByteValue() throws Exception {
        short[] data = {0x1234, 0x5678};
        byte[] expected = new byte[]{(byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78};
        try (ByteLoader loader = ByteLoaderFactory.of(data, 3)) {
            for (byte b : expected) {
                assertTrue(loader.hasNextByteValue());
                assertEquals(b, loader.nextByteValue());
            }
            assertFalse(loader.hasNextByteValue());
        }
    }
}
