package ua.spring.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
		
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.setServletContext(arg0);
		webContext.setConfigLocation("ua.spring.web.config");
		arg0.addListener(new ContextLoaderListener(webContext));
		
		ServletRegistration.Dynamic reg = arg0.addServlet("dispatcherServlet", new DispatcherServlet(webContext));
		reg.setLoadOnStartup(1);
		reg.addMapping("/");
	}

}
