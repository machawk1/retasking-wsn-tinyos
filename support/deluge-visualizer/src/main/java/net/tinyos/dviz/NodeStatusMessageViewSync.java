package net.tinyos.dviz;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.tinyos.message.Message;
import net.tinyos.message.MessageListener;

public class NodeStatusMessageViewSync implements MessageListener {

    private DefaultTableModel nodeStatusModel;

    public NodeStatusMessageViewSync(DefaultTableModel nodeStatusModel) {

        this.nodeStatusModel = nodeStatusModel;
    }

    @Override
    public void messageReceived(int to, Message message) {

        // Update the Table Model
        updateTable(message);
    }

    private void updateTable(Message message) {

        Runnable doWorkRunnable = new Runnable() {

            @Override
            public void run() {

                // TODO: Add code to update table
                nodeStatusModel.getDataVector();
            }

        };

        SwingUtilities.invokeLater(doWorkRunnable);
    }

}
