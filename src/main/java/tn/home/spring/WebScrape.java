package tn.home.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebScrape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*final String url="https://www.tanitjobs.com/";
		try {
			final Document doc=Jsoup.connect(url).get();
			for(Element row: doc.select("div.listing-item__list div.media-heading.listing-item__title")) {
				if(row.select("a.link").text().equals("")) {
					continue;
				}else {
					final String ticker=row.select("a.link").text();
					System.out.println(ticker);
				}
			}
			//System.out.println(doc.outerHtml());
			
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		final String url1="http://www.stage-tunisie.tn/";
		try {
			final Document doc=Jsoup.connect(url1).get();
			for(Element row: doc.select("div.container_16 div.BlocOffre")) {
				if(row.select("div.titreTypeContrat").text().equals("")) {
					continue;
				}else {
					
					Scanner myObj = new Scanner(System.in);
				    String search;
				    
				    search = myObj.nextLine();   
					
					final String ticker=row.select("div.titreTypeContrat").text();
					String str[] = ticker.split("-");
					List<String> al = new ArrayList<String>();
					al = Arrays.asList(str);
					al.stream().filter(e->e.length()>55)
					.collect(Collectors.toList());
					System.out.println(al.stream().filter(e->e.startsWith(search))
							.collect(Collectors.toList()));
				}
			}
			//System.out.println(doc.outerHtml());
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
