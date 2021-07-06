package com.sebas.lab.spring.websockets.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author semolina
 *
 */
@Entity
public class OutboundMessage implements IMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String content;
	
	private String username = "Anonymous";

	public OutboundMessage() {
	}

	public OutboundMessage(String content) {
		this.content = content;
	}

	public OutboundMessage(String content, String username) {
		this.content = content;
		this.username = username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sebas.lab.spring.websockets.domain.IMessage#getContent()
	 */
	@Override
	public String getContent() {
		return content;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sebas.lab.spring.websockets.domain.IMessage#setContent(java.lang.String)
	 */
	@Override
	public void setContent(String content) {
		this.content = content;
	}
	
	/* (non-Javadoc)
	 * @see com.sebas.lab.spring.websockets.domain.IMessage#getUsername()
	 */
	public String getUsername() {
		return username;
	}

	/* (non-Javadoc)
	 * @see com.sebas.lab.spring.websockets.domain.IMessage#setUsername(java.lang.String)
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}