package com.lone.loneaiagent.tools;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WebSearchToolTest {

    // 需要加载配置文件就需要springboottset注解
    @Value("${search-api.api-key}")
    private String searchApiKey;

    @Test
    public void testSearchWeb() {
        WebSearchTool tool = new WebSearchTool("iigxXBE58scZun4o34DWigmP");
        String query = "程序员鱼皮编程导航 codefather.cn";
        String result = tool.searchWeb(query);
        assertNotNull(result);
    }
}
