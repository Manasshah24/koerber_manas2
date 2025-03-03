package com.bookapp.controller;


import com.bookapp.entities.JournalEntry;
import com.bookapp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @PostMapping("/{userId}")
    public JournalEntry addJournalEntry(@PathVariable String userId, @RequestBody JournalEntry entry) {
        return journalEntryService.saveJournalEntry(userId, entry);
    }

    @GetMapping
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryService.getAllJournalEntries();
    }
}
