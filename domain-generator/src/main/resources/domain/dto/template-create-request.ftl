package ${basePackage!''}.domain.${NameUtils.packageName(source.name)}.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import ${basePackage!''}.domain.${NameUtils.packageName(source.name)}.dto.*;

@Getter
@Setter
@ToString
public class ${NameUtils.getName(source.name)}CreateRequest extends ${NameUtils.dataTOName(source.name)} {
}
