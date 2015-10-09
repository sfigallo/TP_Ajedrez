package Capa_de_Presentación;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Label;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Button;

import javax.swing.table.DefaultTableModel;

import Capa_de_Datos.DataJugadores;
import Capa_de_Entidades.Jugador;

public class Juego extends JFrame {

	private JPanel contentPane;
	private static Juego frame;
	private JTextField idPiezaTextField;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private static Jugador j1;
	private static Jugador j2;
	private Label turnolbl;

	/**
	 * Launch the application.
	 */
	public static void invocador(int d1, int d2) {
		j1=DataJugadores.buscarJugador(d1);
		j2=DataJugadores.buscarJugador(d2);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Juego();
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
	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label blancaslbl = new Label("Blancas");
		blancaslbl.setFont(new Font("Dialog", Font.BOLD, 12));
		blancaslbl.setAlignment(Label.CENTER);
		blancaslbl.setBounds(10, 39, 176, 22);
		contentPane.add(blancaslbl);
		
		Label nombrej1lbl = new Label(j1.getNombre()+" "+j1.getApellido());
		nombrej1lbl.setAlignment(Label.CENTER);
		nombrej1lbl.setBounds(10, 11, 176, 22);
		contentPane.add(nombrej1lbl);
		
		Label nombrej2lbl = new Label(j2.getNombre()+" "+j2.getApellido());
		nombrej2lbl.setAlignment(Label.CENTER);
		nombrej2lbl.setBounds(365, 11, 176, 22);
		contentPane.add(nombrej2lbl);
		
		Label negraslbl = new Label("Negras");
		negraslbl.setFont(new Font("Dialog", Font.BOLD, 12));
		negraslbl.setAlignment(Label.CENTER);
		negraslbl.setBounds(365, 39, 176, 22);
		contentPane.add(negraslbl);
		
		Label turno = new Label("Turno");
		turno.setFont(new Font("Dialog", Font.PLAIN, 12));
		turno.setAlignment(Label.CENTER);
		turno.setBounds(192, 11, 167, 22);
		contentPane.add(turno);
		
		turnolbl = new Label("Turno");
		turnolbl.setFont(new Font("Dialog", Font.BOLD, 12));
		turnolbl.setForeground(Color.BLUE);
		turnolbl.setAlignment(Label.CENTER);
		turnolbl.setBounds(192, 39, 167, 22);
		contentPane.add(turnolbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 176, 283);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Pieza", "Letra", "Numero"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(31);
		table.getColumnModel().getColumn(1).setPreferredWidth(44);
		table.getColumnModel().getColumn(2).setPreferredWidth(36);
		table.getColumnModel().getColumn(3).setPreferredWidth(48);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(365, 75, 176, 283);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Pieza", "Letra", "Numero"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(31);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(44);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(36);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(48);
		scrollPane_1.setViewportView(table_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(196, 75, 159, 145);
		contentPane.add(layeredPane);
		
		idPiezaTextField = new JTextField();
		idPiezaTextField.setBounds(10, 27, 139, 20);
		layeredPane.add(idPiezaTextField);
		idPiezaTextField.setColumns(10);
		
		JLabel lblIdpieza = new JLabel("ID-Pieza");
		lblIdpieza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdpieza.setBounds(10, 11, 139, 14);
		layeredPane.add(lblIdpieza);
		
		textField = new JTextField();
		textField.setBounds(10, 82, 55, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 82, 55, 20);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLetra = new JLabel("Letra");
		lblLetra.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetra.setBounds(10, 66, 55, 14);
		layeredPane.add(lblLetra);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setBounds(94, 68, 55, 14);
		layeredPane.add(lblNumero);
		
		JLabel lblMoverA = new JLabel("Mover a...");
		lblMoverA.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoverA.setBounds(10, 47, 139, 14);
		layeredPane.add(lblMoverA);
		
		Button moverbtn = new Button("Mover");
		moverbtn.setBounds(10, 108, 139, 22);
		layeredPane.add(moverbtn);
	}
}
