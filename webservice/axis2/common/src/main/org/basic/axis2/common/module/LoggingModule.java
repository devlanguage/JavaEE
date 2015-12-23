/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.axis2.common.module.LoggingModule.java is created on 2008-2-19
 */
package org.basic.axis2.common.module;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.description.AxisDescription;
import org.apache.axis2.description.AxisModule;
import org.apache.neethi.Assertion;
import org.apache.neethi.Policy;

public class LoggingModule implements org.apache.axis2.modules.Module {

    /*
     * The first three methods can be used to control the module initialization and the termination,
     */
    public void engageNotify(AxisDescription axisDescription) throws AxisFault {

    }

    public void init(ConfigurationContext configContext, AxisModule module) throws AxisFault {
 
    }

    public void shutdown(ConfigurationContext configurationContext) throws AxisFault {

    }

    /*
     * the next three methods are used to perform policy related operations
     */

    public void applyPolicy(Policy policy, AxisDescription axisDescription) throws AxisFault {

    }

    public boolean canSupportAssertion(Assertion assertion) {

        return false;
    }

}
