# fileutils-maven-plugin

fileutils-maven-plugin is a build plugin to perform some basic operation on text files.

## Goals Overview

fileutils-maven-plugin provides several goals.

+ fileutils-maven-plugin:concatFileList concatenate files content to an output file
+ fileutils-maven-plugin:concatDirContent concatenate files content to an output file
+ fileutils-maven-plugin:replace is a string replacement utility goal 
+ fileutils-maven-plugin:delete delete files

## Usage

Plugin configuration inside project's pom.xml can be performed throught several configuration blocks based on the goal
to be performed


    <project>
        <build>
            <plugins>
                <plugin>
                    <groupId>com.gesaracino.fileutilsmavenplugin</groupId>
                    <artifactId>fileutils-maven-plugin</artifactId>
                    <version>1.0-SNAPSHOT</version>
                    <configuration>
                        <concatFileList>
                        ...
                        </concatFileList>
                        <concatDirContent>
                        ...
                        </concatDirContent>
                        <replace>
                        ...
                        </replace>
                        <delete>
                        ...
                        </delete>
                    </configuration>
                </plugin>
            </plugins>
        </build>
    </project>

### fileutils-maven-plugin:concatFileList

    <concatFileList>
        <target>output.txt</target>
        <sources>
            <source>firstSource.txt</source>
            <source>secondSource.txt</source>
            ...
        </sources>
        <appendNewLine>true</appendNewLine>
    </concatFileList>

### fileutils-maven-plugin:concatDirContent

    <concatDirContent>
        <target>output.txt</target>
        <sourceDir>path\of\sourcedir</sourceDir>
        <appendNewLine>true</appendNewLine>
        <scanRecursively>true</scanRecursively>
        <excludeDirs>
            <excludeDir>path\of\sourcedir\subdir</excludeDir>
        </excludeDirs>
        <excludeDirsByName>
            <excludeDirByName>prd</excludeDirByName>
        </excludeDirsByName>
        <excludeFiles>
            <excludeFile>path\of\a\subdir\filetobeexcluded.txt</excludeFile>
        </excludeFiles>
        <excludeFilesByName>
            <excludeFileByName>out.txt</excludeFileByName>
        </excludeFilesByName>
        <order>ASC</order>
    </concatDirContent>
    
### fileutils-maven-plugin:replace

    <replace>
        <targets>
            <target>firstTarget.txt</target>
            <target>secondTarget.txt</target>
            ...
        </targets>
        <token>The token</token>
        <value>The value</value>
    </replace>

### fileutils-maven-plugin:delete

    <delete>
        <targets>
            <target>firstTarget.txt</target>
            <target>secondTarget.txt</target>
            ...
        </targets>
    </delete>
