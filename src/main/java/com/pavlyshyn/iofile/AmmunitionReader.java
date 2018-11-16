package com.pavlyshyn.iofile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavlyshyn.ammunition.Ammunition;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AmmunitionReader {
    private  static ObjectMapper objectMapper = new ObjectMapper();
    private File file;
    public AmmunitionReader(String path) {
        this.file = new File(path);
    }
//    public List<Ammunition> readFromFile() throws IOException {
//        return objectMapper.readValue(file, ArrayList<Ammunition>.getClass());
//    }
}
