/* ===========================================================================
* Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved. 
 * ===========================================================================
 * $Header: rgbustores/applications/pos/src/oracle/retail/stores/pos/ui/behavior/ResponseTextListener.java /rgbustores_13.4x_generic_branch/1 2011/05/05 14:07:00 mszekely Exp $
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
 *    3    360Commerce 1.2         3/31/2005 4:29:41 PM   Robert Pearse   
 *    2    360Commerce 1.1         3/10/2005 10:24:46 AM  Robert Pearse   
 *    1    360Commerce 1.0         2/11/2005 12:13:45 PM  Robert Pearse   
 *
 *   Revision 1.2  2004/02/12 16:52:12  mcs
 *   Forcing head revision
 *
 *   Revision 1.1.1.1  2004/02/11 01:04:23  cschellenger
 *   updating to pvcs 360store-current
 *
 *
 * 
 *    Rev 1.0   Aug 29 2003 16:13:20   CSchellenger
 * Initial revision.
 * 
 *    Rev 1.0   Apr 29 2002 14:47:16   msg
 * Initial revision.
 * 
 *    Rev 1.0   Mar 18 2002 11:58:36   msg
 * Initial revision.
 * 
 *    Rev 1.1   Jan 19 2002 10:32:56   mpm
 * Initial implementation of pluggable-look-and-feel user interface.
 * Resolution for POS SCR-798: Implement pluggable-look-and-feel user interface
 * 
 *    Rev 1.0   Sep 21 2001 11:33:52   msg
 * Initial revision.
 * 
 *    Rev 1.1   Sep 17 2001 13:18:18   msg
 * header update
 * ===========================================================================
 */
package oracle.retail.stores.pos.ui.behavior;
//---------------------------------------------------------------------------
/**
   This interface is used to retreive user input, for instance directly from
   PromptAndResponseBean.

   @version $Revision: /rgbustores_13.4x_generic_branch/1 $
*/
//---------------------------------------------------------------------------
public interface ResponseTextListener
{
  //----------------------------------------------------------------------------
    /**
        Returns the active response text.
        @return String representing the active response text.
    **/
    //----------------------------------------------------------------------------
    public String getResponseText();
}

