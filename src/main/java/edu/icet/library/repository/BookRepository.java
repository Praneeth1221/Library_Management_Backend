package edu.icet.library.repository;

import edu.icet.library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, String> {
    Optional<BookEntity> findByIsbn(String isbn);
}
