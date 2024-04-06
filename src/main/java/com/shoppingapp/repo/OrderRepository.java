package com.shoppingapp.repo;

import com.shoppingapp.model.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Ordered,Long> {
}
