package com.Phonebook.modells;


import org.testng.annotations.DataProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> regWithCheckValidEmail() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/regCheckValidEmail.csv")));
        String line = reader.readLine();
        while(line!=null) {


            String[] split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();

    }
    @DataProvider
    public Iterator<Object[]> regWithCheckValidPassword() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader
                (new File("src/test/resources/regCheckValidPassword.csv")));
        String line = reader.readLine();
        while(line!=null) {


            String[] split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();

    }


}
