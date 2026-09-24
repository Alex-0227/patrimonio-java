//package br.com.patrimonio.janela;
//
//import java.awt.EventQueue;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import java.awt.Font;
//import javax.swing.JProgressBar;
//import javax.swing.SwingConstants;
//import java.awt.Color;
//
//public class TelaSplash extends JFrame {
//	public TelaSplash() {
//	}
//
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		
//					JFrame frame = new JFrame();
//					
//					//setar o plano de fundo da tela como transparente. O comando new Color
//					//aplica uma nova cor em 3 posições e a quarta é a opacidade
//					//os valores 0.0f são aplicado nas poisções RGB->
//					//R -> Vermelho
//					//G -> Verde
//					//B -> Azul
//					//Com seus respectivos valores variando entre 0.0 até 255.0.
//					//São valores com casas decimais, por este motivo, estamos usando
//					//os numeros como float(f), então poderiamos ter por exemplo as cores(10.56f ,45.80f ,14.0f)
//					
//					
//					
//				
//					
//					
//					frame.setType(Type.UTILITY);
//					frame.setResizable(false);
//					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					frame.setBounds(100, 100, 532, 537);
//					
//		JPanel contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		frame.setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		//Isso fará a tela abrir no centro da tela
//		frame.setLocationRelativeTo(null);
//		//Tira as bordas e o titulo da janela
//		frame.setUndecorated(true);
//		
//		JProgressBar progressBar = new JProgressBar();
//		progressBar.setStringPainted(true);
//		progressBar.setBackground(new Color(255, 255, 255));
//		progressBar.setForeground(new Color(0, 0, 0));
//		progressBar.setValue(0);
//		progressBar.setBounds(12, 475, 496, 12);
//		contentPane.add(progressBar);
//		
//		JLabel lblLegenda = new JLabel("...");
//		lblLegenda.setForeground(new Color(255, 255, 255));
//		lblLegenda.setHorizontalAlignment(SwingConstants.LEFT);
//		lblLegenda.setBounds(22, 498, 202, 26);
//		contentPane.add(lblLegenda);
//		
//		JLabel lblHako = new JLabel("HAKO");
//		lblHako.setForeground(new Color(255, 255, 255));
//		lblHako.setFont(new Font("Tahoma", Font.BOLD, 40));
//		lblHako.setBounds(363, 409, 145, 78);
//		contentPane.add(lblHako);
//		
//		JLabel lblTitle = new JLabel("DELTA");
//		lblTitle.setForeground(new Color(255, 255, 255));
//		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
//		lblTitle.setBounds(22, 409, 174, 78);
//		contentPane.add(lblTitle);
//		
//		JLabel lblDelta = new JLabel("");
//		lblDelta.setIcon(new ImageIcon(TelaSplash.class.getResource("/br/com/patrimonio/imagens/delta.png")));
//		lblDelta.setBounds(0, 0, 521, 473);
//		contentPane.add(lblDelta);
//		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setIcon(new ImageIcon(TelaSplash.class.getResource("/br/com/patrimonio/imagens/BBlack.png")));
//		lblNewLabel.setBounds(10, 427, 511, 104);
//		contentPane.add(lblNewLabel);
//		
//		frame.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
//		frame.setVisible(true);
//		
//		try {
//		for(int i = 0 ; i <= 100; i++) {
//			Thread.sleep(70);
//			progressBar.setValue(i);
//			
//			if( i < 30) {
//				lblLegenda.setText("Carregando");
//				
//			}
//			else if( i < 60) {
//				lblLegenda.setText("Carregando modulos");
//			}
//			else if(i < 80) {
//				lblLegenda.setText("Carregando as configurações");
//				
//			}
//			else if(i < 90) {
//				lblLegenda.setText("Iniciando a interface");
//				
//			}
//			else {
//				lblLegenda.setText("Tudo pronto!");
//			}
//				}
//			}
//		catch(Exception ex) {
//			ex.printStackTrace();
//		}
//		frame.dispose();
//		
//		TelaPrincipal tp = new TelaPrincipal();
//		tp.setVisible(true);
//	}
//	
//}
