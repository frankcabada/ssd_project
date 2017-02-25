package edu.umd.cs.findbugs.detect;

import org.apache.bcel.classfile.Code;

import edu.umd.cs.findbugs.BugAccumulator;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.BugInstance;

public class TestClass {

	protected final BugAccumulator bugAccumulator;

	public TestClass(BugReporter bugReporter) {
		this.bugAccumulator = new BugAccumulator(bugReporter);
	}

	public void visit(Code code) {
		accumulateBug();

		bugAccumulator.reportAccumulatedBugs();
	}

	protected void accumulateBug() {
		bugAccumulator.accumulateBug(new BugInstance(this, "TEST_BUG",
			NORMAL_PRIORITY).addClassAndMethod(this), this);
	}
}