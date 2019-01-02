package com.wen.aop.example.data.json;

/**
 * @author admin
 * @date 2018-12-24 17:02
 */
public enum TokenType {
    BEGIN_OBJECT(1),
    END_OBJECT(2),
    BEGIN_ARRAY(4),
    END_ARRAY(8),
    NULL(16),
    NUMBER(32),
    STRING(64),
    BOOLEAN(128),
    SPE_COLON(256),
    SEP_COMMA(512),
    END_DOCUMENT(1024);

    private int code;

    TokenType(int code){
        this.code=code;
    }

    public int getTokenType(){
        return code;
    }


}
