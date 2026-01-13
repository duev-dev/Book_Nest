package com.duevops.profile.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.duevops.profile.entity.UserProfiles;

@Repository
public interface UserProfileRepository extends Neo4jRepository<UserProfiles, String> {}
