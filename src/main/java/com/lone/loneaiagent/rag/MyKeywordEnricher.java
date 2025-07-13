package com.lone.loneaiagent.rag;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.KeywordMetadataEnricher;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 基于AI的文档元信息增强器（为文档补充元信息）
 */
@Component
public class MyKeywordEnricher {
    @Resource
    private ChatModel dashscopeChatModel;
    @Resource
    private LoveAppDocumentLoader loveAppDocumentLoader;

    List<Document> enrichDocuments(List<Document> documents) {
        KeywordMetadataEnricher enricher = new KeywordMetadataEnricher(this.dashscopeChatModel, 5);
        return enricher.apply(documents);
    }

}

