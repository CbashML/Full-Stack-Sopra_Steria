package com.sebas.lab.spring.websockets.domain;

public class InboundMessage {

    private String content;
  
    public InboundMessage() {
    }
    public InboundMessage(String content) {
      this.content = content;
    }

    public String getContent() {
      return content;
    }
  
    public void setContent(String content) {
      this.content = content;
    }
  } 
