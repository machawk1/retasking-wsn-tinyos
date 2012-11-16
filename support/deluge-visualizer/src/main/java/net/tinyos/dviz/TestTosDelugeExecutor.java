package net.tinyos.dviz;

public class TestTosDelugeExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TosDelugeExecutor unitUnderTest = new TosDelugeExecutor(
				"serial@/dev/ttyUSB1:57600");

		System.out.println(unitUnderTest.disseminateReboot(1));

	}

}
