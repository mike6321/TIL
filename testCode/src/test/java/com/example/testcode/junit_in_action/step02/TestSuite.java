package com.example.testcode.junit_in_action.step02;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("JUnit Platform Suite Demo")
//@SelectPackages("com.example.testcode.junit_in_action.step02")
//@IncludeClassNamePatterns(".*Case.*")
@SelectClasses(value = {TestCaseB.class, TestCaseA.class})
public class TestSuite {
}
