package aplicacionDeEscritorio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Principal() {
		setTitle("Grupo 4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 450, 320);
		setResizable(false);
		contentPane = new JPanel();		
		contentPane.setBackground(new Color(0, 139, 139));

		setContentPane(contentPane);
		
		JButton btnEjercicio1 = new JButton("Ejercicio 1");
		btnEjercicio1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEjercicio1.setBounds(135, 70, 140, 30);
		
		btnEjercicio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Ejercicio1 frame = new Ejercicio1(Principal.this);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnEjercicio1);
		
		JButton btnEjercicio2 = new JButton("Ejercicio 2");
		btnEjercicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Ejercicio2 frame = new Ejercicio2(Principal.this);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnEjercicio2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEjercicio2.setBounds(135, 137, 140, 30);
		contentPane.add(btnEjercicio2);
		
		JButton btnEjercicio3 = new JButton("Ejercicio 3");
		btnEjercicio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Ejercicio3 frame = new Ejercicio3(Principal.this);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnEjercicio3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEjercicio3.setBounds(135, 205, 140, 30);
		contentPane.add(btnEjercicio3);
		
		JLabel lblGrupo4 = new JLabel("Grupo 4");
		lblGrupo4.setForeground(new Color(240, 255, 255));
		lblGrupo4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGrupo4.setBounds(31, 34, 83, 22);
		contentPane.add(lblGrupo4);
	}

}
