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

    @Test
    public void selectAllEmpTest(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.selectAllEmp();
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
}
