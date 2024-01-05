package ${mapperPackage!''};

import mo.gov.dsaj.parent.core.mybatis.CustomBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import ${tablePackage!''}.*;

/**
* ${source.name}
*
* @author auto
* @version v1.0
*/
@Mapper
public interface ${NameUtils.mapperName(source.name)} extends CustomBaseMapper<${NameUtils.dataObjectName(source.name)}> {
}