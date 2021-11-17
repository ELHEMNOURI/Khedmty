/*
package com.project.job.service.user;






import com.project.job.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.on.service.Impl.UserServiceImpl.isLogged;

@Service
public class CurrentUserService {

    private String currentPrincipalName;


    @Autowired
    private UserDao userDao;


    @Autowired
    private GroupDao groupDao;

    @Autowired
    private StringQuery stringQuery;

    public Authentication authentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String usernameCurrentUser() {

        if (!isLogged()) {
            return "System";
        } else {
            currentPrincipalName = authentication().getName();
            return currentPrincipalName;
        }
    }

//    public String getCurrentUserLogin() {
//
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//
//         Optional.ofNullable(securityContext.getAuthentication())
//                .map(authentication -> {
//
//                    if (authentication.getPrincipal() instanceof KeycloakPrincipal) {
//                        KeycloakPrincipal principal = (KeycloakPrincipal) authentication.getPrincipal();
//                        return "heelo";
//                    }
//                    return "null";
//                });
//          return "naaaaull";
//    }

    public String rolesCurrentUser() {

        currentPrincipalName = authentication().getAuthorities().toString();
        return currentPrincipalName;
    }

    public Long idCurrentUser() {
        User user = userDao.findByUsername(authentication().getName());
        return user.getId();
    }
    
   
    public User getCurrentUser() {
        return userDao.findByUsername(authentication().getName());

        
    }

    public List<Long> getHisListGroups() {

        List<Long> group = stringQuery.getIdsGroupOfOneUser(idCurrentUser());
        return group;
    }

    public List<String> getHisListPermissions() {

        List<String> permissions = stringQuery.getNamesPermissionOfOneUser(idCurrentUser());
        return permissions;
    }

    public List getListGroupsOfOneUser(Long id) {

        List group = stringQuery.getIdsGroupOfOneUser(id);
        return group;
    }

    public List<Long> getHisListTypeOperator() {

        List<Long> type = stringQuery.getIdsTypeOperatorOfUserByGroup(idCurrentUser());
        return type;
    }

    public Boolean hasAuthority(String role) {

        Boolean isRole = false;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication.getAuthorities().contains(new SimpleGrantedAuthority(role))){
            isRole = true;
        }
        return isRole;
    }
}
*/
