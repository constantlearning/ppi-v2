
package com.example.ppiv2.repository;


import com.example.ppiv2.model.Avaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvariaRepository extends JpaRepository<Avaria, Long> {

}
