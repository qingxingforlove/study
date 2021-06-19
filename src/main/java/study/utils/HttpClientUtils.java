package study.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpClientUtils {
    /**
     * get无参请求
     *
     * @param url
     * @throws IOException
     */
    public static void httpget(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        response = httpClient.execute(httpGet);

        //响应Code
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode:" + statusCode);
        //响应头
        System.out.println(response.getStatusLine());

        //响应体
        HttpEntity entity = response.getEntity();
        String responseentity = EntityUtils.toString(entity, "UTF-8");
        if (entity != null) {
            System.out.println("响应内容长度为:" + entity.getContentLength());
            System.out.println("响应内容为:" + responseentity);
        }
        if (httpClient != null) {
            httpClient.close();
        }
        if (response != null) {
            response.close();
        }
    }

    /**
     * get带参数请求
     * @param url
     * @throws IOException
     */
    public static void httpget1(String url) throws IOException{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //参数
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name", "&"));
        params.add(new BasicNameValuePair("age", "18"));
        HttpGet httpGet = new HttpGet(url + "?" + params);

        CloseableHttpResponse response = null;
        response = httpClient.execute(httpGet);

        //响应Code
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode:" + statusCode);

        //响应体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            System.out.println("响应内容长度为:" + entity.getContentLength());
            System.out.println("响应内容为:" + EntityUtils.toString(entity));
        }
        if (httpClient != null) {
            httpClient.close();
        }
        if (response != null) {
            response.close();
        }
    }

    public static void httpPost(String url)throws IOException{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        //参数
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name", "&"));
        params.add(new BasicNameValuePair("age", "18"));
        StringEntity entity = new StringEntity(JSON.toJSONString(params), "UTF-8");
        //请求头
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        //请求体
        httpPost.setEntity(entity);
        //请求
        CloseableHttpResponse response = null;
        response = httpClient.execute(httpPost);
        //响应Code
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode:" + statusCode);

        //响应体
        HttpEntity responseEntity = response.getEntity();
        if (responseEntity != null) {
            System.out.println("响应内容长度为:" + responseEntity.getContentLength());
            System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
        }
        if (httpClient != null) {
            httpClient.close();
        }
        if (response != null) {
            response.close();
        }
    }
}
