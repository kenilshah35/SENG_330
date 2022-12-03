package ca.uvic.seng330.ex4;
/*
* Description: Used to store the Name and email of a Reporter
* who observed the whale and made the observation. This would be used
* if someone would need to know who made the observation and how to contact them
* if there are any questions or concerns regarding the sighting.
*
* Edited: Ryan Hindson V00890116, September 21st 2020
*/

public class Reporter
{
    private final String name;
    private String email;

    public Reporter(String name, String email){
        if( name == null ) {
            name = "";
        }
        if( email == null ) {
            email = "";
        }
        this.name = name ;
        this.email = email ;
    }
    //Return the name of the observer
    public String getName(){
        return name;
    }

    //Return the email of the observer
    public String getEmail(){
        return email;
    }
    //Sets the Email address of the Observer. (
    // If the observer loses access to email it can be then changed to a new address)
    public void setEmail(String email){
        if( email == null ) {
            email = "";
        }
        this.email = email ;
    }
}