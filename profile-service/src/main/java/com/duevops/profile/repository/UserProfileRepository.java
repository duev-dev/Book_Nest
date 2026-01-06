package com.duevops.profile.repository;

import com.duevops.profile.entity.UserProfiles;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends Neo4jRepository<UserProfiles,String> {


}
