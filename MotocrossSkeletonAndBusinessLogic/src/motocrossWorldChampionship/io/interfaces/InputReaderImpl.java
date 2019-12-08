package motocrossWorldChampionship.io.interfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputReaderImpl implements InputReader {
    @Override
    public String readLine() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        return bf.readLine();
    }
}
