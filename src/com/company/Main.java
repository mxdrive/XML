package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

public class Main {

    public static void main(String[] args) {


        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bworkername = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    if (qName.equalsIgnoreCase("worker")) {
                        if (attributes.getValue("id").equalsIgnoreCase("1")) {
                            bworkername = true;
//                            System.out.println(attributes.getValue("id"));
                        }
                    }
                }

                public void characters(char[] chars, int start, int length) {
                    if (bworkername) {
                        System.out.println("Worker name: " + new String(chars, start, length));
                        bworkername = false;
                    }
                }
            };

            File file = new File("/home/developer/company.xml");
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            InputSource inputSource = new InputSource(reader);
            inputSource.setEncoding("UTF-8");

            parser.parse(inputSource, handler);
        } catch ( ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}