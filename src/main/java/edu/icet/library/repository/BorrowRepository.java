package edu.icet.library.repository;

import edu.icet.library.entity.BookEntity;
import edu.icet.library.entity.BorrowEntity;
import edu.icet.library.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowRepository extends JpaRepository<BorrowEntity, Integer> {
    Optional<BorrowEntity> findByUserAndBookAndReturnedAtIsNull(UserEntity user, BookEntity book);

}
