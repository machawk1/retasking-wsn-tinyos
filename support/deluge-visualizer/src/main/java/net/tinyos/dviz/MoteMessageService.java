package net.tinyos.dviz;

import java.io.IOException;
import java.util.List;
import net.tinyos.message.Message;
import net.tinyos.message.MessageListener;
import net.tinyos.message.MoteIF;
import net.tinyos.packet.BuildSource;
import net.tinyos.packet.PacketSource;
import net.tinyos.packet.PhoenixSource;
import net.tinyos.util.PrintStreamMessenger;

public class MoteMessageService {

    public enum State {
        Stopped, Running
    };

    public static class ServiceStatus {

        private State status;
        private String errorText;
        private String source;

        public String getSource() {
            return source;
        }

        public String getErrorText() {
            return errorText;
        }

        public State getStatus() {
            return status;
        }

        protected void setSource(String source) {
            this.source = source;
        }

        protected void setErrorText(String errorText) {
            this.errorText = errorText;
        }

        protected void setStatus(State status) {
            this.status = status;
        }

        protected ServiceStatus() {

        }

        protected ServiceStatus(String source, State status, String errorText) {

            this.source = source;
            this.status = status;
            this.errorText = errorText;
        }
    }

    public static class MessageSubscriber {

        private MessageListener messageListener;
        private Message messageType;

        public MessageListener getMessageListener() {
            return messageListener;
        }

        public Message getMessageType() {
            return messageType;
        }

        public MessageSubscriber(Message messageType, MessageListener messageListener) {
            this.messageType = messageType;
            this.messageListener = messageListener;
        }
    }

    private MoteIF moteIF;
    private PhoenixSource phoenixSource;
    private State status = State.Stopped;
    private List<MessageSubscriber> subscribers;
    private String source;

    public MoteMessageService(List<MessageSubscriber> subscribers) {

        this.subscribers = subscribers;
    }

    public State getStatus() {
        return status;
    }

    public ServiceStatus start(String source) {

        this.source = source;

        ServiceStatus returnValue = new ServiceStatus(source, State.Running, "");

        if (status != State.Running && checkSource(source, returnValue)) {

            phoenixSource = BuildSource.makePhoenix(source, PrintStreamMessenger.err);

            moteIF = new MoteIF(phoenixSource);

            registerAllSubscribers();

            status = State.Running;
        }

        return returnValue;
    }

    public ServiceStatus stop() {

        ServiceStatus returnValue = new ServiceStatus(source, State.Stopped, "");

        if (status != State.Stopped) {

            deregisterAllSubscribers();

            // Shutdown the phoneix source
            phoenixSource.shutdown();

            status = State.Stopped;
        }

        return returnValue;

    }

    /**
     * Check source will attempt to create a packet source to verify the connection (serial or sf) is valid
     * This is needed since MoteIF will call system.exit() if there is an exception during initialization
     * 
     * @param source
     *            (e.g serial@/dev/ttyUSB1:57600 or sf@127.0.0.1:1234)
     * @param serviceStatus
     *            stores error messages and service state
     * @return true if source is valid, false otherwise
     */
    private boolean checkSource(String source, ServiceStatus serviceStatus) {

        boolean returnValue = true;
        PacketSource packetSource = null;

        try {
            packetSource = BuildSource.makePacketSource(source);
            packetSource.open(null);
        } catch (Throwable e) {

            returnValue = false;
            serviceStatus.setStatus(State.Stopped);
            serviceStatus.setErrorText(Utilities.toStringStackTrace(e));
        } finally {

            if (packetSource != null) {
                try {
                    packetSource.close();
                } catch (IOException e) {
                    // Don't do anything if there is an exception
                }
            }
        }

        return returnValue;

    }

    private void registerAllSubscribers() {

        for (MessageSubscriber subscriber : subscribers) {

            moteIF.registerListener(subscriber.getMessageType(), subscriber.getMessageListener());
        }
    }

    private void deregisterAllSubscribers() {

        for (MessageSubscriber subscriber : subscribers) {

            moteIF.deregisterListener(subscriber.getMessageType(), subscriber.getMessageListener());
        }

    }
}
