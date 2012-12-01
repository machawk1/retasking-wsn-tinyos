package net.tinyos.dviz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.tinyos.dviz.message.NodeStatus;
import net.tinyos.message.Message;
import net.tinyos.message.MessageListener;

public class NodeStatusMessageViewSync implements MessageListener {

    private DefaultTableModel nodeStatusModel;
    private HashMap<Long, Integer> nodeIdRowIndex;
    private SimpleDateFormat dateFormatter;

    public NodeStatusMessageViewSync(DefaultTableModel nodeStatusModel) {

        this.nodeStatusModel = nodeStatusModel;
        this.nodeIdRowIndex = new HashMap<Long, Integer>();
        this.dateFormatter = new SimpleDateFormat("MM-dd-yyyy 'at' HH:mm:ss z");
    }

    @Override
    public void messageReceived(int to, Message message) {

        String timeStamp = dateFormatter.format(new Date(System.currentTimeMillis()));

        // Update the Table Model
        updateTable(timeStamp, (NodeStatus) message);
    }

    private Runnable updateRow(final int rowIndex, final String timeStamp, final NodeStatus message) {

        return new Runnable() {

            @Override
            public void run() {

                nodeStatusModel.setValueAt(timeStamp, rowIndex, 0);
                nodeStatusModel.setValueAt(message.get_nodeId(), rowIndex, 1);
                nodeStatusModel.setValueAt(message.get_groupId(), rowIndex, 2);
                nodeStatusModel.setValueAt(message.get_state(), rowIndex, 3);
                nodeStatusModel.setValueAt(String.format("0x%s", Long.toHexString(message.get_appUid())), rowIndex, 4);
                nodeStatusModel.setValueAt(message.getString_appName(), rowIndex, 5);
                nodeStatusModel.setValueAt(dateFormatter.format(new Date(message.get_appTimeStamp() * 1000)), rowIndex, 6);

            }
        };
    }

    private Runnable addRow(final String timeStamp, final NodeStatus message) {

        return new Runnable() {

            @Override
            public void run() {

                nodeStatusModel.addRow(new Object[] 
                        {
                            timeStamp, 
                            message.get_nodeId(), 
                            message.get_groupId(), 
                            message.get_state(),
                            String.format("0x%s", Long.toHexString(message.get_appUid())), 
                            message.getString_appName(), 
                            dateFormatter.format(new Date(message.get_appTimeStamp() * 1000))});
            }
        };

    }

    private void updateTable(String timeStamp, NodeStatus message) {

        long nodeId = message.get_nodeId();
        Runnable worktoPerform;

        if (nodeIdRowIndex.containsKey(nodeId)) {

            worktoPerform = updateRow(nodeIdRowIndex.get(nodeId), timeStamp, message);

        } else {

            nodeIdRowIndex.put(nodeId, nodeStatusModel.getRowCount());
            worktoPerform = addRow(timeStamp, message);
        }

        SwingUtilities.invokeLater(worktoPerform);
    }

}
