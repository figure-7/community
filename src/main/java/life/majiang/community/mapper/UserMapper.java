package life.majiang.community.mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user（name,account_id,token,gmt_create,gmt_modified） values（#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified}）")
    public int insert(User user);
}
