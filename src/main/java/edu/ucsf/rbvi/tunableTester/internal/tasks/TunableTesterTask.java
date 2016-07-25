package edu.ucsf.rbvi.tunableTester.internal.tasks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.ContainsTunables;
import org.cytoscape.work.Task;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.Tunable;
import org.cytoscape.work.swing.RequestsUIHelper;
import org.cytoscape.work.swing.TunableUIHelper;
import org.cytoscape.work.swing.util.UserAction;
import org.cytoscape.work.util.BoundedFloat;
import org.cytoscape.work.util.BoundedInteger;

public class TunableTesterTask extends AbstractTask implements RequestsUIHelper, ActionListener {
	private TunableUIHelper tunableUIHelper = null;

	@Tunable(description="Bounded currency integer", tooltip="Enter Value", required=true, format="\u00A4###,###",params="slider=true")
	public BoundedInteger currency = new BoundedInteger(0, 0, 1000000, false, false);

	@Tunable(description="Bounded currency float", tooltip="Enter Value", required=true, format="\u00A4###,##0.00",params="slider=true")
	public BoundedFloat currencyFloat = new BoundedFloat(0.0f, 0.0f, 1000000.0f, false, false);

	@Tunable(description="Currency float", tooltip="Enter Value", required=true, format="\u00A4###,##0.00")
	public float currencyfloat = 0.99f;

	@Tunable(description="Currency integer", tooltip="Enter Value", format="\u00A4###,##0")
	public int currencyint = 0;

	@Tunable(description="ReadOnly test", params="readOnly=true")
	public String testString = "This is a long update to say something";

	private boolean secondTask;
	@Tunable(description="Add second task?", tooltip="Second task")
	public boolean getSecondTask() {
		return secondTask;
	}
	public void setSecondTask(boolean value) {
		this.secondTask = value;
		if (value == true && taskTwo == null) {
			taskTwo = new TunableTesterTask2();
			testString = "This is a long update to say something";
			if (tunableUIHelper != null)
				tunableUIHelper.refresh(this);
		}
	}

	@ContainsTunables
	public Task taskTwo = null;

	@Tunable(description="Hello")
	public UserAction action = new UserAction(this);

	public TunableTesterTask () {}

	public void run(TaskMonitor taskMonitor) {
		System.out.println("currency = "+currency.getValue());
		System.out.println("currencyFloat = "+currencyFloat.getValue());
		System.out.println("currencyfloat = "+currencyfloat);
		System.out.println("currencyint = "+currencyint);
		if (secondTask && taskTwo != null)
			insertTasksAfterCurrentTask(taskTwo);
	}

	@Override
	public void setUIHelper(TunableUIHelper helper) { this.tunableUIHelper = helper; }

	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				 JOptionPane.showMessageDialog(tunableUIHelper.getParent(), "Hello",
												              "Hello", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
