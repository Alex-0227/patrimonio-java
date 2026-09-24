package br.com.patrimonio.janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import br.com.patrimonio.dao.DAOMovimentacoes;
import br.com.patrimonio.dao.DAOPatrimonios;
import br.com.patrimonio.dao.DAOUsuario;

import br.com.patrimonio.pojo.Patrimonio;
import br.com.patrimonio.pojo.TipoMov;
import br.com.patrimonio.pojo.Usuarios;

public class Movimentacoes extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField textResponsavelDestino;
	private JTextField textDataPrevistaRetorno;
	private JTextField textDataEfetivaRetorno;

	private JTextArea textArea;

	private JComboBox<Patrimonio> cbxPatrimonio;
	private JComboBox<Usuarios> cbxUsuario;
	private JComboBox<TipoMov> cbxTipoMovimentacao;

	private Font fonteDetermination;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Movimentacoes frame =
							new Movimentacoes();

					frame.setVisible(true);

					// =================================================
					// SOM DE INTRODUÇÃO
					// =================================================

					frame.tocarSomIntro();

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		});
	}

	public Movimentacoes() {

		setTitle(
				"SURVEY_PROGRAM_MOVIMENTACOES"
		);

		setResizable(false);

		setDefaultCloseOperation(
				JFrame.DISPOSE_ON_CLOSE
		);

		setBounds(
				100,
				100,
				627,
				423
		);

		// =====================================================
		// FONTE
		// =====================================================

		fonteDetermination =
				carregarFonte();

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

		contentPane.setLayout(null);

		setContentPane(
				contentPane
		);

		// =====================================================
		// BOTÃO CADASTRAR
		// =====================================================

		JButton btnCadastrar =
				new JButton(
						"CADASTRAR"
				);

		btnCadastrar.setFont(
				fonteDetermination
		);

		btnCadastrar.setForeground(
				Color.WHITE
		);

		btnCadastrar.setBackground(
				Color.BLACK
		);

		btnCadastrar.setBounds(
				28,
				316,
				205,
				32
		);

		contentPane.add(
				btnCadastrar
		);

		// =====================================================
		// DATA EFETIVA
		// =====================================================

		textDataEfetivaRetorno =
				new JTextField();

		textDataEfetivaRetorno.setColumns(
				10
		);

		textDataEfetivaRetorno.setFont(
				fonteDetermination
		);

		textDataEfetivaRetorno.setBounds(
				244,
				194,
				357,
				20
		);

		contentPane.add(
				textDataEfetivaRetorno
		);

		// =====================================================
		// DATA PREVISTA
		// =====================================================

		textDataPrevistaRetorno =
				new JTextField();

		textDataPrevistaRetorno.setColumns(
				10
		);

		textDataPrevistaRetorno.setFont(
				fonteDetermination
		);

		textDataPrevistaRetorno.setBounds(
				244,
				165,
				357,
				20
		);

		contentPane.add(
				textDataPrevistaRetorno
		);

		// =====================================================
		// LABEL DATA EFETIVA
		// =====================================================

		JLabel lblDataEfetivaDe =
				new JLabel(
						"DATA EFETIVA DE RETORNO:"
				);

		lblDataEfetivaDe.setForeground(
				Color.WHITE
		);

		lblDataEfetivaDe.setFont(
				fonteDetermination
		);

		lblDataEfetivaDe.setBounds(
				10,
				194,
				237,
				20
		);

		contentPane.add(
				lblDataEfetivaDe
		);

		// =====================================================
		// LABEL DATA PREVISTA
		// =====================================================

		JLabel lblDataPrevistaDo =
				new JLabel(
						"DATA PREVISTA DE RETORNO:"
				);

		lblDataPrevistaDo.setForeground(
				Color.WHITE
		);

		lblDataPrevistaDo.setFont(
				fonteDetermination
		);

		lblDataPrevistaDo.setBounds(
				10,
				163,
				237,
				20
		);

		contentPane.add(
				lblDataPrevistaDo
		);

		// =====================================================
		// RESPONSÁVEL
		// =====================================================

		textResponsavelDestino =
				new JTextField();

		textResponsavelDestino.setFont(
				fonteDetermination
		);

		textResponsavelDestino.setBounds(
				244,
				111,
				357,
				20
		);

		textResponsavelDestino.setColumns(
				10
		);

		contentPane.add(
				textResponsavelDestino
		);

		// =====================================================
		// LABEL RESPONSÁVEL
		// =====================================================

		JLabel lblResponsavelDestino =
				new JLabel(
						"RESPONSAVEL DESTINO:"
				);

		lblResponsavelDestino.setForeground(
				Color.WHITE
		);

		lblResponsavelDestino.setFont(
				fonteDetermination
		);

		lblResponsavelDestino.setBounds(
				10,
				109,
				210,
				20
		);

		contentPane.add(
				lblResponsavelDestino
		);

		// =====================================================
		// LABEL TIPO
		// =====================================================

		JLabel lblTipoDeMovimentacao =
				new JLabel(
						"TIPO DE MOVIMENTACAO:"
				);

		lblTipoDeMovimentacao.setForeground(
				Color.WHITE
		);

		lblTipoDeMovimentacao.setFont(
				fonteDetermination
		);

		lblTipoDeMovimentacao.setBounds(
				10,
				77,
				204,
				20
		);

		contentPane.add(
				lblTipoDeMovimentacao
		);

		// =====================================================
		// LABEL USUÁRIO
		// =====================================================

		JLabel lblUsuario =
				new JLabel(
						"USUARIO:"
				);

		lblUsuario.setForeground(
				Color.WHITE
		);

		lblUsuario.setFont(
				fonteDetermination
		);

		lblUsuario.setBounds(
				376,
				47,
				82,
				20
		);

		contentPane.add(
				lblUsuario
		);

		// =====================================================
		// LABEL PATRIMÔNIO
		// =====================================================

		JLabel lblPatrimonio =
				new JLabel(
						"SELECIONE O PATRIMONIO:"
				);

		lblPatrimonio.setForeground(
				Color.WHITE
		);

		lblPatrimonio.setFont(
				fonteDetermination
		);

		lblPatrimonio.setBounds(
				10,
				47,
				210,
				20
		);

		contentPane.add(
				lblPatrimonio
		);

		// =====================================================
		// COMBO USUÁRIO
		// =====================================================

		cbxUsuario =
				new JComboBox<>();

		cbxUsuario.setFont(
				fonteDetermination
		);

		cbxUsuario.setBounds(
				462,
				45,
				139,
				22
		);

		contentPane.add(
				cbxUsuario
		);

		// =====================================================
		// COMBO TIPO
		// =====================================================

		cbxTipoMovimentacao =
				new JComboBox<>();

		cbxTipoMovimentacao.setFont(
				fonteDetermination
		);

		cbxTipoMovimentacao.setBounds(
				244,
				78,
				357,
				22
		);

		contentPane.add(
				cbxTipoMovimentacao
		);

		// =====================================================
		// COMBO PATRIMÔNIO
		// =====================================================

		cbxPatrimonio =
				new JComboBox<>();

		cbxPatrimonio.setFont(
				fonteDetermination
		);

		cbxPatrimonio.setForeground(
				Color.BLACK
		);

		cbxPatrimonio.setBackground(
				Color.WHITE
		);

		cbxPatrimonio.setBounds(
				244,
				45,
				129,
				22
		);

		contentPane.add(
				cbxPatrimonio
		);

		// =====================================================
		// OBSERVAÇÕES
		// =====================================================

		JLabel lblDesc1 =
				new JLabel(
						"OBSERVAÇÕES:"
				);

		lblDesc1.setFont(
				fonteDetermination
		);

		lblDesc1.setForeground(
				Color.WHITE
		);

		lblDesc1.setBounds(
				273,
				275,
				185,
				25
		);

		contentPane.add(
				lblDesc1
		);

		// =====================================================
		// ÁREA DE TEXTO
		// =====================================================

		textArea =
				new JTextArea();

		textArea.setFont(
				fonteDetermination
		);

		textArea.setBounds(
				273,
				300,
				328,
				73
		);

		contentPane.add(
				textArea
		);

		// =====================================================
		// FUNDO PRETO
		// =====================================================

		JLabel lblBG2 =
				new JLabel("");

		lblBG2.setIcon(
				new ImageIcon(
						Movimentacoes.class.getResource(
								"/br/com/patrimonio/imagens/BBlack.png"
						)
				)
		);

		lblBG2.setBounds(
				0,
				258,
				699,
				126
		);

		contentPane.add(
				lblBG2
		);

		// =====================================================
		// GIF
		// =====================================================

		JLabel lblGif =
				new JLabel();

		lblGif.setIcon(
				new ImageIcon(
						Movimentacoes.class.getResource(
								"/br/com/patrimonio/imagens/bggif.gif"
						)
				)
		);

		lblGif.setBounds(
				0,
				0,
				611,
				517
		);

		contentPane.add(
				lblGif
		);

		// =====================================================
		// CARREGAR DADOS
		// =====================================================

		carregarPatrimonios();

		carregarUsuarios();

		carregarTiposMovimentacao();

		// =====================================================
		// BOTÃO
		// =====================================================

		btnCadastrar.addActionListener(
				e -> cadastrarMovimentacao()
		);
	}

	// =========================================================
	// CARREGAR PATRIMÔNIOS
	// =========================================================

	private void carregarPatrimonios() {

		try {

			DAOPatrimonios dao =
					new DAOPatrimonios();

			List<Patrimonio> lista =
					dao.listar();

			cbxPatrimonio.removeAllItems();

			for (Patrimonio patrimonio : lista) {

				cbxPatrimonio.addItem(
						patrimonio
				);
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(
					this,
					"Erro ao carregar patrimônios:\n"
							+ e.getMessage(),
					"Erro",
					JOptionPane.ERROR_MESSAGE
			);

			tocarSomErro();

			e.printStackTrace();
		}
	}

	// =========================================================
	// CARREGAR USUÁRIOS
	// =========================================================

	private void carregarUsuarios() {

		try {

			DAOUsuario dao =
					new DAOUsuario();

			List<Usuarios> lista =
					dao.listaAtivos();

			cbxUsuario.removeAllItems();

			for (Usuarios usuario : lista) {

				cbxUsuario.addItem(
						usuario
				);
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(
					this,
					"Erro ao carregar usuários:\n"
							+ e.getMessage(),
					"Erro",
					JOptionPane.ERROR_MESSAGE
			);

			tocarSomErro();

			e.printStackTrace();
		}
	}

	// =========================================================
	// CARREGAR TIPOS DE MOVIMENTAÇÃO
	// =========================================================

	private void carregarTiposMovimentacao() {

		cbxTipoMovimentacao.removeAllItems();

		for (TipoMov tipo :
				TipoMov.values()) {

			cbxTipoMovimentacao.addItem(
					tipo
			);
		}
	}

	// =========================================================
	// CADASTRAR MOVIMENTAÇÃO
	// =========================================================

	private void cadastrarMovimentacao() {

		try {

			// -------------------------------------------------
			// PATRIMÔNIO
			// -------------------------------------------------

			Patrimonio patrimonio =
					(Patrimonio)
					cbxPatrimonio
							.getSelectedItem();

			if (patrimonio == null) {

				JOptionPane.showMessageDialog(
						this,
						"Selecione um patrimônio.",
						"Atenção",
						JOptionPane.WARNING_MESSAGE
				);

				tocarSomErro();

				return;
			}

			// -------------------------------------------------
			// USUÁRIO
			// -------------------------------------------------

			Usuarios usuario =
					(Usuarios)
					cbxUsuario
							.getSelectedItem();

			if (usuario == null) {

				JOptionPane.showMessageDialog(
						this,
						"Selecione um usuário.",
						"Atenção",
						JOptionPane.WARNING_MESSAGE
				);

				tocarSomErro();

				return;
			}

			// -------------------------------------------------
			// TIPO
			// -------------------------------------------------

			TipoMov tipo =
					(TipoMov)
					cbxTipoMovimentacao
							.getSelectedItem();

			if (tipo == null) {

				JOptionPane.showMessageDialog(
						this,
						"Selecione o tipo de movimentação.",
						"Atenção",
						JOptionPane.WARNING_MESSAGE
				);

				tocarSomErro();

				return;
			}

			// -------------------------------------------------
			// RESPONSÁVEL
			// -------------------------------------------------

			String responsavel =
					textResponsavelDestino
							.getText()
							.trim();

			if (responsavel.isEmpty()) {

				JOptionPane.showMessageDialog(
						this,
						"Informe o responsável de destino.",
						"Atenção",
						JOptionPane.WARNING_MESSAGE
				);

				tocarSomErro();

				textResponsavelDestino.requestFocus();

				return;
			}

			// -------------------------------------------------
			// DATA PREVISTA
			// -------------------------------------------------

			Date dataPrevista =
					converterData(
							textDataPrevistaRetorno
									.getText()
									.trim()
					);

			// -------------------------------------------------
			// DATA EFETIVA
			// -------------------------------------------------

			Date dataEfetiva =
					null;

			String textoEfetiva =
					textDataEfetivaRetorno
							.getText()
							.trim();

			if (!textoEfetiva.isEmpty()) {

				dataEfetiva =
						converterData(
								textoEfetiva
						);
			}

			// -------------------------------------------------
			// DATA DE SAÍDA
			// -------------------------------------------------

			Date dataSaida =
					new Date(
							System.currentTimeMillis()
					);

			// -------------------------------------------------
			// CRIA OBJETO
			// -------------------------------------------------

			br.com.patrimonio.pojo.Movimentacoes movimentacao =
			        new br.com.patrimonio.pojo.Movimentacoes();

			movimentacao.setPatrimonio_id(
			        patrimonio.getId()
			);

			movimentacao.setUsuario_registro_id(
			        usuario.getId()
			);

			movimentacao.setTipo_movimentacao(
			        tipo
			);

			movimentacao.setResponsavel_destino(
			        responsavel
			);

			movimentacao.setDocumento_responsavel(
			        null
			);

			movimentacao.setData_saida(
			        dataSaida
			);

			movimentacao.setData_prevista_retorno(
			        dataPrevista
			);

			movimentacao.setData_retorno_efetivo(
			        dataEfetiva
			);

			movimentacao.setObservacoes(
			        textArea
			                .getText()
			                .trim()
			);

			// -------------------------------------------------
			// DAO
			// -------------------------------------------------

			DAOMovimentacoes dao =
					new DAOMovimentacoes();

			String mensagem =
					dao.cadastrar(
							movimentacao
					);

			JOptionPane.showMessageDialog(
					this,
					mensagem
			);

			// -------------------------------------------------
			// SOM DE CADASTRO
			// -------------------------------------------------

			tocarSomCadastro();

			limparCampos();

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(
					this,
					"Data inválida.\n"
							+ "Use o formato: dd/MM/yyyy",
					"Erro",
					JOptionPane.ERROR_MESSAGE
			);

			tocarSomErro();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(
					this,
					"Erro ao cadastrar movimentação:\n"
							+ e.getMessage(),
					"Erro",
					JOptionPane.ERROR_MESSAGE
			);

			tocarSomErro();

			e.printStackTrace();
		}
	}

	// =========================================================
	// CONVERTER DATA
	// =========================================================

	private Date converterData(
			String texto)
			throws ParseException {

		if (texto == null ||
				texto.isEmpty()) {

			return null;
		}

		SimpleDateFormat formato =
				new SimpleDateFormat(
						"dd/MM/yyyy"
				);

		formato.setLenient(false);

		java.util.Date data =
				formato.parse(texto);

		return new Date(
				data.getTime()
		);
	}

	// =========================================================
	// LIMPAR CAMPOS
	// =========================================================

	private void limparCampos() {

		textResponsavelDestino.setText("");

		textDataPrevistaRetorno.setText("");

		textDataEfetivaRetorno.setText("");

		textArea.setText("");
	}

	// =========================================================
	// CARREGAR FONTE
	// =========================================================

	private Font carregarFonte() {

		try {

			InputStream is =
					Movimentacoes.class
							.getResourceAsStream(
									"/br/com/patrimonio/fonts/determination.ttf"
							);

			if (is == null) {

				System.out.println(
						"ERRO: Determination.ttf não encontrada!"
				);

				return new Font(
						"Tahoma",
						Font.PLAIN,
						16
				);
			}

			Font fonte =
					Font.createFont(
							Font.TRUETYPE_FONT,
							is
					);

			is.close();

			GraphicsEnvironment ge =
					GraphicsEnvironment
							.getLocalGraphicsEnvironment();

			ge.registerFont(
					fonte
			);

			return fonte.deriveFont(
					Font.PLAIN,
					16f
			);

		} catch (Exception e) {

			e.printStackTrace();

			return new Font(
					"Tahoma",
					Font.PLAIN,
					16
			);
		}
	}

	// =========================================================
	// TOCAR SOM DE INTRODUÇÃO
	// =========================================================

	private void tocarSomIntro() {

		try {

			AudioInputStream audio =
					AudioSystem.getAudioInputStream(
							Movimentacoes.class.getResource(
									"/br/com/patrimonio/sfx/ch6_intro.wav"
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
							Movimentacoes.class.getResource(
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
							Movimentacoes.class.getResource(
									"/br/com/patrimonio/sfx/ch6_error.wav"
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
