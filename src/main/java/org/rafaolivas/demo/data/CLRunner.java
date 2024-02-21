package org.rafaolivas.demo.data;

import java.util.List;
import java.util.Optional;

import org.rafaolivas.demo.data.entity.Room;
import org.rafaolivas.demo.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;

    public CLRunner(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Room> rooms = roomRepository.findAll();
        Optional<Room> room = roomRepository.findByRoomNumberIgnoreCase("C3");
        System.out.println(room);
        rooms.forEach(System.out::println);
    }

}
