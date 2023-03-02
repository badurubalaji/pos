package com.deblabs.pos.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.deblabs.pos.models.Branch;


@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    
}
