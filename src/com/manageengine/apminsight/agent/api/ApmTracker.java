//$Id$
package com.manageengine.apminsight.agent.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Can be used upon any classes and methods. These annotated classes and methods will be instrumented and included in the traces.
 * <p>On annotating the class, all its methods will be instrumented. It will override the method-specific annotation
 * <p><b>Example:</b>
 * <p><b>Case 1: Annotating a class</b>
 * <pre><code>
 * {@literal @}ApmTracker
 * public class Category {
 * 	...
 * }
 * </code></pre>
 * <b>Case 2: Annotating a class and assigning a component</b>
 * <pre><code>
 * {@literal @}ApmTracker(component="payment")
 * public class PaymentProcessor {
 * 	...
 * }
 * </pre></code>
 * <b>Case 3: Annotating multiple methods</b>
 * <pre><code>
 * public class Product {
 * 	{@literal @}ApmTracker
 * 	public int getPrice(String product, String brand) {
 * 		...
 * 	}
 * 
 * 	...
 * 
 * 	{@literal @}ApmTracker(component="FetchBrand")
 * 	private List fetchAllBrandsList(String product) {
 * 		...
 * 	}
 * }
 * </pre></code>
 * 
 * @since Agent Version 2.2, API v1.0
 * 
 * @see ApmRootTracker
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ApmTracker
{
	/**
	 * Defines a component name for the annotated element.
	 */
	String component() default "POJO"; // No I18N
	
	/**
	 * Custom name for the method, which will be prepended to the actual name
	 * 
	 * @since Agent v3.4, API v1.1
	 */
	String name() default ""; // No I18N
}
