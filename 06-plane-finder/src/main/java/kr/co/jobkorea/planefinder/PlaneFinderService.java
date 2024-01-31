package kr.co.jobkorea.planefinder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PlaneFinderService {
    private final PlaneRepository repo;
    private final FlightGenerator generator;
    private URL acURL;
    private final ObjectMapper om;

    @SneakyThrows
    public PlaneFinderService(PlaneRepository repo, FlightGenerator generator) {
        this.repo = repo;
        this.generator = generator;

        // acURL = new URL("http://192.168.1.139/ajax/aircraft");
        om = new ObjectMapper();
    }

    public Iterable<Aircraft> getAircraft() throws IOException {
        List<Aircraft> positions = new ArrayList<>();

        // JsonNode aircraftNodes = null;
        // try {
        //     aircraftNodes = om.readTree(acURL)
        //             .get("aircraft");

        //     aircraftNodes.iterator().forEachRemaining(node -> {
        //         try {
        //             positions.add(om.treeToValue(node, Aircraft.class));
        //         } catch (JsonProcessingException e) {
        //             e.printStackTrace();
        //         }
        //     });
            int idx = (int)(Math.random() * 1000);
            // positions.add(new Aircraft(Long.valueOf(idx), "callsign" + idx, "squawk" + idx, "reg" + idx, "flightno" + idx, "route" + idx, "type" + idx, "category" + idx, idx, idx, idx, idx, Double.valueOf(idx), Double.valueOf(idx), Double.valueOf(idx), Double.valueOf(idx), Double.valueOf(idx), Double.valueOf(idx), true, true, Instant.now(), Instant.now(), Instant.now());
            positions.add(Aircraft.builder().callsign("callsign" + idx).squawk("squawk" + idx).reg("reg" + idx).flightno("flightno" + idx).route("route" + idx).type("type" + idx).category("category" + idx).altitude(idx).heading(idx).speed(idx).vertRate(idx).selectedAltitude(idx).lat(Double.valueOf(idx)).lon(Double.valueOf(idx)).barometer(Double.valueOf(idx)).polarDistance(Double.valueOf(idx)).polarBearing(Double.valueOf(idx)).isADSB(true).isOnGround(true).lastSeenTime(Instant.now()).posUpdateTime(Instant.now()).bds40SeenTime(Instant.now()).build());
        // } catch (IOException e) {
        //     System.out.println("\n>>> IO Exception: " + e.getLocalizedMessage() +
        //             ", generating and providing sample data.\n");
        //     return saveSamplePositions();
        // }

        if (positions.size() > 0) {
            positions.forEach(System.out::println);

            repo.deleteAll();
            return repo.saveAll(positions);
        } else {
            System.out.println("\n>>> No positions to report, generating and providing sample data.\n");
            return saveSamplePositions();
        }
    }

    private Iterable<Aircraft> saveSamplePositions() {
        final Random rnd = new Random();

        repo.deleteAll();

        for (int i = 0; i < rnd.nextInt(10); i++) {
            repo.save(generator.generate());
        }

        return repo.findAll();
    }
}