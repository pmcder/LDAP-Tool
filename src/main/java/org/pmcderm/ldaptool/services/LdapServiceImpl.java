package org.pmcderm.ldaptool.services;

import java.util.List;

import org.pmcderm.ldaptool.utils.LDAPUtils;
import org.pmcderm.ldaptool.web.LDAPBindModel;
import org.pmcderm.ldaptool.web.LDAPEntryModel;
import org.pmcderm.ldaptool.web.LDAPSearchModel;
import org.pmcderm.ldaptool.web.LDAPSearchResultModel;
import org.springframework.stereotype.Service;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchScope;
import com.unboundid.ldap.sdk.SimpleBindRequest;
import com.unboundid.ldap.sdk.BindRequest;
import com.unboundid.ldap.sdk.Entry;
import com.unboundid.ldap.sdk.Filter;

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
      
      Filter filter = Filter.create(ls.getFilterString());
      
      SearchRequest searchRequest = new SearchRequest(ls.getBaseDN(),SearchScope.SUB,filter,ls.getAttributes());
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

  @Override
  public LDAPBindModel bind(LDAPBindModel bindModel) {
    
    //error handling around these for null host and port - also needed in other methods in this class
    this.host = bindModel.getHost();
    this.port = bindModel.getPort();
    
    BindRequest bindRequest = new SimpleBindRequest(bindModel.getDNString(),bindModel.getPassword());
    //TODO make the bind and get the result first
    try {
      
      this.ldapConn.connect(this.host, this.port);
      
      System.out.println(this.ldapConn.bind(bindRequest).getResultCode());
      
      if (this.ldapConn.bind(bindRequest).getResultCode().intValue()==0) {
        bindModel.setBindSuccessful(true);
      }
      else {
        bindModel.setBindSuccessful(false);
        bindModel.setResultCodeName(this.ldapConn.bind(bindRequest).getResultCode().getName());
      }
    } catch (LDAPException le) {
        bindModel.setErrorMessage(le.getMessage());
    }
      catch (Exception e) {
        bindModel.setErrorMessage(e.getMessage());
      }
    return bindModel;
  }
}
