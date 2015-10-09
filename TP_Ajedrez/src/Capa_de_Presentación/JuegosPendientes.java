package Capa_de_Presentación;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Capa_de_Entidades.ControladorAjedrez;
import Capa_de_Entidades.Jugador;
import Capa_de_Entidades.Partida;

import java.awt.Label;
import java.awt.TextField;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JuegosPendientes extends JFrame {

	static ControladorAjedrez caj= new ControladorAjedrez();
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private TextField nropartidatextField;
	private static JuegosPendientes frame;
	private static Jugador j1;
	private static Jugador j2;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void invocador(final int d1, final int d2) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					j1=caj.buscarJugador(d1);
					j2=caj.buscarJugador(d2);	
					frame = new JuegosPendientes();
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
	public JuegosPendientes() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 393, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Juegos pendientes entre:");
		label.setBounds(10, 10, 151, 22);
		contentPane.add(label);
		
		Label nombrej1lbl = new Label(j1.getNombre()+" "+j1.getApellido());
		nombrej1lbl.setBounds(10, 38, 195, 22);
		contentPane.add(nombrej1lbl);
		
		Label nombrej2lbl = new Label(j2.getNombre()+" "+j2.getApellido());
		nombrej2lbl.setBounds(229, 38, 134, 22);
		nombrej2lbl.setAlignment(Label.RIGHT);
		contentPane.add(nombrej2lbl);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(124, 66, 126, 96);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IDPartida"
			}
		));
		scrollPane.setViewportView(table);
		
		nropartidatextField = new TextField();
		nropartidatextField.setBounds(143, 172, 62, 22);
		contentPane.add(nropartidatextField);
		
		Label label_1 = new Label("Nro. Partida:");
		label_1.setAlignment(Label.RIGHT);
		label_1.setBounds(46, 172, 91, 22);
		contentPane.add(label_1);
		
		Button selectbtn = new Button("Seleccionar Partida");
		selectbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int nroPartida = Integer.parseInt(nropartidatextField.getText());
				
			}
		});
		selectbtn.setBounds(212, 172, 151, 22);
		contentPane.add(selectbtn);
		DefaultTableModel tab = (DefaultTableModel)table.getModel();
		ArrayList<Partida> partidas = caj.buscarPartidas(j1.getDni(), j2.getDni());
		for (Partida partida : partidas) {
			Object[] fila = {partida.getIdPartida()};
			tab.addRow(fila);
		}

	}
}
