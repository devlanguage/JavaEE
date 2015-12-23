/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.feitian.pwdp.parser.PasswordParser.java is created on 2007-10-19 上午10:07:13
 */
package org.feitian.pwdp.parser;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.feitian.pwdp.common.data.Constants;
import org.feitian.pwdp.persistence.Password;
import org.feitian.pwdp.util.BasicException;
import org.feitian.pwdp.util.DomUtil;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 
 */
public class PasswordParser {

    static Map<String, Password> passwordMap = new HashMap<String, Password>();

    public final static String ELEMENT_PASSWORD = "password";
    public final static String ELEMENT_ID = "id";
    public final static String ELEMENT_NAME = "name";
    public final static String ELEMENT_VALUE = "value";
    public final static String ELEMENT_USAGE = "usage";
    public final static String ELEMENT_DESCRIPTION = "description";

    public final static String ATTR_SKIP = "skip";

    static {
        try {

            Element passwords = DomUtil.getRootNode(PasswordParser.class.getClassLoader()
                    .getResourceAsStream(Constants.PASSWORD_SOURCE_DATA_FILE));
            NodeList layerNodes = DomUtil.getNodeList(passwords, ELEMENT_PASSWORD);
            for (int i = 0; i < layerNodes.getLength(); i++) {
                Element layerRateElement = (Element) layerNodes.item(i);
                boolean skip = Boolean.parseBoolean(layerRateElement.getAttribute(ATTR_SKIP));
                if (skip) {
                    continue;
                }

                Password password = new Password();
                password.setId(DomUtil.getNodeValue(layerRateElement, ELEMENT_ID));
                password.setName(DomUtil.getNodeValue(layerRateElement, ELEMENT_NAME));
                password.setValue(DomUtil.getNodeValue(layerRateElement, ELEMENT_VALUE));
                password.setUsage(DomUtil.getNodeValue(layerRateElement, ELEMENT_USAGE));
                password
                        .setDescription(DomUtil.getNodeValue(layerRateElement, ELEMENT_DESCRIPTION));

                passwordMap.put(password.getId(), password);

            }
        } catch (BasicException e) {
            e.printStackTrace();
        }
    }

    public final static Collection<Password> getPasswords() {

        return passwordMap.values();
    }

}