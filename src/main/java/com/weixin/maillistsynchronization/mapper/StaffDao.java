package com.weixin.maillistsynchronization.mapper;


import com.weixin.maillistsynchronization.Model.Staff;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffDao {

    /**
     * 新建一个员工
     */
    @Insert({
            "insert into staff (userid, name, ",
            "department, mobile, ",
            "gender, email, position)",
            "values (#{userid,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
            "#{department,jdbcType=INTEGER}, #{mobile,jdbcType=VARCHAR}, ",
            "#{gender,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{position,jdbcType=VARCHAR})"
    })
    int insert(Staff staff);

    /**
     * 查询所有员工
     */
    @Select({
            "select",
            "userid, name, department, mobile, gender, email, position",
            "from staff"
    })
    @Results({
            @Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "department", property = "department", jdbcType = JdbcType.INTEGER),
            @Result(column = "mobile", property = "mobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.VARCHAR),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "position", property = "position", jdbcType = JdbcType.VARCHAR)
    })
    List<Staff> queryAll();

    /**
     * 按userID查询
     */
    @Select({
            "select",
            "userid, name, department, mobile, gender, email, position",
            "from staff",
            "where userid = #{userid,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "department", property = "department", jdbcType = JdbcType.INTEGER),
            @Result(column = "mobile", property = "mobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.VARCHAR),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "position", property = "position", jdbcType = JdbcType.VARCHAR)
    })
    List<Staff> queryByUserId(@Param("userid") String userId);

    /**
     * 按名字查询
     */
    @Select({
            "select",
            "userid, name, department, mobile, gender, email, position",
            "from staff",
            "where name = #{name,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "department", property = "department", jdbcType = JdbcType.INTEGER),
            @Result(column = "mobile", property = "mobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.VARCHAR),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "position", property = "position", jdbcType = JdbcType.VARCHAR)
    })
    List<Staff> queryByName(@Param("name") String name);

    /**
     * 按部门ID查询
     */
    @Select({
            "select",
            "userid, name, department, mobile, gender, email, position",
            "from staff",
            "where name = #{name,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "department", property = "department", jdbcType = JdbcType.INTEGER),
            @Result(column = "mobile", property = "mobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.VARCHAR),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "position", property = "position", jdbcType = JdbcType.VARCHAR)
    })
    List<Staff> queryByDepartment(@Param("department") Integer department);

    /**
     * 按部门职务信息查询
     */
    @Select({
            "select",
            "userid, name, department, mobile, gender, email, position",
            "from staff",
            "where position = #{position,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "department", property = "department", jdbcType = JdbcType.INTEGER),
            @Result(column = "mobile", property = "mobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.VARCHAR),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "position", property = "position", jdbcType = JdbcType.VARCHAR)
    })
    List<Staff> queryByPosition(@Param("position") String position);

    /**
     * 根据userID删除该员工
     */
    @Delete({
            "delete from staff",
            "where userid = #{userid,jdbcType=VARCHAR}"
    })
    int deleteByUserId(@Param("userid") String userId);

    /**
     * 根据部门ID删除该部门的所有员工
     */
    @Delete({
            "delete from staff",
            "where department = #{department,jdbcType=INTEGER}"
    })
    int deleteByDepartment(@Param("department") Integer department);

    /**
     * 根据userId更新员工信息
     */
    @Update({
            "<script>",
            "update staff set",

            "<if test='name!=null'>",
            " name = #{name,jdbcType=VARCHAR},",
            "</if>",

            "<if test='name!=null and department!=null'>",
            ",",
            "</if>",

            "<if test='department!=null'>",
            " department = #{department,jdbcType=INTEGER},",
            "</if>",

            "<if test='department!=null and mobile!=null'>",
            ",",
            "</if>",

            "<if test='mobile!=null'>",
            " mobile = #{mobile,jdbcType=VARCHAR},",
            "</if>",

            "<if test='mobile!=null and gender!=null'>",
            ",",
            "</if>",

            "<if test='gender!=null'>",
            " gender = #{gender,jdbcType=VARCHAR},",
            "</if>",

            "<if test='gender!=null and email!=null'>",
            ",",
            "</if>",

            "<if test='email!=null'>",
            " email = #{email,jdbcType=VARCHAR},",
            "</if>",

            "<if test='email!=null and position!=null'>",
            ",",
            "</if>",

            "<if test='position!=null'>",
            " position = #{position,jdbcType=VARCHAR}",
            "</if>",

            " where userid = #{userid,jdbcType=VARCHAR}",
            "</script>"
    })
    int update(Staff staff);

}
