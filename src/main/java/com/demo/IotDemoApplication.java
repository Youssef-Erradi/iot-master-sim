package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
public class IotDemoApplication {
	
	static final List<Measurement> measurements = new ArrayList<>();
	
	public static void main(String[] args) {
		SpringApplication.run(IotDemoApplication.class, args);
	}

}

@Component
class Scheduler {
   @Scheduled(fixedRate = 1000 * 5)
   public void fixedRateSch() {
	   Measurement measurement = new Measurement();
	   IotDemoApplication.measurements.add(measurement);
      System.out.println("New measurement: " + measurement.getDateTime());
   }
}

@RestController
class Controller{
	@GetMapping("measurements")
	public ResponseEntity<List<Measurement>> findAll(){
		return ResponseEntity.ok(IotDemoApplication.measurements); 
	}
}
