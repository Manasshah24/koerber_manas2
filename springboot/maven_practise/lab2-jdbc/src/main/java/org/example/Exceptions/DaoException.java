package org.example.Exceptions;

import java.sql.SQLException;

public class DaoException extends RuntimeException {
    public DaoException(String message, SQLException e) {

        super(message);
    }
}
