package com.example.roboworld.repository;

import com.example.roboworld.model.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {
    List<Forum> findAllByIdIsNot(Long id);
    Optional<Forum> findByTitle(String title);
}
