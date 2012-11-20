package net.tinyos.dviz;

import java.util.Map;
import net.tinyos.dviz.ProcessExecutor.ProcessResult;

public class TosDelugeExecutor {

    private String source;
    private ProcessExecutor processExecutor;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {

        this.source = source;
    }

    public TosDelugeExecutor(String source, Map<String, String> envVariables) {

        this.source = source;
        this.processExecutor = new ProcessExecutor(envVariables);
    }

    public ProcessResult install(int imageNum, final String pathToTosImageXml) {

        final String[] command = new String[] {"tos-deluge", source, "-i", Integer.toString(imageNum), pathToTosImageXml};

        return processExecutor.execute(new DefaultCommand(command, "ERROR"));
    }

    public ProcessResult disseminateReboot(int imageNum) {

        final String[] command = {"tos-deluge", source, "-dr", Integer.toString(imageNum)};

        return processExecutor.execute(new DefaultCommand(command, "ERROR"));
    }

    public ProcessResult disseminateRebootNodes(int imageNum, int nodeIdsHash) {

        final String[] command = {"tos-deluge", source, "-drn", Integer.toString(imageNum), Integer.toString(nodeIdsHash)};

        return processExecutor.execute(new DefaultCommand(command, "ERROR"));
    }

    public ProcessResult disseminateRebootGroup(int imageNum, int groupId) {

        final String[] command = {"tos-deluge", source, "-drg", Integer.toString(imageNum), Integer.toString(groupId)};

        return processExecutor.execute(new DefaultCommand(command, "ERROR"));
    }

    public ProcessResult updateGroup(int nodeIdsHash, int groupId) {

        final String[] command = {"tos-deluge", source, "-ung", Integer.toString(nodeIdsHash), Integer.toString(groupId)};

        return processExecutor.execute(new DefaultCommand(command, "ERROR"));
    }

}
