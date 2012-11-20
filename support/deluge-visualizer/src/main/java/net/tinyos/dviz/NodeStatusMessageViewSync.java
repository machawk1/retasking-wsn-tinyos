package net.tinyos.dviz;

import javax.swing.SwingUtilities;

import net.tinyos.message.MessageListener;

import net.tinyos.message.Message;

import net.tinyos.message.MoteIF;

import javax.swing.table.DefaultTableModel;

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

			public void run() {

				// TODO: Add code to update table
				nodeStatusModel.getDataVector();
			}

		};

		SwingUtilities.invokeLater(doWorkRunnable);
	}

}
