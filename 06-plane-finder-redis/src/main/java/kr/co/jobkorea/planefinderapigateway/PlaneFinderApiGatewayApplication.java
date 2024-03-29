package kr.co.jobkorea.planefinderapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import kr.co.jobkorea.planefinderapigateway.model.Aircraft;

@SpringBootApplication
public class PlaneFinderApiGatewayApplication {
	@Bean
	public RedisOperations<String, Aircraft> redisOperations(RedisConnectionFactory factory) {
		Jackson2JsonRedisSerializer<Aircraft> serializer = new Jackson2JsonRedisSerializer<>(Aircraft.class);
		RedisTemplate<String, Aircraft> template = new RedisTemplate<>();
		template.setConnectionFactory(factory);
		template.setDefaultSerializer(serializer);
		template.setKeySerializer(new StringRedisSerializer());

		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(PlaneFinderApiGatewayApplication.class, args);
	}

}
