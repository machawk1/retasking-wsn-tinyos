package net.tinyos.dviz;

import java.util.HashMap;

public class TestTosDelugeExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HashMap<String, String> envVariables = new HashMap<String, String>();

		envVariables.put("TOSROOT", "/opt/retasking-wsn-tinyos");

		TosDelugeExecutor unitUnderTest = new TosDelugeExecutor(
				"serial@/dev/ttyUSB1:57600", envVariables);

		System.out.println(unitUnderTest.disseminateReboot(1));

	}

}
