package com.imis.frame;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description: 代码生成器
 * Author: zcx
 * Date: Created in 2019/9/14 18:28
 * Version: 1.0
 */
public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();

        String projectPath = System.getProperty("user.dir");

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("zcx");
        gc.setOpen(false);
        gc.setFileOverride(true);//覆盖已有文件
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setActiveRecord(false);
        gc.setServiceName("%sService");
        gc.setMapperName("%sDao");
        generator.setGlobalConfig(gc);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/imis?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setTypeConvert(new MySqlTypeConvert(){
            @Override
            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                //将tinyint转换为Boolean
                if(fieldType.toLowerCase().contains("tinyint")){
                    return DbColumnType.BOOLEAN;
                }
                if(fieldType.toLowerCase().contains("datetime")){
                    return DbColumnType.DATE;
                }
                if(fieldType.toLowerCase().contains("date")){
                    return DbColumnType.STRING;
                }
                return (DbColumnType)super.processTypeConvert(globalConfig, fieldType);
            }
        });
        generator.setDataSource(dsc);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.imis.project");
        pc.setEntity("entity");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("dao");
        pc.setXml("mapper");
        generator.setPackageInfo(pc);

        //自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        /*List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath+"/src/main/java/"+pc.getParent().replace(".","/")+"/mapper/"+tableInfo.getEntityName()+"Mapper"+ StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        generator.setTemplate(new TemplateConfig().setXml(null));*/
        generator.setCfg(cfg);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(false);//驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix("tb_");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setSuperEntityColumns(new String[]{"id","status","org","orgTree","created","createDate","createTime","updated","updateDate","updateTime"});
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setSuperEntityClass("com.imis.frame.core.entity.BaseEntity");//公共Entity
        strategy.setSuperControllerClass("com.imis.frame.core.controller.BaseController");//公共controller
        strategy.setSuperServiceClass("com.imis.frame.core.service.BaseService");//公共service
        strategy.setSuperServiceImplClass("com.imis.frame.core.service.impl.BaseServiceImpl");//公共serviceImpl
        strategy.setSuperMapperClass("com.imis.frame.core.dao.BaseDao");//公共dao
        generator.setStrategy(strategy);
        //设置freemarker为模板引擎
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

    /**
     * Description: 读取控制台内容
     * Author: zcx
     * Date: Created in 2019-09-15 14:31:45
     * Param: [tip]
     * Return: java.lang.String
     * Version: 1.0
     */
    public static String scanner(String tip){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入"+tip+":");
        if(sc.hasNext()){
            String ipt = sc.next();
            if(StringUtils.isNotEmpty(ipt)){
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的"+tip+"!");
    }
}
