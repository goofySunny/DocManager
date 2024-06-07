package ir.najaftech.najafer.Exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private String message;
    private LocalDateTime timestamp;
    private String detail;
    
    public ErrorDetails(String message, LocalDateTime timestamp, String detail) {
        this.message = message;
        this.timestamp = timestamp;
        this.detail = detail;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
