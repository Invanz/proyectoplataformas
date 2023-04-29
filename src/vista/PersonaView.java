package vista;

import java.awt.EventQueue;
import controlador.PersonaController;
import modelo.PersonaModel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class PersonaView extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textDomicilio;
	private JTextField textTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonaView frame = new PersonaView();
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
	
	
	public PersonaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 634, 406);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Base de Datos Clientes");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(141, 10, 368, 36);
		panel.add(lblTitle);
		
		textId = new JTextField();
		textId.setBounds(82, 88, 96, 19);
		panel.add(textId);
		textId.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(252, 165, 202, 19);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setBounds(252, 202, 202, 19);
		panel.add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(252, 238, 202, 19);
		panel.add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setBounds(27, 91, 45, 13);
		panel.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setBounds(141, 168, 76, 13);
		panel.add(lblNombre);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDomicilio.setBounds(141, 205, 76, 13);
		panel.add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setBounds(141, 241, 76, 13);
		panel.add(lblTelefono);
		
		JButton btnCreate = new JButton("Crear");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// código botón "Crear"
				// Se construye un objeto del tipo PersonaController y se ingresan los parámetros dados por el usuario.
				// Luego en un objeto clase PersonaModel se utiliza el método create generado en el controlador. 
				PersonaController personaController = new PersonaController ();
				System.out.println(textNombre.getText());
				PersonaModel persona = personaController.create(textNombre.getText(), textDomicilio.getText(), 
						textTelefono.getText());
				textId.setText(persona.getId());
				
			}
		});
		btnCreate.setBounds(252, 267, 85, 21);
		panel.add(btnCreate);
		
		JButton btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Con el método read se recibe el id y se devuelven los demás datos al presionar buscar.
				
				PersonaController personaController = new PersonaController ();
				PersonaModel persona = personaController.read(textId.getText());
				textNombre.setText(persona.getNombre());
				textDomicilio.setText(persona.getDomicilio());
				textTelefono.setText(persona.getTelefono());
				
			}
		});
		btnSearch.setBounds(188, 87, 85, 21);
		panel.add(btnSearch);
		
		JButton btnUpdate = new JButton("Actualizar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// con el método actualizar se envía la orden de actualizar los datos en todas las casillas salvo id. 
				PersonaController personaController = new PersonaController ();
				personaController.update(textId.getText(),textNombre.getText(), textDomicilio.getText(), textTelefono.getText());
				
				
			}
		});
		btnUpdate.setBounds(347, 267, 107, 21);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Eliminar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Se lee el id y se elimina la ubicación de dicha fila en el a base de datos. 
				PersonaController personaController = new PersonaController ();
				personaController.delete(textId.getText());
				
			}
		});
		btnDelete.setBounds(283, 87, 85, 21);
		panel.add(btnDelete);
	}
}
