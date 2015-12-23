/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.common.util.StreamUtil.java is created on 2008-1-30
 */
package org.feitian.chat.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.feitian.chat.exception.FChatException;

/**
 * 
 */
public class StreamUtil {

    private static final FChatLogger logger = FChatLogger.getLogger(StreamUtil.class);

    public final static InputStream getInputStreamFromClassPath(String fileName) {

        return StreamUtil.class.getResourceAsStream(fileName);
    }

    public static InputStream getInputStreamFromAbosulateClassPath(String messageFile) throws FChatException {

        FileInputStream fins = null;
        try {
            fins = new FileInputStream(messageFile);
        } catch (FileNotFoundException e) {

            SystemUtil.rethrowException(logger, "Failed to find the file [filePath=" + messageFile + "]", e);
        }
        return fins;
    }

    public static void close(InputStream ins) throws FChatException {

        if (ins != null)
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
                SystemUtil.rethrowException(logger, "Failed to close the specified InputStream", e);
            }

    }

}
