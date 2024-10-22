package com.example.sazondigital.Services;

import com.example.sazondigital.Models.Comment;
import com.example.sazondigital.Repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CommentService {

    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {return commentRepository.findAll();}

    public Comment getCommentById(int id) {return commentRepository.findById(id).orElse(null);}

    public void save(Comment comment) {commentRepository.save(comment);}

    public void delete(Comment comment) {commentRepository.delete(comment);}
}
