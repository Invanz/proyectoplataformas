package controlador;

import modelo.PersonaModel;

public class PersonaController {

	public PersonaModel create (String nombre, String domicilio, String telefono ) {
		//Se crea un objeto de clase PersonaModel y se utiliza el método explicado en el modelo. 
		PersonaModel persona = new PersonaModel (nombre, domicilio, telefono);
		persona.savePersona();
		return persona;
		
	}
	
	public PersonaModel read (String id ) {
		// íbid
		PersonaModel persona = new PersonaModel ("", "", "");
		persona.readPersona(id);
		return persona;
	}
	
	public PersonaModel update (String id, String nombre, String domicilio, String telefono ) {
		// íbid
		PersonaModel persona = new PersonaModel (nombre, domicilio, telefono);
		persona.updatePersona(id, nombre, domicilio, telefono);
		return persona;
	}
	
	public void delete (String id ) {
		// íbid
		PersonaModel persona = new PersonaModel ("", "", "");
		persona.deletePersona (id);
		
	}	
}
