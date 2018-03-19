
package org.emc.rubicon.rest;

/**
 * code test sample Fabonacci lerning exercise on 3/15/2018
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleActuatorApplication implements HealthIndicator {

	@Override  
	public Health health() {
		return Health.up().withDetail("Restful Service", "Fibonacci").build();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleActuatorApplication.class, args);
	}

}
