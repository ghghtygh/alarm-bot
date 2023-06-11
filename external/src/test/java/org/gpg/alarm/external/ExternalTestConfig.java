package org.gpg.alarm.external;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.ContextConfiguration;

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableFeignClients
@ContextConfiguration(locations = {"classpath:external.yml"})
public class ExternalTestConfig {

}
