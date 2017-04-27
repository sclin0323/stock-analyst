package com.fubon.test.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.entity.Pcml;

@Repository
public interface PcmlRepository extends MongoRepository<Pcml, String> {

    //Page<Pcml> findByPcmlIdContaining(String fetchWord,Pageable pageable);

}

