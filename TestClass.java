import org.apache.bcel.classfile.Code;

import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.BugInstance;

public class TestClass extends ByteCodeScanningDetector {

	private BugReporter reporter;

	@Override
	public void visit(Field field) {
		if (field.isStatic()) {
			reporter.reportBug(new BugInstance(this, "TEST_BUG", NORMAL_PRIORITY))
		}
	}