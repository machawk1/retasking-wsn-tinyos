package net.tinyos.dviz;

import javax.swing.SwingUtilities;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JTextArea;

public class MainWindow {

	private JFrame frame;
	private JTable tbNodeStatus;
	private JSplitPane spChild;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 596, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmSettings = new JMenuItem("Settings");
		mnFile.add(mntmSettings);

		
		tbNodeStatus = new JTable();
		tbNodeStatus.setModel(new DefaultTableModel(new Object[][] { { null, null,
				null, null, null, null }, }, new String[] { "", "Node ID",
				"Group ID", "State", "App UID", "App Name" }) {
			Class[] columnTypes = new Class[] { Boolean.class, Integer.class,
					Integer.class, String.class, Integer.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JScrollPane spTable = new JScrollPane();
		spTable.setViewportView(tbNodeStatus);

		spChild = new JSplitPane();
		spChild.setDividerSize(7);
		spChild.setOrientation(JSplitPane.VERTICAL_SPLIT);
		spChild.setOneTouchExpandable(true);
		spChild.setResizeWeight(0.5);
		
		
		spChild.setLeftComponent(spTable);
		
		JScrollPane spCommandTabs = new JScrollPane();
		spChild.setRightComponent(spCommandTabs);

		
		JSplitPane spRoot = new JSplitPane();
		spRoot.setDividerSize(7);
		spRoot.setOrientation(JSplitPane.VERTICAL_SPLIT);
		spRoot.setOneTouchExpandable(true);
		spRoot.setResizeWeight(0.66);
		frame.getContentPane().add(spRoot, BorderLayout.CENTER);
		
		spRoot.setLeftComponent(spChild);
		
		JTextArea taConsole = new JTextArea();
		spRoot.setRightComponent(taConsole);
		
	}

}
