package com.bookapp.service;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import com.bookapp.repo.JournalEntryRepo;
import com.bookapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired
    private UserRepo userRepo;

    public JournalEntry saveJournalEntry(String userId, JournalEntry entry) {
        Optional<User> userOptional = userRepo.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            entry.setDate(LocalDateTime.now());

            JournalEntry savedEntry = journalEntryRepo.save(entry);

            user.getJournalEntries().add(savedEntry);
            userRepo.save(user);

            return savedEntry;
        } else {
            throw new RuntimeException("User not found!");
        }
    }

    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepo.findAll();
    }
}
