package org.pmcderm.ldaptool.controllers;

import org.pmcderm.ldaptool.services.LdapServiceImpl;
import org.pmcderm.ldaptool.web.LDAPSearchModel;
import org.pmcderm.ldaptool.web.LDAPSearchResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LDAPQueryController {
  
  @Autowired
  private LdapServiceImpl ldapService;
    
  @GetMapping("/search")
  public String searchForm(Model model) {
    model.addAttribute("search",new LDAPSearchModel());
    model.addAttribute("result",new LDAPSearchResultModel());
    return "search";
  }
  
  @PostMapping("/search")
  public String doSearch(@ModelAttribute LDAPSearchModel search, Model model) {
    LDAPSearchResultModel result = this.ldapService.search(search);
    model.addAttribute("result", result);
    model.addAttribute("search", search);
    return "search";
  }
}
