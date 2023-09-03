package ${basePackage!''}.domain.${NameUtils.packageName(source.name)}.service;

import ${basePackage!''}.domain.${NameUtils.packageName(source.name)}.dto.request.*;
import ${basePackage!''}.domain.${NameUtils.packageName(source.name)}.dto.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

<#assign serviceClassName=NameUtils.serviceName(source.name)/>
<#assign domainName=NameUtils.getName(source.name)/>
<#assign dtoClassName=NameUtils.dataTOName(source.name)/>
public interface ${serviceClassName} {

    /**
    * 分页查询
    * @param request 请求体
    * @return
    */
    IPage<${dtoClassName}> page(${domainName}PageRequest request);

    /**
    * 查找
    * @param request 请求体
    * @return
    */
    ${dtoClassName} find(${domainName}FindRequest request);

    /**
    * 新增
    * @param request 请求体
    * @return
    */
    ${source.keyType} insert(${domainName}CreateRequest request);

    /**
    * 修改
    * @param request 请求体
    * @return 成功OR失败
    */
    Boolean update(${domainName}UpdateRequest request);

    /**
    * 删除
    * @param id 数据ID
    * @return 成功OR失败
    */
    Boolean delete(${source.keyType} id);
}
