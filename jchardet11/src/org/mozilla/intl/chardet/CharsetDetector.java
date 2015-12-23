package org.mozilla.intl.chardet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * <pre>
 *
 * </pre>
 */
public class CharsetDetector {

    private boolean found = false;
    private String result;
    private int lang;

    public String[] detectChineseCharset(InputStream in) throws IOException {
        lang = nsPSMDetector.CHINESE;
        String[] prob;
        // Initalize the nsDetector() ;
        nsDetector det = new nsDetector(lang);
        // Set an observer...
        // The Notify() will be called when a matching charset is found.

        det.Init(new nsICharsetDetectionObserver() {

            public void Notify(String charset) {
                found = true;
                result = charset;
            }
        });
        BufferedInputStream imp = new BufferedInputStream(in);
        byte[] buf = new byte[1024];
        int len;
        boolean isAscii = true;
        while ((len = imp.read(buf, 0, buf.length)) != -1) {
            // Check if the stream is only ascii.
            if (isAscii)
                isAscii = det.isAscii(buf, len);
            // DoIt if non-ascii and not done yet.
            if (!isAscii) {
                if (det.DoIt(buf, len, false))
                    break;
            }
        }
        imp.close();
        in.close();
        det.DataEnd();
        if (isAscii) {
            found = true;
            prob = new String[] { "ASCII" };
        }
        else if (found) {
            prob = new String[] { result };
        }
        else {
            prob = det.getProbableCharsets();
        }
        return prob;
    }

    public String[] detectAllCharset(InputStream in) throws IOException {
        try {
            lang = nsPSMDetector.ALL;
            return detectChineseCharset(in);
        } catch (IOException e) {
            throw e;
        }
    }

    public static void main(String[] args) throws IOException {

        CharsetDetector charDect = new CharsetDetector();
        URL url = new URL("http://www.oschina.net/");
        String[] probableSet = charDect.detectChineseCharset(url.openStream());
        for (String charset : probableSet) {
            System.out.println(charset);
        }
    }
}
