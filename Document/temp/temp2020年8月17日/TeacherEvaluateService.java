package com.nazhisoft.school.temp;


import com.xgn.nz.common.bean.PageBean;
import com.xgn.nz.common.bean.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherEvaluateService {

    @Autowired
    TeacherEvaluateDao teacherEvaluateDao;

    @Value("${fdfs.customeParam.url}")
    private String fdfsVisitUrl;

    /**
     * 获取教师荣誉数据列表
     *
     * @param pageBean
     * @return
     */
    public ReturnResult getTeacherHonorList(String teacherName,
                                            String honorName,
                                            PageBean pageBean){
        return teacherEvaluateDao.getTeacherHonorList(teacherName,honorName,pageBean);
    }

    /**
     * 自动补全教师姓名
     *
     * @param name
     * @param schoolID
     * @return
     */
    public List<Map<String, Object>> autocompleteTeacherName(String name, String schoolID) {
        List<Map<String, Object>> list = teacherEvaluateDao.autocompleteTeacherName(name, schoolID);
        return list;
    }


    /**
     * 新增教师荣誉数据
     */
    public ReturnResult addTeacherHonor(HashMap<String,String> map){
        ReturnResult result = new ReturnResult();
        ReturnResult queryResult = teacherEvaluateDao.queryTeacherHonor(map);
        if (queryResult.getDataList().size() > 0){
            result.setCode(-1);
            result.setMsg("此信息已存在，请更换一条");
        }else {
            ReturnResult insertResult = teacherEvaluateDao.addTeacherHonor(map);
            if (insertResult.getCode() > 0){
                result.setCode(1);
                result.setMsg("新增成功");
            }else {
                result.setCode(-2);
                result.setMsg("新增失败");
            }
        }

        return result;
    }

    /**
     * 修改教师荣誉数据
     */
    public ReturnResult updateTeacherHonor(HashMap<String,String> map){
        ReturnResult result = new ReturnResult();

        ReturnResult returnResult = teacherEvaluateDao.updateTeacherHonor(map);
        if (returnResult.getCode() > 0){
            result.setCode(1);
            result.setMsg("修改成功");
        }else {
            result.setCode(-1);
            result.setMsg("修改失败");
        }
        return result;
    }

    /**
     * 删除教师荣誉数据
     */
    public ReturnResult deleteTeacherHonorById(String id){
        ReturnResult result = new ReturnResult();

        ReturnResult returnResult = teacherEvaluateDao.deleteTeacherHonorById(id);
        if (returnResult.getCode() > 0){
            result.setCode(1);
            result.setMsg("删除成功");
        }else {
            result.setCode(-1);
            result.setMsg("删除失败");
        }
        return result;
    }

  /*=========================================================================================================*/

    /**
     * 获取教师技能大赛数据列表
     *
     * @param pageBean
     * @return
     */
    public ReturnResult getTeacherSkillsCompetitionList(String teacherName,
                                                        String competitionName,
                                                        PageBean pageBean){
        return teacherEvaluateDao.getTeacherSkillsCompetitionList(teacherName,competitionName,pageBean);
    }

    /**
     * 新增教师技能大赛数据
     */
    public ReturnResult addTeacherSkillsMatch(HashMap<String,String> map){
        ReturnResult result = new ReturnResult();
        ReturnResult queryResult = teacherEvaluateDao.queryTeacherSkillsMatch(map);
        if (queryResult.getDataList().size() > 0){
            result.setCode(-1);
            result.setMsg("此信息已存在，请换一条");
        }else {
            ReturnResult insertResult = teacherEvaluateDao.addTeacherSkillsMatch(map);
            if (insertResult.getCode() > 0){
                result.setCode(1);
                result.setMsg("新增成功");
            }else {
                result.setCode(-2);
                result.setMsg("新增失败");
            }
        }

        return result;
    }

    /**
     * 修改教师技能大赛数据
     */
    public ReturnResult updateTeacherSkillsMatch(HashMap<String,String> map){
        ReturnResult result = new ReturnResult();

        ReturnResult returnResult = teacherEvaluateDao.updateTeacherSkillsMatch(map);
        if (returnResult.getCode() > 0){
            result.setCode(1);
            result.setMsg("修改成功");
        }else {
            result.setCode(-1);
            result.setMsg("修改失败");
        }
        return result;
    }

    /**
     * 删除教师技能大赛数据
     */
    public ReturnResult deleteTeacherSkillsMatchById(String id){
        ReturnResult result = new ReturnResult();

        ReturnResult returnResult = teacherEvaluateDao.deleteTeacherSkillsMatchById(id);
        if (returnResult.getCode() > 0){
            result.setCode(1);
            result.setMsg("删除成功");
        }else {
            result.setCode(-1);
            result.setMsg("删除失败");
        }
        return result;
    }

 /*========================================================================================================*/


    /**
     * 获取年级列表
     */
    public ReturnResult getGradeListBySchoolId(String schoolId){

        return teacherEvaluateDao.getGradeListBySchoolId(schoolId);
    }

    /**
     * 获取班级列表
     */
    public ReturnResult getClassListByGradeId(String schoolId,String gradeId){

        return teacherEvaluateDao.getClassListByGradeId(schoolId,gradeId);
    }

    /**
     * 获取指导学生获奖情况数据
     *
     * @param pageBean
     * @return
     */
    public ReturnResult getStudentPrizeList(String teacherName,
                                            String studentName,
                                            String gradeId,
                                            String classId,
                                            PageBean pageBean){
        return teacherEvaluateDao.getStudentPrizeList(teacherName,studentName,gradeId,classId,pageBean);
    }

    /**
     * 自动补全学生姓名
     *
     * @param name
     * @param schoolId
     * @return
     */
    public List<Map<String, Object>> autocompleteStudentName(String name,String gradeId,
                                                             String classId,String schoolId) {
        List<Map<String, Object>> list = teacherEvaluateDao.autocompleteStudentName(name,gradeId,classId,schoolId);
        return list;
    }

    /**
     * 新增学生获奖情况数据
     */
    public ReturnResult addTeacherStudentPrize(HashMap<String,String> map){
        ReturnResult result = new ReturnResult();
        ReturnResult queryResult = teacherEvaluateDao.queryTeacherStudentPrize(map);
        if (queryResult.getDataList().size() > 0){
            result.setCode(-1);
            result.setMsg("此信息已存在，请换一条");
        }else {
            ReturnResult insertResult = teacherEvaluateDao.addTeacherStudentPrize(map);
            if (insertResult.getCode() > 0){
                result.setCode(1);
                result.setMsg("新增成功");
            }else {
                result.setCode(-2);
                result.setMsg("新增失败");
            }
        }

        return result;
    }

    /**
     * 修改学生获奖情况数据
     */
    public ReturnResult updateTeacherStudentPrize(HashMap<String,String> map){
        ReturnResult result = new ReturnResult();

        ReturnResult returnResult = teacherEvaluateDao.updateTeacherStudentPrize(map);
        if (returnResult.getCode() > 0){
            result.setCode(1);
            result.setMsg("修改成功");
        }else {
            result.setCode(-1);
            result.setMsg("修改失败");
        }
        return result;
    }

    /**
     * 删除学生获奖情况数据
     */
    public ReturnResult deleteTeacherStudentPrizeById(String id){
        ReturnResult result = new ReturnResult();

        ReturnResult returnResult = teacherEvaluateDao.deleteTeacherStudentPrizeById(id);
        if (returnResult.getCode() > 0){
            result.setCode(1);
            result.setMsg("删除成功");
        }else {
            result.setCode(-1);
            result.setMsg("删除失败");
        }
        return result;
    }

/*==========================================================================================================*/

    /**
     * 获取教师发表论文情况数据列表
     *
     * @param pageBean
     * @return
     */
    public ReturnResult getTeacherPublishPaperList(String teacherName,
                                                   String paperTitle,
                                                   String periodicalLevel,
                                                   PageBean pageBean){
        ReturnResult result = teacherEvaluateDao.getTeacherPublishPaperList(teacherName, paperTitle, periodicalLevel, pageBean);
        HashMap<String, Object> map = new HashMap<>();
        map.put("httpTitle",fdfsVisitUrl);
        result.setDataMap(map);
        return result;
    }

    /**
     * 新增教师发表论文情况数据
     */
    public ReturnResult addTeacherPublishPaper(HashMap<String,String> map){
        ReturnResult result = new ReturnResult();
        ReturnResult queryResult = teacherEvaluateDao.queryTeacherPublishPaper(map);
        if (queryResult.getDataList().size() > 0){
            result.setCode(-1);
            result.setMsg("此信息已存在，请换一条");
        }else {
            ReturnResult insertResult = teacherEvaluateDao.addTeacherPublishPaper(map);
            if (insertResult.getCode() > 0){
                result.setCode(1);
                result.setMsg("新增成功");
            }else {
                result.setCode(-2);
                result.setMsg("新增失败");
            }
        }

        return result;
    }

    /**
     * 修改教师发表论文情况数据
     */
    public ReturnResult updateTeacherPaper(HashMap<String,String> map){
        ReturnResult result = new ReturnResult();

        ReturnResult returnResult = teacherEvaluateDao.updateTeacherPaper(map);
        if (returnResult.getCode() > 0){
            result.setCode(1);
            result.setMsg("修改成功");
        }else {
            result.setCode(-1);
            result.setMsg("修改失败");
        }
        return result;
    }

    /**
     * 删除教师发表论文情况数据
     */
    public ReturnResult deleteTeacherPaperById(String id){
        ReturnResult result = new ReturnResult();

        ReturnResult returnResult = teacherEvaluateDao.deleteTeacherPaperById(id);
        if (returnResult.getCode() > 0){
            result.setCode(1);
            result.setMsg("删除成功");
        }else {
            result.setCode(-1);
            result.setMsg("删除失败");
        }
        return result;
    }



    /**
     * 查询教师列表
     * @param schoolID
     * @return
     */
    public ReturnResult queryTeacherList(String schoolID) {
        ReturnResult result = new ReturnResult();
        ReturnResult validateResult = teacherEvaluateDao.queryTeacherList(schoolID);
        if (validateResult.getCode() > 0){
            result.setCode(1);
            result.setDataList(validateResult.getDataList());
        }else {
            result.setCode(-1);
            result.setMsg("未查询到数据");
        }
        return result;

    }

    /**
     * 查询学生列表
     * @param schoolID
     * @return
     */
    public ReturnResult queryStudentList(String schoolID,String gradeId,String classId) {
        ReturnResult result = new ReturnResult();
        ReturnResult validateResult = teacherEvaluateDao.queryStudentList(schoolID,gradeId,classId);
        if (validateResult.getCode() > 0){
            result.setCode(1);
            result.setDataList(validateResult.getDataList());
        }else {
            result.setCode(-1);
            result.setMsg("未查询到数据");
        }
        return result;

    }


}
