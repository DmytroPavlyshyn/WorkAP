package com.pavlyshyn.iofile;

import com.fasterxml.jackson.databind.*;
import com.pavlyshyn.ammunition.Ammunition;

import java.io.*;
import java.util.*;

public class AmmunitionIO  {
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    private File file;

    public AmmunitionIO(String path) {
        this.file = new File(path);
    }

    public List<Ammunition> readFromFile() throws IOException {
        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Ammunition.class));
    }

    public void writeToFile(List<Ammunition> ammunitionList) throws IOException {
        objectMapper.writeValue(file, ammunitionList);
    }
}
