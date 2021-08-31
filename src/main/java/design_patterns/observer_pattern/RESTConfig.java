package design_patterns.observer_pattern;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
 /**
  * create the application path; it has to extend the application class
  */
@ApplicationPath("/api")
public class RESTConfig extends Application {}