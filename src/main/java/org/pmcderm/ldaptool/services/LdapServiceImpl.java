package org.pmcderm.ldaptool.services;

import java.util.List;

import org.pmcderm.ldaptool.utils.LDAPUtils;
import org.pmcderm.ldaptool.web.LDAPEntryModel;
import org.pmcderm.ldaptool.web.LDAPSearchModel;
import org.pmcderm.ldaptool.web.LDAPSearchResultModel;
import org.springframework.stereotype.Service;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchScope;
import com.unboundid.ldap.sdk.Entry;

@Service
public class LdapServiceImpl implements LdapService {
  
  private final LDAPConnection ldapConn;
  
  private String host;
  
  private int port = -1;

  public LdapServiceImpl() {
   this.ldapConn = new LDAPConnection();
  }
   
  @Override
  public Entry add() {
    
    Entry entry = null;
    
    try {
      this.ldapConn.connect(this.host, this.port);
//      entry.setDN();
      //this.ldapConn.add(addRequest);
     ;
      
    }
    catch (LDAPException le) {
      
    }
    catch (Exception e) {
      
    }
    return entry;
  }

  @Override
  public LDAPSearchResultModel search(LDAPSearchModel ls) {
      
    LDAPSearchResultModel ldapSearchResult = new LDAPSearchResultModel();
    
    this.host = ls.getHost();
    this.port = ls.getPort();
    
    try {
   
      this.ldapConn.connect(this.host, this.port);
      
      SearchRequest searchRequest = new SearchRequest(ls.getBaseDN(),SearchScope.SUB,ls.getFilter(),ls.getAttributes());
      SearchResult searchResult = this.ldapConn.search(searchRequest);
      
      //TODO move into mapper
      ldapSearchResult.setEntries(searchResult.getEntryCount());
      ldapSearchResult.setSearchString(searchRequest.toString());
      List<LDAPEntryModel> entriesList = LDAPUtils.mapEntriesToModel(searchResult.getSearchEntries());
      ldapSearchResult.setEntriesList(entriesList);
         
    }
    catch (LDAPException le) {
      ldapSearchResult.setError(le.getMessage());
    }
    catch (Exception e) {
      ldapSearchResult.setError(e.getMessage());
    }
    return ldapSearchResult;
  }

  @Override
  public void delete() {
    // TODO Auto-generated method stub
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
