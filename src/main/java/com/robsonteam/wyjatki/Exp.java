package com.robsonteam.wyjatki;

public class Exp extends Exception
{
    public Exp(String errorDescription)
    {
        super("Wyjątek: " + errorDescription);
    }

    public Exp() {
    }
}
