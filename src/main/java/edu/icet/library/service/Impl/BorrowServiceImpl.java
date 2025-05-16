package edu.icet.library.service.Impl;

import edu.icet.library.entity.BookEntity;
import edu.icet.library.entity.BorrowEntity;
import edu.icet.library.entity.UserEntity;
import edu.icet.library.model.Borrow;
import edu.icet.library.repository.BookRepository;
import edu.icet.library.repository.BorrowRepository;
import edu.icet.library.repository.UserRepository;
import edu.icet.library.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Borrow borrowBook(Borrow borrowRequest) {

            UserEntity user = userRepository.findById(borrowRequest.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            BookEntity book = bookRepository.findById(borrowRequest.getBookId())
                    .orElseThrow(() -> new RuntimeException("Book not found"));

            // Create BorrowEntity
            BorrowEntity borrowEntity = new BorrowEntity();
            borrowEntity.setUser(user);
            borrowEntity.setBook(book);
            borrowEntity.setBorrowedAt(LocalDateTime.now());
            borrowEntity.setDueDate(borrowRequest.getDueDate());
            borrowEntity.setReturnedAt(null); // not returned yet

            // Save to DB
            BorrowEntity saved = borrowRepository.save(borrowEntity);

            // Convert to DTO
            Borrow response = new Borrow(
                    saved.getId(),
                    saved.getUser().getUserid(),
                    saved.getBook().getIsbn(),
                    saved.getBorrowedAt(),
                    saved.getDueDate(),
                    saved.getReturnedAt()
            );

            return response;
        }

}
