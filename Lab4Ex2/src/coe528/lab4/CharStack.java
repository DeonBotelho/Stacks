/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package coe528.lab4;

/**
 *
 * @author Deon
 */
public class CharStack {

    /**
     * Implementation of a first-in, last-out stack. *
     */
    // Abstraction function:
    // Abstraction function: for n elements in a stack, rep = 1, 2 ... n. The top of the stack is n-1
    // Rep Invariant: -1 <= topOfStack < stackArray.length and stackArray != null. 
    // Instance variables
    private char[] stackArray;// The array implementing the stack.
    private int topOfStack;    // The top of the stack.

    // Static variable
    private static int counter;

    //Constructor now increments the counter for each object created.
    public CharStack(int capacity) {
        stackArray = new char[capacity];
        topOfStack = -1;
        counter++;
        RepOK();
    }

    // Instance methods
    public void push(char element) {
        stackArray[++topOfStack] = element;
        RepOK();
    }

    public char pop() {
        RepOK();
        return stackArray[topOfStack--];
    }

    public char peek() {

        return stackArray[topOfStack];
    }

    public boolean isEmpty() {
        return topOfStack < 0;
    }

    public boolean isFull() {
        return topOfStack == stackArray.length - 1;
    }

    public boolean RepOK() {
        // EFFECTS: Returns true if the rep invariant holds for this; 
        //otherwise returns false

        //Stack cannot be empty
        if (this.stackArray == null) {
            return false;
        }
        //Stack must contain elemtents, thus longer than pointer
        if (stackArray.length <= topOfStack) {
            return false;
        }
        //Stack must contain elements, -1 represents an empty stack
        if (topOfStack < -1) {
            return false;
        }
        return true;
    }
}
