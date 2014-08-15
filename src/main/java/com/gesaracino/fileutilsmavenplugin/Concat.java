package com.gesaracino.fileutilsmavenplugin;

import com.gesaracino.fileutilsmavenplugin.config.ConcatConfig;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Gerardo Saracino on 15/08/2014.
 */
@Mojo(name = "concat")
public class Concat extends AbstractMojo {
    private static final int BUFFER_SIZE = 8192;

    private Log LOGGER = getLog();

    @Parameter(alias = "concat")
    private ConcatConfig concatConfig;

    public void execute() throws MojoExecutionException {
        LOGGER.info(concatConfig.toString());

        BufferedWriter writer = null;
        char[] buffer = new char[BUFFER_SIZE];

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(concatConfig.getTarget()), Charset.defaultCharset()));

            for(File sourceFile : concatConfig.getSources()) {
                BufferedReader reader = null;

                try {
                    reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile), Charset.defaultCharset()));
                    int n = 0;

                    while ((n = reader.read(buffer, 0, BUFFER_SIZE)) > -1) {
                        writer.write(buffer, 0, n);
                    }

                    if(concatConfig.isAppendNewLine()) {
                        writer.newLine();
                    }
                } finally {
                    if(reader != null) {
                        reader.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }
}
