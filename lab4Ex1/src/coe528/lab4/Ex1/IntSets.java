/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab4.Ex1;

import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author Deon
 */
public class IntSets {

    //Overview: intSets are unbounded, mutable sets of integers.
    /*
    AF(x)=x.els[i].intValue, where the index is 0<=i<x.else.size
    Rep invariant :
    x.els contains only integers and x.els != null
     */
    private Vector<Integer> els;///the rep

    //constuctor
    public IntSets() {
        //effects:initializes this to be empty.
        els = new Vector<Integer>();
        repOk();
    }

    //methods
    public void insert(int x) {
        //modifies:this
        //effects:adds x to the elemts of this
        Integer y = new Integer(x);
        if (getIndex(y) < 0) {
            els.add(y);
            Collections.sort(this.els);
        }
        repOk();
    }

    public void remove(int x) {
        //Modifies:this
        //effects:Removes x from this.
        int i = getIndex(new Integer(x));
        if (i < 0) {
            return;
        }
        els.set(i, els.lastElement());
        els.remove(els.size() - 1);
        Collections.sort(this.els);
        repOk();
    }

    public boolean isIn(int x) {
        //Effects:returns true if x is in this, else returns false
        return getIndex(new Integer(x)) > 0;

    }

    public int getIndex(Integer x) {
        //effects: if x is in this reutns index where x appears else returns -1.
        for (int i = 0; i < els.size(); i++) {
            if (x.equals(els.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        //effects : returns the cardinality of this.
        return els.size();

    }

    public int choose() throws EmptyException {
        //Effects: if this is empty throws EmptyException else
        // returns an arbitary element of this.

        if (els.isEmpty()) {
            throw new EmptyException("Intset.choose");
        }
        return els.lastElement();

    }

    public boolean repOk() {

        /*Effects :
        *Varifies the vector set is not empty, els!=null 
        *Varifies all elements contained within vector are indeed integers
        *Checks that all elements contained in the vector are sorted in increasing numerical value.
        *Vector may not have any duplicated 
        If anyone of the aformentioned are deemed untrue, false is returned
        
         */
        //Vector cannot be null
        if (els == null) {
            return false;
        }
        //Elements of vector must be of type Integer
        for (Object o : els) {
            if (!(o instanceof Integer)) {
                return false;
            }
            //Values in vector must not be dupicated
            for (Object x : els) {
                if (o.equals(x)) {
                    return false;
                }
            }
        }
        //Numbers in vector must be in numerical order
        for (int i = 0; i < els.size(); i++) {
            for (int j = i++; j < els.size(); j++) {
                if (els.elementAt(i) > els.elementAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        //Effects: Overrides Object class's toString() Method
        String vector = "";
        if (els.size() == 0) {
            return "IntSet: {null}";
        } else {
            for (int i = 0; i < els.size(); i++) {
                vector = vector + " , " + els.elementAt(i).toString();
            }
            return ("Int: {\"Set: { " + vector + " }");
        }

    }

    //Empty Exception class 
    private static class EmptyException extends Exception {

        EmptyException() {
        }

        EmptyException(String s) {
            throw new UnsupportedOperationException("Not implemented yet");
        }
    }

}
