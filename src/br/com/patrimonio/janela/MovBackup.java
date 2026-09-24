//package br.com.patrimonio.janela;
//
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.GraphicsEnvironment;
//import java.io.InputStream;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;
//
//public class Movimentacoes extends JFrame {
//
//	private static final long serialVersionUID = 1L;
//
//	private JPanel contentPane;
//
//	private JTextField textResponsavelDestino;
//	private JTextField textDataPrevistaRetorno;
//	private JTextField textDataEfetivaRetorno;
//
//	// =====================================================
//	// FONTE PERSONALIZADA
//	// =====================================================
//
//	private Font fonteDetermination;
//
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//
//					Movimentacoes frame = new Movimentacoes();
//					frame.setVisible(true);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	public Movimentacoes() {
//
//		setTitle("SURVEY_PROGRAM_MOVIMENTACOES");
//		setResizable(false);
//
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 627, 423);
//
//		// =====================================================
//		// CARREGA A FONTE
//		// =====================================================
//
//		fonteDetermination = carregarFonte();
//
//		// =====================================================
//		// PAINEL
//		// =====================================================
//
//		contentPane = new JPanel();
//
//		contentPane.setBorder(
//				new EmptyBorder(5, 5, 5, 5)
//		);
//
//		contentPane.setLayout(null);
//
//		setContentPane(contentPane);
//
//		// =====================================================
//		// BOTÃO CADASTRAR
//		// =====================================================
//
//		JButton btnCadastrar =
//				new JButton("CADASTRAR");
//
//		btnCadastrar.setFont(fonteDetermination);
//
//		btnCadastrar.setForeground(Color.WHITE);
//		btnCadastrar.setBackground(Color.BLACK);
//
//		btnCadastrar.setBounds(28, 316, 205, 32);
//
//		contentPane.add(btnCadastrar);
//
//		// =====================================================
//		// DATA EFETIVA DE RETORNO
//		// =====================================================
//
//		textDataEfetivaRetorno =
//				new JTextField();
//
//		textDataEfetivaRetorno.setColumns(10);
//
//		textDataEfetivaRetorno.setFont(
//				fonteDetermination
//		);
//
//		textDataEfetivaRetorno.setBounds(
//				244, 194, 357, 20
//		);
//
//		contentPane.add(textDataEfetivaRetorno);
//
//		// =====================================================
//		// DATA PREVISTA DE RETORNO
//		// =====================================================
//
//		textDataPrevistaRetorno =
//				new JTextField();
//
//		textDataPrevistaRetorno.setColumns(10);
//
//		textDataPrevistaRetorno.setFont(
//				fonteDetermination
//		);
//
//		textDataPrevistaRetorno.setBounds(
//				244, 165, 357, 20
//		);
//
//		contentPane.add(textDataPrevistaRetorno);
//
//		// =====================================================
//		// LABEL DATA EFETIVA
//		// =====================================================
//
//		JLabel lblDataEfetivaDe =
//				new JLabel(
//						"DATA EFETIVA DE RETORNO:"
//				);
//
//		lblDataEfetivaDe.setForeground(
//				Color.WHITE
//		);
//
//		lblDataEfetivaDe.setFont(
//				fonteDetermination
//		);
//
//		lblDataEfetivaDe.setBounds(
//				10, 194, 237, 20
//		);
//
//		contentPane.add(lblDataEfetivaDe);
//
//		// =====================================================
//		// LABEL DATA PREVISTA
//		// =====================================================
//
//		JLabel lblDataPrevistaDo =
//				new JLabel(
//						"DATA PREVISTA DE RETORNO:"
//				);
//
//		lblDataPrevistaDo.setForeground(
//				Color.WHITE
//		);
//
//		lblDataPrevistaDo.setFont(
//				fonteDetermination
//		);
//
//		lblDataPrevistaDo.setBounds(
//				10, 163, 237, 20
//		);
//
//		contentPane.add(lblDataPrevistaDo);
//
//		// =====================================================
//		// RESPONSÁVEL DESTINO
//		// =====================================================
//
//		textResponsavelDestino =
//				new JTextField();
//
//		textResponsavelDestino.setFont(
//				fonteDetermination
//		);
//
//		textResponsavelDestino.setBounds(
//				244, 111, 357, 20
//		);
//
//		contentPane.add(textResponsavelDestino);
//
//		textResponsavelDestino.setColumns(10);
//
//		// =====================================================
//		// LABEL RESPONSÁVEL
//		// =====================================================
//
//		JLabel lblResponsavelDestino =
//				new JLabel(
//						"RESPONSAVEL DESTINO:"
//				);
//
//		lblResponsavelDestino.setForeground(
//				Color.WHITE
//		);
//
//		lblResponsavelDestino.setFont(
//				fonteDetermination
//		);
//
//		lblResponsavelDestino.setBounds(
//				10, 109, 210, 20
//		);
//
//		contentPane.add(lblResponsavelDestino);
//
//		// =====================================================
//		// LABEL TIPO DE MOVIMENTAÇÃO
//		// =====================================================
//
//		JLabel lblTipoDeMovimentacao =
//				new JLabel(
//						"TIPO DE MOVIMENTACAO:"
//				);
//
//		lblTipoDeMovimentacao.setForeground(
//				Color.WHITE
//		);
//
//		lblTipoDeMovimentacao.setFont(
//				fonteDetermination
//		);
//
//		lblTipoDeMovimentacao.setBounds(
//				10, 77, 204, 20
//		);
//
//		contentPane.add(lblTipoDeMovimentacao);
//
//		// =====================================================
//		// LABEL USUÁRIO
//		// =====================================================
//
//		JLabel lblUsuario =
//				new JLabel("USUARIO:");
//
//		lblUsuario.setForeground(
//				Color.WHITE
//		);
//
//		lblUsuario.setFont(
//				fonteDetermination
//		);
//
//		lblUsuario.setBounds(
//				376, 47, 82, 20
//		);
//
//		contentPane.add(lblUsuario);
//
//		// =====================================================
//		// LABEL PATRIMÔNIO
//		// =====================================================
//
//		JLabel lblNewLabel =
//				new JLabel(
//						"SELECIONE O PATRIMONIO:"
//				);
//
//		lblNewLabel.setForeground(
//				Color.WHITE
//		);
//
//		lblNewLabel.setFont(
//				fonteDetermination
//		);
//
//		lblNewLabel.setBounds(
//				10, 47, 210, 20
//		);
//
//		contentPane.add(lblNewLabel);
//
//		// =====================================================
//		// COMBO USUÁRIO
//		// =====================================================
//
//		JComboBox<String> cbxUsuarioId =
//				new JComboBox<>();
//
//		cbxUsuarioId.setFont(
//				fonteDetermination
//		);
//
//		cbxUsuarioId.setBounds(
//				462, 45, 139, 22
//		);
//
//		contentPane.add(cbxUsuarioId);
//
//		// =====================================================
//		// COMBO TIPO MOVIMENTAÇÃO
//		// =====================================================
//
//		JComboBox<String> cbxTipoMovimentacao =
//				new JComboBox<>();
//
//		cbxTipoMovimentacao.setFont(
//				fonteDetermination
//		);
//
//		cbxTipoMovimentacao.setBounds(
//				244, 78, 357, 22
//		);
//
//		contentPane.add(cbxTipoMovimentacao);
//
//		// =====================================================
//		// COMBO PATRIMÔNIO
//		// =====================================================
//
//		JComboBox<String> cbxPatrimonioId =
//				new JComboBox<>();
//
//		cbxPatrimonioId.setFont(
//				fonteDetermination
//		);
//
//		cbxPatrimonioId.setForeground(
//				Color.BLACK
//		);
//
//		cbxPatrimonioId.setBackground(
//				Color.WHITE
//		);
//
//		cbxPatrimonioId.setBounds(
//				244, 45, 129, 22
//		);
//
//		contentPane.add(cbxPatrimonioId);
//
//		// =====================================================
//		// OBSERVAÇÕES
//		// =====================================================
//
//		JLabel lblDesc1 =
//				new JLabel("OBSERVAÇÕES:");
//
//		lblDesc1.setFont(
//				fonteDetermination
//		);
//
//		lblDesc1.setBackground(
//				Color.WHITE
//		);
//
//		lblDesc1.setForeground(
//				Color.WHITE
//		);
//
//		lblDesc1.setBounds(
//				273, 275, 185, 25
//		);
//
//		contentPane.add(lblDesc1);
//
//		// =====================================================
//		// ÁREA DE TEXTO
//		// =====================================================
//
//		JTextArea textArea =
//				new JTextArea();
//
//		textArea.setFont(
//				fonteDetermination
//		);
//
//		textArea.setBounds(
//				273, 300, 328, 73
//		);
//
//		contentPane.add(textArea);
//
//		// =====================================================
//		// FUNDO PRETO
//		// =====================================================
//
//		JLabel lblBG2 =
//				new JLabel("");
//
//		lblBG2.setIcon(
//				new ImageIcon(
//						Movimentacoes.class.getResource(
//								"/br/com/patrimonio/imagens/BBlack.png"
//						)
//				)
//		);
//
//		lblBG2.setBounds(
//				0, 258, 699, 126
//		);
//
//		contentPane.add(lblBG2);
//
//		// =====================================================
//		// GIF
//		// =====================================================
//
//		JLabel lblGif =
//				new JLabel();
//
//		lblGif.setIcon(
//				new ImageIcon(
//						Movimentacoes.class.getResource(
//								"/br/com/patrimonio/imagens/bggif.gif"
//						)
//				)
//		);
//
//		lblGif.setBounds(
//				0, 0, 611, 517
//		);
//
//		contentPane.add(lblGif);
//	}
//
//	// =========================================================
//	// CARREGAR FONTE DETERMINATION
//	// =========================================================
//
//	private Font carregarFonte() {
//
//		try {
//
//			/*
//			 * IMPORTANTE:
//			 *
//			 * Não colocamos "patrimonio/src" aqui.
//			 *
//			 * O src é a raiz dos recursos.
//			 */
//
//			InputStream is =
//					Movimentacoes.class.getResourceAsStream(
//							"/br/com/patrimonio/fonts/determination.ttf"
//					);
//
//			// -------------------------------------------------
//			// VERIFICA SE A FONTE FOI ENCONTRADA
//			// -------------------------------------------------
//
//			if (is == null) {
//
//				System.out.println(
//						"ERRO: Determination.ttf não encontrada!"
//				);
//
//				System.out.println(
//						"Verifique se está em:"
//				);
//
//				System.out.println(
//						"src/br/com/patrimonio/fonts/Determination.ttf"
//				);
//
//				return new Font(
//						"Tahoma",
//						Font.PLAIN,
//						16
//				);
//			}
//
//			// -------------------------------------------------
//			// CRIA A FONTE
//			// -------------------------------------------------
//
//			Font fonte =
//					Font.createFont(
//							Font.TRUETYPE_FONT,
//							is
//					);
//
//			is.close();
//
//			// -------------------------------------------------
//			// REGISTRA A FONTE NO JAVA
//			// -------------------------------------------------
//
//			GraphicsEnvironment ge =
//					GraphicsEnvironment
//							.getLocalGraphicsEnvironment();
//
//			ge.registerFont(fonte);
//
//			System.out.println(
//					"Fonte Determination carregada com sucesso!"
//			);
//
//			// -------------------------------------------------
//			// DEFINE O TAMANHO
//			// -------------------------------------------------
//
//			return fonte.deriveFont(
//					Font.PLAIN,
//					16f
//			);
//
//		} catch (Exception e) {
//
//			System.out.println(
//					"Erro ao carregar a fonte Determination:"
//			);
//
//			e.printStackTrace();
//
//			// -------------------------------------------------
//			// FONTE RESERVA
//			// -------------------------------------------------
//
//			return new Font(
//					"Tahoma",
//					Font.PLAIN,
//					16
//			);
//		}
//	}
//}
