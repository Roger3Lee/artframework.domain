package com.artframework.domain.dto;

import cn.hutool.core.util.StrUtil;
import com.artframework.domain.config.GlobalSetting;
import com.artframework.domain.meta.domain.DomainMetaInfo;
import com.artframework.domain.meta.domain.RelatedTableMetaInfo;
import com.artframework.domain.meta.table.ColumnMetaInfo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class DomainInfo {
    private String name;
    private String description;

    private TableInfo mainTable;
    private List<RelateTableInfo> relatedTable;

    public String nameSuffix(String suffix) {
        return StringUtils.capitalize(StrUtil.toCamelCase(StrUtil.format("{}", this.name))) + suffix;
    }

    public static DomainInfo covert(DomainMetaInfo domainMetaInfo) {
        TableInfo tableInfo = TableInfo.convert(domainMetaInfo.getMainTable());
        return DomainInfo
                .builder()
                .name(domainMetaInfo.getName())
                .description(domainMetaInfo.getDescription())
                .mainTable(tableInfo)
                .relatedTable(domainMetaInfo.getRelatedList().stream().map(RelateTableInfo::convert).collect(Collectors.toList()))
                .build();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class RelateTableInfo extends TableInfo {
        private Boolean many;
        private String fkSourceColumnType;
        private String fkSourceColumn;
        private String fkTargetColumnType;
        private String fkTargetColumn;

        public static RelateTableInfo convert(RelatedTableMetaInfo relatedTableMetaInfo) {
            RelateTableInfo tableInfo = new RelateTableInfo();
            tableInfo.setName(relatedTableMetaInfo.getTable());
            tableInfo.setColumn(GlobalSetting.INSTANCE.getTableColumns(relatedTableMetaInfo.getTable()));
            ColumnMetaInfo keyColumn = tableInfo.getColumn().stream().filter(ColumnMetaInfo::getKey).findFirst().orElse(null);
            if (keyColumn != null) {
                tableInfo.setKeyType(keyColumn.getType());
                tableInfo.setKeyColName(keyColumn.getName());
            }

            tableInfo.setMany(relatedTableMetaInfo.getMany());
            String[] strings = relatedTableMetaInfo.getFk().split(":");
            tableInfo.setFkSourceColumn(strings[0]);
            tableInfo.setFkSourceColumnType(tableInfo.getColumn().stream().filter(x->x.getName().equals(strings[0]))
                    .map(ColumnMetaInfo::getType).findFirst().orElse(""));
            tableInfo.setFkTargetColumn(strings[1]);
            tableInfo.setFkTargetColumnType(tableInfo.getColumn().stream().filter(x->x.getName().equals(strings[1]))
                    .map(ColumnMetaInfo::getType).findFirst().orElse(""));
            return tableInfo;
        }
    }


    @Data
    public static class TableInfo {
        private String name;
        private List<ColumnMetaInfo> column;
        private String keyType;
        private String keyColName;

        public static TableInfo convert(String tableName) {
            TableInfo tableInfo = new TableInfo();
            tableInfo.setName(tableName);
            tableInfo.setColumn(GlobalSetting.INSTANCE.getTableColumns(tableName));

            ColumnMetaInfo keyColumn = tableInfo.column.stream().filter(ColumnMetaInfo::getKey).findFirst().orElse(null);
            if (keyColumn != null) {
                tableInfo.setKeyType(keyColumn.getType());
                tableInfo.setKeyColName(keyColumn.getName());
            }

            return tableInfo;
        }
    }
}
