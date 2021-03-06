/* ===========================================================================
* Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved. 
 * ===========================================================================
 * $Header: rgbustores/applications/pos/src/oracle/retail/stores/pos/services/employee/clockentry/EntrySavedAisle.java /rgbustores_13.4x_generic_branch/1 2011/05/05 14:06:09 mszekely Exp $
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
 *    3    360Commerce 1.2         3/31/2005 4:28:06 PM   Robert Pearse   
 *    2    360Commerce 1.1         3/10/2005 10:21:30 AM  Robert Pearse   
 *    1    360Commerce 1.0         2/11/2005 12:10:56 PM  Robert Pearse   
 *
 *   Revision 1.3  2004/02/12 16:50:15  mcs
 *   Forcing head revision
 *
 *   Revision 1.2  2004/02/11 21:49:15  rhafernik
 *   @scr 0 Log4J conversion and code cleanup
 *
 *   Revision 1.1.1.1  2004/02/11 01:04:16  cschellenger
 *   updating to pvcs 360store-current
 *
 *
 * 
 *    Rev 1.0   Aug 29 2003 15:59:02   CSchellenger
 * Initial revision.
 * 
 *    Rev 1.1   Apr 11 2003 13:16:54   baa
 * remove usage of  deprecated EployeeIfc methods get/setName 
 * Resolution for POS SCR-2155: Deprecation warnings - EmployeeIfc
 * 
 *    Rev 1.0   Apr 29 2002 15:24:18   msg
 * Initial revision.
 * 
 *    Rev 1.0   Mar 18 2002 11:31:56   msg
 * Initial revision.
 * 
 *    Rev 1.1   29 Oct 2001 09:44:06   mpm
 * Changed message text to reflect employee's name.
 * Resolution for POS SCR-235: Employee clock-in, clock-out
 *
 *    Rev 1.0   28 Oct 2001 17:55:50   mpm
 * Initial revision.
 * Resolution for POS SCR-235: Employee clock-in, clock-out
 * ===========================================================================
 */
package oracle.retail.stores.pos.services.employee.clockentry;
// foundation imports
import oracle.retail.stores.foundation.manager.ifc.UIManagerIfc;
import oracle.retail.stores.foundation.tour.ifc.BusIfc;
import oracle.retail.stores.pos.services.PosLaneActionAdapter;
import oracle.retail.stores.pos.ui.DialogScreensIfc;
import oracle.retail.stores.pos.ui.POSUIManagerIfc;
import oracle.retail.stores.pos.ui.beans.DialogBeanModel;

//------------------------------------------------------------------------------
/**
    Issues acknowledgement that entry was saved successfully.
    @version $Revision: /rgbustores_13.4x_generic_branch/1 $
**/
//------------------------------------------------------------------------------
public class EntrySavedAisle  extends PosLaneActionAdapter
{

    //--------------------------------------------------------------------------
    /**
        Issues acknowledgement that entry was saved successfully.
        @param bus the bus traversing this lane
    **/
    //--------------------------------------------------------------------------
    public void traverse(BusIfc bus)
    {
        // get ui, cargo handles
        POSUIManagerIfc ui =
          (POSUIManagerIfc) bus.getManager(UIManagerIfc.TYPE);
        ClockEntryCargo cargo = (ClockEntryCargo) bus.getCargo();

        // set employee ID in args
        String[] args = new String[1];
        args[0] = cargo.getClockingEmployee().getPersonName().getFirstLastName();

        // set bean model
        DialogBeanModel model = new DialogBeanModel();
        model.setResourceID("SuccessfulClock");
        model.setArgs(args);
        model.setType(DialogScreensIfc.ACKNOWLEDGEMENT);

        // display dialog
        ui.showScreen(POSUIManagerIfc.DIALOG_TEMPLATE, model);

    }

}
