package riwi.firstWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import riwi.firstWeb.entity.Coder;

@Repository
public interface CoderRepository extends JpaRepository <Coder, Long>{

    
}
