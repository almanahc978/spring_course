package org.kamil;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * 
 * tak mozna skonfigurowac
 * 
 * 
 * 
 * package org.kamil;
 * 
 * import javax.servlet.ServletContext; import javax.servlet.ServletException;
 * import javax.servlet.ServletRegistration.Dynamic;
 * 
 * import org.springframework.web.WebApplicationInitializer; import
 * org.springframework.web.context.support.
 * AnnotationConfigWebApplicationContext; import
 * org.springframework.web.servlet.DispatcherServlet;
 * 
 * public class AppInitializer implements WebApplicationInitializer {
 * 
 * @Override public void onStartup(ServletContext servletContext) throws
 * ServletException { AnnotationConfigWebApplicationContext ctx = new
 * AnnotationConfigWebApplicationContext();
 * ctx.setServletContext(servletContext);
 * 
 * DispatcherServlet dispatcher = new DispatcherServlet(ctx);
 * 
 * Dynamic disptcherConfig = servletContext.addServlet("dispatcher",
 * dispatcher);
 * 
 * disptcherConfig.addMapping("/"); }
 * 
 * }
 */

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
}
