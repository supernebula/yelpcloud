package com.evol.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.evol.domain.dto.EsReviewDTO;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContent;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.PrefixQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RequestMapping("es")
@RestController
public class EsController {

    @Qualifier(value = "esClient")
    @Autowired
    RestHighLevelClient client;

    @PostMapping("insert")
    public String insert(){

        String result = "none";

        try{

            EsReviewDTO reviewDto = new EsReviewDTO(1, 5, new Date(), "评论内容1", 7, 3, 1, 8, 1);

            String json = JSON.toJSONString(reviewDto);
            IndexRequest indexRequest = new IndexRequest("yelp_review", "_doc").source(json, XContentType.JSON);
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
            String id = indexResponse.getId();
            String index = indexResponse.getIndex();
            long version = indexResponse.getVersion();
            int status = indexResponse.status().getStatus();
            if(indexResponse.getResult() == DocWriteResponse.Result.CREATED){
                System.out.println("新增文档成功!" + index + "-" + id + "-" + version + "-status:" + status);
                result = "create_success";
            } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
                System.out.println("修改文档成功!");
                result = "update_success";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @DeleteMapping("delete")
    public String delete(){
        String result = "none";
        String id = "OEwwtnEBQfhP6TmH_J7I";
        DeleteRequest deleteRequest = new DeleteRequest("yelp_review", "_doc", id);
        try {
            DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
            if (deleteResponse.getResult() == DocWriteResponse.Result.DELETED) {
                System.out.println("删除文档成功!id：" + id);
                result = "delete_success";
            } else {
                System.out.println("删除文档成功!id：" + id);
                result = "delete_fail";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @PutMapping("update")
    public String update(){
        String result = "none";
        return result;
    }

    @PutMapping("find")
    public String find(){
        String result = "none";
        return result;
    }

    @GetMapping("search")
    public String search(){
        String result = "none";
        SearchRequest searchRequest = new SearchRequest("yelp_review");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //如果用name直接查询，其实是匹配name分词过后的索引查到的记录(倒排索引)；如果用name.keyword查询则是不分词的查询，正常查询到的记录
        RangeQueryBuilder rangeQueryBuilder =
                QueryBuilders.rangeQuery("date").from("2020-04-25").to("2020-04-27").format("yyyy-MM-dd");//范围查询
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name.keyword", name);//精准查询
        //PrefixQueryBuilder prefixQueryBuilder = QueryBuilders.prefixQuery("text", "评论");//前缀查询
//        WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("name.keyword", "*三");//通配符查询
//        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name", "三");//模糊查询
        FieldSortBuilder fieldSortBuilder = SortBuilders.fieldSort("date");//按照年龄排序
        fieldSortBuilder.sortMode(SortMode.MIN);//从小到大排序

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //boolQueryBuilder.must(rangeQueryBuilder).should(prefixQueryBuilder);//and or  查询

        sourceBuilder.query(boolQueryBuilder).sort(fieldSortBuilder);//多条件查询
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            JSONArray jsonArray = new JSONArray();
            for (SearchHit hit : hits) {
                String sourceAsString = hit.getSourceAsString();
                JSONObject jsonObject = JSON.parseObject(sourceAsString);
                jsonArray.add(jsonObject);
            }
            result = "查询成功";
        } catch (IOException e) {
            e.printStackTrace();
            result = "查询失败";
        }
        return result;
    }



}
