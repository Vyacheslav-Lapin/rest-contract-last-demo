package ru.vlapin.demo.restcontractlastdemo.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.demo.restcontractlastdemo.model.Cat;

public interface CatDao extends JpaRepository<Cat, UUID> {
}
