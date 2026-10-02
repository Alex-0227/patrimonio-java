package br.com.patrimonio.janela;

import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TelaSplash extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	// ==========================================================
	// TOCAR ÁUDIO
	// ==========================================================

	private static void tocarAudio(String arquivo) {

		try {

			AudioInputStream audio =
					AudioSystem.getAudioInputStream(
							TelaSplash.class.getResource(
									"/br/com/patrimonio/sfx/" + arquivo
							)
					);

			Clip clip =
					AudioSystem.getClip();

			clip.open(audio);

			clip.start();

			System.out.println(
					"Áudio iniciado: " + arquivo
			);

		} catch (Exception e) {

			System.out.println(
					"Erro ao reproduzir o áudio: " + arquivo
			);

			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame();

		// ==========================================================
		// CONFIGURAÇÕES DA SPLASH
		// ==========================================================

		frame.setType(java.awt.Window.Type.UTILITY);

		frame.setResizable(false);

		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE
		);

		frame.setBounds(
				100,
				100,
				532,
				537
		);

		// ==========================================================
		// CONTENT PANE
		// ==========================================================

		JPanel contentPane =
				new JPanel();

		contentPane.setBorder(
				new EmptyBorder(
						5,
						5,
						5,
						5
				)
		);

		frame.setContentPane(contentPane);

		contentPane.setLayout(null);

		// ==========================================================
		// CENTRALIZAR SPLASH
		// ==========================================================

		frame.setLocationRelativeTo(null);

		// ==========================================================
		// RETIRAR BORDAS E TÍTULO
		// ==========================================================

		frame.setUndecorated(true);

		// ==========================================================
		// BARRA DE PROGRESSO
		// ==========================================================

		JProgressBar progressBar =
				new JProgressBar();

		progressBar.setStringPainted(true);

		progressBar.setBackground(
				new Color(
						255,
						255,
						255
				)
		);

		progressBar.setForeground(
				new Color(
						0,
						0,
						0
				)
		);

		progressBar.setValue(0);

		progressBar.setBounds(
				12,
				475,
				496,
				12
		);

		contentPane.add(progressBar);

		// ==========================================================
		// LEGENDA
		// ==========================================================

		JLabel lblLegenda =
				new JLabel("...");

		lblLegenda.setForeground(
				new Color(
						255,
						255,
						255
				)
		);

		lblLegenda.setHorizontalAlignment(
				SwingConstants.LEFT
		);

		lblLegenda.setBounds(
				22,
				498,
				202,
				26
		);

		contentPane.add(lblLegenda);

		// ==========================================================
		// HAKO
		// ==========================================================

		JLabel lblHako =
				new JLabel("HAKO");

		lblHako.setForeground(
				new Color(
						255,
						255,
						255
				)
		);

		lblHako.setFont(
				new Font(
						"Tahoma",
						Font.BOLD,
						40
				)
		);

		lblHako.setBounds(
				363,
				409,
				145,
				78
		);

		contentPane.add(lblHako);

		// ==========================================================
		// DELTA
		// ==========================================================

		JLabel lblTitle =
				new JLabel("DELTA");

		lblTitle.setForeground(
				new Color(
						255,
						255,
						255
				)
		);

		lblTitle.setFont(
				new Font(
						"Tahoma",
						Font.BOLD,
						40
				)
		);

		lblTitle.setBounds(
				22,
				409,
				174,
				78
		);

		contentPane.add(lblTitle);

		// ==========================================================
		// IMAGEM DELTA
		// ==========================================================

		JLabel lblDelta =
				new JLabel("");

		lblDelta.setIcon(
				new ImageIcon(
						TelaSplash.class.getResource(
								"/br/com/patrimonio/imagens/delta.png"
						)
				)
		);

		lblDelta.setBounds(
				0,
				0,
				521,
				473
		);

		contentPane.add(lblDelta);

		// ==========================================================
		// IMAGEM BLACK
		// ==========================================================

		JLabel lblNewLabel =
				new JLabel("New label");

		lblNewLabel.setIcon(
				new ImageIcon(
						TelaSplash.class.getResource(
								"/br/com/patrimonio/imagens/BBlack.png"
						)
				)
		);

		lblNewLabel.setBounds(
				10,
				427,
				511,
				104
		);

		contentPane.add(lblNewLabel);

		// ==========================================================
		// FUNDO TRANSPARENTE
		// ==========================================================

		frame.setBackground(
				new Color(
						0.0f,
						0.0f,
						0.0f,
						0.0f
				)
		);

		// ==========================================================
		// MOSTRA SPLASH
		// ==========================================================

		frame.setVisible(true);

		// ==========================================================
		// CARREGAMENTO
		// ==========================================================

		try {

			for (int i = 0; i <= 100; i++) {

				Thread.sleep(70);

				progressBar.setValue(i);

				if (i < 30) {

					lblLegenda.setText(
							"Carregando"
					);

				} else if (i < 60) {

					lblLegenda.setText(
							"Carregando modulos"
					);

				} else if (i < 80) {

					lblLegenda.setText(
							"Carregando as configurações"
					);

				} else if (i < 90) {

					lblLegenda.setText(
							"Iniciando a interface"
					);

				} else {

					lblLegenda.setText(
							"Tudo pronto!"
					);
				}
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		// ==========================================================
		// ENCERRA A SPLASH
		// ==========================================================

		frame.dispose();

		// ==========================================================
		// SOM DE ENCERRAMENTO DA SPLASH /
		// INICIALIZAÇÃO DA APLICAÇÃO
		// ==========================================================

		tocarAudio("StartupApp2.wav");

		// ==========================================================
		// ABRE TELA PRINCIPAL
		// ==========================================================

		TelaPrincipal tp =
				new TelaPrincipal();

		tp.setVisible(true);
	}
}
