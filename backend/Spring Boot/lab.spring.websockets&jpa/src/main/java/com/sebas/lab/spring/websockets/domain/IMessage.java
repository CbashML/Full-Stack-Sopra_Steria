package com.sebas.lab.spring.websockets.domain;

public interface IMessage {

	/**Esta función devuelve el contenido del mensaje.
	 * @return contenido	un string que corresponde al contenido del mensaje.
	 */
	String getContent();

	/**
	 * Este metodo sirve para formatear el contenido del mensaje.
	 * 
	 * @param content
	 *            el cual es el contenido que se quiere establecer.
	 */
	void setContent(String content);

}