package edu.icet.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Borrow {
        private Integer id;
        private Integer userId;
        private String bookId;
        private LocalDateTime borrowedAt;
        private LocalDateTime dueDate;
        private LocalDateTime returnedAt;
    }

