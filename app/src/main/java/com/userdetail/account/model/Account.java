/**
 * Model class for Account object
 */
package com.userdetail.account.model;

public class Account {

    private Integer accountBalanceInCents;
    private String accountCurrency;
    private String accountId;
    private String accountName;
    private String accountNumber;
    private String accountType;
    private String alias;
    private String isVisible;
    private String iban;
    private String linkedAccountId;
    private String productName;
    private String productType;
    private Integer savingsTargetReached;
    private Integer targetAmountInCents;

    public Integer getAccountBalanceInCents() {
        return accountBalanceInCents;
    }

    public void setAccountBalanceInCents(Integer accountBalanceInCents) {
        this.accountBalanceInCents = accountBalanceInCents;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(String isVisible) {
        this.isVisible = isVisible;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getLinkedAccountId() {
        return linkedAccountId;
    }

    public void setLinkedAccountId(String linkedAccountId) {
        this.linkedAccountId = linkedAccountId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getSavingsTargetReached() {
        return savingsTargetReached;
    }

    public void setSavingsTargetReached(Integer savingsTargetReached) {
        this.savingsTargetReached = savingsTargetReached;
    }

    public Integer getTargetAmountInCents() {
        return targetAmountInCents;
    }

    public void setTargetAmountInCents(Integer targetAmountInCents) {
        this.targetAmountInCents = targetAmountInCents;
    }

}