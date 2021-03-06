/* ===========================================================================
* Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved. 
 * ===========================================================================
 * $Header: rgbustores/applications/pos/src/oracle/retail/stores/pos/device/ScannerActionGroupIfc.java /rgbustores_13.4x_generic_branch/1 2011/05/05 14:05:39 mszekely Exp $
 * ===========================================================================
 * NOTES
 * <other useful comments, qualifications, etc.>
 *
 * MODIFIED    (MM/DD/YY)
 *    cgreene   05/27/10 - convert to oracle packaging
 *    cgreene   05/26/10 - convert to oracle packaging
 *    abondala  01/03/10 - update header date
 *
 * ===========================================================================
 * $Log:
 *    3    360Commerce 1.2         3/31/2005 4:29:50 PM   Robert Pearse   
 *    2    360Commerce 1.1         3/10/2005 10:25:04 AM  Robert Pearse   
 *    1    360Commerce 1.0         2/11/2005 12:14:04 PM  Robert Pearse   
 *
 *   Revision 1.3  2004/02/12 16:48:34  mcs
 *   Forcing head revision
 *
 *   Revision 1.2  2004/02/11 21:30:29  rhafernik
 *   @scr 0 Log4J conversion and code cleanup
 *
 *   Revision 1.1.1.1  2004/02/11 01:04:13  cschellenger
 *   updating to pvcs 360store-current
 *
 *
 * 
 *    Rev 1.0   Oct 20 2003 09:06:12   rsachdeva
 * Initial revision.
 * Resolution for POS SCR-3411: Feature Enhancement:  Device and Database Status
 * ===========================================================================
 */
package oracle.retail.stores.pos.device;

//foundation imports
import oracle.retail.stores.foundation.manager.device.DeviceException;
import oracle.retail.stores.foundation.manager.ifc.device.DeviceActionGroupIfc;

//--------------------------------------------------------------------------
/**
The <code>ScannerActionGroupIfc</code> defines the Scanner specific
device operations available to POS applications.
<p>
@version $Revision: /rgbustores_13.4x_generic_branch/1 $
**/
//--------------------------------------------------------------------------
public interface ScannerActionGroupIfc extends DeviceActionGroupIfc
{
    /**
       revision number supplied by source-code-control system
    **/
    public static final String revisionNumber = "$Revision: /rgbustores_13.4x_generic_branch/1 $";
    /**
       type of action group 
    **/
    public static final String TYPE = "ScannerActionGroupIfc";
    //--------------------------------------------------------------------------
    /**
        Determines if Scanner is online. <P>
        @return Boolean indicator that Scanner is online.
    **/
    //--------------------------------------------------------------------------
    public Boolean isScannerOnline() throws DeviceException;
}


