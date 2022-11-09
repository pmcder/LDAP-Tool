package org.pmcderm.ldaptool.utils;

import java.util.ArrayList;
import java.util.List;

import org.pmcderm.ldaptool.web.LDAPEntryModel;

import com.unboundid.ldap.sdk.DN;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResultEntry;

public class LDAPUtils {
  

  public LDAPUtils() {
    // TODO Auto-generated constructor stub
  }
  
  /**
   * Maps list of SearchResultEntry objects into list of LDAPEntryModel objects
   * @param searchResultEntries
   * @return List of LDAPEntryModel objects
   */
  public static List<LDAPEntryModel> mapEntriesToModel(List<SearchResultEntry> searchResultEntries) {
    
    List<LDAPEntryModel>LDAPEntryList = new ArrayList<LDAPEntryModel>();
    
    searchResultEntries.stream().forEach(e->{
      LDAPEntryModel entryModel = new LDAPEntryModel();
      entryModel.setLDIFString(e.toLDIFString());
      LDAPEntryList.add(entryModel);
    });
    
    return LDAPEntryList;
  }
  
 
 

}
