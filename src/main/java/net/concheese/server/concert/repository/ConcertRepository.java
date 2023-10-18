package net.concheese.server.concert.repository;

import net.concheese.server.concert.model.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConcertRepository extends JpaRepository<Concert, UUID> {

}
