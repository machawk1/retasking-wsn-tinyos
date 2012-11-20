package net.tinyos.dviz;

import java.util.List;
import net.tinyos.message.Message;
import net.tinyos.message.MessageListener;
import net.tinyos.message.MoteIF;
import net.tinyos.packet.BuildSource;
import net.tinyos.packet.PhoenixSource;
import net.tinyos.util.PrintStreamMessenger;

public class MoteMessageService {

    public enum State {
        Stopped, Running
    };

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

    public MoteMessageService(List<MessageSubscriber> subscribers) {

        this.subscribers = subscribers;
    }

    public void start(String source) {

        if (status != State.Running) {
            phoenixSource = BuildSource.makePhoenix(source, PrintStreamMessenger.err);

            moteIF = new MoteIF(phoenixSource);

            registerAllSubscribers();

            status = State.Running;
        }
    }

    private void registerAllSubscribers() {

        for (MessageSubscriber subscriber : subscribers) {

            moteIF.registerListener(subscriber.getMessageType(), subscriber.getMessageListener());
        }
    }

    public void stop() {

        if (status != State.Stopped) {

            deregisterAllSubscribers();

            // Shutdown the phoneix source
            phoenixSource.shutdown();

            status = State.Stopped;
        }

    }

    private void deregisterAllSubscribers() {

        for (MessageSubscriber subscriber : subscribers) {

            moteIF.deregisterListener(subscriber.getMessageType(), subscriber.getMessageListener());
        }

    }
}
