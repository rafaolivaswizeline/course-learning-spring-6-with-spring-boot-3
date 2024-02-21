package org.rafaolivas.demo.data.repository;

import org.rafaolivas.demo.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
