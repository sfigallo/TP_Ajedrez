package Capa_de_Presentación;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Capa_de_Datos.DataJugadores;
import Capa_de_Entidades.Jugador;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private TextField dnitextField;
	private TextField nombretextField;
	private TextField apellidotextField;
	private static Registro frame;

	/**
	 * Launch the application.
	 */
	public static void invocador() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static void bajarVentana(){
		frame.setVisible(false);
	}


	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 227, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label dnilbl = new Label("DNI:");
		dnilbl.setAlignment(Label.RIGHT);
		dnilbl.setBounds(10, 10, 62, 22);
		contentPane.add(dnilbl);
		
		Label nombrelbl = new Label("Nombre:");
		nombrelbl.setAlignment(Label.RIGHT);
		nombrelbl.setBounds(10, 38, 62, 22);
		contentPane.add(nombrelbl);
		
		Label apellidolbl = new Label("Apellido:");
		apellidolbl.setAlignment(Label.RIGHT);
		apellidolbl.setBounds(10, 70, 62, 22);
		contentPane.add(apellidolbl);
		
		dnitextField = new TextField();
		dnitextField.setBounds(78, 10, 125, 22);
		contentPane.add(dnitextField);
		
		nombretextField = new TextField();
		nombretextField.setBounds(78, 38, 125, 22);
		contentPane.add(nombretextField);
		
		apellidotextField = new TextField();
		apellidotextField.setBounds(78, 70, 125, 22);
		contentPane.add(apellidotextField);
		
		Button registrarbtn = new Button("Registrar jugador");
		registrarbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		registrarbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Jugador j = new Jugador();
				j.setDni(Integer.parseInt(dnitextField.getText()));
				j.setNombre(nombretextField.getText());
				j.setApellido(apellidotextField.getText());
				DataJugadores.registrarJugador(j);
				Registro.bajarVentana();				
			}
		});
		registrarbtn.setBounds(10, 106, 193, 22);
		contentPane.add(registrarbtn);
	}


}
