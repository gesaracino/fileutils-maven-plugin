package com.gesaracino.fileutilsmavenplugin.config;

import java.io.File;
import java.util.List;

/**
 * Created by Gerardo Saracino on 15/08/2014.
 */
public class ConcatDirContentConfig extends AbstractConcatConfig {
    public static enum Order {
        ASC,
        DESC
    }

    private File sourceDir;
    private boolean scanRecursively;
    private List<File> excludeDirs;
    private List<String> excludeDirsByName;
    private List<File> excludeFiles;
    private List<String> excludeFilesByName;
    private Order order = Order.ASC;

    public File getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(File sourceDir) {
        this.sourceDir = sourceDir;
    }

    public boolean isScanRecursively() {
        return scanRecursively;
    }

    public void setScanRecursively(boolean scanRecursively) {
        this.scanRecursively = scanRecursively;
    }

    public List<File> getExcludeDirs() {
        return excludeDirs;
    }

    public void setExcludeDirs(List<File> excludeDirs) {
        this.excludeDirs = excludeDirs;
    }

    public List<String> getExcludeDirsByName() {
        return excludeDirsByName;
    }

    public void setExcludeDirsByName(List<String> excludeDirsByName) {
        this.excludeDirsByName = excludeDirsByName;
    }

    public List<File> getExcludeFiles() {
        return excludeFiles;
    }

    public void setExcludeFiles(List<File> excludeFiles) {
        this.excludeFiles = excludeFiles;
    }

    public List<String> getExcludeFilesByName() {
        return excludeFilesByName;
    }

    public void setExcludeFilesByName(List<String> excludeFilesByName) {
        this.excludeFilesByName = excludeFilesByName;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ConcatDirContentConfig{" +
                "sourceDir=" + sourceDir +
                ", scanRecursively=" + scanRecursively +
                ", excludeDirs=" + excludeDirs +
                ", excludeDirsByName=" + excludeDirsByName +
                ", excludeFiles=" + excludeFiles +
                ", excludeFilesByName=" + excludeFilesByName +
                ", order=" + order +
                '}';
    }
}
