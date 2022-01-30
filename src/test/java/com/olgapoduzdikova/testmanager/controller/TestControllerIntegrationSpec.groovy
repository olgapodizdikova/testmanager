package com.olgapoduzdikova.testmanager.controller

import com.olgapoduzdikova.testmanager.config.PostgresTestContainerInitializer
import com.olgapoduzdikova.testmanager.model.TestDTO
import com.olgapoduzdikova.testmanager.repository.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = [PostgresTestContainerInitializer])
class TestControllerIntegrationSpec extends Specification {

  @LocalServerPort
  int port

  @Autowired
  TestRestTemplate restTemplate

  @Autowired
  TestRepository dao

  String getUrl() {
    return "http://localhost:$port/tests"
  }

  def 'Should fetch all tests'() {
    HttpHeaders headers = new HttpHeaders()
    headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    when: 'create new test entity'

    List<TestDTO> response = restTemplate.getForObject(getUrl(), List)

    then:
    response.size() == 3
    response[0].name == 'My test 1'
    response[1].name == 'My test 2'
    response[2].name == 'My test 3'
  }
}
