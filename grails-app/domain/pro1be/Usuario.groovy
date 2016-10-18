package pro1be

class Usuario {

	Long    id;
	
	String nombre;
	String apellido1;
	String apellido2;
	
    static constraints = {
		nombre(nullable:false, blank:false, maxSize:50)
		apellido1(nullable:false, blank:false, maxSize:50)
		apellido2(nullable:false, blank:false, maxSize:50)
		
    }
}
