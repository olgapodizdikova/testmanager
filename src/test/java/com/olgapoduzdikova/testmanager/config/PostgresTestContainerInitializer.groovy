package com.olgapoduzdikova.testmanager.config

import org.springframework.beans.factory.DisposableBean
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.stereotype.Component
import org.testcontainers.containers.PostgreSQLContainer

@Component
class PostgresTestContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, DisposableBean {
  PostgreSQLContainer container = createContainer()

  private static PostgreSQLContainer createContainer() {
    return new PostgreSQLContainer('postgres:10.14')
            .withDatabaseName('test')
  }

  @Override
  void initialize(ConfigurableApplicationContext applicationContext) {
    container.start()
    TestPropertyValues.of(
            "spring.datasource.url=$container.jdbcUrl",
            "spring.datasource.username=$container.username",
            "spring.datasource.password=$container.password",
    ).applyTo(applicationContext)
  }

  @Override
  void destroy() throws Exception {
    container.stop()
  }
}
