package com.solvd.booksy.records;

import java.time.LocalDateTime;

public record AppointmentTime(LocalDateTime start, LocalDateTime end, int durationMinutes) {

    public boolean overlaps(AppointmentTime other) {
        return this.start.isBefore(other.end) && other.start.isBefore(this.end);
    }
}