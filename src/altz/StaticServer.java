package altz;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class StaticServer {
	private int port = 8000;
	private String[] welcomeFiles = {"index.html"};
	private HandlerList handlers = new HandlerList();
	
	public StaticServer() throws Exception {
		Server server = new Server();
		
		ServerConnector connector = new ServerConnector(server);
		connector.setPort(port);
		server.addConnector(connector);
		
		addResourceFolder(".");
		
		server.setHandler(handlers);
		server.start();
	}
	
	public void addResourceFolder(String folder) {
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setDirectoriesListed(true);
		resourceHandler.setWelcomeFiles(welcomeFiles);
		resourceHandler.setResourceBase(folder);
		handlers.addHandler(resourceHandler);
	}
	
	public static void main(String[] args) throws Exception {
		new StaticServer();
	}

}
