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

import br.com.patrimonio.dao.DAOPatrimonios;

public class ListarPatrimonios extends JFrame {

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
					ListarPatrimonios frame = new ListarPatrimonios();
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
	public ListarPatrimonios() {
		setResizable(false);
		setTitle("SURVEY_PROGRAM_LISTAR_PATRIMONIOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1134, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Listar Patrimonios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 301, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lbllbl = new JLabel("Digite o código do Patrimonio:");
		lbllbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbllbl.setBounds(10, 110, 199, 19);
		contentPane.add(lbllbl);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 58, 1098, 14);
		contentPane.add(separator);
		
		txtIdCurso = new JTextField();
		txtIdCurso.setBounds(219, 111, 395, 20);
		contentPane.add(txtIdCurso);
		txtIdCurso.setColumns(10);
		
		JButton btnRealizarBusca = new JButton("");
		btnRealizarBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//AQUI AQUI AQUI
				String cx = txtIdCurso.getText();
				if(cx.equals("") || cx==null) {
					carregarPatrimonios(0);
				}
				else {
					carregarPatrimonios(Integer.parseInt(cx));
				}
				
			}
		});
		btnRealizarBusca.setIcon(new ImageIcon(ListarCursos.class.getResource("/br/com/patrimonio/imagens/Icons/search.png")));
		btnRealizarBusca.setBounds(624, 110, 41, 29);
		contentPane.add(btnRealizarBusca);
			
		carregarPatrimonios(0);
		
		
	}
	
	public void carregarPatrimonios(Integer id) {
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 1098, 358);
		contentPane.add(scrollPane);
		
		//Montar o cabeçalho da tabela
		String colunas[] = {"Id","Nº Tombamento","Nome","Descrição","ID do Curso","ID do Local" , "ID da Categoria","Status", "Valor Aquisição", "Data Aquisição","Atualizado por", "Criado Por", "Atualizado em", "Criado Em" };
		
		//Vamos criar um modelo de dados para apresentar as colunas e os dados do banco
		//de dadaos na nossa JTable. O Modelo de dados organiza as informações que serão apresentadas
		
		DefaultTableModel model = new DefaultTableModel(colunas,0);
		
		
		//Instância da classe DAOCurso
		DAOPatrimonios dc = new DAOPatrimonios();
		//Receber a lista de todos os cursos do banco de dados em uma lista
		
		List<br.com.patrimonio.pojo.Patrimonio> lc;
		br.com.patrimonio.pojo.Patrimonio cs;
		
		
		if( id == 0) {
			lc = dc.listar();
			
			for(br.com.patrimonio.pojo.Patrimonio cr : lc) {
				Object[] dados = {
						cr.getId(),
						cr.getNumero_tombamento(),
						cr.getNome(),
						cr.getDescricao(),
						cr.getCurso_id(),
						cr.getLocal_id(),
						cr.getCategoria_id(),
						cr.getStatus(),
						cr.getValor_aquisicao(),
						cr.getData_aquisicao(),
						cr.getAtualizado_por(),
						cr.getCriado_por(),
						cr.getAtualizado_em(),
						cr.getCriado_em()
						
				};
				model.addRow(dados);
			}
			
		}
		else {
			cs = dc.listarID(id);
			
			Object[] dados = {
					cs.getId(),
					cs.getNumero_tombamento(),
					cs.getNome(),
					cs.getDescricao(),
					cs.getCurso_id(),
					cs.getLocal_id(),
					cs.getCategoria_id(),
					cs.getStatus(),
					cs.getValor_aquisicao(),
					cs.getData_aquisicao(),
					cs.getAtualizado_por(),
					cs.getCriado_por(),
					cs.getAtualizado_em(),
					cs.getCriado_em()
			};
			model.addRow(dados);
		}
		
		
		
		//Adicionar o modelo de dados com colunas a JTable	
		tableCursos = new JTable(model);
		scrollPane.setViewportView(tableCursos);
	}
	
}
