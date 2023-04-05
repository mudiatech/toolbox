<a href="https://gitlab.com/mudiasoft/mob/toolbox/-/pipelines" target="_blank"><img alt="pipeline status" src="https://gitlab.com/mudiasoft/mob/toolbox/badges/develop/pipeline.svg" /></a> 
<a href="https://gitlab.com/mudiasoft/mob/toolbox/-/jobs" target="_blank"><img alt="coverage report" src="https://gitlab.com/mudiasoft/mob/toolbox/badges/develop/coverage.svg" /></a> 

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
    <groupId>com.gitlab.mudiasoft.mob</groupId>
    <artifactId>toolbox</artifactId>
    <version>0.2.0-SNAPSHOT</version>
</dependency>
```
