import pro1be.Usuario
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
		def result = '################## corriendo en X'
		println "Iniciando ... "
		switch (Environment.current) {
			case Environment.DEVELOPMENT:
				result = 'iniciando en DEV mode.'
				cargarDatosEjemplo()
				break;
			case Environment.TEST:
				result = 'iniciando en TEST mode.'
				break;
			case Environment.PRODUCTION:
				result = 'iniciando en PROD mode.'
				cargarDatosEjemplo()
				break;
		}
		println "environment: $Environment.current"
		println "$result"
    }
    def destroy = {
		println "Cerrando... "
    }
	
	private void cargarDatosEjemplo() {
		def usuario = null
		println "Cargando usuarios de prueba"
		
		usuario = new Usuario(nombre: 'Randolfo', apellido1: 'Perencejo', apellido2: 'Torres')
		usuario.save(failOnError:true, flush:true, insert: true)
		
		usuario = new Usuario(nombre: 'Randall', apellido1: 'Vargas', apellido2: 'Li')
		usuario.save(failOnError:true, flush:true, insert: true)
		
		
		println "Fin de carga de $Usuario.count usuarios en la BD"
	}
	
}
