
package com.example.ppiv2.repository;


import com.example.ppiv2.model.Navio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NavioRepository extends JpaRepository<Navio, Long> {

}
