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
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JTable tbNodeStatus;
	private JSplitPane spChild;
	private JTextField tfInstallTosImagePath;
	private JTextField tfInstallCmd;
	private JTextField tfDrCmd;
	private JTextField tfDrnNodeIds;
	private JTextField tfDrnCmd;
	private JTextField tfDrgGroupId;
	private JTextField tfDrgCmd;
	private JTextField tfUngGroupId;
	private JTextField tfUngNodeIds;
	private JTextField tfUngCmd;


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
		pInstall.setLayout(new MigLayout("", "[][grow][]", "[][][]"));
		
		JLabel lblInstallImgNum = new JLabel("image number:");
		pInstall.add(lblInstallImgNum, "cell 0 0,alignx trailing");
		
		JComboBox cbInstallImgNum = new JComboBox();
		cbInstallImgNum.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		pInstall.add(cbInstallImgNum, "flowx,cell 1 0,growx");
		
		JLabel lblTosimagexml = new JLabel("tos_image.xml path:");
		pInstall.add(lblTosimagexml, "cell 0 1,alignx trailing");
		
		tfInstallTosImagePath = new JTextField();
		tfInstallTosImagePath.setText("path to tos_image.xml");
		tfInstallTosImagePath.setEditable(false);
		pInstall.add(tfInstallTosImagePath, "cell 1 1,growx");
		tfInstallTosImagePath.setColumns(10);
		
		JButton btnInstallBrowse = new JButton("Browse");
		pInstall.add(btnInstallBrowse, "cell 2 1");
		
		JLabel lblInstallCmd = new JLabel("command:");
		pInstall.add(lblInstallCmd, "cell 0 2,alignx trailing");
		
		tfInstallCmd = new JTextField();
		tfInstallCmd.setText("tos-deluge command");
		tfInstallCmd.setToolTipText("");
		tfInstallCmd.setEditable(false);
		pInstall.add(tfInstallCmd, "cell 1 2,growx");
		tfInstallCmd.setColumns(10);
		
		JButton btnInstallExecute = new JButton("Execute");
		pInstall.add(btnInstallExecute, "cell 2 2");
		tpCommands.addTab("Disseminate-Reboot", pDisseminateReboot);
		pDisseminateReboot.setLayout(new MigLayout("", "[][grow][]", "[][]"));
		
		JLabel lblDrImgNum = new JLabel("image number:");
		pDisseminateReboot.add(lblDrImgNum, "cell 0 0,alignx trailing");
		
		JComboBox cbDrImgNum = new JComboBox();
		cbDrImgNum.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		pDisseminateReboot.add(cbDrImgNum, "cell 1 0,growx");
		
		JLabel lblDrCmd = new JLabel("command:");
		pDisseminateReboot.add(lblDrCmd, "cell 0 1,alignx trailing");
		
		tfDrCmd = new JTextField();
		tfDrCmd.setEditable(false);
		tfDrCmd.setText("tos-deluge command");
		pDisseminateReboot.add(tfDrCmd, "cell 1 1,growx");
		tfDrCmd.setColumns(10);
		
		JButton btnDrExecute = new JButton("Execute");
		pDisseminateReboot.add(btnDrExecute, "cell 2 1");
		tpCommands.addTab("Disseminate-Reboot-Nodes", pDisseminateRebootNodes);
		pDisseminateRebootNodes.setLayout(new MigLayout("", "[][grow][]", "[][][]"));
		
		JLabel lbDrnImgNum = new JLabel("image number:");
		pDisseminateRebootNodes.add(lbDrnImgNum, "cell 0 0,alignx trailing");
		
		JComboBox cbDrnImgNum = new JComboBox();
		cbDrnImgNum.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		pDisseminateRebootNodes.add(cbDrnImgNum, "cell 1 0,growx");
		
		JLabel lblDrnNodeIds = new JLabel("node IDs:");
		pDisseminateRebootNodes.add(lblDrnNodeIds, "cell 0 1,alignx trailing");
		
		tfDrnNodeIds = new JTextField();
		tfDrnNodeIds.setText("hashed value");
		tfDrnNodeIds.setEditable(false);
		pDisseminateRebootNodes.add(tfDrnNodeIds, "cell 1 1,growx");
		tfDrnNodeIds.setColumns(10);
		
		JButton btnDrnUpdate = new JButton("Update");
		pDisseminateRebootNodes.add(btnDrnUpdate, "cell 2 1");
		
		JLabel lblDrnCmd = new JLabel("command:");
		pDisseminateRebootNodes.add(lblDrnCmd, "cell 0 2,alignx trailing");
		
		tfDrnCmd = new JTextField();
		tfDrnCmd.setEditable(false);
		tfDrnCmd.setText("tos-deluge command");
		pDisseminateRebootNodes.add(tfDrnCmd, "cell 1 2,growx,aligny top");
		tfDrnCmd.setColumns(10);
		
		JButton btnDrnExecute = new JButton("Execute");
		pDisseminateRebootNodes.add(btnDrnExecute, "cell 2 2");
		tpCommands.addTab("Disseminate-Reboot-Group", pDisseminateRebootGroup);
		pDisseminateRebootGroup.setLayout(new MigLayout("", "[][grow][]", "[][][]"));
		
		JLabel lblDrgImgNum = new JLabel("image number:");
		pDisseminateRebootGroup.add(lblDrgImgNum, "cell 0 0,alignx trailing");
		
		JComboBox cbDrgImgNum = new JComboBox();
		cbDrgImgNum.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		pDisseminateRebootGroup.add(cbDrgImgNum, "cell 1 0,growx");
		
		JLabel lblDrgGroupId = new JLabel("group ID:");
		pDisseminateRebootGroup.add(lblDrgGroupId, "cell 0 1,alignx trailing");
		
		tfDrgGroupId = new JTextField();
		tfDrgGroupId.setText("1");
		pDisseminateRebootGroup.add(tfDrgGroupId, "cell 1 1,growx");
		tfDrgGroupId.setColumns(10);
		
		JLabel lblDrgCmd = new JLabel("command:");
		pDisseminateRebootGroup.add(lblDrgCmd, "cell 0 2,alignx trailing");
		
		tfDrgCmd = new JTextField();
		tfDrgCmd.setText("tos-deluge command");
		tfDrgCmd.setEditable(false);
		pDisseminateRebootGroup.add(tfDrgCmd, "cell 1 2,growx");
		tfDrgCmd.setColumns(10);
		
		JButton btnDrgExecute = new JButton("Execute");
		pDisseminateRebootGroup.add(btnDrgExecute, "cell 2 2");
		tpCommands.addTab("Update-Group", pUpdateGroup);
		pUpdateGroup.setLayout(new MigLayout("", "[][grow][]", "[][][][]"));
		
		JLabel lblUngImgNum = new JLabel("image number:");
		pUpdateGroup.add(lblUngImgNum, "cell 0 0,alignx trailing");
		
		JComboBox cbUngImgNum = new JComboBox();
		cbUngImgNum.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		pUpdateGroup.add(cbUngImgNum, "cell 1 0,growx");
		
		JLabel lblUngGroupId = new JLabel("group ID:");
		pUpdateGroup.add(lblUngGroupId, "cell 0 1,alignx trailing");
		
		tfUngGroupId = new JTextField();
		tfUngGroupId.setText("1");
		pUpdateGroup.add(tfUngGroupId, "cell 1 1,growx");
		tfUngGroupId.setColumns(10);
		
		JLabel lblUngNodeIds = new JLabel("node IDs:");
		pUpdateGroup.add(lblUngNodeIds, "cell 0 2,alignx trailing");
		
		tfUngNodeIds = new JTextField();
		tfUngNodeIds.setEditable(false);
		tfUngNodeIds.setText("hashed value");
		pUpdateGroup.add(tfUngNodeIds, "cell 1 2,growx");
		tfUngNodeIds.setColumns(10);
		
		JButton btnUngUpdate = new JButton("Update");
		pUpdateGroup.add(btnUngUpdate, "cell 2 2");
		
		JLabel lblUngCmd = new JLabel("command:");
		pUpdateGroup.add(lblUngCmd, "cell 0 3,alignx trailing");
		
		tfUngCmd = new JTextField();
		tfUngCmd.setEditable(false);
		tfUngCmd.setText("tos-deluge command");
		pUpdateGroup.add(tfUngCmd, "cell 1 3,growx");
		tfUngCmd.setColumns(10);
		
		JButton btnUngExecute = new JButton("Execute");
		pUpdateGroup.add(btnUngExecute, "cell 2 3");

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
