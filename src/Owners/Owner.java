package Owners;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Owner implements Serializable {
    private String username;
    private String name;
    private Date birthDate;
    private DateFormat dateFormat = new SimpleDateFormat("dd.mm.yy");
    private Address mutualAddress;
    private String[] outputAddress = new String[3];
    private String phoneNumber;
    private String email;

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setBirthDate(String date) {
        try {
            birthDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public String getBirthDate() {
        return dateFormat.format(birthDate);
    }

    public void setMutualAddress(String address) {
        try {
            outputAddress = address.split(",");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please, write it in this format: /n (example) Hlavna 1, 801 01 Bratislava, Slovensko");
        }
        mutualAddress.setStreetAndNum(outputAddress[0]);
        mutualAddress.setCity(outputAddress[1]);
        mutualAddress.setState(outputAddress[2]);
    }
    public Address getMutualAddress() {
        return mutualAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }


    









    private void phoneNumberCheck(String phoneNumber) {
        if (phoneNumber.matches("[0-9 ]+")) {
            char firstChar = phoneNumber.charAt(0);

            if (phoneNumber.length() == 10) {
                if (firstChar != '0') {
                    System.out.println("Invalid format. \"0\" must be first");
                }
            } else if (phoneNumber.length() == 13) {
                if (firstChar != '+') {
                    System.out.println("Invalid format. \"+\" must be first");
                }
            } else {
                System.out.println("Invalid length");
            }
        } else {
            System.out.println("Invalid characters");
        }
    }

    private void emailCheck(String usersEmail) {
        int count = 0;

        if(!(usersEmail.length()>3 && usersEmail.length()<40)) {
            System.out.println("Inavlid length of email");
        }

        if(email.contains("@")){
            int a = email.indexOf("@");

            for(int i=a; i<usersEmail.length(); i++){
                if(email.charAt(i)=='.'){
                    count += 1;
                }
            }
            if(count != 1){
                System.out.println("Invalid position of special characters");
            }
        } else{
            System.out.println("No \"@\" symbol present");
        }

        if(!(email.matches("[a-z _]+@.*"))) {
            System.out.println("Invalid characters");
        }

    }
}