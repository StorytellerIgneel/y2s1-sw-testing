package Application;

// import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import util.*;

import java.io.*;
import java.time.LocalDate;


public class Member {
  // instance variables to be inherited
  private String name;
  private String email;
  private LocalDate birthday;
  //private ArrayList<Booking> bookings;

  // constructor
  public Member(String name, String email, LocalDate birthday) {
    this.name = name;
    this.email = email;
    this.birthday = birthday;
  }

  // getter methods
  public String getName() {
    return name;
  }

  // setter methoids
  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getBirthday(){
    return birthday;
  }

  public void setBirthDay(LocalDate birthday){
    this.birthday = birthday;
  }
  
  //other methods
  public static Member findMember(ArrayList<Member> members, String name) {
	  for(Member member:members) {
		  if(member.name.equals(name))
			  return member;
	  }
	  return null;
  }
}
