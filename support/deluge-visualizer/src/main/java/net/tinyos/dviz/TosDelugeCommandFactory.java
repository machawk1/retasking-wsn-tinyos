package net.tinyos.dviz;

public class TosDelugeCommandFactory {

    private String source;
    private String tosDeluge;

    public String getTosDeluge() {

        return tosDeluge;
    }

    public void setTosDeluge(String tosDeluge) {

        this.tosDeluge = tosDeluge;
    }

    public String getSource() {

        return source;
    }

    public void setSource(String source) {

        this.source = source;
    }

    public TosDelugeCommandFactory(String source, String tosDeluge) {

        this.source = source;
        this.tosDeluge = tosDeluge;
    }

    public ICommand install(int imageNum, final String pathToTosImageXml) {

        final String[] command = new String[] {tosDeluge, source, "-i", Integer.toString(imageNum), pathToTosImageXml};

        return new DefaultCommand(command, "ERROR");
    }

    public ICommand disseminateReboot(int imageNum) {

        final String[] command = {tosDeluge, source, "-dr", Integer.toString(imageNum)};

        return new DefaultCommand(command, "ERROR");
    }

    public ICommand disseminateRebootNodes(int imageNum, long nodeIdsHash) {

        final String[] command = {tosDeluge, source, "-drn", Integer.toString(imageNum), Long.toString(nodeIdsHash)};

        return new DefaultCommand(command, "ERROR");
    }

    public ICommand disseminateRebootGroup(int imageNum, int groupId) {

        final String[] command = {tosDeluge, source, "-drg", Integer.toString(imageNum), Integer.toString(groupId)};

        return new DefaultCommand(command, "ERROR");
    }

    public ICommand updateGroup(long nodeIdsHash, int groupId) {

        final String[] command = {tosDeluge, source, "-ung", Long.toString(nodeIdsHash), Integer.toString(groupId)};

        return new DefaultCommand(command, "ERROR");
    }

}
