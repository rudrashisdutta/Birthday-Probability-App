package com.rudrashisdutta.birthdayprobability.ui;
public interface OutputInterface {
    int getSize();
    int getCount();
    void print(String text);
    void print(char _char);
    void println(String text);
    void println(char _char);
    void resetText();
    void log(String logText);
    void makeAlertToast(String alertText);
}
