/* ===========================================================================
* Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved. 
 * ===========================================================================
 * $Header: rgbustores/applications/pos/src/oracle/retail/stores/pos/services/manager/registerreports/DateRangeReportSite.java /rgbustores_13.4x_generic_branch/1 2011/05/05 14:06:11 mszekely Exp $
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
 *    3    360Commerce 1.2         3/31/2005 4:27:41 PM   Robert Pearse   
 *    2    360Commerce 1.1         3/10/2005 10:20:49 AM  Robert Pearse   
 *    1    360Commerce 1.0         2/11/2005 12:10:29 PM  Robert Pearse   
 *
 *   Revision 1.3  2004/02/12 16:50:59  mcs
 *   Forcing head revision
 *
 *   Revision 1.2  2004/02/11 21:51:46  rhafernik
 *   @scr 0 Log4J conversion and code cleanup
 *
 *   Revision 1.1.1.1  2004/02/11 01:04:17  cschellenger
 *   updating to pvcs 360store-current
 *
 *
 * 
 *    Rev 1.0   Aug 29 2003 16:01:18   CSchellenger
 * Initial revision.
 * 
 *    Rev 1.1   Aug 07 2002 19:33:58   baa
 * remove hard coded date formats
 * Resolution for POS SCR-1740: Code base Conversions
 * 
 *    Rev 1.0   Apr 29 2002 15:18:56   msg
 * Initial revision.
 * 
 *    Rev 1.0   Mar 18 2002 11:36:30   msg
 * Initial revision.
 * 
 *    Rev 1.1   05 Mar 2002 20:30:10   pdd
 * Made default date the current business date.
 * Resolution for POS SCR-259: Date Range Report screens default date is the system date s/b current biz date
 * 
 *    Rev 1.0   Sep 21 2001 11:24:04   msg
 * Initial revision.
 * 
 *    Rev 1.1   Sep 17 2001 13:12:14   msg
 * header update
 * ===========================================================================
 */
package oracle.retail.stores.pos.services.manager.registerreports;

// Foundation imports
import oracle.retail.stores.domain.financial.StoreStatusIfc;
import oracle.retail.stores.domain.utility.EYSDate;
import oracle.retail.stores.foundation.manager.ifc.UIManagerIfc;
import oracle.retail.stores.foundation.tour.ifc.BusIfc;
import oracle.retail.stores.pos.services.PosSiteActionAdapter;
import oracle.retail.stores.pos.ui.POSUIManagerIfc;
import oracle.retail.stores.pos.ui.beans.DateRangeReportBeanModel;

//------------------------------------------------------------------------------
/**
    Get the date range from the User.

    @version $Revision: /rgbustores_13.4x_generic_branch/1 $
**/
//------------------------------------------------------------------------------
public class DateRangeReportSite extends PosSiteActionAdapter
{
    // Class name
    public static final String SITENAME = "DateRangeReportSite";

    //--------------------------------------------------------------------------
    /**
       Put up the date range form screen.

       @param bus the bus arriving at this site
    **/
    //--------------------------------------------------------------------------
    public void arrive(BusIfc bus)
    {
        POSUIManagerIfc ui = (POSUIManagerIfc) bus.getManager(UIManagerIfc.TYPE);
        RegisterReportsCargo cargo = (RegisterReportsCargo) bus.getCargo();
        DateRangeReportBeanModel model = new DateRangeReportBeanModel();
        StoreStatusIfc store = cargo.getStoreStatus();

        if (store != null)
        {
            EYSDate startDate = store.getBusinessDate();
            
            if (startDate != null)
            {
                model.setStartBusinessDate(startDate);
                model.setEndBusinessDate(startDate);
            }
        }

        ui.showScreen(POSUIManagerIfc.DATE_RANGE_REPORT, model);
    }
}
