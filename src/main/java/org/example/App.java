package org.example;

/**
 * Hello world!
 *  [3:09 PM] Bulusu Sunil
 *
 * Coding Exercise (2-3 hrs max)
 *
 * 1) Download a file from:http://www.gutenberg.org/files/2701/2701-0.txt
 *
 * 2) Test drive cracking the file open, parse it and get a list of the top 50 words
 *
 * 3) Exclude a set of common words (case insensitive) (the,of,to,and,a,in,is,it,you,that,he,was,for,on,are,with,as,I,his,they,be,at,one,have,this,from,or,had,by,not,word,but,what,some,we,can,out,other,were,all,there,when,up,use,your,how,said,an,each,she)
 *
 * Use Collections API in .NET or JAVA or any other language of your choice.
 *
 * 4) Deploy and run this on one of cloud platforms - AWS/Azure/GCP
 * 5) Check the code into GitHub and Share the link
 */

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class App 
{
    static final String MOBY_DICK_URL = "https://www.gutenberg.org/files/2701/2701-0.txt";

    public static void main( String[] args ) throws IOException {
//        System.out.println( "Hello World!" );

        // java.io & a url
        BufferedInputStream in = new BufferedInputStream(new URL(MOBY_DICK_URL).openStream());
        byte dataBuffer[] = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
            System.out.print(bytesRead);
        }
        // file reader class # 2

    }
}
