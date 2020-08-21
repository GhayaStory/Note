package com.nazhisoft.school.temp;


import com.xgn.nz.base.lite.dao.DaoUtils;
import com.xgn.nz.common.bean.PageBean;
import com.xgn.nz.common.bean.ReturnResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TeacherEvaluateDao {

    class DaoUtils{
        DaoUtils(JdbcTemplate abc){}
    }
    private static Logger logger = LoggerFactory.getLogger(TeacherEvaluateDao.class);

    @Autowired
    @Qualifier("schoolJdbcTemplate")
    private JdbcTemplate schoolJdbcTemplate;

    @Autowired
    @Qualifier("personJdbcTemplate")
    private JdbcTemplate personJdbcTemplate;


    @Value("${sql.teacherEvaluate.teacherHonor.getTeacherHonor}")
    private String getTeacherHonor;
    /**
     * 查询教师荣誉数据列表
     *
     * @param pageBean
     * @return
     */
    public ReturnResult getTeacherHonorList(String teacherName, String honorName,PageBean pageBean) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);
        String strSql = getTeacherHonor;

        ReturnResult result = new ReturnResult();

        ArrayList paramsList = new ArrayList();

        if (teacherName != null && !teacherName.equals("") && honorName != null && !honorName.equals("")) {
            strSql += " where teacher_name like ? and honor_name like ? ";
            paramsList.add("%" + teacherName + "%");
            paramsList.add("%" + honorName + "%");

        }else if (teacherName != null && !teacherName.equals("")){
            strSql += " where teacher_name like ? ";
            paramsList.add("%" + teacherName + "%");
        }else if (honorName != null && !honorName.equals("")){
            strSql += " where honor_name like ? ";
            paramsList.add("%" + honorName + "%");
        }else {

        }
        logger.debug("-------baseDao-getTeacherHonor start--------");
        logger.debug("SQL:" + strSql);
        logger.debug("---------baseDao-getTeacherHonor end-----------");

        if (paramsList.size() > 0){
            Object[] paramas = paramsList.toArray();
            result = baseDao.queryForListByPageBean(strSql,paramas,pageBean);
        }else {
            result = baseDao.queryForListByPageBean(strSql,pageBean);
        }


        return result;
    }



    @Value("${sql.teacherEvaluate.teacherHonor.autocompleteTeacherName}")
    private String autocompleteTeacherName;
    /**
     * 自动补全教师姓名
     *
     * @param name
     * @param schoolID
     * @return
     */
    public List<Map<String, Object>> autocompleteTeacherName(String name, String schoolID) {
        DaoUtils baseDao = new DaoUtils(personJdbcTemplate);

        String sql = autocompleteTeacherName;
        ArrayList paramsList = new ArrayList();
        //状态为1的数据
        paramsList.add("1");
        paramsList.add(schoolID);
        if (!StringUtils.isEmpty(name)) {
            sql += " and ( realName like ? or pinyin like ? or initials like ? )";
            paramsList.add("%" + name + "%");
            paramsList.add("%" + name + "%");
            paramsList.add("%" + name + "%");
        }
        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.queryForList(sql, paramas);

        return dataResult.getDataList();
    }


    @Value("${sql.teacherEvaluate.teacherHonor.queryTeacherHonor}")
    private String queryTeacherHonor;
    /**
     * 根据条件查询教师荣誉数据
     * @param map
     * @return
     */
    public ReturnResult queryTeacherHonor(HashMap<String,String> map) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = queryTeacherHonor;
        ArrayList paramsList = new ArrayList();

        paramsList.add(map.get("teacherId"));
        paramsList.add(map.get("teacherName"));
        paramsList.add(map.get("honorName"));
        paramsList.add(map.get("honorLevel"));
        paramsList.add(map.get("selectionUnit"));
        paramsList.add(map.get("certAddress"));
        paramsList.add(map.get("getTime"));
        paramsList.add(map.get("schoolId"));

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.queryForList(sql, paramas);

        return dataResult;
    }

    @Value("${sql.teacherEvaluate.teacherHonor.addTeacherHonor}")
    private String addTeacherHonor;
    /**
     * 新增教师荣誉数据
     *
     * @param map
     * @return
     */
    public ReturnResult addTeacherHonor(HashMap<String,String> map) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = addTeacherHonor;
        ArrayList paramsList = new ArrayList();

        paramsList.add(map.get("teacherId"));
        paramsList.add(map.get("teacherName"));
        paramsList.add(map.get("honorName"));
        paramsList.add(map.get("honorLevel"));
        paramsList.add(map.get("selectionUnit"));
        paramsList.add(map.get("certAddress"));
        paramsList.add(map.get("getTime"));
        paramsList.add(map.get("schoolId"));

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.insert(sql, paramas);

        return dataResult;
    }

    @Value("${sql.teacherEvaluate.teacherHonor.updateTeacherHonor}")
    private String updateTeacherHonor;
    /**
     * 修改教师荣誉数据
     *
     * @param map
     * @return
     */
    public ReturnResult updateTeacherHonor(HashMap<String,String> map) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = updateTeacherHonor;
        ArrayList paramsList = new ArrayList();

        paramsList.add(map.get("teacherId"));
        paramsList.add(map.get("teacherName"));
        paramsList.add(map.get("honorName"));
        paramsList.add(map.get("honorLevel"));
        paramsList.add(map.get("selectionUnit"));
        paramsList.add(map.get("certAddress"));
        paramsList.add(map.get("getTime"));
        paramsList.add(map.get("schoolId"));
        paramsList.add(map.get("dataId"));

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.update(sql, paramas);

        return dataResult;
    }

    @Value("${sql.teacherEvaluate.teacherHonor.deleteTeacherHonorById}")
    private String deleteTeacherHonorById;
    /**
     * 删除教师荣誉数据
     *
     * @param id
     * @return
     */
    public ReturnResult deleteTeacherHonorById(String id) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = deleteTeacherHonorById;
        ArrayList paramsList = new ArrayList();

        paramsList.add(id);

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.update(sql, paramas);

        return dataResult;
    }

 /*=================================================================================================*/

    @Value("${sql.teacherEvaluate.teacherSkillsCompetition.getTeacherSkillsCompetition}")
    private String getTeacherSkillsCompetition;
    /**
     * 查询教师技能大赛数据列表
     *
     * @param pageBean
     * @return
     */
    public ReturnResult getTeacherSkillsCompetitionList(String teacherName, String competitionName,PageBean pageBean) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);
        String strSql = getTeacherSkillsCompetition;

        ReturnResult result = new ReturnResult();

        ArrayList paramsList = new ArrayList();

        if (teacherName != null && !teacherName.equals("") && competitionName != null && !competitionName.equals("")) {
            strSql += " where teacher_name like ? and match_name like ? ";
            paramsList.add("%" + teacherName + "%");
            paramsList.add("%" + competitionName + "%");

        }else if (teacherName != null && !teacherName.equals("")){
            strSql += " where teacher_name like ? ";
            paramsList.add("%" + teacherName + "%");
        }else if (competitionName != null && !competitionName.equals("")){
            strSql += " where match_name like ? ";
            paramsList.add("%" + competitionName + "%");
        }else {

        }
        logger.debug("-------baseDao-getTeacherSkillsCompetition start--------");
        logger.debug("SQL:" + strSql);
        logger.debug("---------baseDao-getTeacherSkillsCompetition end-----------");

        if (paramsList.size() > 0){
            Object[] paramas = paramsList.toArray();
            result = baseDao.queryForListByPageBean(strSql,paramas,pageBean);
        }else {
            result = baseDao.queryForListByPageBean(strSql,pageBean);
        }


        return result;
    }


    @Value("${sql.teacherEvaluate.teacherSkillsCompetition.getTeacherSkillsMatch}")
    private String queryTeacherSkillsMatch;
    /**
     * 根据条件查询教师技能大赛数据
     * @param map
     * @return
     */
    public ReturnResult queryTeacherSkillsMatch(HashMap<String,String> map) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = queryTeacherSkillsMatch;
        ArrayList paramsList = new ArrayList();

        paramsList.add(map.get("teacherId"));
        paramsList.add(map.get("teacherName"));
        paramsList.add(map.get("matchName"));
        paramsList.add(map.get("prize"));
        paramsList.add(map.get("matchLevel"));
        paramsList.add(map.get("selectionUnit"));
        paramsList.add(map.get("prizeAddress"));
        paramsList.add(map.get("getTime"));
        paramsList.add(map.get("schoolId"));

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.queryForList(sql, paramas);

        return dataResult;
    }


    @Value("${sql.teacherEvaluate.teacherSkillsCompetition.addTeacherSkillsMatch}")
    private String addTeacherSkillsMatch;
    /**
     * 新增教师技能大赛数据
     *
     * @param map
     * @return
     */
    public ReturnResult addTeacherSkillsMatch(HashMap<String,String> map) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = addTeacherSkillsMatch;
        ArrayList paramsList = new ArrayList();

        paramsList.add(map.get("teacherId"));
        paramsList.add(map.get("teacherName"));
        paramsList.add(map.get("matchName"));
        paramsList.add(map.get("prize"));
        paramsList.add(map.get("matchLevel"));
        paramsList.add(map.get("selectionUnit"));
        paramsList.add(map.get("prizeAddress"));
        paramsList.add(map.get("getTime"));
        paramsList.add(map.get("schoolId"));

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.insert(sql, paramas);

        return dataResult;
    }


    @Value("${sql.teacherEvaluate.teacherSkillsCompetition.updateTeacherSkillsMatch}")
    private String updateTeacherSkillsMatch;
    /**
     * 修改教师技能大赛数据
     *
     * @param map
     * @return
     */
    public ReturnResult updateTeacherSkillsMatch(HashMap<String,String> map) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = updateTeacherSkillsMatch;
        ArrayList paramsList = new ArrayList();

        paramsList.add(map.get("teacherId"));
        paramsList.add(map.get("teacherName"));
        paramsList.add(map.get("matchName"));
        paramsList.add(map.get("prize"));
        paramsList.add(map.get("matchLevel"));
        paramsList.add(map.get("selectionUnit"));
        paramsList.add(map.get("prizeAddress"));
        paramsList.add(map.get("getTime"));
        paramsList.add(map.get("schoolId"));
        paramsList.add(map.get("dataId"));

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.update(sql, paramas);

        return dataResult;
    }


    @Value("${sql.teacherEvaluate.teacherSkillsCompetition.deleteTeacherSkillsMatchById}")
    private String deleteTeacherSkillsMatchById;
    /**
     * 删除教师荣誉数据
     *
     * @param id
     * @return
     */
    public ReturnResult deleteTeacherSkillsMatchById(String id) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = deleteTeacherSkillsMatchById;
        ArrayList paramsList = new ArrayList();

        paramsList.add(id);

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.update(sql, paramas);

        return dataResult;
    }

