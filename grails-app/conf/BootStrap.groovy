import org.bouncycastle.asn1.x509.UserNotice;


import pro1be.Rol
import pro1be.Usuario
import pro1be.UsuarioRol
import grails.util.Environment

class BootStrap {
	def springSecurityService
	
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
		
		usuario = new Usuario(nombre: 'Randolfo', apellido1: 'Perencejo', apellido2: 'Torres', username: 'randolfo', password: 'clave12345')
		usuario.save(failOnError:true, flush:true, insert: true)
		
		usuario = new Usuario(nombre: 'Randall', apellido1: 'Vargas', apellido2: 'Li', username: 'randall', password: 'clave12345')
		usuario.save(failOnError:true, flush:true, insert: true)
		
		def userRole = Rol.findByAuthority('ROLE_USER') ?: new Rol(authority: 'ROLE_USER').save(failOnError: true)
		def adminRole = Rol.findByAuthority('ROLE_ADMIN') ?: new Rol(authority: 'ROLE_ADMIN').save(failOnError: true)
		
		def adminUser = Usuario.findByUsername('admin') ?: new Usuario(nombre: 'admin', apellido1: 'adminap1', apellido2: 'adminap2',
			username: 'admin',
			password: springSecurityService.encodePassword('admin'),
			enabled: true).save(failOnError: true)

		if (!adminUser.authorities.contains(adminRole)) {
			UsuarioRol.create adminUser, adminRole
		}
		
		println "Fin de carga de $Usuario.count usuarios en la BD"
	}
	
}
