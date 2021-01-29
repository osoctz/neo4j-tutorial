package cn.metaq.neo4j.service;

import cn.metaq.neo4j.entity.CompanyGraph;
import cn.metaq.neo4j.entity.SupplyGraph;
import cn.metaq.neo4j.relationship.SupplyRelationship;
import cn.metaq.neo4j.repository.CompanyGraphRepository;
import cn.metaq.neo4j.repository.SupplyGraphRepository;
import cn.metaq.neo4j.repository.SupplyRelationshipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// 获取启动类，加载配置，确定装载 Spring 程序的装载方法，它回去寻找 主配置启动类（被 @SpringBootApplication 注解的）
@SpringBootTest
// 让 JUnit 运行 Spring 的测试环境， 获得 Spring 环境的上下文的支持
@RunWith(SpringRunner.class)
public class GraphServiceTest {

    @Autowired
    private CompanyGraphRepository companyGraphRepository;
    @Autowired
    private SupplyGraphRepository supplyGraphRepository;
    @Autowired
    private SupplyRelationshipRepository supplyRelationshipRepository;

    @Test
    public void test(){

        //采购占比
        String scale = "45.14%";
        // 采购金额
        String amount ="23543.42";
        //供应商名称
        String name = "五八农业";
        //公司
        String company_name="huawei";

        CompanyGraph companyGraph=CompanyGraph.builder().fullName(company_name).build();
        companyGraphRepository.save(companyGraph);

        SupplyGraph supplyGraph=SupplyGraph.builder().name(name).build();
        supplyGraphRepository.save(supplyGraph);

        String indexName = companyGraph.getFullName() + "-" + supplyGraph.getName();
        //供应商关系
        SupplyRelationship supplyRelationship =
                SupplyRelationship.builder().company(companyGraph).supply(supplyGraph).amount(amount).scale(scale).indexName(indexName).build();
        //添加供应关系
        supplyRelationshipRepository.save(supplyRelationship);
    }
}
