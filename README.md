<a href="https://gitlab.com/mudiasoft/toolbox/-/pipelines" target="_blank"><img alt="pipeline status" src="https://gitlab.com/mudiasoft/toolbox/badges/develop/pipeline.svg" /></a> 
<a href="https://gitlab.com/mudiasoft/toolbox/-/jobs" target="_blank"><img alt="coverage report" src="https://gitlab.com/mudiasoft/toolbox/badges/develop/coverage.svg" /></a> 

# Toolbox

General-purpose utilities for Java projects


#### How to Use
1. Add GitLab package registry as maven repository

```xml
<repositories>
    <repository>
        <id>mudiasoft</id>
        <url>https://gitlab.com/api/v4/groups/64413151/-/packages/maven</url>
    </repository>
</repositories>
```

2. Add this project as maven dependency

```xml
<dependency>
    <groupId>com.gitlab.mudiasoft</groupId>
    <artifactId>toolbox</artifactId>
    <version>0.1.0-SNAPSHOT</version>
</dependency>
```
