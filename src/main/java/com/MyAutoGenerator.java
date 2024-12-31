package com;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
public class MyAutoGenerator {

    public static void main(String[] args) {
        com.baomidou.mybatisplus.generator.AutoGenerator mpg = new com.baomidou.mybatisplus.generator.AutoGenerator();
        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");  //生成路径(一般都是生成在此项目的src/main/java下面)
        gc.setOpen(false);
        gc.setFileOverride(true); //第二次生成会把第一次生成的覆盖掉
        gc.setServiceName("%sService"); //生成的service接口名字首字母是否为I，这样设置就没有
        gc.setBaseResultMap(true); //生成resultMap
        gc.setAuthor("chen"); //设置作者
        mpg.setGlobalConfig(gc);

        //2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/phone_shop?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix("t_"); // 表名前缀
        strategy.setEntityLombokModel(true); //使用lombok
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc1 = new PackageConfig();
        pc1.setParent("com.phone_shop");
        pc1.setController("controller");
        pc1.setService("service");
        pc1.setServiceImpl("service.impl");
        pc1.setMapper("mapper");
        pc1.setEntity("pojo");
        pc1.setXml("xml");
        mpg.setPackageInfo(pc1);

        // 执行生成
        mpg.execute();
    }

}
