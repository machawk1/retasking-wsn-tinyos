package net.tinyos.dviz;

import net.tinyos.dviz.ProcessExecutor.ProcessResult;

public class TosDelugeExecutor {

	private String source;
	private ProcessExecutor processExecutor;

	public TosDelugeExecutor(String source) {

		this.source = source;
		this.processExecutor = new ProcessExecutor();
	}

	public ProcessResult install(int imageNum, String pathToTosImageXml) {

		String[] command = { "tos-deluge", source, "-i",
				Integer.toString(imageNum), pathToTosImageXml };

		return processExecutor.execute(command, "ERROR");

	}

	public ProcessResult disseminateReboot(int imageNum) {

		String[] command = { "tos-deluge", source, "-dr",
				Integer.toString(imageNum) };

		return processExecutor.execute(command, "ERROR");

	}

	public ProcessResult disseminateRebootNodes(int imageNum, int nodeIdsHash) {

		String[] command = { "tos-deluge", source, "-drn",
				Integer.toString(imageNum), Integer.toString(nodeIdsHash) };

		return processExecutor.execute(command, "ERROR");

	}

	public ProcessResult disseminateRebootGroup(int imageNum, int groupId) {

		String[] command = { "tos-deluge", source, "-drg",
				Integer.toString(imageNum), Integer.toString(groupId) };

		return processExecutor.execute(command, "ERROR");

	}

	public ProcessResult updateGroup(int nodeIdsHash, int groupId) {

		String[] command = { "tos-deluge", source, "-ung",
				Integer.toString(nodeIdsHash), Integer.toString(groupId) };

		return processExecutor.execute(command, "ERROR");

	}

}
