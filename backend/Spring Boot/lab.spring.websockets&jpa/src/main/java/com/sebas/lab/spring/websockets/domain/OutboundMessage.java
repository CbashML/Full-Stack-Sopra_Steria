package com.sebas.lab.spring.websockets.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OutboundMessage implements IMessage{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
    private String content;
  
    public OutboundMessage() {
    }
    public OutboundMessage(String content) {
      this.content = content;
    }
  
    public String getContent() {
      return content;
    }
  
    public void setContent(String content) {
      this.content = content;
    }
  }   