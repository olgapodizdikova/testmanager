package com.olgapoduzdikova.testmanager

import com.olgapoduzdikova.testmanager.config.PostgresTestContainerInitializer
import groovy.json.JsonSlurper;
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(initializers = [PostgresTestContainerInitializer])
class TestManagerApplicationTests extends Specification {

  @LocalServerPort
  int port

  def "can start context and healthy"() {
    expect:
    new JsonSlurper().parse(new URL("http://localhost:$port/actuator/health")).status == 'UP'
  }

}
