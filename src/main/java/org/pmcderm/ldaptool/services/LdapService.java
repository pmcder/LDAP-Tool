package org.pmcderm.ldaptool.services;

import org.pmcderm.ldaptool.web.LDAPSearchModel;
import org.pmcderm.ldaptool.web.LDAPSearchResultModel;
import com.unboundid.ldap.sdk.Entry;

public interface LdapService {
    
  /**
   * 
   * @return 
   */
  public Entry add();
  
  /**
   * 
   * @param ls an LDAPSearch object
   * @return an LDAPSearch result object
   */
  public LDAPSearchResultModel search(LDAPSearchModel ls);
  
  /**
   * deletes an entry 
   */
  public void delete();

}
