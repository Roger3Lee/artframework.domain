package ${basePackage!''}.domain.${NameUtils.packageName(source.name)}.repository;

import ${basePackage!''}.domain.${NameUtils.packageName(source.name)}.dto.request.*;
import ${basePackage!''}.domain.${NameUtils.packageName(source.name)}.dto.*;
import ${basePackage!''}.entities.*;
import com.artframework.domain.core.repository.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

<#assign dtoClassName=NameUtils.dataTOName(source.name)/>
<#assign doClassName=NameUtils.dataObjectName(source.mainTable.name)/>
<#assign domainName=NameUtils.getName(source.name)/>
<#assign repositoryClassName=NameUtils.repositoryName(source.name)/>
public interface ${repositoryClassName} extends BaseRepository<${dtoClassName}, ${doClassName}> {
}
<#--    关联实体类-->
<#list source.relatedTable as relateTable>
    <#assign relateRepositoryClassName=NameUtils.repositoryName(relateTable.name)/>
    <#assign relateDtoClassName=NameUtils.dataTOName(relateTable.name)/>
    <#assign relateDoClassName=NameUtils.dataObjectName(relateTable.name)/>
    public interface ${relateRepositoryClassName} extends BaseRepository<${dtoClassName}.${relateDtoClassName}, ${relateDoClassName}> {
    }
</#list>