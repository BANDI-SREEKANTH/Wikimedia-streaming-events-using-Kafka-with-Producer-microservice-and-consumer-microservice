package org.campusconnect.kafkaconsumer.repository;

import org.campusconnect.kafkaconsumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData,Long>
{

}
