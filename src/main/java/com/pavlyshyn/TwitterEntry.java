package com.pavlyshyn;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwitterEntry
{
    long _id;
    String _text;
    int _fromUserId, _toUserId;
    String _languageCode;

    public TwitterEntry() { }

    public void setId(long id) { _id = id; }
    public void setText(String text) { _text = text; }
    public void setFromUserId(int id) { _fromUserId = id; }
    public void setToUserId(int id) { _toUserId = id; }
    public void setLanguageCode(String languageCode) { _languageCode = languageCode; }

    public long getId() { return _id; }
    public String getText() { return _text; }
    public int getFromUserId() { return _fromUserId; }
    public int getToUserId() { return _toUserId; }
    public String getLanguageCode() { return _languageCode; }

    public String toString() {
        return "[Tweet, id: "+_id+",\n text='"+_text+"',\n from: "+_fromUserId+",\n to: "+_toUserId+",\n lang: "+_languageCode+"]";
    }
}

class Main{
    static TwitterEntry read(JsonParser jp) throws IOException
    {
        // Sanity check: verify that we got "Json Object":
        if (jp.nextToken() != JsonToken.START_OBJECT) {
            throw new IOException("Expected data to start with an Object");
        }
        TwitterEntry result = new TwitterEntry();
        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jp.getCurrentName();
            // Let's move to value
            jp.nextToken();
            if (fieldName.equals("id")) {
                result.setId(jp.getLongValue());
            } else if (fieldName.equals("text")) {
                result.setText(jp.getText());
            } else if (fieldName.equals("fromUserId")) {
                result.setFromUserId(jp.getIntValue());
            } else if (fieldName.equals("toUserId")) {
                result.setToUserId(jp.getIntValue());
            } else if (fieldName.equals("languageCode")) {
                result.setLanguageCode(jp.getText());
            } else { // ignore, or signal error?
                throw new IOException("Unrecognized field '"+fieldName+"'");
            }
        }
        jp.close(); // important to close both parser and underlying File reader
        return result;
    }
    public static void main(String[] args) {
        JsonFactory jsonF = new JsonFactory();
//        try {
//
//            JsonParser jp = jsonF.createJsonParser(new );//createJsonParser(new File("input.json"));
//            TwitterEntry entry = read(jp);
//            System.out.println(entry);
//        }catch (Exception e){
//            System.err.println(e);
//        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TwitterEntry twitterEntry = objectMapper.readValue(new File("123.json"), TwitterEntry.class);
            System.out.println(twitterEntry);
        }catch (Exception e){
            System.err.println(e);
        }
    }
}