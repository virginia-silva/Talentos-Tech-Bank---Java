package Aula19;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("inserts.sql", true);
        BufferedWriter bw = new BufferedWriter(fw);


        for (int i =17; i<20_018; i++) {
            System.out.printf("INSERT INTO aluno values(%d, 'Aretha', 20, 1, 1);\n", i);
        }
    }
}
