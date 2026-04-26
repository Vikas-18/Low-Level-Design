package org.example.ChainOfResponsiblity;

public class HundredHandler extends MoneyHandler {

    int numberOfNotes;

    HundredHandler(int numberOfNotes) {
        this.numberOfNotes = numberOfNotes;
    }

    @Override
    public void dispense(int amount) {

        int notesRequired = amount / 100;

        if(notesRequired <= numberOfNotes) {

            System.out.println(
                    "Dispensing " + notesRequired + " Rs:100 notes"
            );

            numberOfNotes -= notesRequired;

            int remainingAmount = amount % 100;

            if(remainingAmount > 0 && nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            }
            else if(remainingAmount > 0) {
                System.out.println(
                        "Remaining Amount " +
                                remainingAmount +
                                " cannot be fulfilled"
                );
            }

        } else {

            System.out.println(
                    "Dispensing " + numberOfNotes + " Rs:100 notes"
            );

            int dispensedAmount = numberOfNotes * 100;
            int remainingAmount = amount - dispensedAmount;

            numberOfNotes = 0;

            if(nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            } else {
                System.out.println(
                        "Remaining Amount " +
                                remainingAmount +
                                " cannot be fulfilled"
                );
            }
        }
    }
}