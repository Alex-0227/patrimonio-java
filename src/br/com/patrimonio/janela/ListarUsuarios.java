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

import br.com.patrimonio.dao.DAOUsuario;

public class ListarUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableUsuarios;
	private JTextField txtIdUsuarios;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarUsuarios frame = new ListarUsuarios();
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
	public ListarUsuarios() {
		setResizable(false);
		setTitle("SURVEY_PROGRAM_LISTAR_USUARIOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 870, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Listar Usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 496, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lbllbl = new JLabel("Digite o código do Usuario:");
		lbllbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbllbl.setBounds(10, 110, 202, 19);
		contentPane.add(lbllbl);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 58, 834, 14);
		contentPane.add(separator);
		
		txtIdUsuarios = new JTextField();
		txtIdUsuarios.setBounds(200, 111, 395, 20);
		contentPane.add(txtIdUsuarios);
		txtIdUsuarios.setColumns(10);
		
		JButton btnRealizarBusca = new JButton("");
		btnRealizarBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//AQUI AQUI AQUI
				String cx = txtIdUsuarios.getText();
				if(cx.equals("") || cx==null) {
					carregarUsuarios(0);
				}
				else {
					carregarUsuarios(Integer.parseInt(cx));
				}
				
			}
		});
		btnRealizarBusca.setIcon(new ImageIcon(ListarUsuarios.class.getResource("/br/com/patrimonio/imagens/Icons/search.png")));
		btnRealizarBusca.setBounds(627, 110, 41, 29);
		contentPane.add(btnRealizarBusca);
			
		carregarUsuarios(0);
		
		
	}
	
	public void carregarUsuarios(Integer id) {
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 155, 834, 358);
		contentPane.add(scrollPane);
		
		//Montar o cabeçalho da tabela
		String colunas[] = {"Id","Nome do Usuario","E-mail","Pefil","Ativo","Criado Em","Atualizado Em"};
		
		//Vamos criar um modelo de dados para apresentar as colunas e os dados do banco
		//de dadaos na nossa JTable. O Modelo de dados organiza as informações que serão apresentadas
		
		DefaultTableModel model = new DefaultTableModel(colunas,0);
		
		
		//Instância da classe DAOCurso
		DAOUsuario dc = new DAOUsuario();
		//Receber a lista de todos os cursos do banco de dados em uma lista
		
		List<br.com.patrimonio.pojo.Usuarios> lu;
		br.com.patrimonio.pojo.Usuarios cs;
		
		
		if( id == 0) {
			lu = dc.listar();
			
			for(br.com.patrimonio.pojo.Usuarios cr : lu) {
				Object[] dados = {
						cr.getId(),
						cr.getNome(),
						cr.getEmail(),
						
						cr.getPerfil(),
							    			
						cr.getAtivo(),
						cr.getCriado_em(),
						cr.getAtualizado_em(),
						
				};
				model.addRow(dados);
			}
			
		}
		else {
			cs = dc.listarID(id);
			
			Object[] dados = {
					cs.getId(),
					cs.getNome(),
					cs.getEmail(),
					
					cs.getPerfil(),
						    			
					cs.getAtivo(),
					cs.getCriado_em(),
					cs.getAtualizado_em()
			};
			model.addRow(dados);
		}
		
		
		
		//Adicionar o modelo de dados com colunas a JTable	
		tableUsuarios = new JTable(model);
		scrollPane.setViewportView(tableUsuarios);
	}
	
}
