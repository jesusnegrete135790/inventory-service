package com.jesusn.booking.inventory_service.jobs;

import com.jesusn.booking.inventory_service.entities.EventSeat;
import com.jesusn.booking.inventory_service.repositories.EventSeatRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpiredSeatCleanupJob {


    private final EventSeatRepository eventSeatRepository;

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void unlockExpiredSeats() {
        log.info("Iniciando barrido de asientos bloqueados expirados...");
        LocalDateTime expirationTime = LocalDateTime.now().minusMinutes(15);

        List<EventSeat> expiredSeats = eventSeatRepository.findByStatusAndLockedAtBefore("LOCKED", expirationTime);

        if (expiredSeats.isEmpty()) {
            log.info("Todo limpio. No hay asientos expirados.");
            return;
        }


        for (EventSeat seat : expiredSeats) {
            seat.setStatus("AVAILABLE");
            seat.setLockedAt(null);
            log.info("Asiento {} liberado por inactividad.", seat.getId());
        }

        eventSeatRepository.saveAll(expiredSeats);
        log.info("Barrido terminado. {} asientos devueltos al mercado.", expiredSeats.size());
    }
}