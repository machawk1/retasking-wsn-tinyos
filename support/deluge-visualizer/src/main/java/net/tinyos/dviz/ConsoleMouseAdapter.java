package net.tinyos.dviz;

import java.awt.event.MouseEvent;

import java.awt.event.MouseAdapter;

public class ConsoleMouseAdapter extends MouseAdapter {

	private ConsoleContextMenu consoleContextMenu;

	public ConsoleMouseAdapter(ConsoleContextMenu consoleContextMenu) {

		this.consoleContextMenu = consoleContextMenu;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.isPopupTrigger())
			doPop(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger())
			doPop(e);
	}

	private void doPop(MouseEvent e) {

		consoleContextMenu.show(e.getComponent(), e.getX(), e.getY());
	}
}
