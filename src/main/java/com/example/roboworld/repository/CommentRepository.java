package com.example.roboworld.repository;

import com.example.roboworld.model.entity.Comment;
import com.example.roboworld.model.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByForum_Id(Long forumId);
    Optional<Comment> findByDescription(String description);
}
