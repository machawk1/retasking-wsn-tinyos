package net.tinyos.dviz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class SettingsDialog extends JDialog {

    public enum DialogResult {
        OK, Cancel
    };

    private DialogResult result = DialogResult.Cancel;
    private final JPanel contentPanel = new JPanel();
    private JTextField tfSource;

    private String source;
    private String tosDeluge;
    private JTextField tfTosDeluge;

    public String getSource() {

        return source;
    }

    public String getTosDeluge() {

        return tosDeluge;
    }

    /**
     * Create the dialog.
     */
    public SettingsDialog(String defaultSource, String defaultTosDeluge) {
        this.source = defaultSource;
        this.tosDeluge = defaultTosDeluge;

        setTitle("Settings");
        setBounds(100, 100, 450, 135);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new MigLayout("", "[][grow]", "[][]"));
        {
            JLabel lblSource = new JLabel("source:");
            contentPanel.add(lblSource, "cell 0 0,alignx trailing");
        }
        {
            tfSource = new JTextField();
            tfSource.setText(source);
            contentPanel.add(tfSource, "cell 1 0,growx");
            tfSource.setColumns(10);
        }
        {
            JLabel lblTosDelugePath = new JLabel("tos-deluge path:");
            contentPanel.add(lblTosDelugePath, "cell 0 1,alignx trailing");
        }
        {
            tfTosDeluge = new JTextField();
            tfTosDeluge.setText("tos-deluge");
            contentPanel.add(tfTosDeluge, "cell 1 1,growx");
            tfTosDeluge.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        source = tfSource.getText();
                        tosDeluge = tfTosDeluge.getText();
                        result = DialogResult.OK;
                        SettingsDialog.this.close();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        tfSource.setText(source);
                        tfTosDeluge.setText(tosDeluge);
                        result = DialogResult.Cancel;
                        SettingsDialog.this.close();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    public DialogResult display() {

        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        return result;
    }

    public void close() {

        this.setVisible(false);
        this.dispatchEvent(new WindowEvent(SettingsDialog.this, WindowEvent.WINDOW_CLOSING));
    }

}
