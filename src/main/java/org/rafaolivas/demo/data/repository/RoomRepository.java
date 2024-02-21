package org.rafaolivas.demo.data.repository;

import java.util.Optional;
import org.rafaolivas.demo.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);
}
