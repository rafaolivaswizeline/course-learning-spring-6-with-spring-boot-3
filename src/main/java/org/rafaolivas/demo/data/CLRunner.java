package org.rafaolivas.demo.data;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.rafaolivas.demo.data.entity.Guest;
import org.rafaolivas.demo.data.entity.Reservation;
import org.rafaolivas.demo.data.entity.Room;
import org.rafaolivas.demo.data.repository.GuestRepository;
import org.rafaolivas.demo.data.repository.ReservationRepository;
import org.rafaolivas.demo.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;

    public CLRunner(RoomRepository roomRepository, ReservationRepository reservationRepository,
            GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long roomId = 8;
        Optional<Room> room = roomRepository.findById(roomId);

        List<Reservation> reservations = room.isPresent()
                ? reservationRepository.findByRoomId(room.get().getRoomId())
                : Collections.emptyList();

        Optional<Guest> guest = reservations.size() > 0 ? guestRepository.findById(reservations.get(0).getGuestId())
                : Optional.empty();

        List<Reservation> todayReservations = reservationRepository.findAllByResDate(LocalDate.parse("2023-08-28"));

        System.out.printf("Room #%s: %s\n", roomId, room);

        System.out.printf("One reservation for that room was: %s\n",
                reservations.size() > 0 ? reservations.get(0) : "None");

        System.out.printf("The guest for that reservation was: %s\n", guest);

        System.out.printf("Last years's reservations on August 28: %s\n",
                Stream.of(todayReservations).map(r -> r.toString()).collect(Collectors.joining("\n")));
    }

}
