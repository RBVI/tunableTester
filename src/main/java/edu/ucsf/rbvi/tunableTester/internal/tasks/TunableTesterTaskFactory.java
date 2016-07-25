package edu.ucsf.rbvi.tunableTester.internal.tasks;

import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class TunableTesterTaskFactory extends AbstractTaskFactory {
	public TunableTesterTaskFactory () {}

	public TaskIterator createTaskIterator() {
		return new TaskIterator(new TunableTesterTask());
	}
}
