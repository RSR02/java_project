//package demo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.*;
import java.util.*;
import java.io.FileWriter;

import javax.swing.text.AbstractDocument.Content;

import java.io.IOException;

public class  Main{
    public static void main(String[] args) throws IOException {
        // URL to scrape
        String url = "https://www.quill.com/hanging-file-folders/cbl/4378.html";

        // Make a request to the URL and get the HTML response
        Document document = Jsoup.connect(url).get();
        System.out.println(document.title());
        FileWriter writer = new FileWriter("products.csv");
        writer.write("Product Name,Product Price,ProductItemNo,ProductModelNo,ProductCategory,ProductDescription\n");
        Elements ProductNames = document.getElementsByClass("desc4 scTrack pfm sku-description");
        Elements ProductPrices = document.getElementsByClass("priceupdate");
        Elements ProductItemNos = document.getElementsByClass("iNumber formLabel lblItemNo adptfont");
        Elements ProductModelNos = document.getElementsByClass("model-number");
        Elements ProductCategorys = document.getElementsByClass("H1 L");
        Elements ProductDescriptions = document.getElementsByClass("skuBrowseBullets");
        // Iterate over the product names and prices and print them
        for (int i = 0; i<10; i++) {
            //System.out.println("hello");
            String ProductName= ProductNames.get(i).text().replace(","," ");
            //System.out.println(ProductName);

            String ProductPrice=ProductPrices.get(i).text().replace(","," ");
            String ProductItemNo=ProductItemNos.get(i).text().replace(","," ");
            String ProductModelNo= ProductModelNos.get(i).text().replace(","," ");
            String ProductCategory=ProductCategorys.text().replace(","," ");
            String ProductDescription=ProductDescriptions.get(i).text().replace(","," ");
            writer.write(ProductName + "," + ProductPrice + "," + ProductItemNo + "," + ProductModelNo + "," +  ProductCategory + "," + ProductDescription  +"\n");
        }
        writer.close();
    }
}