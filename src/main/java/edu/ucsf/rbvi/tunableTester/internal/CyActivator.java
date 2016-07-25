package edu.ucsf.rbvi.tunableTester.internal;

import static org.cytoscape.work.ServiceProperties.COMMAND;
import static org.cytoscape.work.ServiceProperties.COMMAND_NAMESPACE;
import static org.cytoscape.work.ServiceProperties.COMMAND_DESCRIPTION;
import static org.cytoscape.work.ServiceProperties.IN_MENU_BAR;
import static org.cytoscape.work.ServiceProperties.MENU_GRAVITY;
import static org.cytoscape.work.ServiceProperties.PREFERRED_MENU;
import static org.cytoscape.work.ServiceProperties.TITLE;

import java.util.Properties;

import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.work.TaskFactory;
import org.osgi.framework.BundleContext;

import edu.ucsf.rbvi.tunableTester.internal.tasks.TunableTesterTaskFactory;

public class CyActivator extends AbstractCyActivator {
	
	public CyActivator() {
		super();
	}

	public void start(BundleContext context) throws Exception {
		TunableTesterTaskFactory ctTaskFactory = new TunableTesterTaskFactory();
		Properties tunableTaskProperties = new Properties();
		tunableTaskProperties.setProperty(IN_MENU_BAR, "true");
		tunableTaskProperties.setProperty(PREFERRED_MENU, "Apps");
		tunableTaskProperties.setProperty(COMMAND_NAMESPACE, "tunable");
		tunableTaskProperties.setProperty(COMMAND, "test");
		tunableTaskProperties.setProperty(TITLE, "tunableTest");
		registerService(context, ctTaskFactory, TaskFactory.class, tunableTaskProperties);
	}
}
