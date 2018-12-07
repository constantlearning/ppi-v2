
package com.example.v2ppi.repository;


import com.example.v2ppi.model.Avaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvariaRepository extends JpaRepository<Avaria, Long> {

}
