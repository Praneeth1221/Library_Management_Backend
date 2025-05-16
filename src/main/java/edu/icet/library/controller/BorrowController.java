package edu.icet.library.controller;

import edu.icet.library.entity.BorrowEntity;
import edu.icet.library.model.Borrow;
import edu.icet.library.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Borrow")
@RequiredArgsConstructor
@CrossOrigin
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping("/book")
    public ResponseEntity<Borrow> borrowBook(@RequestBody Borrow borrowRequest) {
        Borrow response = borrowService.borrowBook(borrowRequest);
        return ResponseEntity.ok(response);
    }

}