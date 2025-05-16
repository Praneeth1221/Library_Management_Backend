package edu.icet.library.service;

import edu.icet.library.entity.BorrowEntity;
import edu.icet.library.model.Borrow;

public interface BorrowService {

    Borrow borrowBook(Borrow borrowRequest);
}
