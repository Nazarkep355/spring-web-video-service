package com.example.springwebvideoservice.repo;

import com.example.springwebvideoservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
