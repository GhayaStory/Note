package com.nazhisoft.school.temp;

import com.xgn.nz.common.bean.PageBean;
import com.xgn.nz.common.bean.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacherEvaluate")
public class TeacherEvaluateController {

    private static Logger logger = LoggerFactory.getLogger(TeacherEvaluateController.class);

    @Autowired
    TeacherEvaluateService teacherEvaluateService;

    /**
     * 获取教师荣誉数据列表
     *
     * @param pageBean
     * @return
     */
    @RequestMapping("/getTeacherHonorList")
    public ReturnResult getTeacherHonorList(@RequestParam("teacherName") String teacherName,
                                            @RequestParam("honorName") String honorName,
                                            @RequestBody PageBean pageBean){
        return teacherEvaluateService.getTeacherHonorList(teacherName,honorName,pageBean);
    }

    /**
     * 自动补全教师姓名
     *
     * @param schoolID
     * @param name
     * @return
     */
    @RequestMapping("/autocompleteTeacherName")
    public List<Map<String, Object>> autocompleteTeacherName(@RequestParam String name, String schoolID) {
        List<Map<String, Object>> list = teacherEvaluateService.autocompleteTeacherName(name, schoolID);
        return list;
    }

    /**
     * 新增教师荣誉数据
     *
     * @param map
     * @return
     */
    @RequestMapping("/addTeacherHonor")
    public ReturnResult addTeacherHonor(@RequestBody HashMap<String,String> map){
        return teacherEvaluateService.addTeacherHonor(map);
    }

    /**
     * 修改教师荣誉数据
     *
     * @param map
     * @return
     */
    @RequestMapping("/updateTeacherHonor")
    public ReturnResult updateTeacherHonor(@RequestBody HashMap<String,String> map){
        return teacherEvaluateService.updateTeacherHonor(map);
    }

    /**
     * 删除教师荣誉数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteTeacherHonorById")
    public ReturnResult deleteTeacherHonorById(@RequestParam("id") String id){
        return teacherEvaluateService.deleteTeacherHonorById(id);
    }

/*=====================================================================================================*/

    /**
     * 获取教师技能大赛数据列表
     *
     * @param pageBean
     * @return
     */
    @RequestMapping("/getTeacherSkillsCompetitionList")
    public ReturnResult getTeacherSkillsCompetitionList(@RequestParam("teacherName") String teacherName,
                                                        @RequestParam("competitionName") String competitionName,
                                                        @RequestBody PageBean pageBean){
        return teacherEvaluateService.getTeacherSkillsCompetitionList(teacherName,competitionName,pageBean);
    }

    /**
     * 新增教师技能大赛数据
     *
     * @param map
     * @return
     */
    @RequestMapping("/addTeacherSkillsMatch")
    public ReturnResult addTeacherSkillsMatch(@RequestBody HashMap<String,String> map){
        return teacherEvaluateService.addTeacherSkillsMatch(map);
    }

    /**
     * 修改教师技能大赛数据
     *
     * @param map
     * @return
     */
    @RequestMapping("/updateTeacherSkillsMatch")
    public ReturnResult updateTeacherSkillsMatch(@RequestBody HashMap<String,String> map){
         return teacherEvaluateService.updateTeacherSkillsMatch(map);
    }

    /**
     * 删除教师技能大赛数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteTeacherSkillsMatchById")
    public ReturnResult deleteTeacherSkillsMatchById(@RequestParam("id") String id){
        return teacherEvaluateService.deleteTeacherSkillsMatchById(id);
    }


 /*=====================================================================================================*/

    /**
     * 查询本校年级列表
     *
     * @param schoolId
     * @return
     */
    @RequestMapping("/getGradeListBySchoolId")
    public ReturnResult getGradeListBySchoolId(@RequestParam("schoolId") String schoolId){
        return teacherEvaluateService.getGradeListBySchoolId(schoolId);
    }

    /**
     * 查询本校班级列表
     *
     * @param schoolId
     * @return
     */
    @RequestMapping("/getClassListByGradeId")
    public ReturnResult getClassListByGradeId(@RequestParam("schoolId") String schoolId,
                                              @RequestParam("gradeId") String gradeId){
        return teacherEvaluateService.getClassListByGradeId(schoolId,gradeId);
    }

