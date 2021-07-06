package com.sebas.lab.spring.websockets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sebas.lab.spring.websockets.domain.OutboundMessage;

@Repository
public interface OutMessageRepository extends JpaRepository<OutboundMessage, Long> {


}
