package org.example.service;

import org.example.entity.Metrics;

import java.util.List;

public interface ConsumerService {

    List<Metrics> findAll();

    Metrics findId(Long id);
}
