package webscraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 *
 * @author Noor Aishah Zainiar
 */
public class WebScraping {

    public static void main(String[] args) 
    {    
        try{
        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Haskell_(programming_language)").get();
            

        // get the page title
        String title = doc.title();
        System.out.println("Title of the Webpage : " + title);
        
        // get data for table of contents
        Elements toc = doc.select("div#toc");
        Elements toc2 = doc.select("li.toclevel-1");
     
        System.out.println("Contents");
        
        System.out.println("\nTotal Contents in Haskell Programming Wikipedia : " + toc2.size());
        
       // System.out.println("\nTotal Contents in Haskell Programming Wikipedia : " + toc.outerHtml());
        for(Element step : toc)
        {
            // display title of table of contents - Contents
            //String method = step.select("div.toctitle").text();
            //System.out.println(method);
            
            // display all table of content
            String toctitles = step.select("li.toclevel-1").text();
            Elements childElem = step.child(2).select("ul");
            
            // System.out.println("\n" + toctitles);
            System.out.println(childElem.text());          

            System.out.println("\n----------------------------");

            // get all pictures in Haskell 
            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
        
            System.out.println("\nTotal Images in Haskell Programming Wikipedia : " + images.size());
        
            for (Element image : images) {  
                System.out.println("\nsrc : " + image.attr("src"));  
                System.out.println("height : " + image.attr("height"));  
                System.out.println("width : " + image.attr("width"));  
                System.out.println("alt : " + image.attr("alt"));  
            }  

            System.out.println("\n----------------------------");
            

            Elements ref2 = doc.select("ol.references > *");
                
           // Document doc2 = Jsoup.connect("https://en.wikipedia.org/wiki/Haskell_(programming_language)#References").get();
            System.out.println("\nTotal References in Haskell Programming Wikipedia : " + ref2.size());
              
            //Elements ref = document.select("#mw-content-text > div > div.reflist.columns.references-column-width");//Get references
                        //System.out.println(ref.get(0).text()); //Print References
                        System.out.println("\r\nReferences:" + ref2.text());
                        
            //Elements paragraphs = doc2.select("li:has(#mw-cite-backlink))");
            
            //return firstParagraph.text();
            // System.out.println(ref2);
            //  for (Element ref : ref2) {  
            //    Elements ref3 = ref.select("a[href^=\\\"/wiki/\\\"]");
            //      Elements ref4 = ref.select("span=[reference-text] , a[href]");
            //     Elements paragraphs = doc2.select("#mw-cite-backlink");
            // Elements firstParagraph = ref3.first("");
            //  System.out.println("\nReference: " + ref.select("ref3"));  
            //    System.out.println("Text : " + ref.select("ref4"));    

        }    
   
        
        }
        
	catch (IOException e) 
	{
		e.printStackTrace();
	}
         
   
    }    
}

 

