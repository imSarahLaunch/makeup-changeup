package org.launchcode.makeupchangeup.data;

import org.launchcode.makeupchangeup.models.MakeupItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeupItemRepository extends CrudRepository<MakeupItem, Integer> {
}
