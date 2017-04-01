import org.apache.bcel.classfile.Code;

import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.BugInstance;

public class TestClass extends ByteCodeScanningDetector {

	private BugReporter reporter;
	private String currentClass;

	@Override
	public void visit(JavaClass someObj) {
		currentClass = someObj.getClassName();
		super.visit(someObj);
	}

	@Override
	public void visit(Field field) {
		super.visit(field);
		if (!field.isStatic()) {
			reporter.reportBug(new BugInstance(this, "TEST", NORMAL_PRIORITY).addClass(currentClass).addField(currentClass, field.getName(), field.getSignature(), true));
		}
	}