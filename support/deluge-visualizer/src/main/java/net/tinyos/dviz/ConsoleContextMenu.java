package net.tinyos.dviz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ConsoleContextMenu extends JPopupMenu {

    private JTextArea console;

    public ConsoleContextMenu(JTextArea console) {

        this.console = console;

        JMenuItem clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ConsoleContextMenu.this.console.setText("");

            }
        });

        add(clearMenuItem);
    }

}
