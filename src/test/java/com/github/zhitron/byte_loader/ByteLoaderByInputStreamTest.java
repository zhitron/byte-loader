package com.github.zhitron.byte_loader;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class ByteLoaderByInputStreamTest {
    @Test
    public void test() throws Exception {
        byte[] data = "Hello from InputStream".getBytes();
        try (ByteLoader loader = ByteLoaderFactory.of(new ByteArrayInputStream(data), 3)) {
            for (byte b : data) {
                assertTrue(loader.hasNextByteValue());
                assertEquals(b, loader.nextByteValue());
            }
            assertFalse(loader.hasNextByteValue());
        }
    }
}
