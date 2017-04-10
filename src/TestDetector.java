package edu.umd.cs.findbugs;

import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.ClassContext;

public class TestDetector extends ByteCodeScanningDetector {

	private BugReporter bugReporter;
	private String currentClass;

	public TestDetector(BugReporter bugReporter) {
		super();		
		this.bugReporter = bugReporter;
	}

	@Override
	public void visitClassContext(ClassContext c) {
		this.bugReporter.reportBug(new BugInstance(this, "TEST", NORMAL_PRIORITY).addClass(this.currentClass).addField(this.currentClass, field.getName(), field.getSignature(), true));
	}