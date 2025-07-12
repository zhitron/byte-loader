package com.github.zhitron.byte_loader;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import static org.junit.Assert.*;

public class ByteLoaderByReadableByteChannelTest {
    @Test
    public void test() throws Exception {
        byte[] expected = "Hello from ReadableByteChannel".getBytes();
        ReadableByteChannel data = Channels.newChannel(new ByteArrayInputStream(expected));
        try (ByteLoader loader = ByteLoaderFactory.of(data, 3)) {
            for (byte b : expected) {
                assertTrue(loader.hasNextByteValue());
                assertEquals(b, loader.nextByteValue());
            }
            assertFalse(loader.hasNextByteValue());
        }
    }
}
