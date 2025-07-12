package com.github.zhitron.byte_loader;

import org.junit.Test;

import java.nio.ByteBuffer;

import static org.junit.Assert.*;

public class ByteLoaderByByteBufferTest {
    @Test
    public void test() throws Exception {
        byte[] data = "Hello from ByteBuffer".getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(data);
        try (ByteLoader loader = ByteLoaderFactory.of(data, 3)) {
            for (byte b : data) {
                assertTrue(loader.hasNextByteValue());
                assertEquals(b, loader.nextByteValue());
            }
            assertFalse(loader.hasNextByteValue());
        }
    }
}
