package main;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.io.*;
import sun.audio.*;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import retalho.Retalho;

/**
 * @author  Emanuel Lopes
 */
public class JanelaPrincipal extends JFrame implements Runnable {

	private JPanel contentPane;
	private JLabel lblOrcamento;
	private JLabel lblInformacao;
	private GridPanel gridRetalho;
	private GridPanel gridBiofarm;
	/**
	 * @uml.property  name="biofarm"
	 * @uml.associationEnd  
	 */
	private BioFarm biofarm;
	/**
	 * @uml.property  name="retalho"
	 * @uml.associationEnd  
	 */
	private Retalho retalho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
					Thread cicloJogo = new Thread(frame);
					cicloJogo.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(73, 154, 73));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblOrcamento = new JLabel("Or\u00E7amento");
		lblOrcamento.setIcon(new ImageIcon(JanelaPrincipal.class
				.getResource("/imagens/dinheiro.png")));
		lblOrcamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrcamento.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblOrcamento.setForeground(Color.WHITE);
		contentPane.add(lblOrcamento, BorderLayout.NORTH);

		gridRetalho = new GridPanel();
		gridRetalho.setRowSize(64);
		gridRetalho.setColumnSize(64);
		gridRetalho.setBackgroundColor(new Color(0, 120, 0));
		gridRetalho.setNumberOfRows(4);
		gridRetalho.setNumberOfColumns(1);
		gridRetalho.setShowGridLines(true);
		contentPane.add(gridRetalho, BorderLayout.EAST);

		gridBiofarm = new GridPanel();
		gridBiofarm.setRowSize(64);
		gridBiofarm.setColumnSize(64);
		gridBiofarm.setBackgroundColor(new Color(73, 154, 73));
		gridBiofarm.setNumberOfRows(7);
		gridBiofarm.setNumberOfColumns(12);
		gridBiofarm.setShowGridLines(true);
		contentPane.add(gridBiofarm, BorderLayout.CENTER);
		
		lblInformacao = new JLabel("Informacao");
		lblInformacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacao.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblInformacao.setForeground(new Color(255,255,255,0));
		contentPane.add(lblInformacao, BorderLayout.SOUTH);
		
		retalho = new Retalho(gridRetalho, lblInformacao);
		biofarm = new BioFarm(gridBiofarm, lblOrcamento, lblInformacao, retalho);
		
		new ReproduzirSom().playMusicBackground("musica_fundo.wav", true);
	}
	


	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {
						biofarm.iterar();
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}
