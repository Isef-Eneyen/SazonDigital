package com.example.sazondigital.Repositories;

import com.example.sazondigital.Models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    public Rol findByName(String name);
}
