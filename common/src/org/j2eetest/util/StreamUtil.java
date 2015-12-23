/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.hibernate3.common.util.StreamUtil.java is created on 2008-1-30
 */
package org.j2eetest.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eetest.exception.BaseException;


public class StreamUtil {

    private static final Log logger = LogFactory.getLog(StreamUtil.class);

    /**
     * Build the <code>InputStream</code> on the specified the file. file path is relative path
     * located in classs path. for example: org/basic/common/config.properties
     * 
     * @param messageFile
     * @return
     * @throws BaseException
     */
    public final static InputStream getInputStreamFromClassPath(String fileName) {

        return StreamUtil.class.getClassLoader().getResourceAsStream(fileName);
    }

    /**
     * Build the <code>InputStream</code> on the specified the file. file path is absolute path
     * located in operating system. for example:
     * C:\\Software\\eclipse3.2.2\\workspace\\basic\\source\\common\\src\\main\\build.properties
     * 
     * @param messageFile
     * @return
     * @throws BaseException
     */
    public static InputStream getInputStreamFromAbosulateClassPath(String messageFile)
            throws BaseException {

        FileInputStream fins = null;
        try {
            fins = new FileInputStream(messageFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
//            throw SystemUtil.handleException(logger, e, "Failed to find the file [filePath="
//                    + messageFile + "]");
        }
        return fins;
    }

    public static void close(InputStream ins) throws BaseException {

        if (ins != null)
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
//                throw SystemUtil.handleException(logger, e,
//                        "Failed to close the specified InputStream");
            }

    }
    public static void main(String[] args) {

        logger.info("sadf");
    }

}
