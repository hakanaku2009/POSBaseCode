/* ===========================================================================
* Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved. 
 * ===========================================================================
 * $Header: rgbustores/applications/pos/src/oracle/retail/stores/pos/services/common/ResumeTillLaunchShuttle.java /rgbustores_13.4x_generic_branch/1 2011/05/05 14:05:53 mszekely Exp $
 * ===========================================================================
 * NOTES
 * <other useful comments, qualifications, etc.>
 *
 * MODIFIED    (MM/DD/YY)
 *    cgreene   05/27/10 - convert to oracle packaging
 *    cgreene   05/27/10 - convert to oracle packaging
 *    cgreene   05/26/10 - convert to oracle packaging
 *    cgreene   04/27/10 - XbranchMerge cgreene_refactor-duplicate-pos-classes
 *                         from st_rgbustores_techissueseatel_generic_branch
 *    abondala  01/03/10 - update header date
 *
 * ===========================================================================
 * $Log:
 *    3    360Commerce 1.2         3/31/2005 4:29:41 PM   Robert Pearse   
 *    2    360Commerce 1.1         3/10/2005 10:24:46 AM  Robert Pearse   
 *    1    360Commerce 1.0         2/11/2005 12:13:46 PM  Robert Pearse   
 *
 *   Revision 1.6  2004/08/23 16:15:58  cdb
 *   @scr 4204 Removed tab characters
 *
 *   Revision 1.5  2004/07/18 21:26:33  cdb
 *   @scr 6273    Updated so EvaluateOperator takes more responsibility
 *   during till resume.
 *
 *   Revision 1.4  2004/04/09 16:55:58  cdb
 *   @scr 4302 Removed double semicolon warnings.
 *
 *   Revision 1.3  2004/02/12 16:48:02  mcs
 *   Forcing head revision
 *
 *   Revision 1.2  2004/02/11 21:19:59  rhafernik
 *   @scr 0 Log4J conversion and code cleanup
 *
 *   Revision 1.1.1.1  2004/02/11 01:04:11  cschellenger
 *   updating to pvcs 360store-current
 *
 *
 * 
 *    Rev 1.1   08 Nov 2003 01:05:06   baa
 * cleanup -sale refactoring
 * 
 *    Rev 1.0   Nov 04 2003 19:00:10   cdb
 * Initial revision.
 * Resolution for 3430: Sale Service Refactoring
 *
 * ===========================================================================
 */
package oracle.retail.stores.pos.services.common;

import org.apache.log4j.Logger;

import oracle.retail.stores.foundation.tour.ifc.BusIfc;
import oracle.retail.stores.pos.services.dailyoperations.till.tillresume.TillResumeCargo;

/**
 * This service copies any needed information from the cargo used in one service
 * to another service.
 * 
 * @version $Revision: /rgbustores_13.4x_generic_branch/1 $
 */
public class ResumeTillLaunchShuttle extends FinancialCargoShuttle
{
    private static final long serialVersionUID = 7055489897643252903L;

    /**
     * The logger to which log messages will be sent.
     */
    protected static final Logger logger = Logger.getLogger(ResumeTillLaunchShuttle.class);

    /**
     * revision number of this class
     */
    public static final String revisionNumber = "$Revision: /rgbustores_13.4x_generic_branch/1 $";

    /**
     * Copies information to the cargo used in the service.
     * 
     * @param bus Service Bus
     */
    public void unload(BusIfc bus)
    {
        // execute FinancialCargoShuttle class unload
        super.unload(bus);

        // get cargo reference and set attributes
        TillResumeCargo cargo = (TillResumeCargo) bus.getCargo();
        cargo.setShowWarning(false);
    }
}
