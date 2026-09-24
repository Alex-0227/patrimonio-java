package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// ==========================================================
	// MÉTODO PARA TOCAR ÁUDIO
	// ==========================================================

	private void tocarAudio(String arquivo) {

		try {

			String caminho = "/br/com/patrimonio/sfx/" + arquivo;

			System.out.println("Tentando abrir: " + caminho);

			InputStream input =
					TelaPrincipal.class.getResourceAsStream(caminho);

			if (input == null) {

				System.out.println("ERRO: arquivo não encontrado!");
				System.out.println("Caminho procurado: " + caminho);

				return;
			}

			System.out.println("Arquivo encontrado!");

			AudioInputStream audioStream =
					AudioSystem.getAudioInputStream(input);

			Clip clip = AudioSystem.getClip();

			clip.open(audioStream);

			clip.start();

			System.out.println("Áudio iniciado!");

		} catch (Exception e) {

			System.out.println("ERRO AO TOCAR ÁUDIO:");
			e.printStackTrace();

		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {

		setTitle("SURVEY_PROGRAM_GESTAO_DE_PATRIMONIO");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Obter a resolução da tela

		setBounds(100, 100, 1920, 1000);

		// Abrir a tela sempre maximizada

		setExtendedState(MAXIMIZED_BOTH);

		// ==========================================================
		// MENU
		// ==========================================================

		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		// ==========================================================
		// MENU CADASTRAR
		// ==========================================================

		JMenu mnCadastrar = new JMenu("Cadastrar");

		mnCadastrar.setMnemonic('c');

		menuBar.add(mnCadastrar);

		// ==========================================================
		// USUÁRIO
		// ==========================================================

		JMenuItem itemUsuario =
				new JMenuItem("Usuário");

		itemUsuario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Toca ch1_intro.wav
				tocarAudio("ch1_intro.wav");

				Usuarios formUsuario =
						new Usuarios();

				formUsuario.setVisible(true);
			}
		});

		itemUsuario.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_U,
						InputEvent.CTRL_DOWN_MASK
								| InputEvent.SHIFT_DOWN_MASK));

		itemUsuario.setBackground(
				new Color(255, 255, 255));

		mnCadastrar.add(itemUsuario);

		// ==========================================================
		// CURSOS
		// ==========================================================

		JMenuItem itemCursos =
				new JMenuItem("Cursos");

		itemCursos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Toca ch2_intro.wav
				tocarAudio("ch2_intro.wav");

				Cursos formCurso =
						new Cursos();

				formCurso.setVisible(true);
			}
		});

		itemCursos.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_C,
						InputEvent.CTRL_DOWN_MASK
								| InputEvent.SHIFT_DOWN_MASK));

		itemCursos.setBackground(
				new Color(255, 255, 255));

		mnCadastrar.add(itemCursos);

		// ==========================================================
		// LOCAIS
		// ==========================================================

		JMenuItem itemLocais =
				new JMenuItem("Locais");

		itemLocais.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Toca ch3_intro.wav
				tocarAudio("ch3_intro.wav");

				Locais formLocal =
						new Locais();

				formLocal.setVisible(true);
			}
		});

		itemLocais.setBackground(
				new Color(255, 255, 255));

		mnCadastrar.add(itemLocais);

		// ==========================================================
		// CATEGORIA
		// ==========================================================

		JMenuItem itemCategoria =
				new JMenuItem("Categoria");

		itemCategoria.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Toca ch4_intro.wav
				tocarAudio("ch4_intro.wav");

				Categorias formCategoria =
						new Categorias();

				formCategoria.setVisible(true);
			}
		});

		itemCategoria.setBackground(
				new Color(255, 255, 255));

		mnCadastrar.add(itemCategoria);

		// ==========================================================
		// PATRIMÔNIO
		// ==========================================================

		JMenuItem itemPatrimonio =
				new JMenuItem("Patrimônio");

		itemPatrimonio.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Toca ch5_intro.wav
				tocarAudio("ch5_intro.wav");

				Patrimonios formPatrimonio =
						new Patrimonios();

				formPatrimonio.setVisible(true);
			}
		});

		itemPatrimonio.setBackground(
				new Color(255, 255, 255));

		mnCadastrar.add(itemPatrimonio);

		// ==========================================================
		// MOVIMENTAÇÃO
		// ==========================================================

		JMenuItem itemMovimentacao =
				new JMenuItem("Movimentação");

		itemMovimentacao.setBackground(
				new Color(255, 255, 255));

		mnCadastrar.add(itemMovimentacao);

		// ==========================================================
		// BAIXAR PATRIMÔNIO
		// ==========================================================

		JMenuItem itemBaixarPatrimonio =
				new JMenuItem("Baixar Patrimônio");

		itemBaixarPatrimonio.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_B,
						InputEvent.CTRL_DOWN_MASK
								| InputEvent.SHIFT_DOWN_MASK));

		itemBaixarPatrimonio.setBackground(
				new Color(255, 255, 255));

		mnCadastrar.add(itemBaixarPatrimonio);

		// ==========================================================
		// MENU CONSULTA
		// ==========================================================

		JMenu mnConsulta =
				new JMenu("Consulta");

		mnConsulta.setMnemonic('s');

		menuBar.add(mnConsulta);

		// ==========================================================
		// LISTAR TUDO
		// ==========================================================

		JMenu itemListarTudo =
				new JMenu("Listar Tudo");

		mnConsulta.add(itemListarTudo);

		JMenuItem itemLstUsuario =
				new JMenuItem("Usuário");

		itemListarTudo.add(itemLstUsuario);

		JMenuItem itemLstCursos =
				new JMenuItem("Cursos");
		itemLstCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ListarCursos().setVisible(true);
			}
		});

		itemListarTudo.add(itemLstCursos);

		JMenuItem itemLstPatrimonio =
				new JMenuItem("Patrimônio");

		itemListarTudo.add(itemLstPatrimonio);

		// ==========================================================
		// PESQUISAR POR ID
		// ==========================================================

		JMenu itemPesquisarPorId =
				new JMenu("Pesquisar por ID");

		mnConsulta.add(itemPesquisarPorId);

		JMenuItem itemPorIdMovimentacao =
				new JMenuItem("Movimentação");

		itemPesquisarPorId.add(itemPorIdMovimentacao);

		JMenuItem itemPorIdBaixarPatrimonio =
				new JMenuItem("Baixar Patrimônio");

		itemPesquisarPorId.add(
				itemPorIdBaixarPatrimonio);

		JSeparator separator =
				new JSeparator();

		mnConsulta.add(separator);

		// ==========================================================
		// USUÁRIO POR...
		// ==========================================================

		JMenu itemConsultaUsuario =
				new JMenu("Usuario Por ...");

		mnConsulta.add(itemConsultaUsuario);

		JMenuItem ItemConsultaPerfil =
				new JMenuItem("Perfil");

		itemConsultaUsuario.add(
				ItemConsultaPerfil);

		JMenuItem itemConsutalEmail =
				new JMenuItem("E-Mail");

		itemConsultaUsuario.add(
				itemConsutalEmail);

		JSeparator separator_1 =
				new JSeparator();

		mnConsulta.add(separator_1);

		// ==========================================================
		// MOVIMENTAÇÃO
		// ==========================================================

		JMenu itemConsultaMovimentacao =
				new JMenu("Movimentação");

		mnConsulta.add(
				itemConsultaMovimentacao);

		JMenuItem itemConsultaTipo =
				new JMenuItem("Tipo");

		itemConsultaMovimentacao.add(
				itemConsultaTipo);

		// ==========================================================
		// CONTENT PANE
		// ==========================================================

		contentPane =
				new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));

		contentPane.setBorder(
				new EmptyBorder(
						5, 5, 5, 5));

		contentPane.setBounds(
				0, 0, 1920, 1000);

		setContentPane(contentPane);

		contentPane.setLayout(null);

		// ==========================================================
		// TOOLBAR
		// ==========================================================

		JToolBar toolBar =
				new JToolBar();

		toolBar.setFloatable(false);

		toolBar.setBounds(
				0,
				0,
				getWidth(),
				28);

		contentPane.add(toolBar);

		// ==========================================================
		// BOTÃO USUÁRIOS
		// ==========================================================

		JButton btnAbrirUsuarios =
				new JButton("");

		btnAbrirUsuarios.setToolTipText(
				"Abrir configurações de usuarios (Ctrl+Shift+U)");

		btnAbrirUsuarios.setIcon(
				new ImageIcon(
						TelaPrincipal.class.getResource(
								"/br/com/patrimonio/imagens/Icons/IconUser.png")));

		btnAbrirUsuarios.addActionListener(
				new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Toca ch1_intro.wav
				tocarAudio("ch1_intro.wav");

				Usuarios formUsuario =
						new Usuarios();

				formUsuario.setVisible(true);
			}
		});

		toolBar.add(btnAbrirUsuarios);

		// ==========================================================
		// BOTÃO CURSOS
		// ==========================================================

		JButton btnAbrirCursos =
				new JButton("");

		btnAbrirCursos.addActionListener(
				new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Toca ch2_intro.wav
				tocarAudio("ch2_intro.wav");

				Cursos formCurso =
						new Cursos();

				formCurso.setVisible(true);
			}
		});

		btnAbrirCursos.setToolTipText(
				"Abrir configurações de Cursos");

		btnAbrirCursos.setIcon(
				new ImageIcon(
						TelaPrincipal.class.getResource(
								"/br/com/patrimonio/imagens/Icons/IconCursos.png")));

		toolBar.add(btnAbrirCursos);

		// ==========================================================
		// BOTÃO LOCAIS
		// ==========================================================

		JButton btnAbrirLocais =
				new JButton("");

		btnAbrirLocais.addActionListener(
				new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Toca ch3_intro.wav
				tocarAudio("ch3_intro.wav");

				Locais formLocal =
						new Locais();

				formLocal.setVisible(true);
			}
		});

		btnAbrirLocais.setToolTipText(
				"Abrir configurações de locais");

		btnAbrirLocais.setIcon(
				new ImageIcon(
						TelaPrincipal.class.getResource(
								"/br/com/patrimonio/imagens/Icons/IconLocais.png")));

		toolBar.add(btnAbrirLocais);

		// ==========================================================
		// BOTÃO CATEGORIAS
		// ==========================================================

		JButton btnAbrirCategorias =
				new JButton("");

		btnAbrirCategorias.addActionListener(
				new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Toca ch4_intro.wav
				tocarAudio("ch4_intro.wav");

				Categorias formCategoria =
						new Categorias();

				formCategoria.setVisible(true);
			}
		});

		btnAbrirCategorias.setToolTipText(
				"Abrir configurações de Categorias");

		btnAbrirCategorias.setIcon(
				new ImageIcon(
						TelaPrincipal.class.getResource(
								"/br/com/patrimonio/imagens/Icons/IconCat.png")));

		toolBar.add(btnAbrirCategorias);

		// ==========================================================
		// BOTÃO PATRIMÔNIO
		// ==========================================================

		JButton btnAbrirPatrimonio =
				new JButton("");

		btnAbrirPatrimonio.addActionListener(
				new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Toca ch5_intro.wav
				tocarAudio("ch5_intro.wav");

				Patrimonios formPatrimonio =
						new Patrimonios();

				formPatrimonio.setVisible(true);
			}
		});

		btnAbrirPatrimonio.setToolTipText(
				"Abrir Configurações de Patrimonio");

		btnAbrirPatrimonio.setIcon(
				new ImageIcon(
						TelaPrincipal.class.getResource(
								"/br/com/patrimonio/imagens/Icons/IconPatrimonio.png")));

		toolBar.add(btnAbrirPatrimonio);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

					// Toca ch5_intro.wav
					tocarAudio("ch6_intro.wav");

					Movimentacoes formMovimentacoes =
							new Movimentacoes();

					formMovimentacoes.setVisible(true);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/Icons/movimentacoes.png")));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Toca ch7_intro.wav
				tocarAudio("ch7_intro.wav");

				Baixas_Patrimoniais formBaixas_Patrimoniais =
						new Baixas_Patrimoniais();

				formBaixas_Patrimoniais.setVisible(true);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/Icons/baixas.png")));
		toolBar.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/wallpaperBG.png")));
		lblNewLabel.setBounds(10, 39, 1910, 900);
		contentPane.add(lblNewLabel);
	}
}