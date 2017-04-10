package edu.umd.cs.findbugs;

import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.BugInstance;

public class TestDetector extends ByteCodeScanningDetector {

	private BugReporter bugReporter;
	private String currentClass;

	public TestDetector(BugReporter bugReporter) {
		super();		
		this.bugReporter = bugReporter;
	}

	@Override
	public void visit(JavaClass someObj) {
		this.currentClass = someObj.getClassName();
		super.visit(someObj);
		this.bugReporter.reportBug(new BugInstance(this, "TEST", NORMAL_PRIORITY).addClass(this.currentClass).addField(this.currentClass, field.getName(), field.getSignature(), true));
	}

	@Override
	public void visit(Field field) {
		super.visit(field);
		this.bugReporter.reportBug(new BugInstance(this, "TEST", NORMAL_PRIORITY).addClass(this.currentClass).addField(this.currentClass, field.getName(), field.getSignature(), true));
