//package br.com.patrimonio.janela;
//
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.ImageIcon;
//import javax.swing.JTextArea;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JTextField;
//import javax.swing.JOptionPane;
//
//import br.com.patrimonio.dao.DAOBaixas;
//import br.com.patrimonio.dao.DAOUsuario;
//import br.com.patrimonio.pojo.Baixas;
//import br.com.patrimonio.pojo.TipoBaixa;
//import br.com.patrimonio.pojo.Usuarios;
//
//public class Baixas_Patrimoniais extends JFrame {
//
//private static final long serialVersionUID = 1L;
//
//private JPanel contentPane;
//
//private JTextField txtDocComprobatorio;
//private JTextField txtValorRecuperado;
//
//private JTextArea txtDescricao;
//
//private JComboBox cbxTipoBaixa;
//private JComboBox cbxSelectUsuario;
//private JComboBox cbxSelectPatrimonios;
//
///**
// * Launch the application.
// */
//public static void main(String[] args) {
//
//	EventQueue.invokeLater(new Runnable() {
//
//		public void run() {
//
//			try {
//
//				Baixas_Patrimoniais frame =
//						new Baixas_Patrimoniais();
//
//				frame.setVisible(true);
//
//			} catch (Exception e) {
//
//				e.printStackTrace();
//			}
//		}
//	});
//}
//
///**
// * Create the frame.
// */
//public Baixas_Patrimoniais() {
//
//	setTitle("SURVEY_PROGRAM_BAIXAS");
//
//	setDefaultCloseOperation(
//			JFrame.DISPOSE_ON_CLOSE
//	);
//
//	setBounds(
//			100,
//			100,
//			649,
//			484
//	);
//
//	// =====================================================
//	// PAINEL
//	// =====================================================
//
//	contentPane =
//			new JPanel();
//
//	contentPane.setBackground(
//			new Color(0, 0, 0)
//	);
//
//	contentPane.setBorder(
//			new EmptyBorder(
//					5,
//					5,
//					5,
//					5
//			)
//	);
//
//	setContentPane(contentPane);
//
//	contentPane.setLayout(null);
//
//	// =====================================================
//	// DAO USUÁRIO
//	// =====================================================
//
//	DAOUsuario dau =
//			new DAOUsuario();
//
//	// =====================================================
//	// COMBOBOX TIPO DE BAIXA
//	// =====================================================
//
//	cbxTipoBaixa =
//			new JComboBox();
//
//	cbxTipoBaixa.setBounds(
//			297,
//			215,
//			326,
//			22
//	);
//
//	contentPane.add(
//			cbxTipoBaixa
//	);
//
//	// =====================================================
//	// CARREGA TIPOS DE BAIXA
//	// =====================================================
//
//	for (TipoBaixa tipo :
//			TipoBaixa.values()) {
//
//		cbxTipoBaixa.addItem(
//				tipo
//		);
//	}
//
//	// =====================================================
//	// COMBOBOX USUÁRIO
//	// =====================================================
//
//	cbxSelectUsuario =
//			new JComboBox();
//
//	cbxSelectUsuario.setBounds(
//			297,
//			182,
//			326,
//			22
//	);
//
//	contentPane.add(
//			cbxSelectUsuario
//	);
//
//	// =====================================================
//	// CARREGA USUÁRIOS
//	// =====================================================
//
//	List<Usuarios> lstUsuarios =
//			dau.listaAtivos();
//
//	for (Usuarios us :
//			lstUsuarios) {
//
//		cbxSelectUsuario.addItem(
//				us
//		);
//	}
//
//	// =====================================================
//	// COMBOBOX PATRIMÔNIOS
//	// =====================================================
//
//	cbxSelectPatrimonios =
//			new JComboBox();
//
//	cbxSelectPatrimonios.setBounds(
//			297,
//			149,
//			326,
//			22
//	);
//
//	contentPane.add(
//			cbxSelectPatrimonios
//	);
//
//	// =====================================================
//	// LABEL DOCUMENTO
//	// =====================================================
//
//	JLabel lblDocumento =
//			new JLabel(
//					"Documento Comprobatorio"
//			);
//
//	lblDocumento.setForeground(
//			Color.WHITE
//	);
//
//	lblDocumento.setFont(
//			new Font(
//					"Tahoma",
//					Font.PLAIN,
//					20
//			)
//	);
//
//	lblDocumento.setBackground(
//			Color.WHITE
//	);
//
//	lblDocumento.setBounds(
//			17,
//			275,
//			270,
//			21
//	);
//
//	contentPane.add(
//			lblDocumento
//	);
//
//	// =====================================================
//	// LABEL VALOR RECUPERADO
//	// =====================================================
//
//	JLabel lblValor =
//			new JLabel(
//					"Valor recuperado"
//			);
//
//	lblValor.setForeground(
//			Color.WHITE
//	);
//
//	lblValor.setFont(
//			new Font(
//					"Tahoma",
//					Font.PLAIN,
//					20
//			)
//	);
//
//	lblValor.setBackground(
//			Color.WHITE
//	);
//
//	lblValor.setBounds(
//			17,
//			244,
//			270,
//			21
//	);
//
//	contentPane.add(
//			lblValor
//	);
//
//	// =====================================================
//	// LABEL TIPO DE BAIXA
//	// =====================================================
//
//	JLabel lblTipo =
//			new JLabel(
//					"Selecione o Tipo de baixa"
//			);
//
//	lblTipo.setForeground(
//			Color.WHITE
//	);
//
//	lblTipo.setFont(
//			new Font(
//					"Tahoma",
//					Font.PLAIN,
//					20
//			)
//	);
//
//	lblTipo.setBackground(
//			Color.WHITE
//	);
//
//	lblTipo.setBounds(
//			17,
//			212,
//			270,
//			21
//	);
//
//	contentPane.add(
//			lblTipo
//	);
//
//	// =====================================================
//	// LABEL USUÁRIO
//	// =====================================================
//
//	JLabel lblUsuario =
//			new JLabel(
//					"Selecione o Usuario"
//			);
//
//	lblUsuario.setForeground(
//			Color.WHITE
//	);
//
//	lblUsuario.setFont(
//			new Font(
//					"Tahoma",
//					Font.PLAIN,
//					20
//			)
//	);
//
//	lblUsuario.setBackground(
//			Color.WHITE
//	);
//
//	lblUsuario.setBounds(
//			17,
//			182,
//			217,
//			21
//	);
//
//	contentPane.add(
//			lblUsuario
//	);
//
//	// =====================================================
//	// LABEL PATRIMÔNIO
//	// =====================================================
//
//	JLabel lblPatrimonio =
//			new JLabel(
//					"Selecione o Patrimônio"
//			);
//
//	lblPatrimonio.setFont(
//			new Font(
//					"Tahoma",
//					Font.PLAIN,
//					20
//			)
//	);
//
//	lblPatrimonio.setForeground(
//			Color.WHITE
//	);
//
//	lblPatrimonio.setBackground(
//			Color.WHITE
//	);
//
//	lblPatrimonio.setBounds(
//			17,
//			150,
//			217,
//			21
//	);
//
//	contentPane.add(
//			lblPatrimonio
//	);
//
//	// =====================================================
//	// CAMPO VALOR RECUPERADO
//	// =====================================================
//
//	txtValorRecuperado =
//			new JTextField();
//
//	txtValorRecuperado.setColumns(
//			10
//	);
//
//	txtValorRecuperado.setBounds(
//			297,
//			248,
//			326,
//			20
//	);
//
//	contentPane.add(
//			txtValorRecuperado
//	);
//
//	// =====================================================
//	// CAMPO DOCUMENTO COMPROBATÓRIO
//	// =====================================================
//
//	txtDocComprobatorio =
//			new JTextField();
//
//	txtDocComprobatorio.setBounds(
//			297,
//			279,
//			326,
//			20
//	);
//
//	contentPane.add(
//			txtDocComprobatorio
//	);
//
//	txtDocComprobatorio.setColumns(
//			10
//	);
//
//	// =====================================================
//	// BACKGROUND
//	// =====================================================
//
//	JLabel lblNewLabel =
//			new JLabel("");
//
//	lblNewLabel.setIcon(
//			new ImageIcon(
//					Baixas_Patrimoniais.class.getResource(
//							"/br/com/patrimonio/imagens/snowgrave.png"
//					)
//			)
//	);
//
//	lblNewLabel.setBounds(
//			0,
//			-106,
//			640,
//			247
//	);
//
//	contentPane.add(
//			lblNewLabel
//	);
//
//	// =====================================================
//	// DESCRIÇÃO
//	// =====================================================
//
//	txtDescricao =
//			new JTextArea();
//
//	txtDescricao.setBounds(
//			297,
//			351,
//			326,
//			83
//	);
//
//	contentPane.add(
//			txtDescricao
//	);
//
//	// =====================================================
//	// BOTÃO CADASTRAR
//	// =====================================================
//
//	JButton btnCadastrar =
//			new JButton(
//					"Cadastrar"
//			);
//
//	btnCadastrar.setBounds(
//			17,
//			370,
//			270,
//			46
//	);
//
//	contentPane.add(
//			btnCadastrar
//	);
//
//	// =====================================================
//	// LABEL DESCRIÇÃO
//	// =====================================================
//
//	JLabel lblDescricao =
//			new JLabel(
//					"Descreva o motivo:"
//			);
//
//	lblDescricao.setForeground(
//			Color.WHITE
//	);
//
//	lblDescricao.setFont(
//			new Font(
//					"Tahoma",
//					Font.PLAIN,
//					20
//			)
//	);
//
//	lblDescricao.setBackground(
//			Color.WHITE
//	);
//
//	lblDescricao.setBounds(
//			297,
//			322,
//			270,
//			21
//	);
//
//	contentPane.add(
//			lblDescricao
//	);
//
//	// =====================================================
//	// BOTÃO CADASTRAR
//	// =====================================================
//
//	btnCadastrar.addActionListener(
//			new ActionListener() {
//
//				public void actionPerformed(
//						ActionEvent e) {
//
//					// -------------------------------------
//					// PEGA OS DADOS DA TELA
//					// -------------------------------------
//
//					String motivo =
//							txtDescricao
//									.getText()
//									.trim();
//
//					String documento =
//							txtDocComprobatorio
//									.getText()
//									.trim();
//
//					String valorTexto =
//							txtValorRecuperado
//									.getText()
//									.trim();
//
//					// -------------------------------------
//					// VALIDA MOTIVO
//					// -------------------------------------
//
//					if (motivo.isEmpty()) {
//
//						JOptionPane.showMessageDialog(
//								null,
//								"Informe o motivo da baixa.",
//								"Erro",
//								JOptionPane.ERROR_MESSAGE
//						);
//
//						return;
//					}
//
//					// -------------------------------------
//					// PEGA O USUÁRIO
//					// -------------------------------------
//
//					Usuarios usuario =
//							(Usuarios)
//							cbxSelectUsuario
//									.getSelectedItem();
//
//					if (usuario == null) {
//
//						JOptionPane.showMessageDialog(
//								null,
//								"Nenhum usuário foi selecionado.",
//								"Erro",
//								JOptionPane.ERROR_MESSAGE
//						);
//
//						return;
//					}
//
//					// -------------------------------------
//					// PEGA O TIPO DE BAIXA
//					// -------------------------------------
//
//					TipoBaixa tipo =
//							(TipoBaixa)
//							cbxTipoBaixa
//									.getSelectedItem();
//
//					if (tipo == null) {
//
//						JOptionPane.showMessageDialog(
//								null,
//								"Nenhum tipo de baixa foi selecionado.",
//								"Erro",
//								JOptionPane.ERROR_MESSAGE
//						);
//
//						return;
//					}
//
//					// -------------------------------------
//					// VALIDA VALOR RECUPERADO
//					// -------------------------------------
//
//					Double valorRecuperado =
//							null;
//
//					if (!valorTexto.isEmpty()) {
//
//						try {
//
//							valorRecuperado =
//									Double.parseDouble(
//											valorTexto.replace(
//													",",
//													"."
//											)
//									);
//
//						} catch (
//								NumberFormatException nfe) {
//
//							JOptionPane.showMessageDialog(
//									null,
//									"Informe um valor recuperado válido.",
//									"Erro",
//									JOptionPane.ERROR_MESSAGE
//							);
//
//							return;
//						}
//					}
//
//					// -------------------------------------
//					// CRIA OBJETO BAIXA
//					// -------------------------------------
//
//					Baixas baixa =
//							new Baixas();
//
//					// -------------------------------------
//					// PASSA OS DADOS PARA O OBJETO
//					// -------------------------------------
//
//					baixa.setUsuario_registro_id(
//							usuario.getId()
//					);
//
//					baixa.setTipo_baixa(
//							tipo
//					);
//
//					baixa.setMotivo(
//							motivo
//					);
//
//					baixa.setValor_recuperado(
//							valorRecuperado
//					);
//
//					baixa.setDocumento_comprobatorio(
//							documento
//					);
//
//					// -------------------------------------
//					// CRIA DAO
//					// -------------------------------------
//
//					DAOBaixas db =
//							new DAOBaixas();
//
//					// -------------------------------------
//					// CADASTRA NO BANCO
//					// -------------------------------------
//
//					/*
//					 * O patrimonio_id será preenchido quando
//					 * fizermos a associação com o POJO Patrimonios.
//					 */
//
//					String m =
//							"Patrimônio ainda não associado.";
//
//					// -------------------------------------
//					// MOSTRA RESULTADO
//					// -------------------------------------
//
//					JOptionPane.showMessageDialog(
//							null,
//							m
//					);
//				}
//			}
//	);
//}
//
//
//}