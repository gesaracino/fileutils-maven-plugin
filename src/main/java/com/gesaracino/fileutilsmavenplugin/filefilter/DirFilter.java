package com.gesaracino.fileutilsmavenplugin.filefilter;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

/**
 * Created by Gerardo Saracino on 16/08/2014.
 */
public class DirFilter implements FileFilter {
    private List<File> excludeDirs;
    private List<String> excludeDirsByName;

    public DirFilter(List<File> excludeDirs, List<String> excludeDirsByName) {
        this.excludeDirs = excludeDirs;
        this.excludeDirsByName = excludeDirsByName;
    }
    
    public boolean accept(File file) {
        if(! file.isDirectory()) {
            return false;
        }

        if(excludeDirs != null && excludeDirs.contains(file)) {
            return false;
        }

        if(excludeDirsByName != null && excludeDirsByName.contains(file.getName())) {
            return false;
        }

        return true;
    }
}
