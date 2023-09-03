package com.artframework.domain.generator;

import com.artframework.domain.utils.FreeMakerTplUtil;
import com.artframework.domain.utils.StreamUtils;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class AbstractGenerator {

    protected String basePackage;
    @Setter
    protected String templateFilePath;

    public  <T> String generate(T source){
        try (InputStream inputStream = AbstractGenerator.class.getClassLoader().getResourceAsStream(templateFilePath)) {
            String template = StreamUtils.readAsString(inputStream);
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("basePackage",this.basePackage);
            paramMap.put("source", buildParam(source));
            return FreeMakerTplUtil.process(template, paramMap);
        } catch (Throwable e) {
            e.printStackTrace();
            log.error("generate failed", e);
        }
        return "";
    }

    public abstract <T> Object buildParam(T source);
}
