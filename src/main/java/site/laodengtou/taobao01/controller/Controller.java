package site.laodengtou.taobao01.controller;

import org.aspectj.apache.bcel.classfile.Code;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.laodengtou.taobao01.dao.CodeDao;
import site.laodengtou.taobao01.dao.CodeSettingDao;
import site.laodengtou.taobao01.entity.CodeSetting;
import site.laodengtou.taobao01.entity.MyCode;
import site.laodengtou.taobao01.util.Result;
import site.laodengtou.taobao01.util.ResultCode;
import java.util.Date;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    CodeDao codeDao;
    @Autowired
    CodeSettingDao settingDao;

   @GetMapping("search")
   public Result search(int one,int two,int three,int four){
       LoggerFactory.getLogger("Controll").info(one+","+two+","+three+","+four+"");
       Result result = new Result();
       List<MyCode> codes = codeDao.findCodesByOneAndTwoAndThreeAndFour(one, two, three, four);
       List<CodeSetting> settings = settingDao.findAll();
       if(settings.size()>0){
           LoggerFactory.getLogger("Controll").info("范围判断");
           CodeSetting setting = settings.get(0);
           if(one<setting.getOneMin()||one>setting.getOneMax()||two<setting.getTwoMin()||two>setting.getTwoMax()||three<setting.getThreeMin()||three>setting.getThreeMax()||four<setting.getFourMin()||four>setting.getFourMax()){
               result.setCode(0);
               return result;
           }
       }
       if(codes==null||codes.size()==0){
           LoggerFactory.getLogger("Controll").info("没有验证码");
           result.setCode(0);
           return result;
       }
       MyCode code = codes.get(0);
       if(code.getcCheck()){
           result.setCode(2);
           result.setData(code.getCheckTime());
           System.out.println("重复验证："+result.toString());
           return result;
       }else {
           result.setCode(1);
           code.setcCheck(true);
           codeDao.save(code);
           return result;
       }

   }

   @GetMapping("deleteAll")
   public Result deleteAll(){
       codeDao.deleteAll();
       return Result.success();
   }

   @PostMapping("addCode")
   public Result addCode(int one,int two,int three,int four){
       Result result = new Result();
       //查询范围
       List<CodeSetting> settings = settingDao.findAll();
       if(settings.size()>0){
           LoggerFactory.getLogger("Controll").info("范围判断");
           CodeSetting setting = settings.get(0);
           if(one<setting.getOneMin()||one>setting.getOneMax()||two<setting.getTwoMin()||two>setting.getTwoMax()||three<setting.getThreeMin()||three>setting.getThreeMax()||four<setting.getFourMin()||four>setting.getFourMax()){
               result.setCode(100);
               result.setMsg("范围不符合规范");
               return result;
           }
       }

       List<MyCode> codes = codeDao.findCodesByOneAndTwoAndThreeAndFour(one, two, three, four);
       if(codes.size()>0){
           result.setCode(200);
           result.setMsg("校验码已存在");
           return result;
       }

       MyCode code = new MyCode();
       code.setOne(one);
       code.setTwo(two);
       code.setThree(three);
       code.setFour(four);
       code.setcCheck(false);
       code.setCheckTime(new Date());
       codeDao.save(code);
       return Result.success();
   }

   @PostMapping("setFanWei")
    public Result setFanwei(int min,int max,int type){
       List<CodeSetting> settings = settingDao.findAll();
       switch (type){
           case 1:
               if(settings==null||settings.size()==0){
                   CodeSetting set = new CodeSetting();
                   set.setOneMin(min);
                   set.setOneMax(max);
                   set.setTwoMin(0);
                   set.setTwoMax(9);
                   set.setThreeMin(0);
                   set.setThreeMax(9);
                   set.setFourMin(0);
                   set.setFourMax(9);
                   settingDao.save(set);
               }else{
                   CodeSetting set = settings.get(0);
                   set.setOneMax(max);
                   set.setOneMin(min);
               }
               break;
           case 2:
               if(settings==null||settings.size()==0){
                   CodeSetting set = new CodeSetting();
                   set.setOneMin(0);
                   set.setOneMax(9);
                   set.setTwoMin(min);
                   set.setTwoMax(max);
                   set.setThreeMin(0);
                   set.setThreeMax(9);
                   set.setFourMin(0);
                   set.setFourMax(9);
                   settingDao.save(set);
               }else{
                   CodeSetting set = settings.get(0);
                   set.setTwoMax(max);
                   set.setTwoMin(min);
               }
               break;
           case 3:
               if(settings==null||settings.size()==0){
                   CodeSetting set = new CodeSetting();
                   set.setOneMin(0);
                   set.setOneMax(9);
                   set.setTwoMin(0);
                   set.setTwoMax(9);
                   set.setThreeMin(min);
                   set.setThreeMax(max);
                   set.setFourMin(0);
                   set.setFourMax(9);
                   settingDao.save(set);
               }else {
                   CodeSetting set = settings.get(0);
                   set.setThreeMax(max);
                   set.setThreeMin(min);
               }
               break;
           case 4:
               if(settings==null||settings.size()==0){
                   CodeSetting set = new CodeSetting();
                   set.setOneMin(0);
                   set.setOneMax(9);
                   set.setTwoMin(0);
                   set.setTwoMax(9);
                   set.setThreeMin(0);
                   set.setThreeMax(9);
                   set.setFourMin(min);
                   set.setFourMax(max);
                   settingDao.save(set);
               }else {
                   CodeSetting set = settings.get(0);
                   set.setFourMax(max);
                   set.setFourMin(min);
               }
               break;
       }
       return Result.success();
   }




}
