package org.elsys.ip.rest.service;

import org.elsys.ip.rest.model.Test;
import org.elsys.ip.rest.repository.TestRepository;

import java.util.List;

public class TestService {

  private TestRepository testRepository = new TestRepository();

  public List<Test> getTestList() {
    return testRepository.getTestList();
  }

  public Test getTestById(Integer id) {
    return testRepository.getTestById(id);
  }

  public Test saveTest(Test test) {
    return testRepository.saveTest(test);
  }

  public Test updateTest(Test test) {
    return testRepository.updateTest(test);
  }

  public void deleteTest(Integer id) {
    testRepository.deleteTest(id);
  }
}
