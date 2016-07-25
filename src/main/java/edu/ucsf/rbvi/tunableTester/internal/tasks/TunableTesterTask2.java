package edu.ucsf.rbvi.tunableTester.internal.tasks;

import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.Tunable;
import org.cytoscape.work.util.BoundedFloat;
import org.cytoscape.work.util.BoundedInteger;

public class TunableTesterTask2 extends AbstractTask {
	@Tunable(description="Bounded currency integer", tooltip="Enter Value", required=true, format="\u00A4###,###",params="slider=true",
						groups={"second task"})
	public BoundedInteger currency = new BoundedInteger(0, 0, 1000000, false, false);

	@Tunable(description="Bounded currency float", tooltip="Enter Value", required=true, format="\u00A4###,##0.00",params="slider=true",
						groups={"second task"})
	public BoundedFloat currencyFloat = new BoundedFloat(0.0f, 0.0f, 1000000.0f, false, false);

	@Tunable(description="Currency float", tooltip="Enter Value", required=true, format="\u00A4###,##0.00",
						groups={"second task"})
	public float currencyfloat = 0.99f;

	@Tunable(description="Currency integer", tooltip="Enter Value", format="\u00A4###,##0",
						groups={"second task"})
	public int currencyint = 0;

	public TunableTesterTask2 () {}

	public void run(TaskMonitor taskMonitor) {
		System.out.println("currency = "+currency.getValue());
		System.out.println("currencyFloat = "+currencyFloat.getValue());
		System.out.println("currencyfloat = "+currencyfloat);
		System.out.println("currencyint = "+currencyint);
	}
}
