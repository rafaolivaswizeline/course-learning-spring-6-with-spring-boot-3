package org.rafaolivas.demo.data.repository;

import org.rafaolivas.demo.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByRoomId(long roomId);

    List<Reservation> findAllByResDate(LocalDate date);
}
