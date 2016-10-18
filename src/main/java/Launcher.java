import org.mortbay.jetty.*;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;

public class Launcher {
    public static void main(String[] args) throws Exception {
        Server server = new Server();

        Connector connector = new SelectChannelConnector();
        connector.setPort(8080);
        server.addConnector(connector);

        WebAppContext root = new WebAppContext("C:\\Users\\AntonPC\\IdeaProjects\\web_app\\src\\main\\webapp", "/");
        //WebAppContext reports = new WebAppContext("reports/src/main/webapp", "/reports");
        //WebAppContext petclinic = new WebAppContext("petclinic/src/main/webapp", "/petclinic");
        server.setHandlers(new Handler[]{root});

        server.start();
    }
}