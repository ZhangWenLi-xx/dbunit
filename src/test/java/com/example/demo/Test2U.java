package com.example.demo;


import com.example.demo.Entity.User;
import com.example.demo.service.StudentService;
import com.github.springtestdbunit.annotation.*;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.github.springtestdbunit.dataset.ReplacementDataSetLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
@DbUnitConfiguration(dataSetLoader = ReplacementDataSetLoader.class)
public class Test2U {


    @Autowired
    private StudentService studentService;

    @Test
    /*
    @DatabaseSetup:将特定xml文件中的数据同步到数据库
    @ExpectedDatabase ：数据验证
    @DatabaseTearDown： 清理数据
     */
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "com/example/demo/StudentTest/student.xml")
    @ExpectedDatabase( assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "com/example/demo/StudentTest/dataSource_result.xml")
    @DatabaseTearDown( type = DatabaseOperation.DELETE_ALL, value = "com/example/demo/StudentTest/student.xml")
    public void StudentTest() {

        User user = studentService.select(1);
        System.out.println("user: " + user);
   /*     Assert.assertEquals("张三", user.getName());*/
    }


    @Test
    @DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "com/example/demo/StudentTest/student.xml")
    @ExpectedDatabase( assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "com/example/demo/StudentTest/dataSource_result.xml")
    @DatabaseTearDown( type = DatabaseOperation.DELETE_ALL, value = "com/example/demo/StudentTest/student.xml")
    public void StudentTest1() {

        User user = studentService.select(1);
        System.out.println("user: " + user);
   /*     Assert.assertEquals("张三", user.getName());*/
    }








    /*@DatabaseSetup( type = DatabaseOperation.CLEAN_INSERT, value = "com/example/demo/StudentTest/student.xml")
    @ExpectedDatabase(assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "com/example/demo/StudentTest/studentDataSource.result.xml")
    @DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = "com/example/demo/StudentTest/student.xml")
    public void StudentTest1() {

        User user = studentService.selectSut(2);
        System.out.println("user: " + user);
        //Assert.assertEquals("张三", user.getName());
    }
*/

//    @Test
//    @DatabaseSetups({
//            @DatabaseSetup(connection = "datasource", type = DatabaseOperation.CLEAN_INSERT, value = "/com/example/demo/StudentTest/dataSource.xml"),
//            @DatabaseSetup(connection = "datasource2", type = DatabaseOperation.CLEAN_INSERT, value = "/com/example/demo/StudentTest/studentDataSource.xml")
//    })
//    @ExpectedDatabases({
//            @ExpectedDatabase(connection = "dataSource", override = false, assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "/com/example/demo/StudentTest/dataSource_result.xml"),
//            @ExpectedDatabase(connection = "datasource2", override = false, assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "/com/example/demo/StudentTest/studentDataSource.result.xml")})
//    @DatabaseTearDowns({
//            @DatabaseTearDown(connection = "dataSource", type = DatabaseOperation.DELETE_ALL, value = "/com/example/demo/StudentTest/dataSource_result.xml"),
//            @DatabaseTearDown(connection = "datasource2", type = DatabaseOperation.DELETE_ALL, value = "/com/example/demo/StudentTest/studentDataSource.result.xml")})
//    public void Test() {
//        User user = studentService.select(1);
//        System.out.println("user: " + user);
//        Assert.assertEquals("张三", user.getName());
//
//        User student = studentService.selectSut(1);
//        System.out.println("student: " + student);
//        Assert.assertEquals("张三", student.getName());
//    }

//    @Test
//    @DatabaseSetup(connection = "datasource2", type = DatabaseOperation.CLEAN_INSERT, value = "/com/example/demo/StudentTest/studentDataSource.xml")
//    @ExpectedDatabase(connection = "datasource2", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED, value = "/com/example/demo/StudentTest/studentDataSource.result.xml")
//    @DatabaseTearDown(connection = "datasource2", type = DatabaseOperation.DELETE_ALL, value = "/com/example/demo/StudentTest/studentDataSource.result.xml")
//    public void StudentTest3() {
//
//        User user = studentService.selectSut(1);
//        System.out.println("user: " + user);
//        Assert.assertEquals("张三", user.getName());
//    }
}
