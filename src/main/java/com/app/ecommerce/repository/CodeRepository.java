package com.app.ecommerce.repository;

import com.app.ecommerce.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<Code, Integer> {
}
