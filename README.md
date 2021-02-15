[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/mauriciotogneri/mockserver-java/blob/master/LICENSE.md)

# Mock Server
A mock server for Java.

### Maven

Add the following code to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

And the dependency:

```xml
<dependency>
    <groupId>com.mauriciotogneri</groupId>
    <artifactId>mockserver</artifactId>
    <version>4.9.1</version>
</dependency>
```

### Gradle

Add the following code to your root `build.gradle`:

```groovy
allprojects
{
    repositories
    {
        maven
        {
            url 'https://jitpack.io'
        }
    }
}
```

Add the following code to your module `build.gradle`:
```groovy
implementation 'com.github.mauriciotogneri:mockserver:4.9.1'
```