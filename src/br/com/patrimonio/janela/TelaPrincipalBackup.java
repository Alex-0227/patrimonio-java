//package br.com.patrimonio.janela;
//
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.InputEvent;
//import java.awt.event.KeyEvent;
//
//import javax.swing.JFrame;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//import javax.swing.JSeparator;
//import javax.swing.KeyStroke;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JToolBar;
//import javax.swing.JButton;
//import javax.swing.ImageIcon;
//
//public class TelaPrincipal extends JFrame {
//
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaPrincipal frame = new TelaPrincipal();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public TelaPrincipal() {
//		setTitle("SURVEY_PROGRAM_GESTAO_DE_PATRIMONIO");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		//Obter a resolução da tela
//
//		
//		setBounds(100, 100, 1920, 1000);
//		
//		
//		//Abrir a tela sempre maximizada
//		setExtendedState(MAXIMIZED_BOTH);
//		
//		JMenuBar menuBar = new JMenuBar();
//		setJMenuBar(menuBar);
//		
//		JMenu mnCadastrar = new JMenu("Cadastrar");
//		mnCadastrar.setMnemonic('c');
//		menuBar.add(mnCadastrar);
//		
//		JMenuItem itemUsuario = new JMenuItem("Usuário");
//		itemUsuario.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//			
//				Usuarios formUsuario = new Usuarios();
//				formUsuario.setVisible(true);
//				
//				
//			}
//			
//		});
//		itemUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
//		itemUsuario.setBackground(new Color(255, 255, 255));
//		mnCadastrar.add(itemUsuario);
//		
//		JMenuItem itemCursos = new JMenuItem("Cursos");
//		itemCursos.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				Cursos formCurso = new Cursos();
//				formCurso.setVisible(true);
//				
//			}
//		});
//		itemCursos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
//		itemCursos.setBackground(new Color(255, 255, 255));
//		mnCadastrar.add(itemCursos);
//		
//		JMenuItem itemLocais = new JMenuItem("Locais");
//		itemLocais.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				Locais formLocal = new Locais();
//				formLocal.setVisible(true);
//				
//			}
//		});
//		itemLocais.setBackground(new Color(255, 255, 255));
//		mnCadastrar.add(itemLocais);
//		
//		JMenuItem itemCategoria = new JMenuItem("Categoria");
//		itemCategoria.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				Categorias formCategoria = new Categorias();
//				formCategoria.setVisible(true);
//				
//			}
//		});
//		itemCategoria.setBackground(new Color(255, 255, 255));
//		mnCadastrar.add(itemCategoria);
//		
//		JMenuItem itemPatrimonio = new JMenuItem("Patrimônio");
//		itemPatrimonio.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				Patrimonios formPatrimonio = new Patrimonios();
//				formPatrimonio.setVisible(true);
//				
//			}
//		});
//		itemPatrimonio.setBackground(new Color(255, 255, 255));
//		mnCadastrar.add(itemPatrimonio);
//		
//		JMenuItem itemMovimentacao = new JMenuItem("Movimentação");
//		itemMovimentacao.setBackground(new Color(255, 255, 255));
//		mnCadastrar.add(itemMovimentacao);
//		
//		JMenuItem itemBaixarPatrimonio = new JMenuItem("Baixar Patrimônio");
//		itemBaixarPatrimonio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
//		itemBaixarPatrimonio.setBackground(new Color(255, 255, 255));
//		mnCadastrar.add(itemBaixarPatrimonio);
//		
//		JMenu mnConsulta = new JMenu("Consulta");
//		mnConsulta.setMnemonic('s');
//		menuBar.add(mnConsulta);
//		
//		JMenu itemListarTudo = new JMenu("Listar Tudo");
//		mnConsulta.add(itemListarTudo);
//		
//		JMenuItem itemLstUsuario = new JMenuItem("Usuário");
//		itemListarTudo.add(itemLstUsuario);
//		
//		JMenuItem itemLstCursos = new JMenuItem("Cursos");
//		itemListarTudo.add(itemLstCursos);
//		
//		JMenuItem itemLstPatrimonio = new JMenuItem("Patrimônio");
//		itemListarTudo.add(itemLstPatrimonio);
//		
//		JMenu itemPesquisarPorId = new JMenu("Pesquisar por ID");
//		mnConsulta.add(itemPesquisarPorId);
//		
//		JMenuItem itemPorIdMovimentacao = new JMenuItem("Movimentação");
//		itemPesquisarPorId.add(itemPorIdMovimentacao);
//		
//		JMenuItem itemPorIdBaixarPatrimonio = new JMenuItem("Baixar Patrimônio");
//		itemPesquisarPorId.add(itemPorIdBaixarPatrimonio);
//		
//		JSeparator separator = new JSeparator();
//		mnConsulta.add(separator);
//		
//		JMenu itemConsultaUsuario = new JMenu("Usuario Por ...");
//		mnConsulta.add(itemConsultaUsuario);
//		
//		JMenuItem ItemConsultaPerfil = new JMenuItem("Perfil");
//		itemConsultaUsuario.add(ItemConsultaPerfil);
//		
//		JMenuItem itemConsutalEmail = new JMenuItem("E-Mail");
//		itemConsultaUsuario.add(itemConsutalEmail);
//		
//		JSeparator separator_1 = new JSeparator();
//		mnConsulta.add(separator_1);
//		
//		JMenu itemConsultaMovimentacao = new JMenu("Movimentação");
//		mnConsulta.add(itemConsultaMovimentacao);
//		
//		JMenuItem itemConsultaTipo = new JMenuItem("Tipo");
//		itemConsultaMovimentacao.add(itemConsultaTipo);
//		
//		
//		
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setBounds(0,0,1920,1000);
//		//getWidth()♦Pegar a largura da janela
//		//getHeight()♦Pegar a altura da janela
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		
//		// ---------------
//		JToolBar toolBar = new JToolBar();
//		toolBar.setFloatable(false);
//		toolBar.setBounds(0, 0, getWidth(), 28);
//		contentPane.add(toolBar);
//		
//		JButton btnAbrirUsuarios = new JButton("");
//		btnAbrirUsuarios.setToolTipText("Abrir configurações de usuarios (Ctrl+Shift+U)");
//		btnAbrirUsuarios.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/Icons/IconUser.png")));
//		btnAbrirUsuarios.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				Usuarios formUsuario = new Usuarios();
//				formUsuario.setVisible(true);
//				
//			}
//		});
//		toolBar.add(btnAbrirUsuarios);
//		
//		JButton btnAbrirCursos = new JButton("");
//		btnAbrirCursos.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				Cursos formCurso = new Cursos();
//				formCurso.setVisible(true);
//				
//			}
//		});
//		btnAbrirCursos.setToolTipText("Abrir configurações de Cursos");
//		btnAbrirCursos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/Icons/IconCursos.png")));
//		toolBar.add(btnAbrirCursos);
//		
//		JButton btnAbrirLocais = new JButton("");
//		btnAbrirLocais.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				Locais formLocal = new Locais();
//				formLocal.setVisible(true);								
//			}
//		});
//		btnAbrirLocais.setToolTipText("Abrir configurações de locais");
//		btnAbrirLocais.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/Icons/IconLocais.png")));
//		toolBar.add(btnAbrirLocais);
//		
//		JButton btnAbrirCategorias = new JButton("");
//		btnAbrirCategorias.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				
//				Categorias formCategoria = new Categorias();
//				formCategoria.setVisible(true);		
//				
//				
//				
//			}
//		});
//		btnAbrirCategorias.setToolTipText("Abrir configurações de Categorias");
//		btnAbrirCategorias.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/Icons/IconCat.png")));
//		toolBar.add(btnAbrirCategorias);
//		
//		JButton btnAbrirPatrimonio = new JButton("");
//		btnAbrirPatrimonio.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				Patrimonios formPatrimonio = new Patrimonios();
//				formPatrimonio.setVisible(true);
//				
//			}
//		});
//		btnAbrirPatrimonio.setToolTipText("Abrir Configurações de Patrimonio");
//		btnAbrirPatrimonio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/patrimonio/imagens/Icons/IconPatrimonio.png")));
//		toolBar.add(btnAbrirPatrimonio);
//		
//
//
//	}
//}
