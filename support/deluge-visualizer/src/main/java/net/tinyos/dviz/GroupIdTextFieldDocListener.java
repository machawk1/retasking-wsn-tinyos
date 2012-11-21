package net.tinyos.dviz;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GroupIdTextFieldDocListener implements DocumentListener {

    public static interface GroupIdChangedListener {

        public void valueChanged(String newValue);
    }

    private JLabel lblGroupId;
    private JTextField tfGroupId;
    private GroupIdChangedListener groupIdChangedListener;
    private JButton executeButton;

    public GroupIdTextFieldDocListener(JLabel lblGroupId, JTextField tfGroupId, JButton executeButton, GroupIdChangedListener groupIdChangedListener) {

        this.lblGroupId = lblGroupId;
        this.tfGroupId = tfGroupId;
        this.groupIdChangedListener = groupIdChangedListener;
        this.executeButton = executeButton;
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkNewValue();

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        checkNewValue();

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkNewValue();

    }

    private void newValueIsInValid() {
        lblGroupId.setForeground(Color.RED);
        executeButton.setEnabled(false);
    }

    private void newValueIsValid() {
        lblGroupId.setForeground(Color.BLACK);
        executeButton.setEnabled(true);
        groupIdChangedListener.valueChanged(tfGroupId.getText());
    }

    private void checkNewValue() {

        try {
            if (Integer.parseInt(tfGroupId.getText()) < 0) {

                newValueIsInValid();
            } else {

                newValueIsValid();
            }
        } catch (NumberFormatException e) {

            newValueIsInValid();
        }
    }
}
