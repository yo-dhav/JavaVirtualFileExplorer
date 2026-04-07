package com.esiea.pootd2;

import java.awt.Desktop;
import java.net.URI;

import com.esiea.pootd2.controllers.ExplorerController;
import com.esiea.pootd2.interfaces.*;
public class ExplorerApp {
	public static void main(String[] args) {
	    ExplorerController controller = new ExplorerController();
	    controller.initialiseBaseArchitecture();

	    if (args.length == 0) {
	        System.out.println("Please specify interface [cli or web]");
	    } else if (args[0].equalsIgnoreCase("cli")) {
	        TextInterface textInterface = new TextInterface(controller);
	        textInterface.run();
	    } else if (args[0].equalsIgnoreCase("web")) {
	        HttpInterface httpInterface = new HttpInterface(controller);

	        // Only run if server initialized successfully
	        if (httpInterface.isServerInitialized()) {
	            httpInterface.run();

	            try {
	                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
	                    Desktop.getDesktop().browse(new URI("http://localhost:8181"));
	                } else {
	                    System.out.println("Desktop browse not supported.");
	                }
	            } catch (Exception e) {
	                System.out.println("Failed to open browser: " + e.getMessage());
	            }
	        } else {
	            System.out.println("Web server initialization failed. Exiting.");
	        }
	    } else {
	        System.out.println("Invalid interface specified. Please use 'cli' or 'web'.");
	    }
	}
}
