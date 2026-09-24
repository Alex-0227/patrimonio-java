package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.patrimonio.dao.DAOCurso;
import br.com.patrimonio.dao.DAOUsuario;
import br.com.patrimonio.pojo.Usuarios;

public class Cursos extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtNomeCurso;
	private JTextField txtSigla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Cursos frame = new Cursos();
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
	public Cursos() {

		setTitle("SURVEY_PROGRAM_CURSOS");
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 339);

		// =====================================================
		// PAINEL
		// =====================================================

		contentPane = new JPanel();

		contentPane.setBorder(
				new EmptyBorder(5, 5, 5, 5)
		);

		setContentPane(contentPane);

		contentPane.setLayout(null);

		DAOUsuario dau = new DAOUsuario();

		// =====================================================
		// COMBOBOX CRIADO POR
		// =====================================================

		JComboBox cbxCriadoPor = new JComboBox();

		cbxCriadoPor.setBounds(
				249,
				172,
				364,
				22
		);

		contentPane.add(cbxCriadoPor);

		// =====================================================
		// CARREGA USUÁRIOS
		// =====================================================

		List<Usuarios> lst =
				dau.listaAtivos();

		for (Usuarios us : lst) {

			cbxCriadoPor.addItem(us);
		}

		// =====================================================
		// LABEL CRIADO POR
		// =====================================================

		JLabel lblCriadoPor =
				new JLabel("Criado Por:");

		lblCriadoPor.setHorizontalAlignment(
				SwingConstants.CENTER
		);

		lblCriadoPor.setForeground(
				Color.WHITE
		);

		lblCriadoPor.setFont(
				new Font(
						"Serif",
						Font.PLAIN,
						20
				)
		);

		lblCriadoPor.setBounds(
				36,
				164,
				158,
				30
		);

		contentPane.add(lblCriadoPor);

		// =====================================================
		// LABEL SIGLA
		// =====================================================

		JLabel lblSigla =
				new JLabel("Sigla:");

		lblSigla.setHorizontalAlignment(
				SwingConstants.CENTER
		);

		lblSigla.setForeground(
				Color.WHITE
		);

		lblSigla.setFont(
				new Font(
						"Serif",
						Font.PLAIN,
						20
				)
		);

		lblSigla.setBounds(
				36,
				99,
				158,
				30
		);

		contentPane.add(lblSigla);

		// =====================================================
		// LABEL NOME
		// =====================================================

		JLabel lblNome =
				new JLabel("Nome do curso:");

		lblNome.setHorizontalAlignment(
				SwingConstants.CENTER
		);

		lblNome.setFont(
				new Font(
						"Serif",
						Font.PLAIN,
						20
				)
		);

		lblNome.setForeground(
				Color.WHITE
		);

		lblNome.setBounds(
				36,
				26,
				158,
				30
		);

		contentPane.add(lblNome);

		// =====================================================
		// BOTÃO CADASTRAR
		// =====================================================

		JButton btnCadastrar =
				new JButton("cadastrar");

		btnCadastrar.setBounds(
				270,
				244,
				307,
				45
		);

		contentPane.add(btnCadastrar);

		// =====================================================
		// CAMPO NOME
		// =====================================================

		txtNomeCurso =
				new JTextField();

		txtNomeCurso.setBounds(
				249,
				30,
				364,
				30
		);

		contentPane.add(txtNomeCurso);

		txtNomeCurso.setColumns(10);

		// =====================================================
		// CAMPO SIGLA
		// =====================================================

		txtSigla =
				new JTextField();

		txtSigla.setColumns(10);

		txtSigla.setBounds(
				249,
				103,
				364,
				30
		);

		contentPane.add(txtSigla);

		// =====================================================
		// BACKGROUND
		// =====================================================

		JLabel lblBG =
				new JLabel("New label");

		lblBG.setIcon(
				new ImageIcon(
						Cursos.class.getResource(
								"/br/com/patrimonio/imagens/bg22.png"
						)
				)
		);

		lblBG.setBounds(
				-64,
				0,
				428,
				312
		);

		contentPane.add(lblBG);

		// =====================================================
		// BACKGROUND PRINCIPAL
		// =====================================================

		JLabel BG =
				new JLabel("");

		BG.setIcon(
				new ImageIcon(
						Cursos.class.getResource(
								"/br/com/patrimonio/imagens/chapter2 - Copia.png"
						)
				)
		);

		BG.setBounds(
				90,
				-35,
				656,
				423
		);

		contentPane.add(BG);

		// =====================================================
		// BOTÃO CADASTRAR
		// =====================================================

		btnCadastrar.addActionListener(
				new ActionListener() {

					public void actionPerformed(
							ActionEvent e) {

						// -------------------------------------
						// PEGA OS DADOS DA TELA
						// -------------------------------------

						String nome =
								txtNomeCurso
										.getText()
										.trim();

						String sigla =
								txtSigla
										.getText()
										.trim();

						// -------------------------------------
						// VALIDA NOME E SIGLA
						// -------------------------------------

						if (nome.isEmpty()
								|| sigla.isEmpty()) {

							JOptionPane.showMessageDialog(
									null,
									"Preencha o nome do curso e a sigla.",
									"Erro",
									JOptionPane.ERROR_MESSAGE
							);

							// -----------------------------
							// SOM DE ERRO
							// -----------------------------

							tocarSomErro();

							return;
						}

						// -------------------------------------
						// PEGA O USUÁRIO SELECIONADO
						// -------------------------------------

						Usuarios u =
								(Usuarios)
								cbxCriadoPor
										.getSelectedItem();

						// -------------------------------------
						// VALIDA USUÁRIO
						// -------------------------------------

						if (u == null) {

							JOptionPane.showMessageDialog(
									null,
									"Nenhum usuário foi selecionado.",
									"Erro",
									JOptionPane.ERROR_MESSAGE
							);

							// -----------------------------
							// SOM DE ERRO
							// -----------------------------

							tocarSomErro();

							return;
						}

						// -------------------------------------
						// CRIA OBJETO CURSO
						// -------------------------------------

						br.com.patrimonio.pojo.Cursos curso =
								new br.com.patrimonio.pojo.Cursos();

						// -------------------------------------
						// CRIA DAO
						// -------------------------------------

						DAOCurso dc =
								new DAOCurso();

						// -------------------------------------
						// PASSA OS DADOS PARA O OBJETO
						// -------------------------------------

						curso.setNome(nome);

						curso.setSigla(sigla);

						curso.setCriado_por(
								u.getId()
						);

						// -------------------------------------
						// CADASTRA NO BANCO
						// -------------------------------------

						String m =
								dc.cadastrar(curso);

						// -------------------------------------
						// MOSTRA RESULTADO
						// -------------------------------------

						JOptionPane.showMessageDialog(
								null,
								m
						);

						// -------------------------------------
						// VERIFICA O RESULTADO
						// -------------------------------------

						if (m != null &&
								(m.toLowerCase().contains("erro")
								|| m.toLowerCase().contains(
										"não foi possível"))) {

							// -------------------------------
							// SOM DE ERRO
							// -------------------------------

							tocarSomErro();

						} else {

							// -------------------------------
							// SOM DE CADASTRO
							// -------------------------------

							tocarSomCadastro();
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
							Cursos.class.getResource(
									"/br/com/patrimonio/sfx/ch2_intro.wav"
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
							Cursos.class.getResource(
									"/br/com/patrimonio/sfx/cadastro_all.wav"
							)
					);

			Clip clip =
					AudioSystem.getClip();

			clip.open(audio);

			clip.start();

			System.out.println(
					"Som de cadastro iniciado!"
			);

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
							Cursos.class.getResource(
									"/br/com/patrimonio/sfx/ch2_error.wav"
							)
					);

			Clip clip =
					AudioSystem.getClip();

			clip.open(audio);

			clip.start();

			System.out.println(
					"Som de erro iniciado!"
			);

		} catch (Exception e) {

			System.out.println(
					"Erro ao reproduzir o som de erro:"
			);

			e.printStackTrace();
		}
	}
}
