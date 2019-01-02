package com.wen.aop.example.data.json;

/**
 * 封装token类来存储每一个token对应的值
 * @author admin
 * @date 2018-12-24 17:07
 */
public class Token {
    private TokenType tokenType;
    private String value;

    public Token(TokenType tokenType,String value){
        this.tokenType =tokenType;
        this.value=value;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenType=" + tokenType +
                ", value='" + value + '\'' +
                '}';
    }
}
