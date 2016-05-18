package com.e2edour.web.p.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ResourceInitListener
  implements ServletContextListener
{
  public void contextDestroyed(ServletContextEvent event) {}
  
  public void contextInitialized(ServletContextEvent event)
  {
    /*String staticFileRoot = event.getServletContext().getContextPath();
    event.getServletContext().setAttribute("staticFileRoot", staticFileRoot);
    ResourceBundle resource = ResourceBundle.getBundle("properties/application");
    String imagePath = resource.getString("imagPath");
    event.getServletContext().setAttribute("imagePath", imagePath);
    event.getServletContext().setAttribute("theme","danger");*/
  }
}
