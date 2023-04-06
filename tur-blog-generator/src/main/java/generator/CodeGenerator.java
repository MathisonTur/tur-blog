package generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Arrays;

/**
 * @author tur
 * @version 1.0
 * @date 2023/3/24 16:19
 * @description 代码生成器类
 */
public class CodeGenerator {

    // TODO 修改服务名以及数据表名
    private static final String SERVICE_NAME = "turblog_dev";
    // 数据库账号
    private static final String DATA_SOURCE_USERNAME = "root";
    // 数据库密码
    private static final String DATA_SOURCE_PASSWORD = "chenmo";
    // 需要映射的表
    private static final String[] TABLE_NAMES = new String[]{
            "t_category"
    };

    private static final Boolean IS_DTO = false;

    public static void main(String[] args) {
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // 覆盖原先已有的文件
        globalConfig.setFileOverride(true);
        // 生成路径
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/tur-blog-generator/src/main/java");
        globalConfig.setAuthor("tur");
        globalConfig.setOpen(false);
        globalConfig.setSwagger2(false);
        globalConfig.setServiceName("%sService");
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseResultMap(true);
        globalConfig.setIdType(IdType.AUTO);
        if (IS_DTO){
            globalConfig.setSwagger2(true);
            globalConfig.setEntityName("%sDto");
        }

        // 数据库配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/" + SERVICE_NAME + "?serverTimezone=UTC&useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername(DATA_SOURCE_USERNAME);
        dataSourceConfig.setPassword(DATA_SOURCE_PASSWORD);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.blog");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setService("service.intf");
        packageConfig.setXml("mapper");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("pojo.entity");

        // 设置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setInclude(TABLE_NAMES);
        strategyConfig.setControllerMappingHyphenStyle(true);
        // Boolean类型字段是否移除前缀处理
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(false);
        strategyConfig.setRestControllerStyle(true);
        // 过滤表前缀
        strategyConfig.setTablePrefix("t_");
        // 自动填充字段配置
        strategyConfig.setTableFillList(Arrays.asList(
                new TableFill("create_date", FieldFill.INSERT),
                new TableFill("change_date", FieldFill.INSERT_UPDATE),
                new TableFill("modify_date", FieldFill.UPDATE)
        ));

        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        // 选择freemarker引擎，默认Velocity
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.setTemplate(templateConfig);
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();
    }
}
