package org.example.ChainOfResponsiblity;

public class FiveHunderedHandler extends MoneyHandler {

    int numberOfNotes;

    FiveHunderedHandler(int numberOfNotes) {
        this.numberOfNotes = numberOfNotes;
    }

    @Override
    public void dispense(int amount) {

        int notesRequired = amount / 500;

        if(notesRequired <= numberOfNotes) {

            System.out.println(
                    "Dispensing " + notesRequired + " Rs:500 notes"
            );

            numberOfNotes -= notesRequired;

            int remainingAmount = amount % 500;

            if(remainingAmount > 0 && nextHandler != null) {
                nextHandler.dispense(remainingAmount);
            }

        } else {

            System.out.println(
                    "Dispensing " + numberOfNotes + " Rs:500 notes"
            );

            int dispensedAmount = numberOfNotes * 500;
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