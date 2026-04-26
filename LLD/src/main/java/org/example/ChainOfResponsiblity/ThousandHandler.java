package org.example.ChainOfResponsiblity;

public class ThousandHandler extends MoneyHandler {

    int numberOfNotes;

    ThousandHandler(int numberOfNotes) {
        this.numberOfNotes = numberOfNotes;
    }

    @Override
    public void dispense(int amount) {

        int notesRequired = amount / 1000;

        if(notesRequired <= numberOfNotes) {
            // enough notes available
            System.out.println("Dispensing " + notesRequired + " Rs:1000 notes");
            numberOfNotes -= notesRequired;

            int remainingAmount = amount % 1000;

            if(remainingAmount > 0 && nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            }
        }
        else {
            // dispense all available notes
            System.out.println("Dispensing " + numberOfNotes + " Rs:1000 notes");

            int dispensedAmount = numberOfNotes * 1000;
            int remainingAmount = amount - dispensedAmount;

            numberOfNotes = 0;

            if(nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            }
            else {
                System.out.println("Remaining Amount " + remainingAmount + " cannot be fulfilled");
            }
        }
    }
}