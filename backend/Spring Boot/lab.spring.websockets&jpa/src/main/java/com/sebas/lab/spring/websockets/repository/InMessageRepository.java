package com.sebas.lab.spring.websockets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sebas.lab.spring.websockets.domain.OutboundMessage;

@Repository
public interface InMessageRepository extends JpaRepository<OutboundMessage, Long> {


}
