package net.tinyos.dviz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import net.tinyos.dviz.MoteMessageService.MessageSubscriber;
import net.tinyos.dviz.MoteMessageService.ServiceStatus;
import net.tinyos.dviz.MoteMessageService.State;
import net.tinyos.dviz.ProcessExecutor.ProcessResult;
import net.tinyos.dviz.SettingsDialog.DialogResult;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JTable tableNodeStatus;
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

	private JComboBox cbInstallImgNum;
	private JTextArea taConsole;
	private JComboBox cbDrnImgNum;
	private JComboBox cbDrImgNum;
	private JComboBox cbDrgImgNum;

	private SettingsDialog settingsDialog;
	private NodeIdsHashCreator nodeIdsHashCreator;
	private TosDelugeExecutor tosDelugeExecutor;
	private MoteMessageService moteMessageService;
	private JButton btnConnection;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		setTitle("Deluge Visualizer");
		initializeGui();
		initializeNodeIdsHashCreator();
		initializeSettingsDialog();
		initializeTosDelugeExecutor();
		initializeMoteMessageService();
	}

	private void initializeNodeIdsHashCreator() {

		nodeIdsHashCreator = new NodeIdsHashCreator();
	}

	private void initializeSettingsDialog() {

		settingsDialog = new SettingsDialog("serial@/dev/ttyUSB1:57600");
	}

	private void initializeTosDelugeExecutor() {

		HashMap<String, String> envVariables = new HashMap<String, String>();
		envVariables.put("TOSROOT", "/opt/retasking-wsn-tinyos");
		tosDelugeExecutor = new TosDelugeExecutor(settingsDialog.getSource(),
				envVariables);
	}

	private void initializeMoteMessageService() {

		ArrayList<MessageSubscriber> subscribers = new ArrayList<MessageSubscriber>();

		// TODO: Fix null
		subscribers.add(new MessageSubscriber(null, null));
		moteMessageService = new MoteMessageService(subscribers);

	}

	private void initializeDisseminateRebootPanel(JPanel pDisseminateReboot) {
		pDisseminateReboot.setLayout(new MigLayout("", "[][grow][]", "[][]"));

		JLabel lblDrImgNum = new JLabel("image number:");
		pDisseminateReboot.add(lblDrImgNum, "cell 0 0,alignx trailing");

		cbDrImgNum = new JComboBox();
		cbDrImgNum.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4" }));
		pDisseminateReboot.add(cbDrImgNum, "cell 1 0,growx");

		JLabel lblDrCmd = new JLabel("command:");
		pDisseminateReboot.add(lblDrCmd, "cell 0 1,alignx trailing");

		tfDrCmd = new JTextField();
		tfDrCmd.setEditable(false);
		tfDrCmd.setText("tos-deluge command");
		pDisseminateReboot.add(tfDrCmd, "cell 1 1,growx");
		tfDrCmd.setColumns(10);

		JButton btnDrExecute = new JButton("Execute");
		btnDrExecute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				executeDisseminateReboot();
			}

		});
		pDisseminateReboot.add(btnDrExecute, "cell 2 1");
	}

	private void initializeInstallPanel(JPanel pInstall) {

		pInstall.setLayout(new MigLayout("", "[][grow][]", "[][][]"));

		JLabel lblInstallImgNum = new JLabel("image number:");
		pInstall.add(lblInstallImgNum, "cell 0 0,alignx trailing");

		cbInstallImgNum = new JComboBox();
		cbInstallImgNum.setModel(new DefaultComboBoxModel(new String[] { "1",
				"2", "3", "4" }));
		pInstall.add(cbInstallImgNum, "flowx,cell 1 0,growx");

		JLabel lblTosimagexml = new JLabel("tos_image.xml path:");
		pInstall.add(lblTosimagexml, "cell 0 1,alignx trailing");

		tfInstallTosImagePath = new JTextField();
		tfInstallTosImagePath.setText("path to tos_image.xml");
		tfInstallTosImagePath.setEditable(false);
		pInstall.add(tfInstallTosImagePath, "cell 1 1,growx");
		tfInstallTosImagePath.setColumns(10);

		JButton btnInstallBrowse = new JButton("Browse");
		btnInstallBrowse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFileChooserForTosImagePath();
			}
		});
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
		btnInstallExecute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO: This should be threaded off
				executeInstall();
			}
		});
		pInstall.add(btnInstallExecute, "cell 2 2");
	}

	private void drnUpdateNodeIdsHash() {

		if (nodeIdsHashCreator.display(Long.parseLong(tfDrnNodeIds.getText())) == net.tinyos.dviz.NodeIdsHashCreator.DialogResult.OK) {

			tfDrnNodeIds.setText(Long.toString(nodeIdsHashCreator
					.getNodeIdsHash()));
		}

	}

	private void ungUpdateNodeIdsHash() {

		if (nodeIdsHashCreator.display(Long.parseLong(tfUngNodeIds.getText())) == net.tinyos.dviz.NodeIdsHashCreator.DialogResult.OK) {

			tfUngNodeIds.setText(Long.toString(nodeIdsHashCreator
					.getNodeIdsHash()));
		}

	}

	private void openFileChooserForTosImagePath() {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "tos_image.xml";
			}

			@Override
			public boolean accept(File f) {

				if (f.isDirectory()) {
					return true;
				}

				return f.getName().equals("tos_image.xml");
			}
		});

		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

			tfInstallTosImagePath.setText(fileChooser.getSelectedFile()
					.getAbsolutePath());
		}

	}

	private void startMoteMessageService() {

		ServiceStatus serviceStatus = moteMessageService.start(settingsDialog
				.getSource());

		if (serviceStatus.getStatus() == State.Running) {

			btnConnection.setBackground(Color.GREEN);
			btnConnection.setText("Connected");
		} else {

			btnConnection.setBackground(Color.RED);
			btnConnection.setText("Disconnected");
			displayMoteMessageServiceStatusError(serviceStatus);
		}
	}

	private void executeInstall() {

		// Get parameters
		int imageNum = Integer.parseInt((String) cbInstallImgNum
				.getSelectedItem());
		String pathToTosImageXml = tfInstallTosImagePath.getText();

		// Execute and display command results
		displayTosDelugeResults(tosDelugeExecutor.install(imageNum,
				pathToTosImageXml));

	}

	private void executeDisseminateReboot() {

		// Get parameters
		int imageNum = Integer.parseInt((String) cbDrImgNum.getSelectedItem());

		// Execute and display command results
		displayTosDelugeResults(tosDelugeExecutor.disseminateReboot(imageNum));
	}

	private void executeDisseminateRebootNodes() {

		// Get parameters
		int imageNum = Integer.parseInt((String) cbDrnImgNum.getSelectedItem());

		long nodeIdsHash = Long.parseLong(tfDrnNodeIds.getText());

		displayTosDelugeResults(tosDelugeExecutor.disseminateRebootNodes(
				imageNum, nodeIdsHash));

	}

	private void executeDisseminateRebootGroup() {

		// Get parameters
		int imageNum = Integer.parseInt((String) cbDrgImgNum.getSelectedItem());
		int groupId = Integer.parseInt(tfDrgGroupId.getText());

		displayTosDelugeResults(tosDelugeExecutor.disseminateRebootGroup(
				imageNum, groupId));

	}

	private void executeUpdateNodeGroup() {
		// Get parameters
		long nodeIdsHash = Long.parseLong(tfUngNodeIds.getText());
		int groupId = Integer.parseInt(tfUngGroupId.getText());

		displayTosDelugeResults(tosDelugeExecutor.updateGroup(nodeIdsHash,
				groupId));

	}

	private void displayTosDelugeResults(ProcessResult processResult) {

		taConsole.append(processResult.getCommand().toString() + "\n");
		taConsole.append(processResult.toString());
	}

	private void displayMoteMessageServiceStatusError(
			ServiceStatus serviceStatus) {

		taConsole
				.append(String
						.format("Attempted to start the MoteMessageService (Source=\"%s\") but captured the following error:\n",
								serviceStatus.getSource()));
		taConsole.append(serviceStatus.getErrorText());
	}

	private void initializeDisseminateRebootNodesPanel(
			JPanel pDisseminateRebootNodes) {
		pDisseminateRebootNodes.setLayout(new MigLayout("", "[][grow][]",
				"[][][]"));

		JLabel lbDrnImgNum = new JLabel("image number:");
		pDisseminateRebootNodes.add(lbDrnImgNum, "cell 0 0,alignx trailing");

		cbDrnImgNum = new JComboBox();
		cbDrnImgNum.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4" }));
		pDisseminateRebootNodes.add(cbDrnImgNum, "cell 1 0,growx");

		JLabel lblDrnNodeIds = new JLabel("node IDs hash:");
		pDisseminateRebootNodes.add(lblDrnNodeIds, "cell 0 1,alignx trailing");

		tfDrnNodeIds = new JTextField();
		tfDrnNodeIds.setText("0");
		tfDrnNodeIds.setEditable(false);
		pDisseminateRebootNodes.add(tfDrnNodeIds, "cell 1 1,growx");
		tfDrnNodeIds.setColumns(10);

		JButton btnDrnUpdate = new JButton("Update");
		btnDrnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drnUpdateNodeIdsHash();
			}
		});
		pDisseminateRebootNodes.add(btnDrnUpdate, "cell 2 1");

		JLabel lblDrnCmd = new JLabel("command:");
		pDisseminateRebootNodes.add(lblDrnCmd, "cell 0 2,alignx trailing");

		tfDrnCmd = new JTextField();
		tfDrnCmd.setEditable(false);
		tfDrnCmd.setText("tos-deluge command");
		pDisseminateRebootNodes.add(tfDrnCmd, "cell 1 2,growx,aligny top");
		tfDrnCmd.setColumns(10);

		JButton btnDrnExecute = new JButton("Execute");
		btnDrnExecute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				executeDisseminateRebootNodes();
			}
		});
		pDisseminateRebootNodes.add(btnDrnExecute, "cell 2 2");

	}

	private void initializeDisseminateRebootGroupPanel(
			JPanel pDisseminateRebootGroup) {
		pDisseminateRebootGroup.setLayout(new MigLayout("", "[][grow][]",
				"[][][]"));

		JLabel lblDrgImgNum = new JLabel("image number:");
		pDisseminateRebootGroup.add(lblDrgImgNum, "cell 0 0,alignx trailing");

		cbDrgImgNum = new JComboBox();
		cbDrgImgNum.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4" }));
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
		btnDrgExecute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				executeDisseminateRebootGroup();
			}
		});
		pDisseminateRebootGroup.add(btnDrgExecute, "cell 2 2");

	}

	private void initializeUpdateGroupPanel(JPanel pUpdateGroup) {
		pUpdateGroup.setLayout(new MigLayout("", "[][grow][]", "[][][]"));

		JLabel lblUngNodeIds = new JLabel("node IDs hash:");
		pUpdateGroup.add(lblUngNodeIds, "cell 0 0,alignx trailing");

		tfUngNodeIds = new JTextField();
		tfUngNodeIds.setEditable(false);
		tfUngNodeIds.setText("0");
		pUpdateGroup.add(tfUngNodeIds, "cell 1 0,growx");
		tfUngNodeIds.setColumns(10);

		JButton btnUngUpdate = new JButton("Update");
		btnUngUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ungUpdateNodeIdsHash();
			}
		});
		pUpdateGroup.add(btnUngUpdate, "cell 2 0");

		JLabel lblUngGroupId = new JLabel("group ID:");
		pUpdateGroup.add(lblUngGroupId, "cell 0 1,alignx trailing");

		tfUngGroupId = new JTextField();
		tfUngGroupId.setText("1");
		pUpdateGroup.add(tfUngGroupId, "cell 1 1,growx");
		tfUngGroupId.setColumns(10);

		JLabel lblUngCmd = new JLabel("command:");
		pUpdateGroup.add(lblUngCmd, "cell 0 2,alignx trailing");

		tfUngCmd = new JTextField();
		tfUngCmd.setEditable(false);
		tfUngCmd.setText("tos-deluge command");
		pUpdateGroup.add(tfUngCmd, "cell 1 2,growx");
		tfUngCmd.setColumns(10);

	}

	private void initializeMenuBar(JMenuBar menuBar) {

		this.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (settingsDialog.display() == DialogResult.OK) {

					tosDelugeExecutor.setSource(settingsDialog.getSource());
				}
			}
		});
		mnFile.add(mntmSettings);

	}

	private void initializeNodeTable(JTable tbNodeStatus2) {

		tableNodeStatus.setModel(new DefaultTableModel(new Object[][] { { null,
				null, null, null, null, null }, }, new String[] { "",
				"Node ID", "Group ID", "State", "App UID", "App Name" }) {
			Class<?>[] columnTypes = new Class[] { Boolean.class,
					Integer.class, Integer.class, String.class, Integer.class,
					String.class };

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

	}

	private void initializeTextArea(JTextArea taConsole) {

		taConsole.setEditable(false);
		taConsole.addMouseListener(new ConsoleMouseAdapter(
				new ConsoleContextMenu(taConsole)));
	}

	private void initializeStatusPanel(JPanel pStatus) {

		pStatus.setBorder(new BevelBorder(BevelBorder.LOWERED));
		pStatus.setPreferredSize(new Dimension(this.getWidth(), 18));
		pStatus.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		pStatus.setLayout(new BoxLayout(pStatus, BoxLayout.LINE_AXIS));

		btnConnection = new JButton("Disconnected");
		btnConnection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				startMoteMessageService();
			}
		});
		btnConnection.setBackground(Color.RED);
		pStatus.add(btnConnection);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeGui() {

		this.setBounds(100, 100, 722, 560);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		initializeMenuBar(menuBar);

		tableNodeStatus = new JTable();
		initializeNodeTable(tableNodeStatus);

		JSplitPane spRoot = new JSplitPane();
		spRoot.setDividerSize(7);
		spRoot.setOrientation(JSplitPane.VERTICAL_SPLIT);
		spRoot.setOneTouchExpandable(true);
		spRoot.setResizeWeight(0.66);
		this.getContentPane().add(spRoot, BorderLayout.CENTER);

		JScrollPane spTable = new JScrollPane();
		spTable.setViewportView(tableNodeStatus);

		spChild = new JSplitPane();
		spChild.setDividerSize(7);
		spChild.setOrientation(JSplitPane.VERTICAL_SPLIT);
		spChild.setOneTouchExpandable(true);
		spChild.setResizeWeight(0.5);

		spChild.setLeftComponent(spTable);

		JScrollPane spCommandTabs = new JScrollPane();
		spChild.setRightComponent(spCommandTabs);

		JTabbedPane tpCommands = new JTabbedPane(SwingConstants.TOP);
		spCommandTabs.setViewportView(tpCommands);

		JPanel pInstall = new JPanel();
		JPanel pDisseminateReboot = new JPanel();
		JPanel pDisseminateRebootNodes = new JPanel();
		JPanel pDisseminateRebootGroup = new JPanel();
		JPanel pUpdateGroup = new JPanel();

		tpCommands.addTab("Install", pInstall);
		initializeInstallPanel(pInstall);

		tpCommands.addTab("Disseminate-Reboot", pDisseminateReboot);
		initializeDisseminateRebootPanel(pDisseminateReboot);

		tpCommands.addTab("Disseminate-Reboot-Nodes", pDisseminateRebootNodes);
		initializeDisseminateRebootNodesPanel(pDisseminateRebootNodes);

		tpCommands.addTab("Disseminate-Reboot-Group", pDisseminateRebootGroup);
		initializeDisseminateRebootGroupPanel(pDisseminateRebootGroup);

		tpCommands.addTab("Update-Group", pUpdateGroup);
		initializeUpdateGroupPanel(pUpdateGroup);

		JButton btnUngExecute = new JButton("Execute");
		btnUngExecute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				executeUpdateNodeGroup();
			}
		});
		pUpdateGroup.add(btnUngExecute, "cell 2 2");

		taConsole = new JTextArea();
		initializeTextArea(taConsole);

		JScrollPane spConsole = new JScrollPane();
		spConsole.setViewportView(taConsole);

		spRoot.setLeftComponent(spChild);
		spRoot.setRightComponent(spConsole);

		JPanel pStatus = new JPanel();
		initializeStatusPanel(pStatus);
		getContentPane().add(pStatus, BorderLayout.SOUTH);

	}
}
