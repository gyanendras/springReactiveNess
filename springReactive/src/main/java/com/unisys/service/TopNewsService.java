package com.unisys.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.unisys.domain.News;

import reactor.core.publisher.Flux;

@Service
public class TopNewsService {
	List<News> newsList = Arrays.asList(new News("Top1"),new News("Top2"),new News("Top3"));
    ArrayList arList = new ArrayList<>(newsList);
	
	public Flux<News> getTopNews(){
	    for(int i=0;i<1000;++i) {
	    	arList.add(new News("Top"+i));
	    }
	    
		Flux<News> newsFlux = Flux.fromIterable(arList);//.delayElements(Duration.ofSeconds(2));
		newsFlux.subscribe(System.out::println);
		Flux<String> stringFlux = newsFlux.map(e->new String(e.getNews()));
		stringFlux.subscribe(System.out::println);
		//map, filter, reduce, collect,
		Flux<News> filteredNews = newsFlux.filter(e->e.getNews().endsWith("2")).delayElements(Duration.ofSeconds(2));
		
		return filteredNews;
	}
	
	
}
