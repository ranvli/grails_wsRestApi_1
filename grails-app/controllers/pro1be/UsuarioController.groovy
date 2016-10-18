package pro1be

import grails.rest.RestfulController

//http://docs.grails.org/2.3.1/guide/webServices.html#restfulControllers

class UsuarioController extends RestfulController {

	static allowedMethods = [update: "POST", delete: "POST"]
	static responseFormats = ['json', 'xml']
	
	UsuarioController() {
		super(Usuario)
	}
	
}