/*=====================================================================================================*/

    @Value("${sql.teacherEvaluate.teacherStudentPrize.getGradeListBySchoolId}")
    private String getGradeListBySchoolId;
    /**
     * 查询学校年级列表
     *
     * @param id
     * @return
     */
    public ReturnResult getGradeListBySchoolId(String id) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = getGradeListBySchoolId;
        ArrayList paramsList = new ArrayList();

        paramsList.add(id);

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.queryForList(sql, paramas);

        return dataResult;
    }

    @Value("${sql.teacherEvaluate.teacherStudentPrize.getClassListByGradeId}")
    private String getClassListByGradeId;
    /**
     * 查询学校班级列表
     *
     * @param schoolId
     * @return
     */
    public ReturnResult getClassListByGradeId(String schoolId,String gradeId) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = getClassListByGradeId;
        ArrayList paramsList = new ArrayList();

        paramsList.add(schoolId);
        paramsList.add(gradeId);

        logger.debug("-------baseDao-getClassListByGradeId start--------");
        logger.debug("SQL:" + sql);
        logger.debug("schoolId:" + schoolId +"--"+gradeId);
        logger.debug("---------baseDao-getClassListByGradeId end-----------");

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.queryForList(sql, paramas);

        return dataResult;
    }


    @Value("${sql.teacherEvaluate.teacherStudentPrize.getStudentPrizeList}")
    private String getStudentPrizeList;
    /**
     * 查询教师技能大赛数据列表
     *
     * @param pageBean
     * @return
     */
    public ReturnResult getStudentPrizeList(String teacherName, String studentName,
                                            String gradeId, String classId, PageBean pageBean) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);
        String strSql = getStudentPrizeList;

        ReturnResult result = new ReturnResult();

        ArrayList paramsList = new ArrayList();

        if (teacherName != null && !teacherName.equals("")){
            strSql += " and teacher_name like ? ";
            paramsList.add("%"+teacherName+"%");
        }
        if (studentName != null && !studentName.equals("")){
            strSql += " and student_name like ? ";
            paramsList.add("%"+studentName+"%");
        }
        if (gradeId != null && !gradeId.equals("") && !gradeId.equals("null") && !gradeId.equals("-1")){
            strSql += " and grade_id = ? ";
            paramsList.add(gradeId);
        }
        if (classId != null && !classId.equals("") && !classId.equals("null") && !classId.equals("-1")){
            strSql += " and class_id = ? ";
            paramsList.add(classId);
        }

        logger.debug("-------baseDao-getStudentPrizeList start--------");
        logger.debug("SQL:" + strSql);
        logger.debug("---------baseDao-getStudentPrizeList end-----------");

        if (paramsList.size() > 0){
            Object[] paramas = paramsList.toArray();
            result = baseDao.queryForListByPageBean(strSql,paramas,pageBean);
        }else {
            result = baseDao.queryForListByPageBean(strSql,pageBean);
        }

        return result;
    }


    @Value("${sql.teacherEvaluate.teacherStudentPrize.autocompleteStudentName}")
    private String autocompleteStudentName;
    /**
     * 自动补全学生姓名
     *
     * @param name
     * @param schoolId
     * @return
     */
    public List<Map<String, Object>> autocompleteStudentName(String name,String gradeId,
                                                             String classId, String schoolId) {
        DaoUtils baseDao = new DaoUtils(personJdbcTemplate);

        String sql = autocompleteStudentName;
        ArrayList paramsList = new ArrayList();
        //状态为1的数据
        paramsList.add("1");
        paramsList.add(schoolId);
        if (!StringUtils.isEmpty(name)) {
            sql += " and ( userName like ? or pinyin like ? or initials like ? ) ";
            paramsList.add("%" + name + "%");
            paramsList.add("%" + name + "%");
            paramsList.add("%" + name + "%");
        }
        if (!StringUtils.isEmpty(gradeId)) {
            sql += " and gradeId = ? ";
            paramsList.add(gradeId);
        }
        if (!StringUtils.isEmpty(classId)) {
            sql += " and classID = ? ";
            paramsList.add(classId);
        }

        logger.debug("-------baseDao-autocompleteStudentName start--------");
        logger.debug("SQL:" + sql);
        logger.debug("---------baseDao-autocompleteStudentName end-----------");

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.queryForList(sql, paramas);

        return dataResult.getDataList();
    }


    @Value("${sql.teacherEvaluate.teacherStudentPrize.queryTeacherStudentPrize}")
    private String queryTeacherStudentPrize;
    /**
     * 根据条件查询学生获奖情况数据
     * @param map
     * @return
     */
    public ReturnResult queryTeacherStudentPrize(HashMap<String,String> map) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = queryTeacherStudentPrize;
        ArrayList paramsList = new ArrayList();

        paramsList.add(map.get("teacherId"));
        paramsList.add(map.get("teacherName"));
        paramsList.add(map.get("studentId"));
        paramsList.add(map.get("studentName"));
        paramsList.add(map.get("gradeId"));
        paramsList.add(map.get("classId"));
        paramsList.add(map.get("gradeName"));
        paramsList.add(map.get("className"));
        paramsList.add(map.get("prizeName"));
        paramsList.add(map.get("prizeLevel"));
        paramsList.add(map.get("selectionUnit"));
        paramsList.add(map.get("getTime"));
        paramsList.add(map.get("prizeAddress"));
        paramsList.add(map.get("schoolId"));

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.queryForList(sql, paramas);

        return dataResult;
    }


    @Value("${sql.teacherEvaluate.teacherStudentPrize.addTeacherStudentPrize}")
    private String addTeacherStudentPrize;
    /**
     * 新增学生获奖情况数据
     *
     * @param map
     * @return
     */
    public ReturnResult addTeacherStudentPrize(HashMap<String,String> map) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = addTeacherStudentPrize;
        ArrayList paramsList = new ArrayList();

        paramsList.add(map.get("teacherId"));
        paramsList.add(map.get("teacherName"));
        paramsList.add(map.get("studentId"));
        paramsList.add(map.get("studentName"));
        paramsList.add(map.get("gradeId"));
        paramsList.add(map.get("classId"));
        paramsList.add(map.get("gradeName"));
        paramsList.add(map.get("className"));
        paramsList.add(map.get("prizeName"));
        paramsList.add(map.get("prizeLevel"));
        paramsList.add(map.get("selectionUnit"));
        paramsList.add(map.get("getTime"));
        paramsList.add(map.get("prizeAddress"));
        paramsList.add(map.get("schoolId"));

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.insert(sql, paramas);

        return dataResult;
    }


    @Value("${sql.teacherEvaluate.teacherStudentPrize.updateTeacherStudentPrize}")
    private String updateTeacherStudentPrize;
    /**
     * 修改学生获奖情况数据
     *
     * @param map
     * @return
     */
    public ReturnResult updateTeacherStudentPrize(HashMap<String,String> map) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = updateTeacherStudentPrize;
        ArrayList paramsList = new ArrayList();

        paramsList.add(map.get("teacherId"));
        paramsList.add(map.get("teacherName"));
        paramsList.add(map.get("studentId"));
        paramsList.add(map.get("studentName"));
        paramsList.add(map.get("gradeId"));
        paramsList.add(map.get("classId"));
        paramsList.add(map.get("gradeName"));
        paramsList.add(map.get("className"));
        paramsList.add(map.get("prizeName"));
        paramsList.add(map.get("prizeLevel"));
        paramsList.add(map.get("selectionUnit"));
        paramsList.add(map.get("getTime"));
        paramsList.add(map.get("prizeAddress"));
        paramsList.add(map.get("schoolId"));
        paramsList.add(map.get("dataId"));

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.update(sql, paramas);

        return dataResult;
    }


    @Value("${sql.teacherEvaluate.teacherStudentPrize.deleteTeacherStudentPrizeById}")
    private String deleteTeacherStudentPrizeById;
    /**
     * 删除学生获奖情况数据
     *
     * @param id
     * @return
     */
    public ReturnResult deleteTeacherStudentPrizeById(String id) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = deleteTeacherStudentPrizeById;
        ArrayList paramsList = new ArrayList();

        paramsList.add(id);

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.update(sql, paramas);

        return dataResult;
    }

