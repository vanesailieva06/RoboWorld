package com.example.roboworld.web;

import com.example.roboworld.model.dto.CommentViewDto;
import com.example.roboworld.model.dto.NewCommentDto;
import com.example.roboworld.model.validation.ApiError;
import com.example.roboworld.service.CommentService;
import com.example.roboworld.service.ForumService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
public class ForumRestController {

    private final ForumService forumService;
    private final CommentService commentService;

    public ForumRestController(ForumService forumService, CommentService commentService) {
        this.forumService = forumService;
        this.commentService = commentService;
    }

    @GetMapping("/api/comments/{forumId}")
    public ResponseEntity<List<CommentViewDto>> getComments(
            @PathVariable Long forumId,
            Principal principal
    ) {
        return ResponseEntity.ok(
                commentService.getComments(forumId));
    }

    @PostMapping("/api/comments/{forumId}")
    public ResponseEntity<CommentViewDto> newComment(
            @AuthenticationPrincipal UserDetails principal,
            @PathVariable Long forumId,
            @RequestBody @Valid NewCommentDto newCommentDto
    ) {
        newCommentDto.setUser(principal.getUsername());
        newCommentDto.setForumTitle(forumService.findById(forumId).getTitle());

        CommentViewDto newComment =
                commentService.createComment(newCommentDto);


        URI locationOfNewComment =
                URI.create(String.format("/api/comments/%s/%s", forumId, newComment.getCommentId()));

        return ResponseEntity.
                created(locationOfNewComment).
                body(newComment);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> onValidationFailure(MethodArgumentNotValidException exc) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        exc.getFieldErrors().forEach(fe ->
                apiError.addFieldWithError(fe.getField()));

        return ResponseEntity.badRequest().body(apiError);
    }
}
