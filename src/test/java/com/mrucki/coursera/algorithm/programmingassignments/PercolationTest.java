package com.mrucki.coursera.algorithm.programmingassignments;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class PercolationTest {

    @Test
    public void testPercolates() throws Exception {
        assertFalse(compute("greeting57.txt"));
        assertTrue(compute("input3.txt"));
        assertTrue(compute("input10.txt"));
        assertTrue(compute("input20.txt"));
        assertTrue(compute("jerry47.txt"));
    }

    private boolean compute(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\marek_rucki@epam.com\\IdeaProjects\\coursera-algorithm\\src\\main\\resources\\percolation\\" + fileName));

        int percolationSize = Integer.parseInt(lines.get(0));
        Percolation percolation = new Percolation(percolationSize);

        for (int i = 1; i < lines.size(); i++) {
            if(lines.get(i) == null || lines.get(i).equals("")) {
                continue;
            }

            String[] coordinates = lines.get(i).trim().split("\\s{1,}");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);

            percolation.open(x, y);
        }

        boolean percolates = percolation.percolates();
        System.out.println(fileName+", "+ percolates);

        return percolates;
    }
}