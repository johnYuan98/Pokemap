package edu.frostburg.cosc310.projects.hashmap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main implements Pokedex {

    Scanner input = new Scanner(System.in);
    HashTable hashTable = new HashTable(900);

    @Override
    public String find(String pokemon) {
        DataItem dataItem = hashTable.find(pokemon);
        if (dataItem == null) {
            return "";
        } else {
            return dataItem.toString();
        }
    }

    @Override
    public boolean add(String pokemon, String entry) {
        String[] arr = entry.split(",");
        DataItem dataItem = new DataItem(arr[0], arr[1], arr[2], arr[3], arr[4], pokemon, arr[5], arr[6], arr[7], arr[8], arr[9], arr[10]);
        boolean rs = hashTable.insert(dataItem);
        return rs;
    }

    @Override
    public boolean delete(String pokemon) {
        return hashTable.delete(pokemon);
    }

    @Override
    public void printHT() {
        hashTable.displayTable();
    }

    @Override
    public double getLoadFactor() {
        return hashTable.returnLoadFactor();
    }

    @Override
    public double getMaxLoadFactor() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        return hashTable.getArraySize();
    }

    /*
     * Print my name
     */
    @Override
    public void who() {
        System.out.println("Junhu Yuan");
    }

    /*
     * Print these commands
     */
    @Override
    public void help() {
        System.out.println("You can execute the following commands:");
        System.out.println("1.add - insert an entry into the table");
        System.out.println("2.delete - remove an entry");
        System.out.println("3.find - If the user enters a pokemon name,print out its entry");
        System.out.println("4.printHT - Print the entire table");
        System.out.println("5.who - Print my name");
        System.out.println("6.help - Print these commands");
        System.out.println("7.exit - Quit my program");
    }

    /*
     * Quit program
     */
    @Override
    public void exit() {
        System.out.println("bye bye!");
        System.exit(0);
    }

    public void init() {
        //read the input file
        File inputFile = new File("pokemon_pokedex_alt.csv");
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            while ((line = reader.readLine()) != null) {

                String[] value = line.split(cvsSplitBy);
                //insert every entry to hash table
                String japanese_name = new String(value[4].getBytes(), "utf-8");
                boolean flag = true;
                if (value.length == 9) {
                    DataItem dataItem = new DataItem(value[0], value[1], value[2], value[3], japanese_name, value[5], value[6], value[7], value[8], "", "", "");
                    flag = hashTable.insert(dataItem);
                } else if (value.length == 10) {
                    DataItem dataItem = new DataItem(value[0], value[1], value[2], value[3], japanese_name, value[5], value[6], value[7], value[8], value[9], "", "");
                    flag = hashTable.insert(dataItem);
                } else if (value.length == 11) {
                    DataItem dataItem = new DataItem(value[0], value[1], value[2], value[3], japanese_name, value[5], value[6], value[7], value[8], value[9], value[10], "");
                    flag = hashTable.insert(dataItem);
                } else {
                    DataItem dataItem = new DataItem(value[0], value[1], value[2], value[3], japanese_name, value[5], value[6], value[7], value[8], value[9], value[10], value[11]);
                    flag = hashTable.insert(dataItem);
                }
                if (!flag) {
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist!");
        } catch (IOException e) {
            System.out.println("Error reading file!");
        }

        //repeatedly ask the user to input one of the following commands
        try {
            show();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void show() throws Exception {
        System.out.println("=============================");
        System.out.println("You can execute the following commands:");
        System.out.println("1.add");
        System.out.println("2.delete");
        System.out.println("3.find");
        System.out.println("4.printHT");
        System.out.println("5.who");
        System.out.println("6.help");
        System.out.println("7.exit");
        System.out.println("Please select serial number input according to the command to be executed.");
        Scanner sc = new Scanner(System.in);
        int options = sc.nextInt();
        switch (options) {
            case 1:
                System.out.println("Please enter the name of the Pokemon");
                String name = input.next();
                System.out.println("Please enter abilities,for example ['Overgrow','Chloropyll']");
                String abilities = input.next();
                System.out.println("Please enter attack");
                int attack = input.nextInt();
                System.out.println("Please enter classfication");
                String classfication = input.next();
                System.out.println("Please enter defense");
                int defense = input.nextInt();
                System.out.println("Please enter hp");
                int hp = input.nextInt();
                System.out.println("Please enter japanese_name");
                String japanese_name = input.next();
                System.out.println("Please enter pokedex_number");
                int pokedex_number = input.nextInt();
                System.out.println("Please enter sp_attack");
                int sp_attack = input.nextInt();
                System.out.println("Please enter sp_defense");
                int sp_defense = input.nextInt();
                System.out.println("Please enter speed");
                String speed = input.next();
                System.out.println("Please enter type1");
                String type1 = input.next();
                System.out.println("Please enter type2");
                String type2 = input.next();

                String entry = abilities + "," + attack + "," + classfication + "," + defense + "," + hp + "," + japanese_name + "," + pokedex_number + "," + sp_attack + "," + sp_defense + "," + speed + "," + type1 + "," + type2;
                boolean rs = add(name, entry);
                if (rs) {
                    System.out.println("Add Success");
                } else {
                    System.out.println("Add Fail");
                }
                break;
            case 2:
                System.out.println("Please enter the name of the Pokemon you want to delete.");
                String deleteName = input.next();
                if (deleteName.length() == 0) {
                    System.out.println("The name of Pokemon cannot be empty.");
                } else {
                    boolean flag = delete(deleteName);
                    if (flag) {
                        System.out.println("Delete Success");
                    } else {
                        System.out.println("Delete Fail");
                    }
                }
                break;
            case 3:
                System.out.println("Please enter the name of the Pokemon");
                String findName = input.next();
                if (findName.length() == 0) {
                    System.out.println("The name of Pokemon cannot be empty.");
                } else {
                    String findResult = find(findName);
                    if (findResult.equals("")) {
                        System.out.println("no find");
                    } else {
                        System.out.println("Find Result:");
                        System.out.println(findResult);
                    }
                }
                break;
            case 4:
                printHT();
                break;
            case 5:
                who();
                break;
            case 6:
                help();
                break;
            case 7:
                exit();
                break;
        }
        try {
            show();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
