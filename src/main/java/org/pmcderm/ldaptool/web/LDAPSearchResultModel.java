package org.pmcderm.ldaptool.web;

import java.util.List;

public class LDAPSearchResultModel {
  
  private int entries = -1;
  
  private String error;
  
  private String searchString;
  
  private List<LDAPEntryModel> entriesList;

  public int getEntries() {
    return entries;
  }

  public void setEntries(int entries) {
    this.entries = entries;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getSearchString() {
    return searchString;
  }

  public void setSearchString(String searchString) {
    this.searchString = searchString;
  }

  public List<LDAPEntryModel> getEntriesList() {
    return entriesList;
  }

  public void setEntriesList(List<LDAPEntryModel> entriesList) {
    this.entriesList = entriesList;
  }
}
