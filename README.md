[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/mauriciotogneri/mockserver/blob/master/LICENSE.md)
[![Download](https://api.bintray.com/packages/mauriciotogneri/maven/mockserver/images/download.svg)](https://bintray.com/mauriciotogneri/maven/mockserver/_latestVersion)

# Mock Server
A mock server for Java.

## Installation

Add the following code to your **pom.xml**:

```xml
<repositories>
    <repository>
        <id>jcenter</id>
        <url>https://jcenter.bintray.com</url>
    </repository>
</repositories>
```

and the dependency:

```xml
<dependency>
    <groupId>com.mauriciotogneri</groupId>
    <artifactId>mockserver</artifactId>
    <version>1.5.0</version>
</dependency>
```

or if you use Gradle:

```groovy
dependencies
{
    implementation 'com.mauriciotogneri:mockserver:1.5.0'
}
```