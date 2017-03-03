package com.dev.util.mswords.doc;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {
   public static void main(String[] args) {
      String html = "file:///";
      try {
    	  
    	 ;
       //  Document doc = Jsoup.connect(html).get();
         Document doc = Jsoup.parse( FileUtils.readFileToString(new File("E:/2017/poc/testdata/ws_datapedia/outTables.html")));
         Elements tableElements = doc.select("table");

         Elements tableHeaderEles = tableElements.select("thead tr th");
       //  System.out.println("headers");
         for (int i = 0; i < tableHeaderEles.size(); i++) {
            System.out.print(tableHeaderEles.get(i).text()+"|");
         }
         System.out.println();

         Elements tableRowElements = tableElements.select(":not(thead) tr");

         for (int i = 0; i < tableRowElements.size(); i++) {
            Element row = tableRowElements.get(i);
            System.out.println("------------------");
            Elements rowItems = row.select("td");
            for (int j = 0; j < rowItems.size(); j++) {
               System.out.print(rowItems.get(j).text()+"|");
            }
            System.out.println();
         }

      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}