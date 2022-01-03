/**
 * 
 */
package com.devpredator.projectjsf.controllers;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author cesarjimenez
 * Clase que permite controlar el funcionamiento con la pantalla de login.xhtml
 */
@ManagedBean(name="LoginController")
public class LoginController {
	/**
	 * Usuario que ingresan al Login.
	 */
	private String usuario;
	/**
	 * Contraseña ingresada en el Login.
	 */
	private String password;
	/**
	 * Método que permite ingresar a la pantalla principal del proyecto
	 */
	public void ingresar() {
		System.out.println("Usuario: " + usuario);
		
		//backend
		if(usuario.equals("devpredator") && password.equals("12345")) {
			
			try {
				this.rediccionar("principal.xhtml"); // Llamar clase para redireccionar
				
			} catch (IOException e) {
				FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "La página no existe", ""));
				e.printStackTrace();
			}
			//FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Correcto", ""));
		}else {
			FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseña incorrectos", ""));
		}
	}
	// Clase para redireccionar pagina de ingreso
	private void rediccionar( String pagina ) throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();// Clase para redireccionar a otra pantalla
		ec.redirect(pagina);
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
