package com.zzg.day03.dao;

import com.zzg.day03.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @Author: zzg
 * @Description: TODO
 * @DateTime: 2021/11/27 9:58
 */
public interface StudentDAO {
    /**
     * 查询学生
     *
     * @return 所有学生数据
     */
    List<Map<String, Object>> inquireStu();

    /**
     * 根据传入的学生id删除学生数据
     *
     * @param id 传入学生id
     * @return 是否删除成功
     */
    int deleteStu(String id);

    /**
     * 传入学生数据，添加到数据库
     *
     * @param stu 学生信息
     * @return 是否成功
     */
    int addStu(Student stu);

    /**
     * 根据要修改的学生id获取他的数据
     *
     * @param id 要修改的学生id
     * @return 要修改的学生数据
     */
    List<Map<String, Object>> getStu(String id);

    /**
     * 根据学生数据对学生信息进行修改
     *
     * @param stu 学生数据
     * @return 是否修改成功
     */
    int updateStu(Student stu);
}
