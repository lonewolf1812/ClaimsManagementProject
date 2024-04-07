package com.claimsmanagement.claimsmodule.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestUtils {
	public static File businessTestFile;
	public static File boundaryTestFile;
	public static File exceptionTestFile;
	static {
		businessTestFile = new File("./testcases_revised.txt");
		businessTestFile.delete();
		
		boundaryTestFile = new File("./testcases_boundary_revised.txt");
		boundaryTestFile.delete();
		
		exceptionTestFile = new File("./testcases_exception_revised.txt");
		exceptionTestFile.delete();
	}
				
	public static void technocratsAssert(String testName, Object result, File file) throws IOException {			
		System.out.println("\n" + testName + "=" + result);
		FileWriter writer = new FileWriter(file,true);
		writer.append("\n" + testName + "=" + result);
		writer.flush();
		writer.close();
	}

	public static String currentTest() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}	
}
