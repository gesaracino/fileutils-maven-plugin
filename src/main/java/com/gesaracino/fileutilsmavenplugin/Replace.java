package com.gesaracino.fileutilsmavenplugin;

import com.gesaracino.fileutilsmavenplugin.config.ReplaceConfig;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Gerardo Saracino on 15/08/2014.
 */
@Mojo(name = "replace")
public class Replace extends AbstractMojo {
    private static final int BUFFER_SIZE = 8192;

    private Log LOGGER = getLog();

    @Parameter(alias = "replace")
    private ReplaceConfig replaceConfig;
    
    public void execute() throws MojoExecutionException, MojoFailureException {
        LOGGER.info(replaceConfig.toString());

        try {
            for(File targetFile : replaceConfig.getTargets()) {
                BufferedReader reader = null;
                char[] buffer = new char[BUFFER_SIZE];
                String content = null;

                try {
                    reader = new BufferedReader(new InputStreamReader(new FileInputStream(targetFile), Charset.defaultCharset()));
                    StringBuilder builder = new StringBuilder();
                    int n = 0;

                    while ((n = reader.read(buffer, 0, BUFFER_SIZE)) > -1) {
                        builder.append(buffer, 0, n);
                    }

                    content = builder.toString();
                } finally {
                    if(reader != null) {
                        reader.close();
                    }
                }

                BufferedWriter writer = null;

                try {
                    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile), Charset.defaultCharset()));
                    writer.write(content.replace(replaceConfig.getToken(), replaceConfig.getValue()));
                } finally {
                    if(writer != null) {
                        writer.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
            throw new MojoFailureException(e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new MojoFailureException(e.getMessage(), e);
        }
    }
}
