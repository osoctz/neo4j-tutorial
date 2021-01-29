package cn.metaq.neo4j.repository;

import cn.metaq.neo4j.entity.CompanyGraph;
import cn.metaq.neo4j.entity.SupplyGraph;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyGraphRepository extends Neo4jRepository<CompanyGraph,Long> {}