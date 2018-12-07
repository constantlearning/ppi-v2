
package com.example.v2ppi.repository;


import com.example.v2ppi.model.Navio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NavioRepository extends JpaRepository<Navio, Long> {

}
