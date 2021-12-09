
package com.phonebookAssignment;

import java.util.Optional;
import java.util.stream.Stream;

public class PhoneBookCrawler {

    PhoneBookData phoneBook;


    public PhoneBookCrawler(PhoneBookData phoneBook) {

        this.phoneBook = phoneBook;
    }

    public void findPhoneNumberByNameAndPunishIfNothingFound(String name)  {
        phoneBook.findPhoneNumberByName(name).orElseThrow(() -> new IllegalArgumentException("No phone number found for Punish"));
    }

    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){

        return phoneBook.findPhoneNumberByName(name).orElseGet(()->phoneBook.toString());
    }

    public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber){

        return Stream.of(phoneBook.findPhoneNumberByName(name), phoneBook.findNameByPhoneNumber(phoneNumber), phoneBook.findPhoneNumberByName(name))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst().get();
    }
    public PhoneBookData getPhoneBook(){
        return phoneBook;
    }

}