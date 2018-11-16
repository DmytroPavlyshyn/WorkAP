package com.pavlyshyn.iofile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pavlyshyn.ammunition.Ammunition;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class AmmunitionWriter {
    private  static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }
    private File file;
    public AmmunitionWriter(String path) {
        this.file = new File(path);
    }
    public void writeToFile (List<Ammunition> ammunitionList) throws IOException {
        objectMapper.writeValue(file,ammunitionList);
    }
}
