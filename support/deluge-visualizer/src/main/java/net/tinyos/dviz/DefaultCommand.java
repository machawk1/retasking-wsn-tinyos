package net.tinyos.dviz;

public class DefaultCommand implements ICommand {

    private String[] command;
    private String errorMatchString;

    public DefaultCommand(String[] command, String errorMatchString) {

        this.command = command;
        this.errorMatchString = errorMatchString;
    }

    @Override
    public String[] getCommand() {

        return command;
    }

    @Override
    public String getErrorMatchString() {

        return errorMatchString;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (String val : command) {
            stringBuilder.append(val);
            stringBuilder.append(' ');
        }

        return stringBuilder.toString();
    }

}
