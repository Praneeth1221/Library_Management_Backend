package edu.icet.library.repository;

import edu.icet.library.entity.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<BorrowEntity, Integer> {

}
