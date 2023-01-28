package com.markcode.dev.jugtours.repository;

import com.markcode.dev.jugtours.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findByName(String name);
}
