package org.pmcderm.ldaptool.web;

public class LDAPBindModel {
  
  private String host;
  
  private int port;
  
  private String DNString;
  
  private String password;
  
  private String errorMessage;
  
  private boolean bindSuccessful;

  private String resultCodeName;

  public String getDNString() {
    return DNString;
  }

  public void setDNString(String dNString) {
    DNString = dNString;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public boolean isBindSuccessful() {
    return bindSuccessful;
  }

  public void setBindSuccessful(boolean bindSuccessful) {
    this.bindSuccessful = bindSuccessful;
  }

  public String getResultCodeName() {
    return resultCodeName;
  }

  public void setResultCodeName(String resultCodeName) {
    this.resultCodeName = resultCodeName;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
  

}
