package org.example;

import com.example.SpringMybatisDemo;
import com.example.dao.MenuDOMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//在进行单元测试时，确保在测试类上使用@RunWith(SpringRunner.class)注解或@ExtendWith(SpringExtension.class)注解来启用Spring的测试支持。另外，使用@SpringBootTest注解时，指定的classes属性应该是你的应用程序的主类，而不是测试类本身。
@SpringBootTest(classes = SpringMybatisDemo.class)
public class MapperTest {
    @Autowired
    MenuDOMapper menuDOMapper;
    // 报错怎么处理，我服了  test 环境的配置文件会覆盖 生产 src 文件下的配置，所以会报错
    @Test
    public void testMenuMapper(){
        System.out.println(menuDOMapper.selectByPrimaryKey(1L));
    }
}
