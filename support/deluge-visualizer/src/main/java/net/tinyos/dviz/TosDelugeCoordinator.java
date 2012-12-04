package net.tinyos.dviz;

import net.tinyos.dviz.MoteMessageService.State;
import net.tinyos.dviz.ProcessExecutor.ProcessResult;

/**
 * Coordinates the execution of the tos-deluge commands (ICommands) with the MoteMessageService
 * During testing it was observed that the MoteMessageService could not be running when a tos-deluge command
 * was executed (resulted in a serial error).
 * 
 * @author Mike Ruffing
 * 
 */
public class TosDelugeCoordinator {

    private MoteMessageService moteMessageService;
    private ProcessExecutor processExecutor;

    public TosDelugeCoordinator(MoteMessageService moteMessageService, ProcessExecutor processExecutor) {

        this.moteMessageService = moteMessageService;
        this.processExecutor = processExecutor;
    }

    public ProcessResult execute(ICommand command) {

        ProcessResult returnValue;

        // Stop the service and then start it back after executing the command
        if (moteMessageService.getStatus() == State.Running) {

            // Get the source before stopping the service
            String source = moteMessageService.getSource();

            moteMessageService.stop();

            returnValue = processExecutor.execute(command);

            // Start the service with the same source
            moteMessageService.start(source);
        } else {

            returnValue = processExecutor.execute(command);
        }

        return returnValue;
    }

}
