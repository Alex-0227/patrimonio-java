package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.patrimonio.dao.DAOCategorias;

public class Categorias extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField lblNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Categorias frame =
							new Categorias();

					frame.setVisible(true);

					// =====================================================
					// SOM DE INTRODUÇÃO
					// =====================================================

					frame.tocarSomIntro();

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Categorias() {

		setResizable(false);

		setTitle(
				"SURVEY_PROGRAM_CATEGORIAS"
		);

		setDefaultCloseOperation(
				JFrame.DISPOSE_ON_CLOSE
		);

		setBounds(
				100,
				100,
				667,
				411
		);

		contentPane =
				new JPanel();

		contentPane.setBackground(
				new Color(0, 0, 0)
		);

		contentPane.setBorder(
				new EmptyBorder(
						5,
						5,
						5,
						5
				)
		);

		setContentPane(contentPane);

		contentPane.setLayout(null);

		// =====================================================
		// LABEL DESCRIÇÃO
		// =====================================================

		JLabel lblDescrio =
				new JLabel(
						"Descrição:"
				);

		lblDescrio.setForeground(
				Color.WHITE
		);

		lblDescrio.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		lblDescrio.setBounds(
				10,
				126,
				111,
				47
		);

		contentPane.add(
				lblDescrio
		);

		// =====================================================
		// LABEL NOME DA CATEGORIA
		// =====================================================

		JLabel lblNewLabel =
				new JLabel(
						"Nome da categoria:"
				);

		lblNewLabel.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		lblNewLabel.setForeground(
				new Color(
						255,
						255,
						255
				)
		);

		lblNewLabel.setBounds(
				10,
				58,
				221,
				47
		);

		contentPane.add(
				lblNewLabel
		);

		// =====================================================
		// CAMPO DESCRIÇÃO
		// =====================================================

		JTextArea lblDescricao =
				new JTextArea();

		lblDescricao.setBounds(
				241,
				137,
				385,
				78
		);

		contentPane.add(
				lblDescricao
		);

		// =====================================================
		// CAMPO NOME
		// =====================================================

		lblNome =
				new JTextField();

		lblNome.setBounds(
				241,
				70,
				385,
				30
		);

		contentPane.add(
				lblNome
		);

		lblNome.setColumns(
				10
		);

		// =====================================================
		// BOTÃO CADASTRAR
		// =====================================================

		JButton btnCadastrar =
				new JButton(
						"Cadastrar"
				);

		btnCadastrar.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		btnCadastrar.setBounds(
				241,
				304,
				228,
				57
		);

		contentPane.add(
				btnCadastrar
		);

		// =====================================================
		// BACKGROUND
		// =====================================================

		JLabel lblDisplay =
				new JLabel("");

		lblDisplay.setIcon(
				new ImageIcon(
						Categorias.class.getResource(
								"/br/com/patrimonio/imagens/bg22.png"
						)
				)
		);

		lblDisplay.setBounds(
				-71,
				-25,
				353,
				397
		);

		contentPane.add(
				lblDisplay
		);

		JLabel darkdesign =
				new JLabel("");

		darkdesign.setBounds(
				137,
				-114,
				1006,
				547
		);

		darkdesign.setIcon(
				new ImageIcon(
						Categorias.class.getResource(
								"/br/com/patrimonio/imagens/darksanctuary.jpg"
						)
				)
		);

		contentPane.add(
				darkdesign
		);

		// =====================================================
		// BOTÃO CADASTRAR
		// =====================================================

		btnCadastrar.addActionListener(
				new ActionListener() {

					public void actionPerformed(
							ActionEvent e) {

						// -----------------------------------------
						// VALIDA NOME
						// -----------------------------------------

						if (lblNome.getText()
								.trim()
								.isEmpty()) {

							tocarSomErro();

							JOptionPane.showMessageDialog(
									null,
									"Informe o nome da categoria.",
									"Erro",
									JOptionPane.ERROR_MESSAGE
							);

							lblNome.requestFocus();

							return;
						}

						// -----------------------------------------
						// CRIA OBJETO CATEGORIA
						// -----------------------------------------

						br.com.patrimonio.pojo.Categorias obj =
								new br.com.patrimonio.pojo.Categorias();

						// -----------------------------------------
						// PEGA OS DADOS DA TELA
						// -----------------------------------------

						obj.setNome(
								lblNome.getText().trim()
						);

						obj.setDescricao(
								lblDescricao.getText().trim()
						);

						// -----------------------------------------
						// CRIA DAO
						// -----------------------------------------

						DAOCategorias dao =
								new DAOCategorias();

						// -----------------------------------------
						// CADASTRA
						// -----------------------------------------

						String mensagem =
								dao.cadastrar(obj);

						// -----------------------------------------
						// MOSTRA RESULTADO
						// -----------------------------------------

						JOptionPane.showMessageDialog(
								null,
								mensagem,
								"Aviso",
								JOptionPane.WARNING_MESSAGE
						);

						// -----------------------------------------
						// VERIFICA SUCESSO OU ERRO
						// -----------------------------------------

						/*
						 * Ajuste esta comparação caso o seu
						 * DAOCategorias utilize outra mensagem
						 * de sucesso.
						 */
						if ("Cadastro realizado".equals(mensagem)
								|| "Categoria cadastrada!".equals(mensagem)) {

							// -------------------------------
							// SOM DE CADASTRO
							// -------------------------------

							tocarSomCadastro();

							// -------------------------------
							// LIMPA CAMPOS
							// -------------------------------

							lblNome.setText("");
							lblDescricao.setText("");

							lblNome.requestFocus();

						} else {

							// -------------------------------
							// SOM DE ERRO
							// -------------------------------

							tocarSomErro();
						}
					}
				}
		);
	}

	// =========================================================
	// TOCAR SOM DE INTRODUÇÃO
	// =========================================================

	private void tocarSomIntro() {

		try {

			AudioInputStream audio =
					AudioSystem.getAudioInputStream(
							Categorias.class.getResource(
									"/br/com/patrimonio/sfx/ch4_intro.wav"
							)
					);

			Clip clip =
					AudioSystem.getClip();

			clip.open(audio);

			clip.start();

			System.out.println(
					"Som de introdução iniciado!"
			);

		} catch (Exception e) {

			System.out.println(
					"Erro ao reproduzir o som de introdução:"
			);

			e.printStackTrace();
		}
	}

	// =========================================================
	// TOCAR SOM DE CADASTRO
	// =========================================================

	private void tocarSomCadastro() {

		try {

			AudioInputStream audio =
					AudioSystem.getAudioInputStream(
							Categorias.class.getResource(
									"/br/com/patrimonio/sfx/cadastro_all.wav"
							)
					);

			Clip clip =
					AudioSystem.getClip();

			clip.open(audio);

			clip.start();

		} catch (Exception e) {

			System.out.println(
					"Erro ao reproduzir o som de cadastro:"
			);

			e.printStackTrace();
		}
	}

	// =========================================================
	// TOCAR SOM DE ERRO
	// =========================================================

	private void tocarSomErro() {

		try {

			AudioInputStream audio =
					AudioSystem.getAudioInputStream(
							Categorias.class.getResource(
									"/br/com/patrimonio/sfx/ch4_error.wav"
							)
					);

			Clip clip =
					AudioSystem.getClip();

			clip.open(audio);

			clip.start();

		} catch (Exception e) {

			System.out.println(
					"Erro ao reproduzir o som de erro:"
			);

			e.printStackTrace();
		}
	}
}