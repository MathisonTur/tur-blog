package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * @author ${author}
 * @description ${table.comment!}服务
 * @version 1.0
 * @date ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

}
</#if>
