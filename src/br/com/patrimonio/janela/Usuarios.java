package br.com.patrimonio.janela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import br.com.patrimonio.dao.DAOUsuario;
import br.com.patrimonio.pojo.Perfil;

public class Usuarios extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtEmail;
	private JLabel lblPerfilDeUsurio;
	private JComboBox cbxPerfil;
	private JLabel lblSenha;
	private JPasswordField txtSenha;
	private JCheckBox chkAtivo;
	private JLabel lblAtivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Usuarios frame = new Usuarios();

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
	public Usuarios() {

		setTitle("Cadastro de Usuarios");

		setBackground(SystemColor.desktop);

		setForeground(SystemColor.text);

		setResizable(false);

		setDefaultCloseOperation(
				JFrame.DISPOSE_ON_CLOSE
		);

		setBounds(
				100,
				100,
				748,
				407
		);

		contentPane = new JPanel();

		contentPane.setForeground(
				SystemColor.text
		);

		contentPane.setBackground(
				SystemColor.desktop
		);

		contentPane.setBorder(
				new BevelBorder(
						BevelBorder.LOWERED,
						SystemColor.text,
						SystemColor.text,
						SystemColor.text,
						SystemColor.text
				)
		);

		setContentPane(contentPane);

		contentPane.setLayout(null);

		// =====================================================
		// LABEL NOME
		// =====================================================

		JLabel lbl_nome_usuario =
				new JLabel("Nome de Usuário");

		lbl_nome_usuario.setFont(
				new Font(
						"Tahoma",
						Font.BOLD,
						11
				)
		);

		lbl_nome_usuario.setBounds(
				10,
				14,
				114,
				14
		);

		lbl_nome_usuario.setHorizontalAlignment(
				SwingConstants.LEFT
		);

		lbl_nome_usuario.setForeground(
				SystemColor.text
		);

		contentPane.add(lbl_nome_usuario);

		// =====================================================
		// CAMPO USUÁRIO
		// =====================================================

		txtUsuario =
				new JTextField();

		txtUsuario.setBounds(
				369,
				11,
				297,
				20
		);

		contentPane.add(txtUsuario);

		txtUsuario.setColumns(10);

		// =====================================================
		// LABEL EMAIL
		// =====================================================

		JLabel lblEmail =
				new JLabel("Endereço de Email");

		lblEmail.setFont(
				new Font(
						"Tahoma",
						Font.BOLD,
						11
				)
		);

		lblEmail.setHorizontalAlignment(
				SwingConstants.LEFT
		);

		lblEmail.setForeground(
				SystemColor.text
		);

		lblEmail.setBounds(
				10,
				42,
				164,
				14
		);

		contentPane.add(lblEmail);

		// =====================================================
		// CAMPO EMAIL
		// =====================================================

		txtEmail =
				new JTextField();

		txtEmail.setColumns(10);

		txtEmail.setBounds(
				369,
				39,
				297,
				20
		);

		contentPane.add(txtEmail);

		// =====================================================
		// LABEL PERFIL
		// =====================================================

		lblPerfilDeUsurio =
				new JLabel("Perfil de Usuário");

		lblPerfilDeUsurio.setFont(
				new Font(
						"Tahoma",
						Font.BOLD,
						11
				)
		);

		lblPerfilDeUsurio.setHorizontalAlignment(
				SwingConstants.LEFT
		);

		lblPerfilDeUsurio.setForeground(
				SystemColor.text
		);

		lblPerfilDeUsurio.setBounds(
				10,
				109,
				137,
				14
		);

		contentPane.add(lblPerfilDeUsurio);

		// =====================================================
		// COMBOBOX PERFIL
		// =====================================================

		cbxPerfil =
				new JComboBox();

		cbxPerfil.setModel(
				new DefaultComboBoxModel(
						Perfil.values()
				)
		);

		cbxPerfil.setBounds(
				369,
				101,
				297,
				22
		);

		contentPane.add(cbxPerfil);

		// =====================================================
		// LABEL SENHA
		// =====================================================

		lblSenha =
				new JLabel("Senha");

		lblSenha.setFont(
				new Font(
						"Tahoma",
						Font.BOLD,
						11
				)
		);

		lblSenha.setHorizontalAlignment(
				SwingConstants.LEFT
		);

		lblSenha.setForeground(
				SystemColor.text
		);

		lblSenha.setBounds(
				10,
				73,
				37,
				14
		);

		contentPane.add(lblSenha);

		// =====================================================
		// CAMPO SENHA
		// =====================================================

		txtSenha =
				new JPasswordField();

		txtSenha.setBounds(
				369,
				70,
				297,
				20
		);

		contentPane.add(txtSenha);

		// =====================================================
		// CHECKBOX ATIVO
		// =====================================================

		chkAtivo =
				new JCheckBox("Sim");

		chkAtivo.setBounds(
				369,
				140,
				297,
				23
		);

		contentPane.add(chkAtivo);

		// =====================================================
		// LABEL ATIVO
		// =====================================================

		lblAtivo =
				new JLabel("Ativo");

		lblAtivo.setFont(
				new Font(
						"Tahoma",
						Font.BOLD,
						11
				)
		);

		lblAtivo.setHorizontalAlignment(
				SwingConstants.LEFT
		);

		lblAtivo.setForeground(
				SystemColor.text
		);

		lblAtivo.setBounds(
				10,
				144,
				81,
				14
		);

		contentPane.add(lblAtivo);

		// =====================================================
		// BOTÃO CADASTRAR
		// =====================================================

		JButton btnCadastrar =
				new JButton("Cadastrar");

		btnCadastrar.setIcon(
				new ImageIcon(
						Usuarios.class.getResource(
								"/br/com/patrimonio/imagens/iconbutton.png"
						)
				)
		);

		btnCadastrar.setBounds(
				190,
				282,
				414,
				75
		);

		contentPane.add(btnCadastrar);

		// =====================================================
		// BACKGROUND
		// =====================================================

		JLabel bg =
				new JLabel("New label");

		bg.setIcon(
				new ImageIcon(
						Usuarios.class.getResource(
								"/br/com/patrimonio/imagens/chapter1.png"
						)
				)
		);

		bg.setBounds(
				-193,
				-31,
				1004,
				553
		);

		contentPane.add(bg);

		// =====================================================
		// BOTÃO CADASTRAR
		// =====================================================

		btnCadastrar.addActionListener(
				new java.awt.event.ActionListener() {

					public void actionPerformed(
							java.awt.event.ActionEvent e) {

						// -----------------------------------------
						// VALIDA NOME DE USUÁRIO
						// -----------------------------------------

						if (txtUsuario.getText()
								.trim()
								.isEmpty()) {

							tocarSomErro();

							JOptionPane.showMessageDialog(
									null,
									"Informe o nome de usuário.",
									"Erro",
									JOptionPane.ERROR_MESSAGE
							);

							txtUsuario.requestFocus();

							return;
						}

						// -----------------------------------------
						// VALIDA EMAIL
						// -----------------------------------------

						if (txtEmail.getText()
								.trim()
								.isEmpty()) {

							tocarSomErro();

							JOptionPane.showMessageDialog(
									null,
									"Informe o endereço de email.",
									"Erro",
									JOptionPane.ERROR_MESSAGE
							);

							txtEmail.requestFocus();

							return;
						}

						// -----------------------------------------
						// VALIDA SENHA
						// -----------------------------------------

						if (txtSenha.getText()
								.trim()
								.isEmpty()) {

							tocarSomErro();

							JOptionPane.showMessageDialog(
									null,
									"Informe a senha.",
									"Erro",
									JOptionPane.ERROR_MESSAGE
							);

							txtSenha.requestFocus();

							return;
						}

						// -----------------------------------------
						// CRIA OBJETO USUÁRIO
						// -----------------------------------------

						br.com.patrimonio.pojo.Usuarios us =
								new br.com.patrimonio.pojo.Usuarios();

						// -----------------------------------------
						// PEGA OS DADOS DA TELA
						// -----------------------------------------

						us.setNome(
								txtUsuario.getText().trim()
						);

						us.setEmail(
								txtEmail.getText().trim()
						);

						us.setSenha_hash(
								txtSenha.getText()
						);

						us.setPerfil(
								(Perfil)
								cbxPerfil.getSelectedItem()
						);

						us.setAtivo(
								chkAtivo.isSelected()
						);

						// -----------------------------------------
						// CRIA DAO
						// -----------------------------------------

						DAOUsuario dau =
								new DAOUsuario();

						// -----------------------------------------
						// CADASTRA
						// -----------------------------------------

						String rs =
								dau.cadastrar(us);

						// -----------------------------------------
						// MOSTRA RESULTADO
						// -----------------------------------------

						JOptionPane.showMessageDialog(
								null,
								rs,
								"Aviso",
								JOptionPane.WARNING_MESSAGE
						);

						// -----------------------------------------
						// VERIFICA SUCESSO OU ERRO
						// -----------------------------------------

						if ("Usuário cadastrado!".equals(rs)) {

							// -------------------------------
							// SOM DE CADASTRO
							// -------------------------------

							tocarSomCadastro();

							// -------------------------------
							// LIMPA CAMPOS
							// -------------------------------

							txtUsuario.setText("");
							txtEmail.setText("");
							txtSenha.setText("");

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
							Usuarios.class.getResource(
									"/br/com/patrimonio/sfx/ch1_intro.wav"
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
							Usuarios.class.getResource(
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
							Usuarios.class.getResource(
									"/br/com/patrimonio/sfx/ch1_error.wav"
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