    /**
     * 获取指导学生获奖情况数据
     *
     * @param pageBean
     * @return
     */
    @RequestMapping("/getStudentPrizeList")
    public ReturnResult getStudentPrizeList(@RequestParam("teacherName") String teacherName,
                                            @RequestParam("studentName") String studentName,
                                            @RequestParam("gradeId") String gradeId,
                                            @RequestParam("classId") String classId,
                                            @RequestBody PageBean pageBean){
        return teacherEvaluateService.getStudentPrizeList(teacherName,studentName,gradeId,classId,pageBean);
    }

    /**
     * 自动补全学生姓名
     *
     * @param name
     * @param schoolId
     * @return
     */
    @RequestMapping("/autocompleteStudentName")
    public List<Map<String, Object>> autocompleteStudentName(@RequestParam("name") String name,
                                                             @RequestParam("gradeId") String gradeId,
                                                             @RequestParam("classId") String classId,
                                                             @RequestParam("schoolId") String schoolId){

        List<Map<String, Object>> list = teacherEvaluateService.autocompleteStudentName(name,gradeId,classId,schoolId);
        return list;
    }

    /**
     * 新增学生获奖情况数据
     *
     * @param map
     * @return
     */
    @RequestMapping("/addTeacherStudentPrize")
    public ReturnResult addTeacherStudentPrize(@RequestBody HashMap<String,String> map){
        return teacherEvaluateService.addTeacherStudentPrize(map);
    }

    /**
     * 修改学生获奖情况数据
     *
     * @param map
     * @return
     */
    @RequestMapping("/updateTeacherStudentPrize")
    public ReturnResult updateTeacherStudentPrize(@RequestBody HashMap<String,String> map){
        return teacherEvaluateService.updateTeacherStudentPrize(map);
    }

    /**
     * 删除学生获奖情况数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteTeacherStudentPrizeById")
    public ReturnResult deleteTeacherStudentPrizeById(@RequestParam("id") String id){
        return teacherEvaluateService.deleteTeacherStudentPrizeById(id);
    }

/*=======================================================================================================*/

    /**
     * 获取教师发表论文情况数据列表
     *
     * @param pageBean
     * @return
     */
    @RequestMapping("/getTeacherPublishPaperList")
    public ReturnResult getTeacherPublishPaperList(@RequestParam("teacherName") String teacherName,
                                                   @RequestParam("paperTitle") String paperTitle,
                                                   @RequestParam("periodicalLevel") String periodicalLevel,
                                                   @RequestBody PageBean pageBean){

        return teacherEvaluateService.getTeacherPublishPaperList(teacherName,paperTitle,periodicalLevel,pageBean);
    }

    /**
     * 新增教师发表论文情况数据
     *
     * @param map
     * @return
     */
    @RequestMapping("/addTeacherPublishPaper")
    public ReturnResult addTeacherPublishPaper(@RequestBody HashMap<String,String> map){
        return teacherEvaluateService.addTeacherPublishPaper(map);
    }

    /**
     * 修改教师发表论文情况数据
     *
     * @param map
     * @return
     */
    @RequestMapping("/updateTeacherPaper")
    public ReturnResult updateTeacherPaper(@RequestBody HashMap<String,String> map){
        return teacherEvaluateService.updateTeacherPaper(map);
    }

    /**
     * 删除教师发表论文情况数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteTeacherPaperById")
    public ReturnResult deleteTeacherPaperById(@RequestParam("id") String id){
        return teacherEvaluateService.deleteTeacherPaperById(id);
    }



    /**
     * 查询教师列表
     *
     * @param schoolID
     * @return
     */
    @RequestMapping(value = "/queryTeacherList")
    public ReturnResult queryTeacherList(@RequestParam("schoolID") String schoolID){
        return teacherEvaluateService.queryTeacherList(schoolID);
    }

    /**
     * 查询学生列表
     *
     * @param schoolID
     * @return
     */
    @RequestMapping(value = "/queryStudentList")
    public ReturnResult queryStudentList(@RequestParam("schoolID") String schoolID,
                                         @RequestParam("gradeId") String gradeId,
                                         @RequestParam("classId") String classId){
        return teacherEvaluateService.queryStudentList(schoolID,gradeId,classId);
    }


}
