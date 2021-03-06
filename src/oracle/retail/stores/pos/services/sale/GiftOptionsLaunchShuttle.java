/* ===========================================================================
* Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved. 
 * ===========================================================================
 * $Header: rgbustores/applications/pos/src/oracle/retail/stores/pos/services/sale/GiftOptionsLaunchShuttle.java /rgbustores_13.4x_generic_branch/1 2011/05/05 14:06:01 mszekely Exp $
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
 *    4    360Commerce 1.3         2/10/2006 11:06:45 AM  Deepanshu       CR
 *         6092: Sales Assoc sould be last 4 digits of Sales Assoc ID and not
 *         of Cashier ID on the recipt
 *    3    360Commerce 1.2         3/31/2005 4:28:18 PM   Robert Pearse   
 *    2    360Commerce 1.1         3/10/2005 10:21:57 AM  Robert Pearse   
 *    1    360Commerce 1.0         2/11/2005 12:11:16 PM  Robert Pearse   
 *
 *   Revision 1.6  2004/09/23 00:07:11  kmcbride
 *   @scr 7211: Adding static serialVersionUIDs to all POS Serializable objects, minus the JComponents
 *
 *   Revision 1.5  2004/06/22 19:06:32  crain
 *   @scr 5470 add Gift Card or Gift Cert to Sell Item screen; select More->Gift Card/Cert->Undo - a twin of the first Gift Card or Cert is added to transaction
 *
 *   Revision 1.4  2004/04/09 16:56:01  cdb
 *   @scr 4302 Removed double semicolon warnings.
 *
 *   Revision 1.3  2004/02/12 16:48:17  mcs
 *   Forcing head revision
 *
 *   Revision 1.2  2004/02/11 21:22:50  rhafernik
 *   @scr 0 Log4J conversion and code cleanup
 *
 *   Revision 1.1.1.1  2004/02/11 01:04:11  cschellenger
 *   updating to pvcs 360store-current
 *
 *
 * 
 *    Rev 1.1   Nov 26 2003 09:12:34   lzhao
 * remove tendering.
 * Resolution for 3371: Feature Enhancement:  Gift Card Enhancement
 * 
 *    Rev 1.0   20 Nov 2003 00:14:08   baa
 * Initial revision.
 * 
 *    Rev 1.0   Oct 30 2003 09:38:48   lzhao
 * Initial revision.
 * ===========================================================================
 */
package oracle.retail.stores.pos.services.sale;

import org.apache.log4j.Logger;

import oracle.retail.stores.foundation.tour.ifc.BusIfc;
import oracle.retail.stores.foundation.tour.ifc.ShuttleIfc;
import oracle.retail.stores.pos.services.giftcard.GiftCardCargo;

//--------------------------------------------------------------------------
/**
    This shuttle copies information from the cargo used
    in the Sale service to the cargo used in the Gift Card service. <p>
    @version $Revision: /rgbustores_13.4x_generic_branch/1 $
**/
//--------------------------------------------------------------------------
public class GiftOptionsLaunchShuttle implements ShuttleIfc
{                                      
    // This id is used to tell
    // the compiler not to generate a
    // new serialVersionUID.
    //
    static final long serialVersionUID = 2456373953929130875L;

    /** 
        The logger to which log messages will be sent.
    **/
    protected static Logger logger = Logger.getLogger(oracle.retail.stores.pos.services.sale.GiftOptionsLaunchShuttle.class);

    /**
       revision number supplied by Team Connection
    **/
    public static final String revisionNumber = "$Revision: /rgbustores_13.4x_generic_branch/1 $";

    /**
       The sale cargo
    **/
    protected SaleCargoIfc saleCargo = null;
    //----------------------------------------------------------------------
    /**
       Loads cargo from Sale service. <P>
       <B>Pre-Condition(s)</B>
       <UL>
       <LI>Cargo will contain the retail transaction
       </UL>
       <B>Post-Condition(s)</B>
       <UL>
       <LI>
       </UL>
       @param  bus     Service Bus
    **/
    //----------------------------------------------------------------------
    public void load(BusIfc bus)
    {                                   // begin load()
       saleCargo = (SaleCargoIfc)bus.getCargo();
    }                                      // end load()

    //----------------------------------------------------------------------
    /**
       Loads data into GiftCard  service. <P>
       <B>Pre-Condition(s)</B>
       <UL>
       <LI>Cargo will contain the retail transaction
       </UL>
       <B>Post-Condition(s)</B>
       <UL>
       <LI>
       </UL>
       @param  bus     Service Bus
    **/
    //----------------------------------------------------------------------
    public void unload(BusIfc bus)
    {                                   // begin unload()
        //super.unload(bus);
        GiftCardCargo cargo = (GiftCardCargo) bus.getCargo();
        cargo.setStoreStatus(saleCargo.getStoreStatus());
        cargo.setRegister(saleCargo.getRegister());
        cargo.setOperator(saleCargo.getOperator());
        cargo.setCustomerInfo(saleCargo.getCustomerInfo());
        cargo.setTenderLimits(saleCargo.getTenderLimits());
        cargo.setTransaction(saleCargo.getTransaction());
        cargo.setSalesAssociate(saleCargo.getSalesAssociate());
   }                                      // end unload()

    //----------------------------------------------------------------------
    /**
       Returns a string representation of this object.  <P>
       @return String representation of object
    **/
    //----------------------------------------------------------------------
    public String toString()
    {                                   // begin toString()
        // result string
        String strResult = new String("Class:  GiftCardLaunchShuttle (Revision " +
                                        revisionNumber + ") @" + hashCode());
        // pass back result
        return(strResult);
    }                                   // end toString()

}                                       // end class GiftOptionsLaunchShuttle
