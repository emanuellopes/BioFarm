package main;

import java.awt.Color;

import javax.swing.JLabel;

public class AnimarLabel {

	private JLabel label;
	private Thread thread;
	private int alpha;

	public AnimarLabel(JLabel label) {
		this.label = label;
		alpha = 255;
	}

	public void Animando(String text) {
		alpha=255;
		label.setText(text);
		label.setForeground(new Color(255, 255, 255, alpha));
		thread = new Thread(new Runnable() {
			public void run() {
				while (alpha > 0) {
					alpha -= 10;
					try {
						thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (alpha < 0)
						alpha = 0;
					label.setForeground(new Color(255, 255, 255, alpha));
				}

			}
		});
		thread.start();
	}
}
