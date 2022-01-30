package com.olgapoduzdikova.testmanager.validator

import com.olgapoduzdikova.testmanager.repository.ExecutionStatusRepository
import com.olgapoduzdikova.testmanager.validation.ExecutionStatusValidator
import spock.lang.Specification
import spock.lang.Unroll

class ExecutionStatusValidatorSpec extends Specification {
  ExecutionStatusRepository dao = Mock()
  ExecutionStatusValidator validator = new ExecutionStatusValidator(dao)

  @Unroll
  def 'validate execution status. Status value: #status; result: #valid.'() {
    when: 'validate execution status'
    validator.isValid(status, null) == valid

    then: 'check status exists in DB'
    daoCallCounter * dao.existsById(status) >> valid

    where:
    status   | daoCallCounter | valid
    null     | 0              | true
    ''       | 1              | false
    'FAILED' | 1              | true
    'TEST'   | 1              | false
  }
}
