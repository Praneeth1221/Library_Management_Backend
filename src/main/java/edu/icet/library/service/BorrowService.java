package edu.icet.library.service;

import edu.icet.library.entity.BorrowEntity;

public interface BorrowService {

    BorrowEntity issueBook(Integer userId, String isbn);
}
