package com.lone.loneaiagent.rag;

import jakarta.annotation.Resource;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 恋爱大师向量数据库配置（初始化基于内存的向量数据库Bean）
 */
@Configuration
public class LoveAppVectorStoreConfig {

    @Resource
    private LoveAppDocumentLoader loveAppDocumentLoader;
    
    @Bean
    VectorStore loveAppVectorStore(EmbeddingModel dashscopeEmbeddingModel) {
        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(dashscopeEmbeddingModel)
                .build();
        // 加载文档
        List<Document> documents = loveAppDocumentLoader.loadMarkdowns();
        simpleVectorStore.add(documents);
        return simpleVectorStore;
    }

    // 自主切分
//    @Resource
//    private MyTokenTextSplitter myTokenTextSplitter;
//
//    @Bean
//    VectorStore loveAppVectorStore(EmbeddingModel dashscopeEmbeddingModel) {
//        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(dashscopeEmbeddingModel)
//                .build();
//        // 加载文档
//        List<Document> documents = loveAppDocumentLoader.loadMarkdowns();
//        // 自主切分
//        List<Document> splitDocuments = myTokenTextSplitter.splitCustomized(documents);
//        simpleVectorStore.add(splitDocuments);
//        return simpleVectorStore;
//    }


    /**
     * 利用ai 自动补充关键词元信息
     */
//    @Resource
//    private MyKeywordEnricher myKeywordEnricher;
//    @Bean
//    VectorStore loveAppVectorStore(EmbeddingModel dashscopeEmbeddingModel) {
//        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(dashscopeEmbeddingModel)
//                .build();
//        // 加载文档
//        List<Document> documents = loveAppDocumentLoader.loadMarkdowns();
//        // 自动补充关键词元信息
//        List<Document> enrichedDocuments = myKeywordEnricher.enrichDocuments(documents);
//        simpleVectorStore.add(enrichedDocuments);
//        return simpleVectorStore;
//    }

}
