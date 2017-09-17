package com.roncoo.example;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.roncoo.example.bean.RoncooUserLog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo251ApplicationTests {
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	/**
	 * get请求
	 */
	@Test
	public void getForObject() {

		RoncooUserLog bean = restTemplateBuilder.build().getForObject("http://localhost:8080/rest/update/{id}",
				RoncooUserLog.class, 1);
		System.out.println(bean);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 2);
		bean = restTemplateBuilder.build().postForObject("http://localhost:8080/rest/update", map, RoncooUserLog.class);
		System.out.println(bean);

		String result = restTemplateBuilder.additionalCustomizers(new ProxyCustomizer()).build()
				.getForObject("http://www.roncoo.com", String.class);
		System.out.println(result);

	}

	static class ProxyCustomizer implements RestTemplateCustomizer {
		@Override
		public void customize(RestTemplate restTemplate) {
			String proxyHost = "43.255.104.179";
			int proxyPort = 8080;

			HttpHost proxy = new HttpHost(proxyHost, proxyPort);
			HttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {
				@Override
				public HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context)
						throws HttpException {
					System.out.println(target.getHostName());
					return super.determineProxy(target, request, context);
				}
			}).build();
			HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
					httpClient);
			httpComponentsClientHttpRequestFactory.setConnectTimeout(10000);
			httpComponentsClientHttpRequestFactory.setReadTimeout(60000);
			restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
		}
	}

}
