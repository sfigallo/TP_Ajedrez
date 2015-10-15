package Capa_de_Presentación;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Label;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Button;

import javax.swing.table.DefaultTableModel;

import Capa_de_Entidades.ControladorAjedrez;
import Capa_de_Entidades.Jugador;
import Capa_de_Entidades.Pieza;
import Capa_de_Entidades.Posicion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JuegoActual extends JFrame {
	
	/*Variable AUTO-GENERADA para eliminar advertencias.*/
	private static final long serialVersionUID = 1L;
	/*Variable AUTO-GENERADA para eliminar advertencias.*/
	private static int id;
	private static Pieza[] piezas;
	private static ControladorAjedrez caj = new ControladorAjedrez();
	private JPanel contentPane;
	private static JuegoActual frame;
	private JTextField idPiezaTextField;
	private JTextField letraTextField;
	private JTextField numeroTextField;
	private JTable blancasTable;
	private JTable negrasTable;
	private static Jugador j1;
	private static Jugador j2;
	private Label turnolbl;	
	private String ganador = null;
	private Label messageBox;

	/**
	 * Launch the application.
	 */
	public static void invocador(int d1, int d2, int idPartida) {
		id = idPartida;
		j1=caj.buscarJugador(d1);
		j2=caj.buscarJugador(d2);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JuegoActual();
					frame.setVisible(true);
					if(id==0){
						caj.nuevaPartida(j1.getDni(), j2.getDni());
						piezas = caj.getPartidaActual().getPiezas();
						frame.CargarTablas();
						frame.turnolbl.setText("Blancas");
						
					}
					else{
						caj.buscarPartida(id);
						piezas = caj.getPartidaActual().getPiezas();
						frame.CargarTablas();
						frame.ActualizarTurno();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


		});
	}

	/**
	 * Create the frame.
	 */
	public JuegoActual() {
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
		
		turnolbl = new Label("turno");
		turnolbl.setFont(new Font("Dialog", Font.BOLD, 12));
		turnolbl.setForeground(Color.BLUE);
		turnolbl.setAlignment(Label.CENTER);
		turnolbl.setBounds(192, 39, 167, 22);
		contentPane.add(turnolbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 176, 283);
		contentPane.add(scrollPane);
		
		blancasTable = new JTable();
		blancasTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Pieza", "Letra", "Numero"
			}
		));
		blancasTable.getColumnModel().getColumn(0).setPreferredWidth(31);
		blancasTable.getColumnModel().getColumn(1).setPreferredWidth(44);
		blancasTable.getColumnModel().getColumn(2).setPreferredWidth(36);
		blancasTable.getColumnModel().getColumn(3).setPreferredWidth(48);
		scrollPane.setViewportView(blancasTable);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(365, 75, 176, 283);
		contentPane.add(scrollPane_1);
		
		negrasTable = new JTable();
		negrasTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Pieza", "Letra", "Numero"
			}
		));
		negrasTable.getColumnModel().getColumn(0).setPreferredWidth(31);
		negrasTable.getColumnModel().getColumn(1).setPreferredWidth(44);
		negrasTable.getColumnModel().getColumn(2).setPreferredWidth(36);
		negrasTable.getColumnModel().getColumn(3).setPreferredWidth(48);
		scrollPane_1.setViewportView(negrasTable);
		
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
		
		letraTextField = new JTextField();
		letraTextField.setBounds(10, 82, 55, 20);
		layeredPane.add(letraTextField);
		letraTextField.setColumns(10);
		
		numeroTextField = new JTextField();
		numeroTextField.setBounds(94, 82, 55, 20);
		layeredPane.add(numeroTextField);
		numeroTextField.setColumns(10);
		
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
		moverbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Mover();
			}
		});
		moverbtn.setBounds(10, 108, 139, 22);
		layeredPane.add(moverbtn);
		
		Label label = new Label("Mensaje");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setAlignment(Label.CENTER);
		label.setBounds(192, 226, 159, 22);
		contentPane.add(label);
		
		messageBox = new Label("");
		messageBox.setAlignment(Label.CENTER);
		messageBox.setBounds(192, 254, 159, 84);
		contentPane.add(messageBox);
	}
	protected void ActualizarTurno() {
		if(caj.getPartidaActual().getTurno()=='b') turnolbl.setText("Blancas");
		if(caj.getPartidaActual().getTurno()=='n') turnolbl.setText("Negras");
	}
	protected void Mover(){
		int idPieza = Integer.parseInt(idPiezaTextField.getText());
		char letra = letraTextField.getText().toCharArray()[0];
		int numero = Integer.parseInt(numeroTextField.getText());
		Posicion p = new Posicion();
		p.setLetra(letra);
		p.setNumero(numero);
		if(caj.moverPieza(idPieza, p)){
			piezas = caj.getPartidaActual().getPiezas();
			ActualizarTablas();
			ActualizarTurno();
			BorrarCampos();
			messageBox.setText("Movimiento guardado.");
			MostrarGanador();
		}
		else messageBox.setText("<html>El movimiento no<br>se puede realizar</html>");
	}

	protected void MostrarGanador() {
		ganador = caj.getGanador();
		if(ganador != null){
			if(ganador.equals("Blancas")){
				messageBox.setText("Ganador: Blancas");
			}
			else if (ganador.equals("Negras")){
				messageBox.setText("Ganador: Negras");
			}
		}
		
	}

	protected void BorrarCampos() {
		idPiezaTextField.setText("");
		letraTextField.setText("");
		numeroTextField.setText("");
	}

	protected void ActualizarTablas() {
		BorrarTablas();
		CargarTablas();		
	}
	
	protected void BorrarTablas() {
		DefaultTableModel btab = (DefaultTableModel)blancasTable.getModel();
		DefaultTableModel ntab = (DefaultTableModel)negrasTable.getModel();
		for (int i = 0; i < btab.getRowCount(); i++) {
			btab.removeRow(i);
			i-=1;
		}
		for (int i = 0; i < ntab.getRowCount(); i++) {
			ntab.removeRow(i);
			i-=1;
		}
	}
	
	protected void CargarTablas() {
		DefaultTableModel btab = (DefaultTableModel)blancasTable.getModel();
		DefaultTableModel ntab = (DefaultTableModel)negrasTable.getModel();
		for (Pieza pieza : piezas) {
			if (pieza.getColor().equals("b")&&pieza.isEstado()){
				Object[] fila = {pieza.getIdPieza(), pieza.getNombre(), pieza.getPosicion().getLetra(), pieza.getPosicion().getNumero()};
				btab.addRow(fila);
			}
			if(pieza.getColor().equals("n")&&pieza.isEstado()){
				Object[] fila = {pieza.getIdPieza(), pieza.getNombre() , pieza.getPosicion().getLetra(), pieza.getPosicion().getNumero()};
				ntab.addRow(fila);
				
			}
			
		}		
	}
}
