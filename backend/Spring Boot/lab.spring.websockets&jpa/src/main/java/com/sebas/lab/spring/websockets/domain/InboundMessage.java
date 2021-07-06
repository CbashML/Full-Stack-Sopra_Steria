package com.sebas.lab.spring.websockets.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InboundMessage implements IMessage {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

    private String content;
  
    public InboundMessage() {
    }
    public InboundMessage(String content) {
      this.content = content;
    }

    /* (non-Javadoc)
	 * @see com.sebas.lab.spring.websockets.domain.IMessage#getContent()
	 */
    @Override
	public String getContent() {
      return content;
    }
  
    /* (non-Javadoc)
	 * @see com.sebas.lab.spring.websockets.domain.IMessage#setContent(java.lang.String)
	 */
    @Override
	public void setContent(String content) {
      this.content = content;
    }
  } 
