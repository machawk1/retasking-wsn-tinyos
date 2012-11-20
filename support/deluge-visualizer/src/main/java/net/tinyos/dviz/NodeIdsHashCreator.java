package net.tinyos.dviz;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class NodeIdsHashCreator extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField tfNodeIdsHash;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            NodeIdsHashCreator dialog = new NodeIdsHashCreator();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public NodeIdsHashCreator() {
        setBounds(100, 100, 493, 182);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new MigLayout("", "[][][][][][][][][][][]", "[][][]"));
        {
            JCheckBox checkBox = new JCheckBox("0");
            contentPanel.add(checkBox, "cell 0 0");
        }
        {
            JCheckBox checkBox = new JCheckBox("1");
            contentPanel.add(checkBox, "cell 1 0");
        }
        {
            JCheckBox checkBox = new JCheckBox("2");
            contentPanel.add(checkBox, "cell 2 0");
        }
        {
            JCheckBox checkBox = new JCheckBox("3");
            contentPanel.add(checkBox, "cell 3 0");
        }
        {
            JCheckBox checkBox = new JCheckBox("4");
            contentPanel.add(checkBox, "cell 4 0");
        }
        {
            JCheckBox checkBox = new JCheckBox("5");
            contentPanel.add(checkBox, "cell 5 0");
        }
        {
            JCheckBox checkBox = new JCheckBox("6");
            contentPanel.add(checkBox, "cell 6 0");
        }
        {
            JCheckBox checkBox = new JCheckBox("7");
            contentPanel.add(checkBox, "cell 7 0");
        }
        {
            JCheckBox checkBox = new JCheckBox("8");
            contentPanel.add(checkBox, "cell 8 0");
        }
        {
            JCheckBox checkBox = new JCheckBox("9");
            contentPanel.add(checkBox, "cell 9 0");
        }
        {
            JCheckBox checkBox = new JCheckBox("10");
            contentPanel.add(checkBox, "cell 10 0");
        }
        {
            JCheckBox checkBox = new JCheckBox("11");
            contentPanel.add(checkBox, "cell 0 1");
        }
        {
            JCheckBox checkBox = new JCheckBox("12");
            contentPanel.add(checkBox, "cell 1 1");
        }
        {
            JCheckBox checkBox = new JCheckBox("13");
            contentPanel.add(checkBox, "cell 2 1");
        }
        {
            JCheckBox checkBox = new JCheckBox("14");
            contentPanel.add(checkBox, "cell 3 1");
        }
        {
            JCheckBox checkBox = new JCheckBox("15");
            contentPanel.add(checkBox, "cell 4 1");
        }
        {
            JCheckBox checkBox = new JCheckBox("16");
            contentPanel.add(checkBox, "cell 5 1");
        }
        {
            JCheckBox checkBox = new JCheckBox("17");
            contentPanel.add(checkBox, "cell 6 1");
        }
        {
            JCheckBox checkBox = new JCheckBox("18");
            contentPanel.add(checkBox, "cell 7 1");
        }
        {
            JCheckBox checkBox = new JCheckBox("19");
            contentPanel.add(checkBox, "cell 8 1");
        }
        {
            JCheckBox checkBox = new JCheckBox("20");
            contentPanel.add(checkBox, "cell 9 1");
        }
        {
            JCheckBox checkBox = new JCheckBox("21");
            contentPanel.add(checkBox, "cell 10 1");
        }
        {
            JCheckBox checkBox = new JCheckBox("22");
            contentPanel.add(checkBox, "cell 0 2");
        }
        {
            JCheckBox checkBox = new JCheckBox("23");
            contentPanel.add(checkBox, "cell 1 2");
        }
        {
            JCheckBox checkBox = new JCheckBox("24");
            contentPanel.add(checkBox, "cell 2 2");
        }
        {
            JCheckBox checkBox = new JCheckBox("25");
            contentPanel.add(checkBox, "cell 3 2");
        }
        {
            JCheckBox checkBox = new JCheckBox("26");
            contentPanel.add(checkBox, "cell 4 2");
        }
        {
            JCheckBox checkBox = new JCheckBox("27");
            contentPanel.add(checkBox, "cell 5 2");
        }
        {
            JCheckBox checkBox = new JCheckBox("28");
            contentPanel.add(checkBox, "cell 6 2");
        }
        {
            JCheckBox checkBox = new JCheckBox("29");
            contentPanel.add(checkBox, "cell 7 2");
        }
        {
            JCheckBox checkBox = new JCheckBox("30");
            contentPanel.add(checkBox, "cell 8 2");
        }
        {
            JCheckBox checkBox = new JCheckBox("31");
            contentPanel.add(checkBox, "cell 9 2");
        }
        {
            JPanel buttonPane = new JPanel();
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            buttonPane.setLayout(new MigLayout("", "[][118.00][][][][][][][][]", "[]"));
            {
                JLabel lblNodeIdsHash = new JLabel("NodeIds Hash:");
                buttonPane.add(lblNodeIdsHash, "cell 0 0,alignx left,aligny center");
            }
            {
                tfNodeIdsHash = new JTextField();
                tfNodeIdsHash.setEditable(false);
                buttonPane.add(tfNodeIdsHash, "cell 1 0,growx,aligny center");
                tfNodeIdsHash.setColumns(10);
            }
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton, "cell 8 0,alignx center,aligny top");
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton, "cell 9 0,alignx left,aligny center");
            }
        }
    }

}
