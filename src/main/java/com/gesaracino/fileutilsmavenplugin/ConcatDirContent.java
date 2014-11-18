package com.gesaracino.fileutilsmavenplugin;

import com.gesaracino.fileutilsmavenplugin.config.ConcatDirContentConfig;
import com.gesaracino.fileutilsmavenplugin.filefilter.DirFilter;
import com.gesaracino.fileutilsmavenplugin.filefilter.NormalFileFilter;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.util.*;

/**
 * Created by Gerardo Saracino on 17/08/2014.
 */
@Mojo(name = "concatDirContent")
public class ConcatDirContent extends AbstractConcat<ConcatDirContentConfig> {
    private static final HashMap<ConcatDirContentConfig.Order, Comparator<File>> COMPARATORS = new HashMap<ConcatDirContentConfig.Order, Comparator<File>>() {
		private static final long serialVersionUID = -1730308922315098769L;

	{
        put(ConcatDirContentConfig.Order.ASC, new Comparator<File>() {
            
            public int compare(File o1, File o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        put(ConcatDirContentConfig.Order.DESC, new Comparator<File>() {
            
            public int compare(File o1, File o2) {
                return -1 * o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
    }};

    @Parameter(alias = "concatDirContent")
    private ConcatDirContentConfig concatDirContentConfig;

    @Override
    protected ConcatDirContentConfig getConcatConfig() {
        return concatDirContentConfig;
    }

    @Override
    protected List<File> getFiles() {
        List<File> files = retrieveFileList(concatDirContentConfig.getSourceDir());
        Collections.sort(files, COMPARATORS.get(concatDirContentConfig.getOrder()));
        return files;
    }

    private List<File> retrieveFileList(File dir) {
        File[] files = dir.listFiles(new NormalFileFilter(concatDirContentConfig.getExcludeFiles(), concatDirContentConfig.getExcludeFilesByName()));
        List<File> result = new ArrayList<File>(Arrays.asList(files));

        if(! concatDirContentConfig.isScanRecursively()) {
            return result;
        }

        File[] subdirs = dir.listFiles(new DirFilter(concatDirContentConfig.getExcludeDirs(), concatDirContentConfig.getExcludeDirsByName()));

        for(File subdir : subdirs) {
            result.addAll(retrieveFileList(subdir));
        }

        return result;
    }
}
