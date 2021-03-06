/* ===========================================================================
* Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved. 
 * ===========================================================================
 * $Header: rgbustores/applications/pos/src/oracle/retail/stores/pos/services/dailyoperations/endofday/SuspendedTransactionsReportPromptSite.java /rgbustores_13.4x_generic_branch/1 2011/05/05 14:06:22 mszekely Exp $
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
 *    3    360Commerce 1.2         3/31/2005 4:30:17 PM   Robert Pearse   
 *    2    360Commerce 1.1         3/10/2005 10:25:42 AM  Robert Pearse   
 *    1    360Commerce 1.0         2/11/2005 12:14:36 PM  Robert Pearse   
 *
 *   Revision 1.3  2004/02/12 16:49:37  mcs
 *   Forcing head revision
 *
 *   Revision 1.2  2004/02/11 21:46:17  rhafernik
 *   @scr 0 Log4J conversion and code cleanup
 *
 *   Revision 1.1.1.1  2004/02/11 01:04:15  cschellenger
 *   updating to pvcs 360store-current
 *
 *
 * 
 *    Rev 1.0   Aug 29 2003 15:56:34   CSchellenger
 * Initial revision.
 * 
 *    Rev 1.0   Apr 29 2002 15:31:28   msg
 * Initial revision.
 * 
 *    Rev 1.1   Mar 18 2002 23:14:04   msg
 * - updated copyright
 * 
 *    Rev 1.0   Mar 18 2002 11:26:50   msg
 * Initial revision.
 * 
 *    Rev 1.0   Sep 21 2001 11:16:24   msg
 * Initial revision.
 * 
 *    Rev 1.1   Sep 17 2001 13:07:18   msg
 * header update
 * ===========================================================================
 */
package oracle.retail.stores.pos.services.dailyoperations.endofday;

// foundation imports
import oracle.retail.stores.foundation.manager.ifc.UIManagerIfc;
import oracle.retail.stores.foundation.tour.ifc.BusIfc;
import oracle.retail.stores.pos.services.PosSiteActionAdapter;
import oracle.retail.stores.pos.ui.DialogScreensIfc;
import oracle.retail.stores.pos.ui.POSUIManagerIfc;
import oracle.retail.stores.pos.ui.beans.DialogBeanModel;

//--------------------------------------------------------------------------
/**
    Displays suspended transactions report prompt dialog. <P>
    @version $Revision: /rgbustores_13.4x_generic_branch/1 $
**/
//--------------------------------------------------------------------------
public class SuspendedTransactionsReportPromptSite extends PosSiteActionAdapter
{                                                                               // begin class SuspendedTransactionsReportPromptSite
    /**
        revision number
    **/
    public static final String revisionNumber = "$Revision: /rgbustores_13.4x_generic_branch/1 $";
        /**
                site name constant
        **/
    public static final String SITENAME = "SuspendedTransactionsReportPromptSite";

    //----------------------------------------------------------------------
    /**
        Displays suspended transactions report prompt dialog. <P>
        @param bus the bus traversing this lane
    **/
    //----------------------------------------------------------------------
    public void arrive(BusIfc bus)
    {                                                                   // begin arrive()
        // get ui handle
        POSUIManagerIfc ui = (POSUIManagerIfc) bus.getManager(UIManagerIfc.TYPE);

        // set bean model
        DialogBeanModel model = new DialogBeanModel();
        model.setResourceID("StoreCloseSuspendedTransactionsReportPrompt");
        model.setType(DialogScreensIfc.CONFIRMATION);
        ui.showScreen(POSUIManagerIfc.DIALOG_TEMPLATE, model);
    }                                                                   // end arrive()

    //----------------------------------------------------------------------
    /**
        Returns a string representation of the object. <P>
        @return String representation of object
    **/
    //----------------------------------------------------------------------
    public String toString()
    {                                   // begin toString()
        // result string
        StringBuffer strResult = new StringBuffer("Class:  ");
        strResult.append(SITENAME).append(" (Revision ")
                 .append(getRevisionNumber()).append(") ")
                                 .append(hashCode());
        // pass back result
        return(strResult.toString());
    }                                   // end toString()

    //----------------------------------------------------------------------
    /**
        Returns the revision number of the class. <P>
        @return String representation of revision number
    **/
    //----------------------------------------------------------------------
    public String getRevisionNumber()
    {
        return(revisionNumber);
    }
}                                                                               // end class SuspendedTransactionsReportPromptSite
