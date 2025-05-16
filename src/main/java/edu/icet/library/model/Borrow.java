package edu.icet.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false)
    private Integer user_id;

    @Column(nullable = false)
    private Integer book_id;

    @CreationTimestamp
    @Column(name = " borrowed_at",nullable = false)
    private LocalDateTime borrowAt;
    @CreationTimestamp
    @Column(name = "due_date",nullable = false)
    private LocalDateTime due;
    @CreationTimestamp
    @Column(name = " returned_at")
    private LocalDateTime returnedAt;
}
