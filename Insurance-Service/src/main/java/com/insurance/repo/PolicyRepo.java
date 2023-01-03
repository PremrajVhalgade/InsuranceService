package com.insurance.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.Policy;
@Repository
public interface PolicyRepo extends JpaRepository<Policy, Integer> {

}
