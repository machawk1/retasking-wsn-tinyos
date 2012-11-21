package net.tinyos.dviz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class NodeIdsHashCreator extends JDialog {

	public enum DialogResult {
		OK, Cancel
	};

	private DialogResult result = DialogResult.Cancel;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNodeIdsHash;
	private long currentNodeIdsHash = 0;

	/**
	 * Create the dialog.
	 */
	public NodeIdsHashCreator() {
		setResizable(false);
		setTitle("Node IDs Hash Creator");
		setBounds(100, 100, 493, 182);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][][][][][][][][]",
				"[][][]"));
		{
			JCheckBox checkBox = new JCheckBox("0");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 0 0");
		}
		{
			JCheckBox checkBox = new JCheckBox("1");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 1 0");
		}
		{
			JCheckBox checkBox = new JCheckBox("2");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 2 0");
		}
		{
			JCheckBox checkBox = new JCheckBox("3");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 3 0");
		}
		{
			JCheckBox checkBox = new JCheckBox("4");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 4 0");
		}
		{
			JCheckBox checkBox = new JCheckBox("5");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 5 0");
		}
		{
			JCheckBox checkBox = new JCheckBox("6");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 6 0");
		}
		{
			JCheckBox checkBox = new JCheckBox("7");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 7 0");
		}
		{
			JCheckBox checkBox = new JCheckBox("8");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 8 0");
		}
		{
			JCheckBox checkBox = new JCheckBox("9");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 9 0");
		}
		{
			JCheckBox checkBox = new JCheckBox("10");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 10 0");
		}
		{
			JCheckBox checkBox = new JCheckBox("11");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 0 1");
		}
		{
			JCheckBox checkBox = new JCheckBox("12");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 1 1");
		}
		{
			JCheckBox checkBox = new JCheckBox("13");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 2 1");
		}
		{
			JCheckBox checkBox = new JCheckBox("14");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 3 1");
		}
		{
			JCheckBox checkBox = new JCheckBox("15");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 4 1");
		}
		{
			JCheckBox checkBox = new JCheckBox("16");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 5 1");
		}
		{
			JCheckBox checkBox = new JCheckBox("17");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 6 1");
		}
		{
			JCheckBox checkBox = new JCheckBox("18");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 7 1");
		}
		{
			JCheckBox checkBox = new JCheckBox("19");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 8 1");
		}
		{
			JCheckBox checkBox = new JCheckBox("20");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 9 1");
		}
		{
			JCheckBox checkBox = new JCheckBox("21");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 10 1");
		}
		{
			JCheckBox checkBox = new JCheckBox("22");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 0 2");
		}
		{
			JCheckBox checkBox = new JCheckBox("23");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 1 2");
		}
		{
			JCheckBox checkBox = new JCheckBox("24");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 2 2");
		}
		{
			JCheckBox checkBox = new JCheckBox("25");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 3 2");
		}
		{
			JCheckBox checkBox = new JCheckBox("26");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 4 2");
		}
		{
			JCheckBox checkBox = new JCheckBox("27");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 5 2");
		}
		{
			JCheckBox checkBox = new JCheckBox("28");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 6 2");
		}
		{
			JCheckBox checkBox = new JCheckBox("29");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 7 2");
		}
		{
			JCheckBox checkBox = new JCheckBox("30");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 8 2");
		}
		{
			JCheckBox checkBox = new JCheckBox("31");
			checkBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkBoxUpdated((JCheckBox) e.getSource());
				}
			});
			contentPanel.add(checkBox, "cell 9 2");
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new MigLayout("", "[][118.00][146.00][][]", "[]"));
			{
				JLabel lblNodeIdsHash = new JLabel("node IDs hash:");
				buttonPane.add(lblNodeIdsHash,
						"cell 0 0,alignx left,aligny center");
			}
			{
				tfNodeIdsHash = new JTextField();
				tfNodeIdsHash.setEditable(false);
				buttonPane.add(tfNodeIdsHash, "cell 1 0,growx,aligny center");
				tfNodeIdsHash.setColumns(10);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						result = DialogResult.OK;
						NodeIdsHashCreator.this.close();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton, "cell 3 0,alignx center,aligny top");
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						result = DialogResult.Cancel;
						NodeIdsHashCreator.this.close();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton,
						"cell 4 0,alignx left,aligny center");
			}
		}
	}

	private void checkBoxUpdated(JCheckBox checkBox) {

		// System.out.println(String.format("CheckBox Num:(%s) Value:%b",
		// checkBox.getText(), checkBox.isSelected()));

		boolean setBit = checkBox.isSelected();
		long bit = Long.parseLong(checkBox.getText());

		if (setBit) {

			currentNodeIdsHash = currentNodeIdsHash | (1L << bit);
		} else {

			currentNodeIdsHash = currentNodeIdsHash & ~(1L << bit);
		}

		// Update JTextField
		tfNodeIdsHash.setText(Long.toString(currentNodeIdsHash));

	}

	private void deselectAllCheckBoxes() {

		for (Component component : contentPanel.getComponents()) {

			JCheckBox checkBox = (JCheckBox) component;
			checkBox.setSelected(false);
		}
	}

	private void matchCheckBoxesToNodeIdsHash(long nodeIdsHash) {

		// Loop through all 32 bits
		for (int i = 0; i <= 31; ++i) {

			// If the ith bit is set select the corresponding checkbox
			if ((nodeIdsHash & (1L << i)) != 0) {

				JCheckBox checkBox = (JCheckBox) contentPanel.getComponent(i);
				checkBox.setSelected(true);
			}
		}

	}

	public long getNodeIdsHash() {

		return currentNodeIdsHash;
	}

	public DialogResult display(long nodeIdsHash) {

		if (nodeIdsHash != currentNodeIdsHash) {

			deselectAllCheckBoxes();
			matchCheckBoxesToNodeIdsHash(nodeIdsHash);
			currentNodeIdsHash = nodeIdsHash;
			tfNodeIdsHash.setText(Long.toString(currentNodeIdsHash));
		}

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		return result;
	}

	public void close() {

		this.setVisible(false);
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

}
