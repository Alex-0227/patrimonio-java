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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.patrimonio.dao.DAOUsuario;
import br.com.patrimonio.dao.DAOLocais;
import br.com.patrimonio.pojo.Usuarios;

public class Locais extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Locais frame = new Locais();

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
	public Locais() {

		setDefaultCloseOperation(
				JFrame.DISPOSE_ON_CLOSE
		);

		setResizable(false);

		setTitle(
				"SURVEY_PROGRAM_LOCAIS"
		);

		setBounds(
				100,
				100,
				719,
				390
		);

		// =====================================================
		// PAINEL
		// =====================================================

		contentPane =
				new JPanel();

		contentPane.setBorder(
				new EmptyBorder(
						5,
						5,
						5,
						5
				)
		);

		setContentPane(
				contentPane
		);

		contentPane.setLayout(null);

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

		// =====================================================
		// DESCRIÇÃO
		// =====================================================

		JTextArea textDescricao =
				new JTextArea();

		textDescricao.setBounds(
				288,
				128,
				388,
				94
		);

		contentPane.add(
				textDescricao
		);

		// =====================================================
		// LABEL CRIADO POR
		// =====================================================

		JLabel lblCriadoPor =
				new JLabel(
						"Criado por:"
				);

		lblCriadoPor.setForeground(
				Color.WHITE
		);

		lblCriadoPor.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						26
				)
		);

		lblCriadoPor.setBounds(
				37,
				227,
				154,
				30
		);

		contentPane.add(
				lblCriadoPor
		);

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
						26
				)
		);

		lblDescrio.setBounds(
				37,
				119,
				154,
				30
		);

		contentPane.add(
				lblDescrio
		);

		// =====================================================
		// LABEL LOCAL
		// =====================================================

		JLabel lblNewLabel =
				new JLabel(
						"Local:"
				);

		lblNewLabel.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						26
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
				37,
				40,
				154,
				30
		);

		contentPane.add(
				lblNewLabel
		);

		// =====================================================
		// COMBOBOX USUÁRIO
		// =====================================================

		JComboBox<Usuarios> cbxCriado_Por =
				new JComboBox<Usuarios>();

		cbxCriado_Por.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		cbxCriado_Por.setBounds(
				288,
				233,
				388,
				22
		);

		contentPane.add(
				cbxCriado_Por
		);

		// =====================================================
		// CARREGAR USUÁRIOS ATIVOS
		// =====================================================

		DAOUsuario daoUsuario =
				new DAOUsuario();

		for (Usuarios u :
				daoUsuario.listaAtivos()) {

			cbxCriado_Por.addItem(
					u
			);
		}

		// =====================================================
		// CAMPO NOME
		// =====================================================

		textNome =
				new JTextField();

		textNome.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		textNome.setBounds(
				288,
				42,
				388,
				31
		);

		contentPane.add(
				textNome
		);

		textNome.setColumns(
				10
		);

		// =====================================================
		// BOTÃO
		// =====================================================

		btnCadastrar.setBounds(
				288,
				278,
				274,
				62
		);

		contentPane.add(
				btnCadastrar
		);

		// =====================================================
		// BACKGROUND
		// =====================================================

		JLabel Picture_Display =
				new JLabel("");

		Picture_Display.setIcon(
				new ImageIcon(
						Locais.class.getResource(
								"/br/com/patrimonio/imagens/bg22.png"
						)
				)
		);

		Picture_Display.setBounds(
				-80,
				-27,
				642,
				424
		);

		contentPane.add(
				Picture_Display
		);

		// =====================================================
		// BACKGROUND CHAPTER 3M
		// =====================================================

		JLabel TVTIMEM =
				new JLabel("");

		TVTIMEM.setIcon(
				new ImageIcon(
						Locais.class.getResource(
								"/br/com/patrimonio/imagens/chapter3M.png"
						)
				)
		);

		TVTIMEM.setBounds(
				131,
				-143,
				736,
				502
		);

		contentPane.add(
				TVTIMEM
		);

		// =====================================================
		// BACKGROUND CHAPTER 3
		// =====================================================

		JLabel TVTIME =
				new JLabel("");

		TVTIME.setIcon(
				new ImageIcon(
						Locais.class.getResource(
								"/br/com/patrimonio/imagens/chapter3.png"
						)
				)
		);

		TVTIME.setBounds(
				-342,
				-281,
				1380,
				1035
		);

		contentPane.add(
				TVTIME
		);

		// =====================================================
		// BOTÃO CADASTRAR
		// =====================================================

		btnCadastrar.addActionListener(
				new ActionListener() {

					public void actionPerformed(
							ActionEvent e) {

						// -----------------------------------------
						// VALIDA NOME DO LOCAL
						// -----------------------------------------

						if (textNome.getText()
								.trim()
								.isEmpty()) {

							tocarSomErro();

							JOptionPane.showMessageDialog(
									null,
									"Informe o nome do local.",
									"Erro",
									JOptionPane.ERROR_MESSAGE
							);

							textNome.requestFocus();

							return;
						}

						// -----------------------------------------
						// PEGA O USUÁRIO
						// -----------------------------------------

						Usuarios u =
								(Usuarios)
								cbxCriado_Por
										.getSelectedItem();

						// -----------------------------------------
						// VALIDA USUÁRIO
						// -----------------------------------------

						if (u == null) {

							tocarSomErro();

							JOptionPane.showMessageDialog(
									null,
									"Selecione o usuário que criou o local.",
									"Erro",
									JOptionPane.ERROR_MESSAGE
							);

							return;
						}

						// -----------------------------------------
						// CRIA OBJETO LOCAL
						// -----------------------------------------

						br.com.patrimonio.pojo.Locais obj =
								new br.com.patrimonio.pojo.Locais();

						// -----------------------------------------
						// PEGA OS DADOS DA TELA
						// -----------------------------------------

						obj.setLocal(
								textNome.getText().trim()
						);

						obj.setDescricao(
								textDescricao.getText().trim()
						);

						// -----------------------------------------
						// SALVA ID DO USUÁRIO
						// -----------------------------------------

						obj.setCriado_por(
								u.getId()
						);

						// -----------------------------------------
						// CRIA DAO
						// -----------------------------------------

						DAOLocais dao =
								new DAOLocais();

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
						// VERIFICA SUCESSO
						// -----------------------------------------

						if ("Cadastro realizado".equals(mensagem)) {

							// -------------------------------
							// SOM DE CADASTRO
							// -------------------------------

							tocarSomCadastro();

							// -------------------------------
							// LIMPA CAMPOS
							// -------------------------------

							textNome.setText("");

							textDescricao.setText("");

							if (cbxCriado_Por.getItemCount() > 0) {

								cbxCriado_Por.setSelectedIndex(
										0
								);
							}

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
							Locais.class.getResource(
									"/br/com/patrimonio/sfx/ch3_intro.wav"
							)
					);

			Clip clip =
					AudioSystem.getClip();

			clip.open(
					audio
			);

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
							Locais.class.getResource(
									"/br/com/patrimonio/sfx/cadastro_all.wav"
							)
					);

			Clip clip =
					AudioSystem.getClip();

			clip.open(
					audio
			);

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
							Locais.class.getResource(
									"/br/com/patrimonio/sfx/ch3_error.wav"
							)
					);

			Clip clip =
					AudioSystem.getClip();

			clip.open(
					audio
			);

			clip.start();

		} catch (Exception e) {

			System.out.println(
					"Erro ao reproduzir o som de erro:"
			);

			e.printStackTrace();
		}
	}
}