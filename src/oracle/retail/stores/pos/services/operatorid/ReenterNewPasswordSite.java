/* ===========================================================================
* Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved. 
 * ===========================================================================
 * $Header: rgbustores/applications/pos/src/oracle/retail/stores/pos/services/operatorid/ReenterNewPasswordSite.java /rgbustores_13.4x_generic_branch/1 2011/05/05 14:06:02 mszekely Exp $
 * ===========================================================================
 * NOTES
 * <other useful comments, qualifications, etc.>
 *
 * MODIFIED    (MM/DD/YY)
 *    cgreene   05/26/10 - convert to oracle packaging
 *
 * ===========================================================================
 * $Log:
 *3    360Commerce 1.2         3/31/2005 4:29:36 PM   Robert Pearse   
 *2    360Commerce 1.1         3/10/2005 10:24:36 AM  Robert Pearse   
 *1    360Commerce 1.0         2/11/2005 12:13:36 PM  Robert Pearse   
 *
 Revision 1.2  2004/07/22 16:36:41  rsachdeva
 @scr 6394 default to none
 *
 Revision 1.1  2004/02/13 16:35:20  jriggins
 @scr 3782 Initial revision
 *
 * ===========================================================================
 */
package oracle.retail.stores.pos.services.operatorid;

import oracle.retail.stores.foundation.manager.ifc.UIManagerIfc;
import oracle.retail.stores.foundation.tour.ifc.BusIfc;
import oracle.retail.stores.pos.services.PosSiteActionAdapter;
import oracle.retail.stores.pos.ui.POSUIManagerIfc;
import oracle.retail.stores.pos.ui.beans.POSBaseBeanModel;

/**
 * Handles case where the employee needs to reenter (for consistency) a new password for 
 * his/her account.
 */
public class ReenterNewPasswordSite extends PosSiteActionAdapter
{
    /**
     * revision number of this class 
     */
    public static String revisionNumber = "$Revision: /rgbustores_13.4x_generic_branch/1 $";
    
    /**
     * Handles case where the employee needs to reenter (for consistency) a new password for 
     * his/her account.
     */    
    public void arrive(BusIfc bus)
    {
        // Show the REENTER_NEW_PASSWORD screen
        POSUIManagerIfc uiManager = (POSUIManagerIfc)bus.getManager(UIManagerIfc.TYPE);
        uiManager.showScreen(POSUIManagerIfc.REENTER_NEW_PASSWORD, new POSBaseBeanModel());
        
    }
}
