package com.capitanperegrina.geniusrating.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


/**
 *	<pre><servlet>
 *		<servlet-name>genius-rating-web</servlet-name>
 *		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
 *		<init-param>
 *			<param-name>contextConfigLocation</param-name>
 *			<param-value>classpath:spring-context.xml</param-value>
 *		</init-param>
 *		<load-on-startup>1</load-on-startup>
 *	</servlet>
 *
 *	<servlet-mapping>
 *		<servlet-name>genius-rating-web</servlet-name>
 *		<url-pattern>*.do</url-pattern>
 *	</servlet-mapping>
 *
 * 	<session-config>
 *	  <cookie-config>
 *	    <http-only>true</http-only>
 *	    <secure>true</secure>
 *	  </cookie-config>
 *	</session-config></pre>		
 */
public class GeniusRatingWebApplicationInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext rootContext  = new AnnotationConfigWebApplicationContext();
		rootContext .register(GeniusRatingSpringConfiguration.class);
		servletContext.addListener(new ContextLoaderListener(rootContext ));

		ServletRegistration.Dynamic servlet = servletContext.addServlet("genius-rating-web", new DispatcherServlet(rootContext));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("*.do");

		servletContext.getSessionCookieConfig().setHttpOnly(true);
		servletContext.getSessionCookieConfig().setSecure(true);		
	}	
}
