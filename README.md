# Byte Loader

## 📄 项目简介

`Byte Loader` 是一个轻量级但设计良好的字节加载与处理库，具有高度可扩展性和灵活性，便于集成到更复杂的系统中进行字节级别的精细控制和处理。按需加载和处理字节数据的工具库，主要目的是将多种类型的数据源转换为字节流，并提供统一的迭代接口进行访问。其核心功能是将不同形式的输入（如数组、缓冲区、流等）封装成 `ByteLoader` 实现类，通过缓存机制和缓冲区管理实现高效的字节读取。

---

## 🚀 快速开始

### 构建要求

- JDK 21 或以上（推荐使用 JDK 21）
- Maven 3.x

### 添加依赖

你可以通过 Maven 引入该项目：

```xml
<dependency>
    <groupId>com.github.zhitron</groupId>
    <artifactId>byte-loader</artifactId>
    <version>1.1.0</version>
</dependency>
```

###  使用案例

```java
package com.github.zhitron.byte_loader;

import org.junit.Test;

/**
 * @author zhitron
 */
public class ByteLoaderTest {

    public static void main(String[] args) throws Exception {
        byte[] data = "Hello, World!".getBytes();
        try (ByteLoader loader = ByteLoaderFactory.of(data, 3)) {
            for (byte b : data) {
                assertTrue(loader.hasNextByteValue());
                assertEquals(b, loader.nextByteValue());
            }
            assertFalse(loader.hasNextByteValue());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
```

---

## 🧩 功能特性

### 项目主要功能总结如下：

1. **统一字节加载接口**
    - 定义抽象类 `ByteLoader` 和方法 `load(ByteBuffer)`，作为所有具体实现的基础类。
    - 提供一致的 API 如 `hasNextByteValue()` 和 `nextByteValue()` 来遍历字节序列。
    - 提供一致的 API 如 `peek(offset)` 和 `pop(offset)` 来预先获取遍历字节序列。

2. **支持多种数据源**
   支持从以下数据结构或来源中加载并解析字节数据：
    - 原始数组：`byte[]`, `char[]`, `short[]`, `int[]`, `long[]`
    - 缓冲对象：`ByteBuffer`, `CharBuffer`
    - 输入流：`InputStream`, `Reader`, `ReadableByteChannel`
    - 文件路径：`File`, `Path`

3. **工厂类创建实例**
   使用 `ByteLoaderFactory` 提供静态方法，根据不同的数据源快速构建对应的 `ByteLoader` 实例。

4. **资源自动管理**
    - 所有 `ByteLoader` 实现类均实现了 `AutoCloseable` 接口，确保资源在使用完毕后可以正确关闭。

5. **高效缓冲机制**
    - 使用 `ByteBuffer.allocateDirect()` 创建直接缓冲区，提高 I/O 性能。
    - 在读取过程中采用标记 (`mark`) 和重置 (`reset`) 技术，实现非破坏性查看字节数据。

### 应用场景举例

该库适用于需要以统一方式处理各种字节输入源的场景，例如：
- 网络通信协议解析
- 文件格式解析器
- 自定义序列化/反序列化框架
- 字符编码转换工具

---

## ✍️ 开发者

- **Zhitron**
- 邮箱: zhitron@foxmail.com
- 组织: [Zhitron](https://github.com/zhitron)

---

## 📦 发布状态

当前版本：`1.1.0`

该项目已发布至 [Maven Central](https://search.maven.org/)，支持快照版本与正式版本部署。

---

## 🛠 源码管理

GitHub 地址：https://github.com/zhitron/byte-loader

使用 Git 进行版本控制：

```bash
git clone https://github.com/zhitron/byte-loader.git
```


---

## 📚 文档与社区

- Javadoc 文档可通过 `mvn javadoc:javadoc` 生成。
- 如有问题或贡献，请提交 Issues 或 PR 至 GitHub 仓库。

---

## 📎 License

Apache License, Version 2.0  
详见 [LICENSE](https://www.apache.org/licenses/LICENSE-2.0.txt)

---
