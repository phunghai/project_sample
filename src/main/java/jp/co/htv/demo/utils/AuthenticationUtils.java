package jp.co.htv.demo.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Authentication Utility class.
 * 
 * @author hainp
 *
 */
public class AuthenticationUtils {

    /**
     * Private constructor.
     */
    private AuthenticationUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Check user authentication.
     * 
     * @return
     */
    public static boolean isLogged() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return null != authentication && !("anonymousUser").equals(authentication.getName());
    }
}
