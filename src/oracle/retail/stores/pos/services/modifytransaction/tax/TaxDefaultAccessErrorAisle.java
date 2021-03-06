/* ===========================================================================
* Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved. 
 * ===========================================================================
 * $Header: rgbustores/applications/pos/src/oracle/retail/stores/pos/services/modifytransaction/tax/TaxDefaultAccessErrorAisle.java /rgbustores_13.4x_generic_branch/1 2011/05/05 14:06:32 mszekely Exp $
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
 *    3    360Commerce 1.2         3/31/2005 4:30:19 PM   Robert Pearse   
 *    2    360Commerce 1.1         3/10/2005 10:25:46 AM  Robert Pearse   
 *    1    360Commerce 1.0         2/11/2005 12:14:41 PM  Robert Pearse   
 *
 *   Revision 1.4  2004/09/23 00:07:13  kmcbride
 *   @scr 7211: Adding static serialVersionUIDs to all POS Serializable objects, minus the JComponents
 *
 *   Revision 1.3  2004/02/12 16:51:17  mcs
 *   Forcing head revision
 *
 *   Revision 1.2  2004/02/11 21:51:37  rhafernik
 *   @scr 0 Log4J conversion and code cleanup
 *
 *   Revision 1.1.1.1  2004/02/11 01:04:18  cschellenger
 *   updating to pvcs 360store-current
 *
 *
 * 
 *    Rev 1.0   Aug 29 2003 16:02:56   CSchellenger
 * Initial revision.
 * 
 *    Rev 1.0   Apr 29 2002 15:15:00   msg
 * Initial revision.
 * 
 *    Rev 1.0   Mar 18 2002 11:39:56   msg
 * Initial revision.
 * 
 *    Rev 1.0   Sep 21 2001 11:31:46   msg
 * Initial revision.
 * 
 *    Rev 1.1   Sep 17 2001 13:10:02   msg
 * header update
 * ===========================================================================
 */
package oracle.retail.stores.pos.services.modifytransaction.tax;

// foundation imports
import oracle.retail.stores.domain.employee.EmployeeIfc;
import oracle.retail.stores.domain.employee.RoleFunctionIfc;
import oracle.retail.stores.foundation.manager.ifc.UIManagerIfc;
import oracle.retail.stores.foundation.tour.application.LaneActionAdapter;
import oracle.retail.stores.foundation.tour.application.Letter;
import oracle.retail.stores.foundation.tour.ifc.BusIfc;
import oracle.retail.stores.foundation.tour.ifc.LaneActionIfc;
import oracle.retail.stores.pos.ui.DialogScreensIfc;
import oracle.retail.stores.pos.ui.POSUIManagerIfc;
import oracle.retail.stores.pos.ui.beans.DialogBeanModel;

//------------------------------------------------------------------------------
/**
     The GiftRegUserAccessErrorAisle is traversed when the operator attempts
     access a function the she does have the authority to use.
    @version $Revision: /rgbustores_13.4x_generic_branch/1 $
**/

//------------------------------------------------------------------------------

public class TaxDefaultAccessErrorAisle extends LaneActionAdapter implements LaneActionIfc
{
    // This id is used to tell
    // the compiler not to generate a
    // new serialVersionUID.
    //
    static final long serialVersionUID = -7993405334913075654L;

    /**
        revision number supplied by Team Connection
    **/
    public static final String revisionNumber = "$Revision: /rgbustores_13.4x_generic_branch/1 $";

    /**
        class name constant
    **/
    public static final String LANENAME = "TaxDefaultAccessErrorAisle";

    //--------------------------------------------------------------------------
    /**
        The GiftRegUserAccessErrorAisle is traversed when the operator attempts
        access a function she not does have the authority to use.
         @param bus the bus traversing this lane
    **/
    //--------------------------------------------------------------------------
    public void traverse(BusIfc bus)
    {

        Letter   letter           = null;
        POSUIManagerIfc ui= (POSUIManagerIfc) bus.getManager(UIManagerIfc.TYPE);
  
        // Using "generic dialog bean".  
        DialogBeanModel model = new DialogBeanModel();

        ModifyTransactionTaxCargo cargo = (ModifyTransactionTaxCargo) bus.getCargo();
        
        EmployeeIfc securityOverrideEmployee = cargo.getSecurityOverrideEmployee();

        if(securityOverrideEmployee != null)
        {
            cargo.setAccessEmployee(securityOverrideEmployee);
        }
        
        if (cargo.getAccessEmployee().hasAccessToFunction(RoleFunctionIfc.TAX_MODIFICATION))
        {
            cargo.setSecurityOverrideReturnLetter("Success");
            letter = new Letter(cargo.getSecurityOverrideReturnLetter());  
            bus.mail(letter, BusIfc.CURRENT);
        }
        else
        {
            // Set model to same name as dialog in config\posUI.properties
            // Set button and arugments
            // set and display the model
            model.setResourceID("SecurityErrorNotice");
            model.setType(DialogScreensIfc.CONFIRMATION);
            ui.showScreen(POSUIManagerIfc.DIALOG_TEMPLATE, model);
        }
    }

    //----------------------------------------------------------------------
    /**
        Returns a string representation of this object.
        <P>
        @param none
        @return String representation of object
    **/
    //----------------------------------------------------------------------
    public String toString()
    {                                   // begin toString()
        // result string
        String strResult = new String("Class:  GiftRegUserAccessErrorAisle (Revision " +
                                      getRevisionNumber() +
                                      ")" + hashCode());

        // pass back result
        return(strResult);
    }                                   // end toString()

    //----------------------------------------------------------------------
    /**
        Returns the revision number of the class.
        <P>
        @param none
        @return String representation of revision number
    **/
    //----------------------------------------------------------------------
    public String getRevisionNumber()
    {                                   // begin getRevisionNumber()
        // return string
        return(revisionNumber);
    }                                   // end getRevisionNumber()

} // end class GiftRegUserAccessErrorAisle
