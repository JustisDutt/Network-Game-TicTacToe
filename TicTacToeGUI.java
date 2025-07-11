package tictactoeNetwork;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextArea;

public class TicTacToeGUI {

	private JFrame frame;
	private JTextField tfPort;
	private JTextField tfServer;
	private JTextField tfMyPort;
	private JButton btnRunServer;
	private JButton btnConnect;
	private JButton btnReplay;
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	
	private JTextArea taLog;
	private TicTacToeClient client;
	private TicTacToeServer server;
	private boolean isClient;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeGUI window = new TicTacToeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToeGUI() {
		initialize();
	}
	
	public void doAction(int row, int col) {
		if(isClient) {
			if(client.changeText(row, col)) {
				client.send(row, col);
			}
		} else {
			if (server.changeText(row, col)) {
				server.send(row, col);
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Port");
		lblNewLabel.setBounds(35, 67, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Server");
		lblNewLabel_1.setBounds(35, 44, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MyPort");
		lblNewLabel_2.setBounds(35, 10, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		tfPort = new JTextField();
		tfPort.setBounds(90, 64, 96, 19);
		frame.getContentPane().add(tfPort);
		tfPort.setColumns(10);
		
		tfServer = new JTextField();
		tfServer.setBounds(90, 41, 96, 19);
		frame.getContentPane().add(tfServer);
		tfServer.setColumns(10);
		
		tfMyPort = new JTextField();
		tfMyPort.setBounds(90, 7, 149, 19);
		frame.getContentPane().add(tfMyPort);
		tfMyPort.setColumns(10);
		
		btnRunServer = new JButton("Run Server");
		btnRunServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int myPort = Integer.parseInt(tfMyPort.getText());
				
				server = new TicTacToeServer(myPort, taLog,btn1,
						btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
				
				isClient = false;
			}
		});
		btnRunServer.setBounds(263, 6, 85, 21);
		frame.getContentPane().add(btnRunServer);
		
		btnReplay = new JButton("Replay");
		btnReplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isClient) {
					client.init();
				}else {
					server.init();
				}
			}
		});
		btnReplay.setBounds(317, 37, 85, 43);
		frame.getContentPane().add(btnReplay);
		
		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serverIP = tfServer.getText();
				int serverPort = Integer.parseInt(tfPort.getText());
				
				client = new TicTacToeClient(serverIP, serverPort, taLog, btn1,
						btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
				
				isClient = true;
			}
		});
		btnConnect.setBounds(222, 37, 85, 43);
		frame.getContentPane().add(btnConnect);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 90, 416, 201);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(0,0);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btn1);
		
		btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(0,1);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btn2);
		
		btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(0,2);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btn3);
		
		btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(1,0);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btn4);
		
		btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(1,1);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btn5);
		
		btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(1,2);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btn6);
		
		btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(2,0);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btn7);
		
		btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(2,1);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btn8);
		
		btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(2,2);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btn9);
		
		taLog = new JTextArea();
		taLog.setBounds(10, 301, 416, 152);
		frame.getContentPane().add(taLog);
	}
}
