package com.robsonteam.wyjatki;

public class CoreSystemMissException extends Exception
{
    public CoreSystemMissException(String errorDescription)
    {
        super("System module fail: " + errorDescription);
    }

    public CoreSystemMissException() {
    }
}
