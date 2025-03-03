package com.bookapp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;

    private String email;

    // Store references to JournalEntry objects using @DBRef
    @DBRef(lazy = true)  // Lazy loading to avoid unnecessary fetches
    private List<JournalEntry> journalEntries = new ArrayList<>();

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
