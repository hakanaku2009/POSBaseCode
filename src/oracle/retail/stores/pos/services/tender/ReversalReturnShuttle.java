/* ===========================================================================
* Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved. 
 * ===========================================================================
 * $Header: rgbustores/applications/pos/src/oracle/retail/stores/pos/services/tender/ReversalReturnShuttle.java /rgbustores_13.4x_generic_branch/2 2011/07/20 14:39:05 blarsen Exp $
 * ===========================================================================
 * NOTES
 * <other useful comments, qualifications, etc.>
 *
 * MODIFIED    (MM/DD/YY)
 *    blarsen   07/19/11 - Changed to use the reversal service's new cargo
 *                         (ReversalCargo).
 *    blarsen   07/12/11 - Initial version.
 *
 *
 *
 * ===========================================================================
 */
package oracle.retail.stores.pos.services.tender;

import oracle.retail.stores.foundation.tour.ifc.BusIfc;
import oracle.retail.stores.foundation.tour.ifc.ShuttleIfc;
import oracle.retail.stores.pos.ado.context.ContextFactory;
import oracle.retail.stores.pos.ado.context.TourADOContext;
import oracle.retail.stores.pos.services.tender.reversal.ReversalCargo;


/**
 * Reversals are fire-and-forget.
 *
 * At this time there is no meaningful information to be returned by the reversal shuttle.
 */
public class ReversalReturnShuttle implements ShuttleIfc
{
    private static final long serialVersionUID = 7479300564024803927L;

    /* (non-Javadoc)
     * @see oracle.retail.stores.foundation.tour.ifc.ShuttleIfc#load(oracle.retail.stores.foundation.tour.ifc.BusIfc)
     */
    public void load(BusIfc bus)
    {
    }

    /* (non-Javadoc)
     * @see oracle.retail.stores.foundation.tour.ifc.ShuttleIfc#unload(oracle.retail.stores.foundation.tour.ifc.BusIfc)
     */
    public void unload(BusIfc bus)
    {
        // create TourADOContext and set it on the context factory
        ReversalCargo tenderCargo = (ReversalCargo)bus.getCargo();
        TourADOContext context = new TourADOContext(bus);
        context.setApplicationID(tenderCargo.getAppID());
        ContextFactory.getInstance().setContext(context);
    }

}
