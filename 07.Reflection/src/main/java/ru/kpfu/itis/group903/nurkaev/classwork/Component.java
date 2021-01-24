package ru.kpfu.itis.group903.nurkaev.classwork;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Classwork
 */

public class Component {

    public final static String staticField = "FINAL";
    private final int privateField;
    public int publicField;

    public Component() {
        this.privateField = 10;
        this.publicField = 10;
    }

    public Component(int publicField, int privateField) {
        this.publicField = publicField;
        this.privateField = privateField;
    }

    public static int methodWithArgs(int a, int b, int c) {
        return a + b + c;
    }

    public int getPublicField() {
        return publicField;
    }

    public int getPrivateField() {
        return privateField;
    }

    public void publicMethod() {
        System.out.println(privateField + " " + publicField);
    }

    private boolean privateMethod() {
        return this.privateField == this.publicField;
    }

    public int getSumOfFields(int a) {
        return a + this.privateField + this.publicField;
    }
}
