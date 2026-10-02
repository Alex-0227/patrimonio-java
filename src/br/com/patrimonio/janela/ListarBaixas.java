package br.com.patrimonio.janela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.patrimonio.dao.DAOBaixas;

public class ListarBaixas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableCursos;
	private JTextField txtIdCurso;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarBaixas frame = new ListarBaixas();
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
	public ListarBaixas() {
		setResizable(false);
		setTitle("SURVEY_PROGRAM_LISTAR_BAIXAS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 870, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Listar Baixas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 180, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lbllbl = new JLabel("Digite o código da Baixa:");
		lbllbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbllbl.setBounds(10, 110, 167, 19);
		contentPane.add(lbllbl);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 58, 834, 14);
		contentPane.add(separator);
		
		txtIdCurso = new JTextField();
		txtIdCurso.setBounds(175, 111, 395, 20);
		contentPane.add(txtIdCurso);
		txtIdCurso.setColumns(10);
		
		JButton btnRealizarBusca = new JButton("");
		btnRealizarBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//AQUI AQUI AQUI
				String cx = txtIdCurso.getText();
				if(cx.equals("") || cx==null) {
					carregarBaixas(0);
				}
				else {
					carregarBaixas(Integer.parseInt(cx));
				}
				
			}
		});
		btnRealizarBusca.setIcon(new ImageIcon(ListarCursos.class.getResource("/br/com/patrimonio/imagens/Icons/search.png")));
		btnRealizarBusca.setBounds(580, 110, 41, 29);
		contentPane.add(btnRealizarBusca);
			
		carregarBaixas(0);
		
		
	}
	
	public void carregarBaixas(Integer id) {
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 834, 358);
		contentPane.add(scrollPane);
		
		//Montar o cabeçalho da tabela
		String colunas[] = {"Id","Patrimonio","Registro de Usuario","Tipo de baixa","Motivo","Valor recuperado","Documento Comprobatório","Data da baixa"};
		
		//Vamos criar um modelo de dados para apresentar as colunas e os dados do banco
		//de dadaos na nossa JTable. O Modelo de dados organiza as informações que serão apresentadas
		
		DefaultTableModel model = new DefaultTableModel(colunas,0);
		
		
		//Instância da classe DAOCurso
		DAOBaixas dc = new DAOBaixas();
		//Receber a lista de todos os cursos do banco de dados em uma lista
		
		List<br.com.patrimonio.pojo.Baixas> lc;
		br.com.patrimonio.pojo.Baixas cs;
		
		
		if( id == 0) {
			lc = dc.listar();
			
			for(br.com.patrimonio.pojo.Baixas cr : lc) {
				Object[] dados = {
						cr.getId(),						
						cr.getPatrimonio_id(),
						cr.getUsuario_registro_id(),
						
						cr.getTipo_baixa(),
						
						cr.getMotivo(),
						cr.getValor_recuperado(),
						cr.getDocumento_comprobatorio(),
						cr.getData_baixa()
						
				};
				model.addRow(dados);
			}
			
		}
		else {
			cs = dc.listarID(id);
			
			Object[] dados = {
					cs.getId(),						
					cs.getPatrimonio_id(),
					cs.getUsuario_registro_id(),
					
					cs.getTipo_baixa(),
					
					cs.getMotivo(),
					cs.getValor_recuperado(),
					cs.getDocumento_comprobatorio(),
					cs.getData_baixa()
			
			};
			model.addRow(dados);
		}
		
		
		
		//Adicionar o modelo de dados com colunas a JTable	
		tableCursos = new JTable(model);
		scrollPane.setViewportView(tableCursos);
	}
	
}
