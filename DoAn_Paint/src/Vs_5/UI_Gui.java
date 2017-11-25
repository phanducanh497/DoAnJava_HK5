package Vs_5;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseListener;

public class UI_Gui {
	
	DrawArea drawArea;
	private JFrame frame_Paint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Gui window = new UI_Gui();
					window.frame_Paint.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI_Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame_Paint = new JFrame();
		frame_Paint.setBounds(100, 100, 850, 472);
		frame_Paint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_Paint.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 834, 433);
		frame_Paint.getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 834, 21);
		panel.add(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem itemNew = new JMenuItem("New");
		menuFile.add(itemNew);
		
		Button bnt_Pencil = new Button("Pencil");
		bnt_Pencil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawArea draw=new DrawArea();
				Graphics g=null;
				draw.paintComponent(g);
			}
		});
		bnt_Pencil.setBounds(0, 21, 70, 22);
		panel.add(bnt_Pencil);
		
		Button bntClear = new Button("Clear");
		bntClear.setBounds(71, 21, 70, 22);
		panel.add(bntClear);
	}
}
