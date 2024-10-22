package com.example.sazondigital.Repositories;

import com.example.sazondigital.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
