//$Id$
package com.manageengine.apminsight.agent.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Can be used upon the methods which are likely to be starting point of transaction execution.
 * <p>If annotated method is the start point, transaction will be named using the value of <code>txnName</code> attribute.
 * <p><b>Example:</b>
 * <p><b>Case 1: Annotating a method</b>
 * <pre><code>
 * public class AppService {
 * 	{@literal @}ApmRootTracker(txnName="App-Initialisation")
 * 	public void init() {
 * 		...
 * 	}
 * }
 * </pre></code>
 * 
 * <p><b>Case 2: Annotating a method and assigning a Component</b>
 * <pre><code>
 * public class TxnService {
 * 	{@literal @}ApmRootTracker(txnName="Txn-Initialisation", component="TxnServiceInit")
 * 	public void init() {
 * 		...
 * 	}
 * }
 * </pre></code>
 * 
 * 
 * @since Agent Version 2.2, API v1.0
 * 
 * @see ApmTracker
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ApmRootTracker
{
	/**
	 * Defines a custom name for the transaction.
	 */
	String txnName();
	
	/**
	 * Defines a component name for the annotated method.
	 */
	String component() default "POJO"; // No I18N
	
	/**
	 * Custom name for the method, which will be prepended to the actual name
	 * 
	 * @since Agent v3.4, API v1.1
	 */
	String name() default ""; // No I18N
}
