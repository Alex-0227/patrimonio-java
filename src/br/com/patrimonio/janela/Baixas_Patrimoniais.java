package br.com.patrimonio.janela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import br.com.patrimonio.dao.DAOBaixas;
import br.com.patrimonio.dao.DAOPatrimonios;
import br.com.patrimonio.dao.DAOUsuario;

import br.com.patrimonio.pojo.Baixas;
import br.com.patrimonio.pojo.Patrimonio;
import br.com.patrimonio.pojo.TipoBaixa;
import br.com.patrimonio.pojo.Usuarios;

public class Baixas_Patrimoniais extends JFrame {

private static final long serialVersionUID = 1L;

private JPanel contentPane;

private JTextField txtDocComprobatorio;
private JTextField txtValorRecuperado;

private JTextArea txtDescricao;

private JComboBox<TipoBaixa> cbxTipoBaixa;
private JComboBox<Usuarios> cbxSelectUsuario;
private JComboBox<Patrimonio> cbxSelectPatrimonios;

/**
 * Launch the application.
 */
public static void main(String[] args) {

	EventQueue.invokeLater(new Runnable() {

		public void run() {

			try {

				Baixas_Patrimoniais frame =
						new Baixas_Patrimoniais();

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
public Baixas_Patrimoniais() {

	setTitle("SURVEY_PROGRAM_BAIXAS");

	setDefaultCloseOperation(
			JFrame.DISPOSE_ON_CLOSE
	);

	setBounds(
			100,
			100,
			649,
			484
	);

	// =====================================================
	// PAINEL
	// =====================================================

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
	// COMBOBOX TIPO DE BAIXA
	// =====================================================

	cbxTipoBaixa =
			new JComboBox<TipoBaixa>();

	cbxTipoBaixa.setBounds(
			297,
			215,
			326,
			22
	);

	contentPane.add(
			cbxTipoBaixa
	);

	// =====================================================
	// CARREGA TIPOS DE BAIXA
	// =====================================================

	for (TipoBaixa tipo :
			TipoBaixa.values()) {

		cbxTipoBaixa.addItem(
				tipo
		);
	}

	// =====================================================
	// COMBOBOX USUÁRIO
	// =====================================================

	cbxSelectUsuario =
			new JComboBox<Usuarios>();

	cbxSelectUsuario.setBounds(
			297,
			182,
			326,
			22
	);

	contentPane.add(
			cbxSelectUsuario
	);

	// =====================================================
	// CARREGA USUÁRIOS
	// =====================================================

	carregarUsuarios();

	// =====================================================
	// COMBOBOX PATRIMÔNIOS
	// =====================================================

	cbxSelectPatrimonios =
			new JComboBox<Patrimonio>();

	cbxSelectPatrimonios.setBounds(
			297,
			149,
			326,
			22
	);

	contentPane.add(
			cbxSelectPatrimonios
	);

	// =====================================================
	// CARREGA PATRIMÔNIOS
	// =====================================================

	carregarPatrimonios();

	// =====================================================
	// LABEL DOCUMENTO
	// =====================================================

	JLabel lblDocumento =
			new JLabel(
					"Documento Comprobatorio"
			);

	lblDocumento.setForeground(
			Color.WHITE
	);

	lblDocumento.setFont(
			new Font(
					"Tahoma",
					Font.PLAIN,
					20
			)
	);

	lblDocumento.setBackground(
			Color.WHITE
	);

	lblDocumento.setBounds(
			17,
			275,
			270,
			21
	);

	contentPane.add(
			lblDocumento
	);

	// =====================================================
	// LABEL VALOR RECUPERADO
	// =====================================================

	JLabel lblValor =
			new JLabel(
					"Valor recuperado"
			);

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

	lblValor.setBackground(
			Color.WHITE
	);

	lblValor.setBounds(
			17,
			244,
			270,
			21
	);

	contentPane.add(
			lblValor
	);

	// =====================================================
	// LABEL TIPO DE BAIXA
	// =====================================================

	JLabel lblTipo =
			new JLabel(
					"Selecione o Tipo de baixa"
			);

	lblTipo.setForeground(
			Color.WHITE
	);

	lblTipo.setFont(
			new Font(
					"Tahoma",
					Font.PLAIN,
					20
			)
	);

	lblTipo.setBackground(
			Color.WHITE
	);

	lblTipo.setBounds(
			17,
			212,
			270,
			21
	);

	contentPane.add(
			lblTipo
	);

	// =====================================================
	// LABEL USUÁRIO
	// =====================================================

	JLabel lblUsuario =
			new JLabel(
					"Selecione o Usuario"
			);

	lblUsuario.setForeground(
			Color.WHITE
	);

	lblUsuario.setFont(
			new Font(
					"Tahoma",
					Font.PLAIN,
					20
			)
	);

	lblUsuario.setBackground(
			Color.WHITE
	);

	lblUsuario.setBounds(
			17,
			182,
			217,
			21
	);

	contentPane.add(
			lblUsuario
	);

	// =====================================================
	// LABEL PATRIMÔNIO
	// =====================================================

	JLabel lblPatrimonio =
			new JLabel(
					"Selecione o Patrimônio"
			);

	lblPatrimonio.setFont(
			new Font(
					"Tahoma",
					Font.PLAIN,
					20
			)
	);

	lblPatrimonio.setForeground(
			Color.WHITE
	);

	lblPatrimonio.setBackground(
			Color.WHITE
	);

	lblPatrimonio.setBounds(
			17,
			150,
			217,
			21
	);

	contentPane.add(
			lblPatrimonio
	);

	// =====================================================
	// CAMPO VALOR RECUPERADO
	// =====================================================

	txtValorRecuperado =
			new JTextField();

	txtValorRecuperado.setColumns(
			10
	);

	txtValorRecuperado.setBounds(
			297,
			248,
			326,
			20
	);

	contentPane.add(
			txtValorRecuperado
	);

	// =====================================================
	// CAMPO DOCUMENTO COMPROBATÓRIO
	// =====================================================

	txtDocComprobatorio =
			new JTextField();

	txtDocComprobatorio.setBounds(
			297,
			279,
			326,
			20
	);

	contentPane.add(
			txtDocComprobatorio
	);

	txtDocComprobatorio.setColumns(
			10
	);

	// =====================================================
	// BACKGROUND
	// =====================================================

	JLabel lblNewLabel =
			new JLabel("");

	lblNewLabel.setIcon(
			new ImageIcon(
					Baixas_Patrimoniais.class.getResource(
							"/br/com/patrimonio/imagens/snowgrave.png"
					)
			)
	);

	lblNewLabel.setBounds(
			0,
			-106,
			640,
			247
	);

	contentPane.add(
			lblNewLabel
	);

	// =====================================================
	// DESCRIÇÃO
	// =====================================================

	txtDescricao =
			new JTextArea();

	txtDescricao.setBounds(
			297,
			351,
			326,
			83
	);

	contentPane.add(
			txtDescricao
	);

	// =====================================================
	// BOTÃO CADASTRAR
	// =====================================================

	JButton btnCadastrar =
			new JButton(
					"Cadastrar"
			);

	btnCadastrar.setBounds(
			17,
			370,
			270,
			46
	);

	contentPane.add(
			btnCadastrar
	);

	// =====================================================
	// LABEL DESCRIÇÃO
	// =====================================================

	JLabel lblDescricao =
			new JLabel(
					"Descreva o motivo:"
			);

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

	lblDescricao.setBackground(
			Color.WHITE
	);

	lblDescricao.setBounds(
			297,
			322,
			270,
			21
	);

	contentPane.add(
			lblDescricao
	);

	// =====================================================
	// AÇÃO DO BOTÃO
	// =====================================================

	btnCadastrar.addActionListener(
			new ActionListener() {

				public void actionPerformed(
						ActionEvent e) {

					cadastrarBaixa();
				}
			}
	);
}

// =========================================================
// CARREGAR USUÁRIOS
// =========================================================

private void carregarUsuarios() {

	try {

		DAOUsuario dao =
				new DAOUsuario();

		List<Usuarios> listaUsuarios =
				dao.listaAtivos();

		for (Usuarios usuario :
				listaUsuarios) {

			cbxSelectUsuario.addItem(
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
	}
}

// =========================================================
// CARREGAR PATRIMÔNIOS
// =========================================================

private void carregarPatrimonios() {

	try {

		DAOPatrimonios dao =
				new DAOPatrimonios();

		List<br.com.patrimonio.pojo.Patrimonio> lista =
				dao.listar();

		for (Patrimonio patrimonio :
				lista) {

			cbxSelectPatrimonios.addItem(
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
	}
}

// =========================================================
// CADASTRAR BAIXA
// =========================================================

private void cadastrarBaixa() {

	// -----------------------------------------
	// PEGA O MOTIVO
	// -----------------------------------------

	String motivo =
			txtDescricao
					.getText()
					.trim();

	if (motivo.isEmpty()) {

		JOptionPane.showMessageDialog(
				this,
				"Informe o motivo da baixa.",
				"Erro",
				JOptionPane.ERROR_MESSAGE
		);

		tocarSomErro();

		txtDescricao.requestFocus();

		return;
	}

	// -----------------------------------------
	// PEGA O DOCUMENTO
	// -----------------------------------------

	String documento =
			txtDocComprobatorio
					.getText()
					.trim();

	// -----------------------------------------
	// PEGA O USUÁRIO
	// -----------------------------------------

	Usuarios usuario =
			(Usuarios)
			cbxSelectUsuario
					.getSelectedItem();

	if (usuario == null) {

		JOptionPane.showMessageDialog(
				this,
				"Nenhum usuário foi selecionado.",
				"Erro",
				JOptionPane.ERROR_MESSAGE
		);

		tocarSomErro();

		return;
	}

	// -----------------------------------------
	// PEGA O PATRIMÔNIO
	// -----------------------------------------

	Patrimonio patrimonio =
			(Patrimonio)
			cbxSelectPatrimonios
					.getSelectedItem();

	if (patrimonio == null) {

		JOptionPane.showMessageDialog(
				this,
				"Nenhum patrimônio foi selecionado.",
				"Erro",
				JOptionPane.ERROR_MESSAGE
		);

		tocarSomErro();

		return;
	}

	// -----------------------------------------
	// PEGA O TIPO DE BAIXA
	// -----------------------------------------

	TipoBaixa tipo =
			(TipoBaixa)
			cbxTipoBaixa
					.getSelectedItem();

	if (tipo == null) {

		JOptionPane.showMessageDialog(
				this,
				"Nenhum tipo de baixa foi selecionado.",
				"Erro",
				JOptionPane.ERROR_MESSAGE
		);

		tocarSomErro();

		return;
	}

	// -----------------------------------------
	// VALOR RECUPERADO
	// -----------------------------------------

	String valorTexto =
			txtValorRecuperado
					.getText()
					.trim();

	Double valorRecuperado =
			null;

	if (!valorTexto.isEmpty()) {

		try {

			valorRecuperado =
					Double.parseDouble(
							valorTexto.replace(
									",",
									"."
							)
					);

			if (valorRecuperado < 0) {

				JOptionPane.showMessageDialog(
						this,
						"O valor recuperado não pode ser negativo.",
						"Erro",
						JOptionPane.ERROR_MESSAGE
				);

				tocarSomErro();

				return;
			}

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(
					this,
					"Informe um valor recuperado válido.",
					"Erro",
					JOptionPane.ERROR_MESSAGE
			);

			tocarSomErro();

			txtValorRecuperado.requestFocus();

			return;
		}
	}

	// -----------------------------------------
	// CRIA O POJO BAIXAS
	// -----------------------------------------

	Baixas baixa =
			new Baixas();

	/*
	 * Aqui acontece a associação
	 * entre o patrimônio selecionado
	 * e a tabela baixas_patrimoniais.
	 */
	baixa.setPatrimonio_id(
			patrimonio.getId()
	);

	/*
	 * Usuário que está registrando
	 * a baixa.
	 */
	baixa.setUsuario_registro_id(
			usuario.getId()
	);

	baixa.setTipo_baixa(
			tipo
	);

	baixa.setMotivo(
			motivo
	);

	baixa.setValor_recuperado(
			valorRecuperado
	);

	baixa.setDocumento_comprobatorio(
			documento
	);

	// -----------------------------------------
	// CADASTRA
	// -----------------------------------------

	try {

		DAOBaixas dao =
				new DAOBaixas();

		String mensagem =
				dao.cadastrar(
						baixa
				);

		JOptionPane.showMessageDialog(
				this,
				mensagem
		);

		/*
		 * Se o DAO retornar a mensagem
		 * de sucesso, toca o som de cadastro
		 * e limpa os campos.
		 */
		if ("Cadastro realizado".equals(
				mensagem)) {

			tocarSomCadastro();

			limparCampos();
		}

	} catch (Exception e) {

		JOptionPane.showMessageDialog(
				this,
				"Erro ao cadastrar a baixa:\n"
				+ e.getMessage(),
				"Erro",
				JOptionPane.ERROR_MESSAGE
		);

		tocarSomErro();

		e.printStackTrace();
	}
}

// =========================================================
// LIMPAR CAMPOS
// =========================================================

private void limparCampos() {

	txtDescricao.setText("");
	txtDocComprobatorio.setText("");
	txtValorRecuperado.setText("");

	if (cbxSelectPatrimonios.getItemCount() > 0) {

		cbxSelectPatrimonios.setSelectedIndex(
				0
		);
	}

	if (cbxSelectUsuario.getItemCount() > 0) {

		cbxSelectUsuario.setSelectedIndex(
				0
		);
	}

	if (cbxTipoBaixa.getItemCount() > 0) {

		cbxTipoBaixa.setSelectedIndex(
				0
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
						Baixas_Patrimoniais.class.getResource(
								"/br/com/patrimonio/sfx/ch7_intro.wav"
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
						Baixas_Patrimoniais.class.getResource(
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
						Baixas_Patrimoniais.class.getResource(
								"/br/com/patrimonio/sfx/ch7_error.wav"
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
