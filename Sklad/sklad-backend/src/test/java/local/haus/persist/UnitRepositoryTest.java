package local.haus.persist;

import static local.haus.prototype.UnitsPrototype.aUnit;
import static org.assertj.core.api.Assertions.assertThat;

import local.haus.dao.UnitRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitRepositoryTest {

  @Autowired
  private UnitRepository repository;

  @Test
  void findByName() {
    repository.save(aUnit());
    Unit foundUnit = repository.findByName(aUnit().getName());
    assertThat(foundUnit).isNotNull();
    assertThat(foundUnit.getName()).isEqualTo(aUnit().getName());
  }
}