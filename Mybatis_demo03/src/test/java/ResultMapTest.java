import com.whz.mybatis.mapper.EmpMapper;
import com.whz.mybatis.pojo.Emp;
import com.whz.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author weihongzhi on 2022/3/16.
 */
public class ResultMapTest {

    /**
     * 解决字段名和属性名不一致的情况：
     * a>为字段起别名，保持和属性名一致
     * b>设置全局配置，将下划线自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * c>通过resultMap设置自定义的映射关系
     * <resultMap id="empResultMap" type="Emp">
     *     <id property="eid" column="eid"/>
     *     <result property="empName" column="emp_name"/>
     *     <result property="age" column="age"/>
     *     <result property="sex" column="sex"/>
     *     <result property="email" column="email"/>
     * </resultMap>
     *
     *
     *
     */
    @Test
    public void selectAllEmpTest() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.selectAllEmp();
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 处理多对一的映射关系方式
     * a>级联属性赋值
     */
    @Test
    public void selectEmpAndDept() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectEmpAndDept(1);
        System.out.println(emp);
    }

    @Test
    public void selectEmpAndDeptByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectEmpAndDeptByStepOne(3);
        System.out.println(emp);
    }

}
