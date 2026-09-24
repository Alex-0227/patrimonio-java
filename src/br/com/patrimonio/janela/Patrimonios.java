package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.patrimonio.dao.Conexao;
import br.com.patrimonio.dao.DAOUsuario;
import br.com.patrimonio.pojo.Status;
import br.com.patrimonio.pojo.Usuarios;

public class Patrimonios extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField txtTombamento;
	private JTextField txtNome;
	private JTextField txtValor;
	private JTextField textDataAquisicao;

	private JTextArea txtDescricao;

	private JComboBox<ComboItem> cbxCurso;
	private JComboBox<ComboItem> cbxLocal;
	private JComboBox<ComboItem> cbxCategoria;
	private JComboBox<ComboItem> cbxCriadoPor;
	private JComboBox<Status> cbxStatus;

	/*
	 * Objeto responsável pela conexão com o banco.
	 */
	private Conexao conexao = new Conexao() {
	};

	/**
	 * Classe utilizada para colocar ID + nome dentro do JComboBox.
	 */
	private class ComboItem {

		private int id;
		private String nome;

		public ComboItem(int id, String nome) {
			this.id = id;
			this.nome = nome;
		}

		public int getId() {
			return id;
		}

		public String getNome() {
			return nome;
		}

		@Override
		public String toString() {
			return nome;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Patrimonios frame =
							new Patrimonios();

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
	public Patrimonios() {

		setTitle("SURVEY_PROGRAM_PATRIMONIOS");

		setDefaultCloseOperation(
				JFrame.DISPOSE_ON_CLOSE
		);

		setBounds(
				100,
				100,
				704,
				490
		);

		contentPane =
				new JPanel();

		contentPane.setBackground(
				new Color(0, 0, 0)
		);

		contentPane.setForeground(
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

		/*
		 * Nº DE TOMBAMENTO
		 */
		JLabel lblTombamento =
				new JLabel("Nº de Tombamento");

		lblTombamento.setForeground(
				Color.WHITE
		);

		lblTombamento.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		lblTombamento.setBounds(
				10,
				16,
				188,
				17
		);

		contentPane.add(lblTombamento);

		txtTombamento =
				new JTextField();

		txtTombamento.setBounds(
				10,
				42,
				176,
				20
		);

		contentPane.add(txtTombamento);

		txtTombamento.setColumns(10);

		/*
		 * NOME
		 */
		JLabel lblNome =
				new JLabel("Nome do Patrimonio");

		lblNome.setForeground(
				Color.WHITE
		);

		lblNome.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		lblNome.setBounds(
				370,
				16,
				235,
				17
		);

		contentPane.add(lblNome);

		txtNome =
				new JTextField();

		txtNome.setColumns(10);

		txtNome.setBounds(
				370,
				42,
				312,
				20
		);

		contentPane.add(txtNome);

		/*
		 * CURSO
		 */
		JLabel lblCurso =
				new JLabel("Curso");

		lblCurso.setForeground(
				Color.WHITE
		);

		lblCurso.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		lblCurso.setBounds(
				10,
				73,
				69,
				17
		);

		contentPane.add(lblCurso);

		cbxCurso =
				new JComboBox<ComboItem>();

		cbxCurso.setBounds(
				10,
				101,
				319,
				22
		);

		contentPane.add(cbxCurso);

		/*
		 * LOCAL
		 */
		JLabel lblLocal =
				new JLabel("Local");

		lblLocal.setForeground(
				Color.WHITE
		);

		lblLocal.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		lblLocal.setBounds(
				370,
				73,
				69,
				17
		);

		contentPane.add(lblLocal);

		cbxLocal =
				new JComboBox<ComboItem>();

		cbxLocal.setBounds(
				370,
				101,
				312,
				22
		);

		contentPane.add(cbxLocal);

		/*
		 * CATEGORIA
		 */
		JLabel lblCategoria =
				new JLabel("Categoria");

		lblCategoria.setForeground(
				Color.WHITE
		);

		lblCategoria.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		lblCategoria.setBounds(
				10,
				134,
				109,
				22
		);

		contentPane.add(lblCategoria);

		cbxCategoria =
				new JComboBox<ComboItem>();

		cbxCategoria.setBounds(
				10,
				167,
				321,
				22
		);

		contentPane.add(cbxCategoria);

		/*
		 * STATUS
		 */
		JLabel lblStatus =
				new JLabel("Status");

		lblStatus.setForeground(
				Color.WHITE
		);

		lblStatus.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		lblStatus.setBounds(
				370,
				137,
				95,
				17
		);

		contentPane.add(lblStatus);

		cbxStatus =
				new JComboBox<Status>();

		cbxStatus.setBounds(
				370,
				167,
				312,
				22
		);

		for (Status status :
				Status.values()) {

			cbxStatus.addItem(status);
		}

		contentPane.add(cbxStatus);

		/*
		 * VALOR
		 */
		JLabel lblValor =
				new JLabel("Valor");

		lblValor.setForeground(
				Color.WHITE
		);

		lblValor.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		lblValor.setBounds(
				10,
				200,
				235,
				25
		);

		contentPane.add(lblValor);

		txtValor =
				new JTextField();

		txtValor.setBounds(
				10,
				238,
				321,
				20
		);

		contentPane.add(txtValor);

		txtValor.setColumns(10);

		/*
		 * DESCRIÇÃO
		 */
		JLabel lblDescricao =
				new JLabel("Descrição");

		lblDescricao.setForeground(
				Color.WHITE
		);

		lblDescricao.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		lblDescricao.setBounds(
				370,
				200,
				235,
				25
		);

		contentPane.add(lblDescricao);

		txtDescricao =
				new JTextArea();

		txtDescricao.setBounds(
				370,
				236,
				312,
				89
		);

		contentPane.add(txtDescricao);

		/*
		 * DATA DE AQUISIÇÃO
		 */
		JLabel lblDataAquisicao =
				new JLabel("Data de Aquisição");

		lblDataAquisicao.setForeground(
				Color.WHITE
		);

		lblDataAquisicao.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		lblDataAquisicao.setBounds(
				10,
				269,
				235,
				25
		);

		contentPane.add(lblDataAquisicao);

		textDataAquisicao =
				new JTextField();

		textDataAquisicao.setColumns(10);

		textDataAquisicao.setBounds(
				10,
				305,
				321,
				20
		);

		contentPane.add(textDataAquisicao);

		/*
		 * CRIADO POR
		 */
		JLabel lblCriadoPor =
				new JLabel("Criado Por");

		lblCriadoPor.setForeground(
				Color.WHITE
		);

		lblCriadoPor.setFont(
				new Font(
						"Tahoma",
						Font.PLAIN,
						20
				)
		);

		lblCriadoPor.setBounds(
				10,
				335,
				235,
				25
		);

		contentPane.add(lblCriadoPor);

		cbxCriadoPor =
				new JComboBox<ComboItem>();

		cbxCriadoPor.setBounds(
				10,
				371,
				321,
				22
		);

		contentPane.add(cbxCriadoPor);

		/*
		 * BOTÃO CADASTRAR
		 */
		JButton btnCadastrar =
				new JButton("Cadastrar");

		btnCadastrar.setBounds(
				227,
				404,
				228,
				36
		);

		contentPane.add(btnCadastrar);

		btnCadastrar.addActionListener(
				e -> cadastrarPatrimonio()
		);

		/*
		 * IMAGEM DE FUNDO
		 */
		JLabel BGSUN =
				new JLabel("");

		BGSUN.setIcon(
				new ImageIcon(
						Patrimonios.class.getResource(
								"/br/com/patrimonio/imagens/Cliffs2C.jpg"
						)
				)
		);

		BGSUN.setBounds(
				-105,
				-71,
				878,
				584
		);

		contentPane.add(BGSUN);

		/*
		 * Carrega os dados dos ComboBox.
		 */
		carregarCombos();
	}

	/**
	 * Carrega todos os JComboBox.
	 */
	private void carregarCombos() {

		carregarCursos();
		carregarLocais();
		carregarCategorias();
		carregarUsuarios();
	}

	/**
	 * Carrega os cursos.
	 */
	private void carregarCursos() {

		if (!conexao.abrir()) {

			JOptionPane.showMessageDialog(
					this,
					"Não foi possível conectar ao banco de dados."
			);

			return;
		}

		String sql =
				"SELECT id, nome FROM cursos ORDER BY nome";

		try {

			conexao.pst =
					conexao.con.prepareStatement(sql);

			conexao.rs =
					conexao.pst.executeQuery();

			while (conexao.rs.next()) {

				int id =
						conexao.rs.getInt("id");

				String nome =
						conexao.rs.getString("nome");

				cbxCurso.addItem(
						new ComboItem(id, nome)
				);
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(
					this,
					"Erro ao carregar cursos:\n"
					+ e.getMessage()
			);

		} finally {

			conexao.fechar();
		}
	}

	/**
	 * Carrega os locais.
	 */
	private void carregarLocais() {

		if (!conexao.abrir()) {
			return;
		}

		String sql =
				"SELECT id, nome FROM locais ORDER BY nome";

		try {

			conexao.pst =
					conexao.con.prepareStatement(sql);

			conexao.rs =
					conexao.pst.executeQuery();

			while (conexao.rs.next()) {

				int id =
						conexao.rs.getInt("id");

				String nome =
						conexao.rs.getString("nome");

				cbxLocal.addItem(
						new ComboItem(id, nome)
				);
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(
					this,
					"Erro ao carregar locais:\n"
					+ e.getMessage()
			);

		} finally {

			conexao.fechar();
		}
	}

	/**
	 * Carrega as categorias.
	 */
	private void carregarCategorias() {

		if (!conexao.abrir()) {
			return;
		}

		String sql =
				"SELECT id, nome FROM categorias ORDER BY nome";

		try {

			conexao.pst =
					conexao.con.prepareStatement(sql);

			conexao.rs =
					conexao.pst.executeQuery();

			while (conexao.rs.next()) {

				int id =
						conexao.rs.getInt("id");

				String nome =
						conexao.rs.getString("nome");

				cbxCategoria.addItem(
						new ComboItem(id, nome)
				);
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(
					this,
					"Erro ao carregar categorias:\n"
					+ e.getMessage()
			);

		} finally {

			conexao.fechar();
		}
	}

	/**
	 * Carrega os usuários.
	 */
	private void carregarUsuarios() {

		try {

			DAOUsuario dau =
					new DAOUsuario();

			List<Usuarios> listaUsuarios =
					dau.listaAtivos();

			for (Usuarios usuario :
					listaUsuarios) {

				ComboItem item =
						new ComboItem(
								usuario.getId(),
								usuario.toString()
						);

				cbxCriadoPor.addItem(item);
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(
					this,
					"Erro ao carregar usuários:\n"
					+ e.getMessage()
			);
		}
	}

	/**
	 * Realiza o cadastro do patrimônio.
	 */
	private void cadastrarPatrimonio() {

		/*
		 * Verifica os campos obrigatórios.
		 */
		if (txtTombamento.getText()
				.trim()
				.isEmpty()) {

			tocarSomErro();

			JOptionPane.showMessageDialog(
					this,
					"Digite o número de tombamento."
			);

			txtTombamento.requestFocus();

			return;
		}

		if (txtNome.getText()
				.trim()
				.isEmpty()) {

			tocarSomErro();

			JOptionPane.showMessageDialog(
					this,
					"Digite o nome do patrimônio."
			);

			txtNome.requestFocus();

			return;
		}

		/*
		 * Verifica os ComboBox.
		 */
		if (cbxCurso.getSelectedItem() == null) {

			tocarSomErro();

			JOptionPane.showMessageDialog(
					this,
					"Selecione um curso."
			);

			return;
		}

		if (cbxLocal.getSelectedItem() == null) {

			tocarSomErro();

			JOptionPane.showMessageDialog(
					this,
					"Selecione um local."
			);

			return;
		}

		if (cbxCategoria.getSelectedItem() == null) {

			tocarSomErro();

			JOptionPane.showMessageDialog(
					this,
					"Selecione uma categoria."
			);

			return;
		}

		if (cbxCriadoPor.getSelectedItem() == null) {

			tocarSomErro();

			JOptionPane.showMessageDialog(
					this,
					"Selecione quem está criando o patrimônio."
			);

			return;
		}

		/*
		 * Pega os objetos selecionados.
		 */
		ComboItem cursoSelecionado =
				(ComboItem)
				cbxCurso.getSelectedItem();

		ComboItem localSelecionado =
				(ComboItem)
				cbxLocal.getSelectedItem();

		ComboItem categoriaSelecionada =
				(ComboItem)
				cbxCategoria.getSelectedItem();

		ComboItem usuarioSelecionado =
				(ComboItem)
				cbxCriadoPor.getSelectedItem();

		int cursoId =
				cursoSelecionado.getId();

		int localId =
				localSelecionado.getId();

		int categoriaId =
				categoriaSelecionada.getId();

		int criadoPor =
				usuarioSelecionado.getId();

		/*
		 * Pega os valores.
		 */
		String tombamento =
				txtTombamento.getText().trim();

		String nome =
				txtNome.getText().trim();

		String descricao =
				txtDescricao.getText().trim();

		Status statusSelecionado =
				(Status)
				cbxStatus.getSelectedItem();

		String status =
				statusSelecionado.name();

		/*
		 * Converte o valor.
		 */
		BigDecimal valor = null;

		if (!txtValor.getText()
				.trim()
				.isEmpty()) {

			try {

				String valorTexto =
						txtValor.getText()
								.trim()
								.replace(",", ".");

				valor =
						new BigDecimal(valorTexto);

			} catch (NumberFormatException e) {

				tocarSomErro();

				JOptionPane.showMessageDialog(
						this,
						"Digite um valor válido."
				);

				txtValor.requestFocus();

				return;
			}
		}

		/*
		 * Converte a data.
		 */
		Date dataAquisicao = null;

		if (!textDataAquisicao.getText()
				.trim()
				.isEmpty()) {

			try {

				LocalDate data =
						LocalDate.parse(
								textDataAquisicao
										.getText()
										.trim()
						);

				dataAquisicao =
						Date.valueOf(data);

			} catch (Exception e) {

				tocarSomErro();

				JOptionPane.showMessageDialog(
						this,
						"Data inválida.\nUse o formato: AAAA-MM-DD"
				);

				textDataAquisicao.requestFocus();

				return;
			}
		}

		/*
		 * Abre a conexão.
		 */
		if (!conexao.abrir()) {

			tocarSomErro();

			JOptionPane.showMessageDialog(
					this,
					"Não foi possível conectar ao banco de dados."
			);

			return;
		}

		/*
		 * INSERT
		 */
		String sql =
				"INSERT INTO patrimonios "
				+ "(numero_tombamento, nome, descricao, "
				+ "curso_id, local_id, categoria_id, status, "
				+ "valor_aquisicao, data_aquisicao, criado_por) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			conexao.pst =
					conexao.con.prepareStatement(sql);

			conexao.pst.setString(
					1,
					tombamento
			);

			conexao.pst.setString(
					2,
					nome
			);

			conexao.pst.setString(
					3,
					descricao
			);

			conexao.pst.setInt(
					4,
					cursoId
			);

			conexao.pst.setInt(
					5,
					localId
			);

			conexao.pst.setInt(
					6,
					categoriaId
			);

			conexao.pst.setString(
					7,
					status
			);

			if (valor != null) {

				conexao.pst.setBigDecimal(
						8,
						valor
				);

			} else {

				conexao.pst.setNull(
						8,
						java.sql.Types.DECIMAL
				);
			}

			if (dataAquisicao != null) {

				conexao.pst.setDate(
						9,
						dataAquisicao
				);

			} else {

				conexao.pst.setNull(
						9,
						java.sql.Types.DATE
				);
			}

			conexao.pst.setInt(
					10,
					criadoPor
			);

			conexao.pst.executeUpdate();

			// =====================================================
			// SOM DE CADASTRO
			// =====================================================

			tocarSomCadastro();

			JOptionPane.showMessageDialog(
					this,
					"Patrimônio cadastrado com sucesso!"
			);

			limparCampos();

		} catch (SQLException e) {

			// =====================================================
			// SOM DE ERRO
			// =====================================================

			tocarSomErro();

			JOptionPane.showMessageDialog(
					this,
					"Erro ao cadastrar patrimônio:\n"
					+ e.getMessage()
			);

			e.printStackTrace();

		} finally {

			conexao.fechar();
		}
	}

	/**
	 * Limpa os campos depois do cadastro.
	 */
	private void limparCampos() {

		txtTombamento.setText("");
		txtNome.setText("");
		txtDescricao.setText("");
		txtValor.setText("");
		textDataAquisicao.setText("");

		if (cbxCurso.getItemCount() > 0) {
			cbxCurso.setSelectedIndex(0);
		}

		if (cbxLocal.getItemCount() > 0) {
			cbxLocal.setSelectedIndex(0);
		}

		if (cbxCategoria.getItemCount() > 0) {
			cbxCategoria.setSelectedIndex(0);
		}

		if (cbxCriadoPor.getItemCount() > 0) {
			cbxCriadoPor.setSelectedIndex(0);
		}

		cbxStatus.setSelectedIndex(0);
	}

	// =========================================================
	// TOCAR SOM DE INTRODUÇÃO
	// =========================================================

	private void tocarSomIntro() {

		try {

			AudioInputStream audio =
					AudioSystem.getAudioInputStream(
							Patrimonios.class.getResource(
									"/br/com/patrimonio/sfx/ch5_intro.wav"
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
							Patrimonios.class.getResource(
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
							Patrimonios.class.getResource(
									"/br/com/patrimonio/sfx/ch5_error.wav"
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
