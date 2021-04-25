package syberry.academy.test.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestAssignment {

    private final HashMap<String, List<List>> list;

    private final Scanner scanner;

    public TestAssignment() {
        list = new HashMap<>();
        scanner = new Scanner(System.in);


    }

    protected void input() {
        while (true) {
            System.out.println("enter matrix NAME=[x11 x12 ... x1n; x21 x22 ... x2n;...,xm1 xm2 ... xmm]");
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            createMatrix(line);
        }
        System.out.println("enter the equation:");
        String line = scanner.nextLine();
        readEquation(line);

    }

    private void readEquation(String line) {
        int i = 0;
        while (true) {

            Matcher matcher = Pattern.compile("([A-Z]|[0-100]+)[*]([A-Z]|[0-100]+)").matcher(String.valueOf(line));
            if (matcher.find()) {

                String example = matcher.group();
                list.put(String.valueOf(i), multip(list.get(example.substring(0, 1)), list.get(example.substring(2))));
                String a = String.valueOf(example.charAt(0));
                line = line.replaceAll(example.charAt(0) + "\\*" + example.charAt(2), String.valueOf(i));
                i++;
                continue;

            }
            matcher = Pattern.compile("([A-Z]|[0-100]+)[+]([A-Z]|[0-100]+)").matcher(String.valueOf(line));
            if (matcher.find()) {
                String example = matcher.group();
                list.put(String.valueOf(i), sum(list.get(example.substring(0, 1)), list.get(example.substring(2))));
                String a = String.valueOf(example.charAt(0));
                line = line.replaceAll(example.charAt(0) + "\\+" + example.charAt(2), String.valueOf(i));
                i++;
                continue;

            }
            matcher = Pattern.compile("([A-Z]|[0-100]+)[-]([A-Z]|[0-100]+)").matcher(String.valueOf(line));
            if (matcher.find()) {
                String example = matcher.group();
                list.put(String.valueOf(i), sum(list.get(example.substring(0, 1)), list.get(example.substring(2))));
                String a = String.valueOf(example.charAt(0));
                line = line.replaceAll(example.charAt(0) + "-" + example.charAt(2), String.valueOf(i));
                i++;
                continue;

            } else {
                break;
            }


        }
        System.out.println(list.get(String.valueOf(i-1)));
    }

    private void createMatrix(String line) {
        Matcher checkName = Pattern.compile("[a-z]").matcher(String.valueOf(line.charAt(0)));

        if (checkName.find()) {
            System.out.println("Exception caught: IllegalArgumentException. Can't read matrix");
            return;
        }
        Matcher findMatrix = Pattern.compile("(?<=\\[)([\\s\\S]+?)(?=])").matcher(line);
        String[] splitLine = new String[1];
        while (findMatrix.find()) {
            splitLine = findMatrix.group().split(";");
        }
        List<List> matrix = new ArrayList<List>();

        for (String element : splitLine) {
            List<Integer> list = new ArrayList<>();
            String[] split = element.split(" ");
            for (String el : split) {
                Matcher findExepcion = Pattern.compile("\\D").matcher(el);
                if (findExepcion.find()) {
                    System.out.println("Exception caught: IllegalArgumentException. Can't read matrix");
                    return;
                }
                Matcher matcher = Pattern.compile("\\d+").matcher(el);
                if (matcher.find()) {
                    list.add(Integer.parseInt(matcher.group()));
                }

            }
            matrix.add(List.copyOf(list));

        }
        list.put(String.valueOf(line.charAt(0)), List.copyOf(matrix));


    }

    private List<List> sum(List<List> a, List<List> b) {
        checkSize(a,b);
        List<List> resul = new ArrayList<>();
        for (int i = 0; i < a.size() & i < b.size(); i++) {
            List<Integer> sum = new ArrayList<>();
            if (a.get(i).size() > b.get(i).size() | a.get(i).size() == b.get(i).size()) {
                for (int j = 0; j < a.get(i).size(); j++) {
                    sum.add((Integer) a.get(i).get(j));
                }
            }
            if (a.get(i).size() < b.get(i).size()) {
                for (int j = 0; j < b.get(i).size(); j++) {
                    sum.add((Integer) b.get(i).get(j));
                }
            }
            for (int j = 0; j < a.get(i).size() & j < b.get(i).size(); j++) {
                sum.set(j, (Integer) (a.get(i).get(j)) + (Integer) (b.get(i).get(j)));
            }
            resul.add(List.copyOf(sum));
        }

        return resul;
    }

    private List<List> sub(List<List> a, List<List> b) {
        checkSize(a,b);
        List<List> resul = new ArrayList<>();
        for (int i = 0; i < a.size() & i < b.size(); i++) {
            List<Integer> sum = new ArrayList<>();
            if (a.get(i).size() > b.get(i).size() | a.get(i).size() == b.get(i).size()) {
                for (int j = 0; j < a.get(i).size(); j++) {
                    sum.add((Integer) a.get(i).get(j));
                }
            }
            if (a.get(i).size() < b.get(i).size()) {
                for (int j = 0; j < b.get(i).size(); j++) {
                    sum.add((Integer) b.get(i).get(j));
                }
            }
            for (int j = 0; j < a.get(i).size() & j < b.get(i).size(); j++) {
                sum.set(j, (Integer) (a.get(i).get(j)) - (Integer) (b.get(i).get(j)));
            }
            resul.add(List.copyOf(sum));
        }
        return resul;
    }

    private List<List> multip(List<List> a, List<List> b) {
        checkSize(a,b);
        List<List> resul = new ArrayList<>();
        for (int i = 0; i < a.size() & i < b.size(); i++) {
            List<Integer> sum = new ArrayList<>();
            if (a.get(i).size() > b.get(i).size() | a.get(i).size() == b.get(i).size()) {
                for (int j = 0; j < a.get(i).size(); j++) {
                    sum.add((Integer) a.get(i).get(j));
                }
            }
            if (a.get(i).size() < b.get(i).size()) {
                for (int j = 0; j < b.get(i).size(); j++) {
                    sum.add((Integer) b.get(i).get(j));
                }
            }
            for (int j = 0; j < a.get(i).size() & j < b.get(i).size(); j++) {
                sum.set(j, (Integer) (a.get(i).get(j)) * (Integer) (b.get(i).get(j)));
            }
            resul.add(List.copyOf(sum));
        }


        return resul;

    }
    private void checkSize(List<List> a, List<List> b){
        if (a.size()!=b.size()){
            System.out.println("Exception caught: IllegalArgumentException. Can't perform multiplication.");
            System. exit(0);


        }

    }
}

//A=[2 2 3;1 1 1;2 1 3]
//B=[1 1 1;1 1 3;1 3 1]
//C=[4 -4 4;0 0 0;-1 -1 -1]
//R=[1 2 2; 2 4 5 6 7]
//A+B*B
//A+A+B*B*A-B;
//A+A+A+B*C-A*B+B*C