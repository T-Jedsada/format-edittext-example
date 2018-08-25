package com.example.formatnumberexample;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class UserIdTextWatcher implements TextWatcher {

    private EditText editText;

    UserIdTextWatcher(EditText edTxtPhone) {
        this.editText = edTxtPhone;
    }

    @Override
    public void onTextChanged(CharSequence s, int cursorPosition, int before, int count) {
        if (before == 0 && count == 1) {
            String val = s.toString();
            String a;
            String b = "";
            String c = "";
            if (val.length() > 0) {
                val = val.replace("-", "");
                if (val.length() >= 4) {
                    a = val.substring(0, 4);
                } else {
                    a = val.substring(0, val.length());
                }
                if (val.length() > 4) {
                    b = val.substring(4, val.length());
                }
                StringBuilder stringBuffer = new StringBuilder();
                if (a.length() > 0) {
                    stringBuffer.append(a);

                }
                if (b.length() > 0) {
                    stringBuffer.append("-");
                    stringBuffer.append(b);
                }
                if (c.length() > 0) {
                    stringBuffer.append("-");
                    stringBuffer.append(c);
                }
                editText.removeTextChangedListener(this);
                editText.setText(stringBuffer.toString());
                if (cursorPosition == 4) {
                    cursorPosition = cursorPosition + 2;
                } else {
                    cursorPosition = cursorPosition + 1;
                }
                if (cursorPosition <= editText.getText().toString().length()) {
                    editText.setSelection(cursorPosition);
                } else {
                    editText.setSelection(editText.getText().toString().length());
                }
                editText.addTextChangedListener(this);
            } else {
                editText.removeTextChangedListener(this);
                editText.setText("");
                editText.addTextChangedListener(this);
            }
        }

        if (before == 1 && count == 0) {
            String val = s.toString();
            String a;
            String b = "";
            String c = "";

            if (val.length() > 0) {
                val = val.replace("-", "");
                if (cursorPosition == 4) {
                    val = removeCharAt(val, cursorPosition - 1, s.toString().length() - 1);
                }
                if (val.length() >= 4) {
                    a = val.substring(0, 4);
                } else {
                    a = val.substring(0, val.length());
                }
                if (val.length() > 4) {
                    b = val.substring(4, val.length());
                }
                StringBuilder stringBuffer = new StringBuilder();
                if (a.length() > 0) {
                    stringBuffer.append(a);

                }
                if (b.length() > 0) {
                    stringBuffer.append("-");
                    stringBuffer.append(b);

                }
                if (c.length() > 0) {
                    stringBuffer.append("-");
                    stringBuffer.append(c);
                }
                editText.removeTextChangedListener(this);
                editText.setText(stringBuffer.toString());
                if (cursorPosition == 4) {
                    cursorPosition = cursorPosition - 1;
                }
                if (cursorPosition <= editText.getText().toString().length()) {
                    editText.setSelection(cursorPosition);
                } else {
                    editText.setSelection(editText.getText().toString().length());
                }
                editText.addTextChangedListener(this);
            } else {
                editText.removeTextChangedListener(this);
                editText.setText("");
                editText.addTextChangedListener(this);
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    private static String removeCharAt(String s, int pos, int length) {
        String value = "";
        if (length > pos) value = s.substring(pos + 1);
        return s.substring(0, pos) + value;
    }
}