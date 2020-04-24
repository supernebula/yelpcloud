package com.evol.controller;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//https://github.com/HanDLFanFan/elasticsearch/

//https://www.cnblogs.com/java-spring/p/11721615.html

@RequestMapping("/es")
@RestController
public class EsIndexController {

    @Qualifier(value = "esClient")
    @Autowired
    RestHighLevelClient client;

    /**
     * GET /_cat/indices?v
     */
    public void show(){}

    /**
     * PUT /{IndexName}?pretty
     */
    @PutMapping("create")
    public boolean create() throws IOException {

        boolean acknowledged = false;

        try{
            CreateIndexRequest createRequest = new CreateIndexRequest("yelp");
            CreateIndexResponse createResponse = client.indices().create(createRequest, RequestOptions.DEFAULT);
            acknowledged = createResponse.isAcknowledged();
            System.out.println("acknowledged="+acknowledged);
            return acknowledged;

        }finally {
            //client.close();
        }
    }



    /**
     * DELETE /{IndexName}?pretty
     */
    @DeleteMapping("delete")
    public boolean delete() throws IOException {
        boolean acknowledged = false;
        try {
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("yelp");
            deleteIndexRequest.indicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN);
            AcknowledgedResponse deleteResponse = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            acknowledged = deleteResponse.isAcknowledged();
        }catch (Exception ex){
            System.out.println(ex);
        }finally {
            //client.close();
        }
        return acknowledged;
    }

    /**
     * GET /_cat/indices?v
     * @return
     * @throws IOException
     */
    @GetMapping("all")
    public String query() throws IOException {

        String result = "null";

        try {
            GetIndexRequest getIndexRequest = new GetIndexRequest("_all");
            GetIndexResponse getIndexResponse = client.indices().get(getIndexRequest, RequestOptions.DEFAULT);
            String[] indexs = getIndexResponse.getIndices();
            result = StringUtils.join(indexs, ",");
        }catch (Exception ex){
            System.out.println(ex);
        }finally {
            //client.close();
        }
        return result;
    }



//    /**
//     * PUT /{IndexName}?pretty
//     */
//    @PutMapping("create")
//    public String create() throws IOException {
//        try{
//            Map<String,Object> esMap = new HashMap<>();
//            esMap.put("name", "serlou");
//            esMap.put("age", "109");
//            esMap.put("des", "i like and study elasticearch");
//
//            IndexRequest indexRequest = new IndexRequest("yelp","review","2").source(esMap);
//
//            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
//
//            int status = indexResponse.status().getStatus();
//
//            System.out.println("status="+status);
//
//            System.out.println("info="+indexResponse.status().toString());
//            return indexResponse.status().toString();
//
//        }finally {
//            client.close();
//        }
//    }


}
