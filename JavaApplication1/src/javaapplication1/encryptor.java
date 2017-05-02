/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Arinn
 */
public class encryptor {String full = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    ArrayList<String> decription = new ArrayList<>();
    public int key;
    public String keystr;
    int tmp = 0;
    int tmp3 = 0;
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("windows-1251")));
    public void alphabetcreate() throws IOException {  
        keystr = reader.readLine();
        for(int j=0;j<10;j++){
            if(keystr.contains(String.valueOf(j))){
                System.out.println("Введите нужный ключ");
                
            }
        }
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        try{
            key = sc.nextInt();
        }
        catch(Exception ex){
            System.out.println("Введите нужный ключ");
        }
        System.out.println("*-*");
        for (int i = 0; i < keystr.length(); i++) {
            String part1 = full.split(String.valueOf(keystr.charAt(i)))[1];
            String part2 = full.split(String.valueOf(keystr.charAt(i)))[0];
            decription.add(keystr.charAt(i) + part1 + part2);
        }
    }

    public String encrypt() throws IOException {
        String param = reader.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < param.length(); i++) {
            sb.append(encchar(String.valueOf(Character.toLowerCase(param.charAt(i))),i));
        }
        
        return sb.toString();
        
    }
    public String decrypt() throws IOException{
                String param = reader.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < param.length(); i++) {
            sb.append(decchar(String.valueOf(Character.toLowerCase(param.charAt(i))),i));
        }
        return sb.toString();
    }

    public String encchar(String enc,int num) {
        if(!full.contains(enc)){
            tmp -=1;
            return enc;
        }
        else{
            String tmp1 = decription.get((num+tmp) % key);
            return(String.valueOf(tmp1.charAt(full.indexOf(enc))));
        }
    }
    public String decchar(String enc,int num){
        String tmp1 = decription.get((num+tmp3) % key);
        if(!tmp1.contains(enc)){
            tmp3 -=1;
            return enc;
        }
        else{
        return(String.valueOf(full.charAt(tmp1.indexOf(enc))));
        }
        
    }
}
