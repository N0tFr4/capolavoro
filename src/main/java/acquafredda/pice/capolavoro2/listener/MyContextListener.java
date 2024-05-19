package acquafredda.pice.capolavoro2.listener;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyContextListener
 *
 */
@WebListener
public class MyContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 

    	ServletContext ctx=sce.getServletContext();
    	String language=ctx.getInitParameter("LANGUAGE");
    	String country=ctx.getInitParameter("COUNTRY");
    	Locale locale=new Locale(language, country);
    	ResourceBundle rb=ResourceBundle.getBundle("MessageBundle", locale);
    	ctx.setAttribute("rb", rb);
    	ctx.setAttribute("locale", locale);
    }
	
}
