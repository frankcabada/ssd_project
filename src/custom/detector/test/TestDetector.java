package custom.detector.test;

import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.ClassContext;

public class TestDetector extends ByteCodeScanningDetector {

	private final BugReporter bugReporter;

	public TestDetector(BugReporter bugReporter) {
		this.bugReporter = bugReporter;
	}

	@Override
	public void visitClassContext(ClassContext c) {
		bugReporter.reportBug(new BugInstance(this, "TEST_BUG", HIGH_PRIORITY).addClassAndMethod(
                        this).addSourceLine(this));
	}