package edu.icet.library.controller;

import edu.icet.library.entity.BorrowEntity;
import edu.icet.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping("/issue")
    public ResponseEntity<BorrowEntity> issueBook(@RequestParam Integer userId,
                                                  @RequestParam String isbn) {
        BorrowEntity issued = borrowService.issueBook(userId, isbn);
        return ResponseEntity.ok(issued);
    }
}
