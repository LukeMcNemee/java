/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import org.apache.commons.csv.*;
import org.apache.commons.lang3.StringEscapeUtils;


/**
 *
 * @author lukemcnemee
 */
public class Message {

    private MessageType type;
    private String author;
    private String text;

    private String message;

    public Message(MessageType type, String author) {
        this.type = type;
        this.author = author;
        message = type.toString() + "," + StringEscapeUtils.escapeCsv(author) + ",,";
    }

    public Message(MessageType type, String author, String text) {
        this.type = type;
        this.author = author;
        this.text = text;
        
        message = type.toString() + "," + StringEscapeUtils.escapeCsv(author) + "," + StringEscapeUtils.escapeCsv(text) + ",";
    }

    public Message(String message) throws IOException {
        this.message = message;
        Reader in = new StringReader(message);
        CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT);
        List<CSVRecord> list = parser.getRecords();
        
        type = MessageType.valueOf(list.get(0).toString());
        author = list.get(1).toString();
        if (type == MessageType.TEXT) {
            text = list.get(2).toString();
        }
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