/*=============================================================================================================*/

    @Value("${sql.teacherEvaluate.teacherPublishPaper.getTeacherPublishPaperList}")
    private String getTeacherPublishPaperList;
    /**
     * 获取教师发表论文情况数据列表
     *
     * @param pageBean
     * @return
     */
    public ReturnResult getTeacherPublishPaperList(String teacherName,
                                                   String paperTitle,
                                                   String periodicalLevel,
                                                   PageBean pageBean) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);
        String strSql = getTeacherPublishPaperList;

        ReturnResult result = new ReturnResult();

        ArrayList paramsList = new ArrayList();

        if (teacherName != null && !teacherName.equals("")){
            strSql += " and teacher_name like ? ";
            paramsList.add("%"+teacherName+"%");
        }
        if (paperTitle != null && !paperTitle.equals("")){
            strSql += " and title like ? ";
            paramsList.add("%"+paperTitle+"%");
        }
        if (periodicalLevel != null && !periodicalLevel.equals("") && !periodicalLevel.equals("null") && !periodicalLevel.equals("-1")){
            strSql += " and periodical_level = ? ";
            paramsList.add(periodicalLevel);
        }

        logger.debug("-------baseDao-getTeacherPublishPaperList start--------");
        logger.debug("SQL:" + strSql);
        logger.debug("---------baseDao-getTeacherPublishPaperList end-----------");

        if (paramsList.size() > 0){
            Object[] paramas = paramsList.toArray();
            result = baseDao.queryForListByPageBean(strSql,paramas,pageBean);
        }else {
            result = baseDao.queryForListByPageBean(strSql,pageBean);
        }

        return result;
    }


    @Value("${sql.teacherEvaluate.teacherPublishPaper.queryTeacherPublishPaper}")
    private String queryTeacherPublishPaper;
    /**
     * 根据条件查询教师发表论文情况数据
     * @param map
     * @return
     */
    public ReturnResult queryTeacherPublishPaper(HashMap<String,String> map) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = queryTeacherPublishPaper;
        ArrayList paramsList = new ArrayList();

        paramsList.add(map.get("teacherId"));
        paramsList.add(map.get("teacherName"));
        paramsList.add(map.get("paperTitle"));
        paramsList.add(map.get("abstractWord"));
        paramsList.add(map.get("keyWord"));
        paramsList.add(map.get("year"));
        paramsList.add(map.get("publishingUnit"));
        paramsList.add(map.get("periodicalLevel"));
        paramsList.add(map.get("attachmentPath"));
        paramsList.add(map.get("schoolId"));

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.queryForList(sql, paramas);

        return dataResult;
    }


    @Value("${sql.teacherEvaluate.teacherPublishPaper.addTeacherPublishPaper}")
    private String addTeacherPublishPaper;
    /**
     * 新增教师发表论文情况数据
     *
     * @param map
     * @return
     */
    public ReturnResult addTeacherPublishPaper(HashMap<String,String> map) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = addTeacherPublishPaper;
        ArrayList paramsList = new ArrayList();

        paramsList.add(map.get("teacherId"));
        paramsList.add(map.get("teacherName"));
        paramsList.add(map.get("paperTitle"));
        paramsList.add(map.get("abstractWord"));
        paramsList.add(map.get("keyWord"));
        paramsList.add(map.get("year"));
        paramsList.add(map.get("publishingUnit"));
        paramsList.add(map.get("periodicalLevel"));
        paramsList.add(map.get("attachmentPath"));
        paramsList.add(map.get("attachmentName"));
        paramsList.add(map.get("schoolId"));

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.insert(sql, paramas);

        return dataResult;
    }


    @Value("${sql.teacherEvaluate.teacherPublishPaper.updateTeacherPaper}")
    private String updateTeacherPaper;
    /**
     * 修改教师发表论文情况数据
     *
     * @param map
     * @return
     */
    public ReturnResult updateTeacherPaper(HashMap<String,String> map) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = updateTeacherPaper;
        ArrayList paramsList = new ArrayList();

        paramsList.add(map.get("teacherId"));
        paramsList.add(map.get("teacherName"));
        paramsList.add(map.get("paperTitle"));
        paramsList.add(map.get("abstractWord"));
        paramsList.add(map.get("keyWord"));
        paramsList.add(map.get("year"));
        paramsList.add(map.get("publishingUnit"));
        paramsList.add(map.get("periodicalLevel"));
        paramsList.add(map.get("attachmentPath"));
        paramsList.add(map.get("attachmentName"));
        paramsList.add(map.get("schoolId"));
        paramsList.add(map.get("dataId"));

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.update(sql, paramas);

        return dataResult;
    }


    @Value("${sql.teacherEvaluate.teacherPublishPaper.deleteTeacherPaperById}")
    private String deleteTeacherPaperById;
    /**
     * 删除教师发表论文情况数据
     *
     * @param id
     * @return
     */
    public ReturnResult deleteTeacherPaperById(String id) {
        DaoUtils baseDao = new DaoUtils(schoolJdbcTemplate);

        String sql = deleteTeacherPaperById;
        ArrayList paramsList = new ArrayList();

        paramsList.add(id);

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.update(sql, paramas);

        return dataResult;
    }



    @Value("${sql.teacherEvaluate.queryTeacherList}")
    private String queryTeacherList;
    /**
     * 验证教师姓名是否存在
     * @return
     */
    public ReturnResult queryTeacherList(String schoolId) {
        DaoUtils baseDao = new DaoUtils(personJdbcTemplate);

        String sql = queryTeacherList;
        ArrayList paramsList = new ArrayList();

        paramsList.add("1");
        paramsList.add(schoolId);

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.queryForList(sql, paramas);

        return dataResult;
    }

    @Value("${sql.teacherEvaluate.queryStudentList}")
    private String queryStudentList;
    /**
     * 查询学生列表
     * @return
     */
    public ReturnResult queryStudentList(String schoolId,String gradeId,String classId) {
        DaoUtils baseDao = new DaoUtils(personJdbcTemplate);

        String sql = queryStudentList;
        ArrayList paramsList = new ArrayList();

        paramsList.add("1");
        paramsList.add(schoolId);

        if (gradeId != null && !gradeId.equals("") && !gradeId.equals("null") && !gradeId.equals("-1")){
            sql += " and gradeId = ? ";
            paramsList.add(gradeId);
        }
        if (classId != null && !classId.equals("") && !classId.equals("null") && !classId.equals("-1")){
            sql += " and classID = ? ";
            paramsList.add(classId);
        }

        Object[] paramas = paramsList.toArray();
        ReturnResult dataResult = baseDao.queryForList(sql, paramas);

        return dataResult;
    }


}
