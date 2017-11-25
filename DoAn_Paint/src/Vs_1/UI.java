package Vs_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Color;

public class UI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("\r\n");
		menuBar.setBounds(0, 0, 424, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Save");
		mnFile.add(mntmNewMenuItem);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JButton button = new JButton("");
		button.setBounds(0, 21, 43, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(43, 21, 43, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(85, 21, 43, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(128, 21, 43, 23);
		frame.getContentPane().add(button_3);
		
		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 54, 414, 197);
		frame.getContentPane().add(panel);
		
		
	}
}
