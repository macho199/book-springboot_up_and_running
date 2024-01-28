package kr.co.jobkorea.planefinderapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import kr.co.jobkorea.planefinderapigateway.model.Aircraft;

@SpringBootApplication
public class PlaneFinderApiGatewayApplication {
	@Bean
	public RedisOperations<String, Aircraft> redisOperations(RedisConnectionFactory factory) {
		Jackson2JsonRedisSerializer<Aircraft> serializer = new Jackson2JsonRedisSerializer<>(Aircraft.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(PlaneFinderApiGatewayApplication.class, args);
	}

}
