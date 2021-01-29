package cn.metaq.neo4j.repository;

import cn.metaq.neo4j.relationship.SupplyRelationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRelationshipRepository extends Neo4jRepository<SupplyRelationship, Long> { }