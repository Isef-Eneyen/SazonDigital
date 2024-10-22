package com.example.sazondigital.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<RolRepository, Integer> {
    public RolRepository findByRol(String name);
}
