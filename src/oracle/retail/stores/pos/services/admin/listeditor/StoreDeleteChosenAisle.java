/* ===========================================================================
* Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved. 
 * ===========================================================================
 * $Header: rgbustores/applications/pos/src/oracle/retail/stores/pos/services/admin/listeditor/StoreDeleteChosenAisle.java /rgbustores_13.4x_generic_branch/1 2011/05/05 14:06:04 mszekely Exp $
 * ===========================================================================
 * NOTES
 * <other useful comments, qualifications, etc.>
 *
 * MODIFIED    (MM/DD/YY)
 *    cgreene   05/26/10 - convert to oracle packaging
 *    abondala  01/03/10 - update header date
 *
 * ===========================================================================
 * $Log:
 *    3    360Commerce 1.2         3/31/2005 4:30:11 PM   Robert Pearse   
 *    2    360Commerce 1.1         3/10/2005 10:25:32 AM  Robert Pearse   
 *    1    360Commerce 1.0         2/11/2005 12:14:27 PM  Robert Pearse   
 *
 *   Revision 1.5  2004/09/23 00:07:13  kmcbride
 *   @scr 7211: Adding static serialVersionUIDs to all POS Serializable objects, minus the JComponents
 *
 *   Revision 1.4  2004/04/19 18:48:56  awilliam
 *   @scr 4374 Reason Code featrure work
 *
 *   Revision 1.3  2004/02/12 16:48:49  mcs
 *   Forcing head revision
 *
 *   Revision 1.2  2004/02/11 21:35:34  rhafernik
 *   @scr 0 Log4J conversion and code cleanup
 *
 *   Revision 1.1.1.1  2004/02/11 01:04:13  cschellenger
 *   updating to pvcs 360store-current
 *
 *
 * 
 *    Rev 1.0   Aug 29 2003 15:52:26   CSchellenger
 * Initial revision.
 * 
 *    Rev 1.0   Apr 29 2002 15:40:34   msg
 * Initial revision.
 * 
 *    Rev 1.1   Mar 18 2002 23:03:42   msg
 * - updated copyright
 * 
 *    Rev 1.0   Mar 18 2002 11:18:54   msg
 * Initial revision.
 * 
 *    Rev 1.1   20 Feb 2002 16:32:52   jbp
 * check if last reason code enabled.
 * Resolution for POS SCR-1338: Deleting Reason Code loses focus, selecting Delete again causes application to crash
 *
 *    Rev 1.0   Sep 21 2001 11:11:22   msg
 * Initial revision.
 *
 *    Rev 1.1   Sep 17 2001 13:05:24   msg
 * header update
 * ===========================================================================
 */
package oracle.retail.stores.pos.services.admin.listeditor;

import java.util.Vector;

import oracle.retail.stores.foundation.manager.ifc.UIManagerIfc;
import oracle.retail.stores.foundation.tour.application.Letter;
import oracle.retail.stores.foundation.tour.ifc.BusIfc;
import oracle.retail.stores.foundation.tour.ifc.LaneActionIfc;
import oracle.retail.stores.pos.services.PosLaneActionAdapter;
import oracle.retail.stores.pos.ui.POSUIManagerIfc;
import oracle.retail.stores.pos.ui.beans.ReasonCode;
import oracle.retail.stores.pos.ui.beans.ReasonCodeGroupBeanModel;
import oracle.retail.stores.pos.ui.beans.ReasonCodesCommon;

//------------------------------------------------------------------------------
/**
    Delete the reason code indicated by the user, if it is not the only one.

    @version $Revision: /rgbustores_13.4x_generic_branch/1 $
**/
//------------------------------------------------------------------------------

public class StoreDeleteChosenAisle
extends PosLaneActionAdapter
implements LaneActionIfc
{
    // This id is used to tell
    // the compiler not to generate a
    // new serialVersionUID.
    //
    static final long serialVersionUID = 3326190574352178672L;


    public static final String LANENAME = "StoreDeleteChosenAisle";

    //--------------------------------------------------------------------------
    /**
       Delete the reason code indicated by the user, if it is not the only one.
       @param bus the bus traversing this lane
    **/
    //--------------------------------------------------------------------------

    public void traverse(BusIfc bus)
    {
        Letter letter = null;

        POSUIManagerIfc ui
            = (POSUIManagerIfc)bus.getManager(UIManagerIfc.TYPE);
        ListEditorCargo cargo = (ListEditorCargo)bus.getCargo();
        cargo.setOperationRequested(bus.getCurrentLetter().getName());

        ReasonCodeGroupBeanModel model =
            (ReasonCodeGroupBeanModel)
            ui.getModel(cargo.getReasonCodeScreenToDisplay());

        int selectedIndex = model.getReasonCodeSelectionIndex();
        ReasonCodeGroupBeanModel reasonCodeGroup = cargo.getReasonCodeGroup();
        Vector reasonCodes = reasonCodeGroup.getReasonCodes();

        // Prepare to delete the reason code indicated by the user, if
        // it is not the only one enabled.
        Vector reasonCode = model.getReasonCodes();

        boolean deleteEnabled = false;
        int remainingEnabled = 0;

        for (int i=0; i<reasonCode.size(); i++)
        {
            ReasonCode code = (ReasonCode)reasonCode.elementAt(i);
            if (code.getEnabled())
            {
                // counts enabled reason codes
                remainingEnabled++;
            }
        }

        // delete if there is more than one reason code enabled
        if(remainingEnabled > 1)
        {
            ReasonCode reason
                = (ReasonCode)reasonCodes.elementAt(selectedIndex);
            cargo.setReasonCode(reason);
            letter = new Letter(ReasonCodesCommon.CONFIRM_DELETE);
        }
        // If it is the only reason code, notify the user
        else
        {
            letter = new Letter(ReasonCodesCommon.DELETE_FAILED);
        }
        bus.mail(letter, BusIfc.CURRENT);
    }


    //--------------------------------------------------------------------------
    /**
       Log the backing up.
       @param bus the bus traversing this lane
    **/
    //--------------------------------------------------------------------------

    public void backup(BusIfc bus)
    {
    }

}
