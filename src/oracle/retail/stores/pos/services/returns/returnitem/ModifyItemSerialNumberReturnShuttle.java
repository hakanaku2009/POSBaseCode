/* ===========================================================================
* Copyright (c) 2010, 2011, Oracle and/or its affiliates. All rights reserved. 
 * ===========================================================================
 * $Header: rgbustores/applications/pos/src/oracle/retail/stores/pos/services/returns/returnitem/ModifyItemSerialNumberReturnShuttle.java /rgbustores_13.4x_generic_branch/1 2011/05/05 14:05:56 mszekely Exp $
 * ===========================================================================
 * NOTES
 * <other useful comments, qualifications, etc.>
 *
 * MODIFIED    (MM/DD/YY)
 *    jswan     07/07/10 - Code review changes and fixes for Cancel button in
 *                         External Order integration.
 *    jswan     06/17/10 - Checkin external order integration files for
 *                         refresh.
 *    jswan     06/09/10 - Added for external order integration.
 *
 * ===========================================================================
 */
package oracle.retail.stores.pos.services.returns.returnitem;

// Java imports

import java.util.ArrayList;

import oracle.retail.stores.domain.lineitem.SaleReturnLineItemIfc;
import oracle.retail.stores.foundation.tour.ifc.BusIfc;
import oracle.retail.stores.foundation.tour.ifc.ShuttleIfc;
import oracle.retail.stores.pos.services.modifyitem.serialnumber.SerializedItemCargo;
import oracle.retail.stores.pos.services.returns.returncommon.ReturnItemCargoIfc;

//--------------------------------------------------------------------------
/**
    This shuttle sets up the Return Transaction service to retrieve kit component
    items for manual return.  A temporary transaction is created and initialized
    with tax values using the utility manager.  The transaction is used to
    initialize the kit component line items by adding the kit header plu item.
    The kit component line items from the temporary transaction are
    returned to the POS service and added to the transaction in progress.
**/
//--------------------------------------------------------------------------
public class ModifyItemSerialNumberReturnShuttle implements ShuttleIfc
{
    /** serialVersionUID */
    private static final long serialVersionUID = 9142819817045606230L;
    /** 
     * Item Return Cargo
     */
    protected SerializedItemCargo serializedItemCargo = null;

    //----------------------------------------------------------------------
    /**
       Store data from parent service in the shuttle
       <P>
       @param  bus     Parent Service Bus to copy cargo from.
    **/
    //----------------------------------------------------------------------
    public void load(BusIfc bus)
    {
        serializedItemCargo = (SerializedItemCargo)bus.getCargo();
    }

    //----------------------------------------------------------------------
    /**
       Transfer parent data to child cargo.
       <P>
       @param  bus     Child Service Bus to copy cargo to.
    **/
    //----------------------------------------------------------------------
    public void unload(BusIfc bus)
    {
        ReturnItemCargoIfc cargo = (ReturnItemCargoIfc)bus.getCargo();
        ArrayList<SaleReturnLineItemIfc> lineItems = serializedItemCargo.getLineItems();
        cargo.setItemSerial(lineItems.get(0).getItemSerial());
    }

}
