package demo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        // URL to scrape
        String url = "https://www.quill.com/hanging-file-folders/cbl/4378.html";

        // Make a request to the URL and get the HTML response
        Document document = Jsoup.connect(url).get();
        System.out.println(document.title());
        System.out.println(document);

        // Select the product names
        Elements elements = document.getElementsByTag("p");
        System.out.println(elements.get(0).text());
        for(Element e:elements)  
        //{
         //   String link=element.attributes().get("href");
       // }
        // Select the product prices
        //Elements productPrices = document.select(".product-price");
        //for (Elements productName : productNames)
        
        // Iterate over the product names and prices and print them
        for (int i = 0; i < elements.size(); i++) {
            System.out.println("hello");
            System.out.println("Product Name: " + elements.get(i).text());
            //System.out.println("Product Price: " + productPrices.get(i).text());
        }
        System.out.println("hello");
    }
}