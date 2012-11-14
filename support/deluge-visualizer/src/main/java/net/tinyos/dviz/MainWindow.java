package net.tinyos.dviz;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JTable tbNodeStatus;
	private JSplitPane spChild;


	/**
	 * Create the application.
	 */
	public MainWindow() {
		setTitle("Deluge Visualizer");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 722, 560);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				SettingsDialog settingsDialog = new SettingsDialog();
				settingsDialog.display();

			}
		});
		mnFile.add(mntmSettings);

		tbNodeStatus = new JTable();
		tbNodeStatus.setModel(new DefaultTableModel(new Object[][] { { null,
				null, null, null, null, null }, }, new String[] { "",
				"Node ID", "Group ID", "State", "App UID", "App Name" }) {
			Class<?>[] columnTypes = new Class[] { Boolean.class,
					Integer.class, Integer.class, String.class, Integer.class,
					String.class };

			public Class<?> getColumnClass(int columnIndex) {
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

		JTabbedPane tpCommands = new JTabbedPane(JTabbedPane.TOP);
		spCommandTabs.setViewportView(tpCommands);

		JPanel pInstall = new JPanel();
		JPanel pDisseminateReboot = new JPanel();
		JPanel pDisseminateRebootNodes = new JPanel();
		JPanel pDisseminateRebootGroup = new JPanel();
		JPanel pUpdateGroup = new JPanel();

		tpCommands.addTab("Install", pInstall);
		tpCommands.addTab("Disseminate-Reboot", pDisseminateReboot);
		tpCommands.addTab("Disseminate-Reboot-Nodes", pDisseminateRebootNodes);
		tpCommands.addTab("Disseminate-Reboot-Group", pDisseminateRebootGroup);
		tpCommands.addTab("Update-Group", pUpdateGroup);

		JSplitPane spRoot = new JSplitPane();
		spRoot.setDividerSize(7);
		spRoot.setOrientation(JSplitPane.VERTICAL_SPLIT);
		spRoot.setOneTouchExpandable(true);
		spRoot.setResizeWeight(0.66);
		this.getContentPane().add(spRoot, BorderLayout.CENTER);

		spRoot.setLeftComponent(spChild);

		JTextArea taConsole = new JTextArea();
		spRoot.setRightComponent(taConsole);

	}

}
